package dao.impldao;

import java.sql.ResultSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.idao.IDaoJournal;
import models.Journal;

public class DaoJournalImpl implements IDaoJournal{
	@PersistenceContext
	private EntityManager em;

	@Override
	public Object connection(Object conn) {
		
		return conn;
	}

	@Override
	public Object addObj(Object p) {
		em.persist(p);
		return p;
	}

	@Override
	public Object update(Object p) {
		em.merge(p);
		return p;
	}

	@Override
	public List findAll() {
		Query req=em.createQuery("select o from Journal o");
		return req.getResultList();
	}

	@Override
	public Object delete(int id) {
		Journal j=em.find(Journal.class, id);
		em.remove(j);
		return j;
	}

	@Override
	public Object findMc(String mc) {
		Query req=em.createQuery("select o from Journal o where o.libelleOperation like:x");
		req.setParameter("x", "%"+mc+"%");
		return req.getResultList();
	}

	@Override
	public Object findOne(int id) {
		Journal j=em.find(Journal.class, id);
		return j;
	}

	@Override
	public int insertJournal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int suppMouvement(String idmouv) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int suppEcriture(String idjournal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertJournalCode(String idcodejournal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertJournal(String numcpte, String iduser, String liboperation, int solde, char sens, String date,
			int idoperation, String ref, int idmouv, String budget) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertJournal(String numcpte, String iduser, String liboperation, int solde, char sens, String date,
			int idoperation, String ref, int idmouv, String budget, int valide) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertJournal(String numcpte, String iduser, String liboperation, int solde, char sens, String date,
			int idoperation, String ref, int idmouv, String budget, int valide, String centreCout) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertJournal(String numcpte, String iduser, String liboperation, int solde, char sens, String date,
			int idoperation, String ref, int idmouv, String budget, int valide, String centre, String dateval) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertJournal(String numcpte, String iduser, String liboperation, double solde, char sens, String date,
			int idoperation, String ref, int idmouv, String budget, int valide, String centre, String dateval) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertJournal(String numcpte, String iduser, String liboperation, double solde, String sens, String date,
			int idoperation, String ref, int idmouv, String budget, int valide, String centre, String dateval) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertJournalCodeReport(String idcodejournal, int montantReport, String numerocpte, char sens) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertMouvement(String date, String cleinsert, String reference, String datevaleur) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertMouvement(String date, String cleinsert, String reference, String datevaleur, int idexo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertlotComptable(String reference, String datelot) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertlotComptableAgence(String reference, String datelot, String idagencelot) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertGrilleAgence(String iduser, String idperiode, String typegrille, String libellegrille,
			String datedebut, String idagence, String datefin) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertVirementmultiple(String iduser, String numcompte, String libvir, String numvirmult,
			String datevirmult, double montant, String idagenceUser) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertHistoModele(String idgrille, String dateoperation, String etatmodele, String dateprel) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertGrilleEcritureAgence(String idgrille, String numcompte, String libgrilleecri, String sens,
			double montant, String idagence, String codebudget) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertMouvementValide(String date, String cleinsert, String reference, String datevaleur,
			int idoperation, String centreCout, String valide) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertMouvementVirMult(String date, String cleinsert, String reference, String datevaleur,
			int idoperation, String centreCout, String valide, String virmult) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertionMouvementValide(String date, String cleinsert, String reference, String datevaleur,
			int idoperation, String centreCout, String valide) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertMouvement(String date, String cleinsert, String reference, String datevaleur, String centre) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifMouvement(String code, int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertMouvementValide(String date, String cleinsert, String reference, String valide) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String insertionMouvementValideB(int idMouv, String date, String cleinsert, String reference, String valide,
			String datevaleur, String centre, int seqbordereau) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insertionMouvementValide(int idMouv, String date, String cleinsert, String reference, String valide,
			String datevaleur, String centre, int idop) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateMouvementValide(int idMouv, String date, String cleinsert, String reference, String valide,
			String datevaleur, String centre, int idop) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insertMouvValide(int idMouv, String date, String cleinsert, String reference, String valide,
			String datevaleur, String centre, String codejournal, int idop) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateMouvValide(int idMouv, String date, String cleinsert, String reference, String valide,
			String datevaleur, String centre, String codejournal, int idop) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMouvementValideB(String date, String cleinsert, String reference, String valide, String datevaleur,
			String centre) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifierEcriture(String id, String libelle, String valeur, String date, char sens, String reference,
			String codebudget, String codejournal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifEcriture(String id, int idmouv, String numcompte, String libelle, int solde, String sens,
			String date, String ref, String budget, String centrecout) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifEcritureBis(String id, int idmouv, String numcompte, String libelle, double solde, String sens,
			String date, String ref, String budget, String centrecout) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifEcriture(String id, String numcompte, String libelle, int solde) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int ValidMouvement(String id, String valide) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int ValidLettrage(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int ValidEcriture(String id, String valide) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int UpdateDateValeur(String id, String datevaleur) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int UpdateCodeLettrageO(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double selectLettrageId(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String selectSensLettrageId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectRefLettrageId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int verifEcriture(int idmouv, int montant) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int verifEcriture(int idmouv) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int SoldeMouvement(int idmouv) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int historiserJournal(String numcpte, String iduser, String liboperation, double solde, String sens,
			String date, int idoperation, String ref, int idmouv, String budget, int valide, String centre,
			String dateval, String idUserSupp, String dateSupp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String historiserMouvement(int idMouv, String date, String cleinsert, String reference, String valide,
			String datevaleur, String centre, String codejournal, int idop, String idexo, String idlotmouvement,
			String idUserSupp, String dateSupp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateOperationMouv(int idmouv, int idop) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateLotValide(String id, String valide) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateVirmultiple(String id, String valide) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateGrilleActive(String id, String valide) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateGrillesaisie(String id, double montant, String libelle) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void cloturelot(String idlot, String datejour, int agencetravail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clotureVirmult(String idvirmult, String datejour, String idUser, String idagence, int agencetravail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void comptatlotCompteClient(String numcpte, double montant, String datejour) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void activergrille(String grilleid, String datejour, String iduser, int agencetravail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void activerModele(String grilleid, String datejour, String iduser, String etatmodele, String dateoper,
			int agencetravail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultSet ligneReference(String ref) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet journalParCompte(String numcompte, String date1, String date2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double SommeEcritureCompte(String numcompte, String date1, String date2, String sens) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double SommeEcritureComptePrec(String numcompte, String date1, String sens) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String AjoutMoisDateEN(String date1, int nbmois) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int NbJourDifferenceEN(String date1, String date2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultSet journalDatValCompte(String numCpte, String date1, String date2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String maxDateDav(String numCpte, String date1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int histoSoldeDavid(String numCpte, String date1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double SoldeDav(String numCpte, String date1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double SoldeDat(String numCpte, String date1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double SoldeDatValDav(String numCpte, String date1, double solde) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double SoldeDatValDat(String numCpte, String date1, double solde) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double SoldeDebValDav(String numCpte, String date1, String date2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
