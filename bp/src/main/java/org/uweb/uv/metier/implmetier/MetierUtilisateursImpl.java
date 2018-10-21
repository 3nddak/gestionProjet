package org.uweb.uv.metier.implmetier;

import java.sql.ResultSet;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;
import org.uweb.uv.dao.idao.IDaoUtilisateurs;
import org.uweb.uv.metier.imetier.IMetierUtilisateurs;

@Transactional
public class MetierUtilisateursImpl implements IMetierUtilisateurs{
	private IDaoUtilisateurs dao;
	
	

	public IDaoUtilisateurs getDao() {
		return dao;
	}

	public void setDao(IDaoUtilisateurs dao) {
		this.dao =dao;
	}

	@Override
	public Object addObj(Object p) {
		
		return dao.addObj(p);
	}

	@Override
	public Object update(Object p) {
		
		return dao.update(p);
	}

	@Override
	public Object findAll() {
		
		return dao.findAll();
	}

	@Override
	public Object delete(int id) {
		
		return dao.delete(id);
	}

	@Override
	public Object findMc(String mc) {
		return dao.findMc(mc);
	}

	@Override
	public Object findOne(int id) {
		return dao.findOne(id);
	}

	@Override
	public Object connection(Object conn) {
		return dao.connection(conn);
	}

	@Override
	public void bloquerUser(int idUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int changerMotDePasse(String id, String pwd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int changerEtatConnection(String id, String connecte) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int AffecterCode(String id, String code) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int suprimUser(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String RetourneCodeUser(int idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCaissier(String codeUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void afficherchangeUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean userAffectCaisse(String codeUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean userAffectCaisseDefaut(String codeUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean userAffectCaisse(String codeUser, String idDevise) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existLogin(String login) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String convertToHex(byte[] data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String SHA1(String text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet rechercheLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean rechercheUser(String login, String pwd) {
		//System.out.println("OKOKOKOKOKO");
		//System.out.println("DaoRechercheUser =="+dao.rechercheUser(login, pwd));
		return dao.rechercheUser(login, pwd);
	}

	@Override
	public ResultSet afficherUserBis(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int profilUser(int idUser) {
		// TODO Auto-generated method stub
		return 0;
	}

}
