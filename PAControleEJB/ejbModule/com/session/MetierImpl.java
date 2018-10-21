package com.session;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import com.entities.AssuPrinc;
import com.entities.Prestataires;
import com.entities.Service;
import com.entities.Sinistre;
import com.entities.SinistreDetail;
import com.entities.Utilisateurs;

@Stateless(name = "PA")
public class MetierImpl implements IMetierLocale, IMetierRemote {
	@PersistenceContext
	private EntityManager em;

	@Override
	public void ajoutUser(Utilisateurs u) {
		em.persist(u);
	}

	@Override
	public Utilisateurs connection(String username, String password) {
		try {
			
			Query req = em.createQuery("select u from Utilisateurs u where u.username=:x1 and u.password=:x2");
			req.setParameter("x1", username);
			req.setParameter("x2", password);

			if (req.getSingleResult() != null) {
				Utilisateurs cp = (Utilisateurs) req.getSingleResult();
				return cp;
			}

		} catch (Exception e) {
		}
		return null;
	}

	/*
	 * @Override public List<Sinistre> listSinistre() { Query req = em.
	 * createQuery("select new com.entities.Sinistre(s.id, s.dateDeclare,s.souscriptuer,s.beneficiare,"
	 * + "sum(s.expose),sum(s.paye)) from Sinistre s" +
	 * " group by s.id,s.dateDeclare,s.souscriptuer,s.beneficiare"); return
	 * req.getResultList(); }
	 */

	@Override
	public List<Sinistre> listSinistre() {
		Query req = em.createQuery("select s from Sinistre s");
		return req.getResultList();
	}

	@Override
	public List<SinistreDetail> listeDetailSinitre() {
		Query req = em.createQuery("select s from SinistreDetail s");
		return req.getResultList();
	}
	/*
	 * @Override public List<AssuPrinc> listparAssuPrincipal() { Query req = em.
	 * createQuery("select new com.entities.AssuPrinc(s.dateDeclare,sd.numDossier,"
	 * +
	 * "sd.numPolice,s.souscriptuer,sd.AssurePricipale,sd.beneficiare,sd.expose,sd.paye)"
	 * + " from Sinistre s,SinistreDetail sd where s.numPolice=sd.numPolice" +
	 * " and s.numDossier=sd.numDossier and s.anneeProd=sd.anneProd" +
	 * " order by sd.expose,s.dateDeclare desc ");
	 * 
	 * return req.getResultList(); }
	 */

	@Override
	public List<AssuPrinc> listparAssuPrincipal() {
		Query req = em.createQuery("select new com.entities.AssuPrinc(s.dateDeclare,sd.numDossier,"
				+ "sd.numPolice,s.souscriptuer,sd.AssurePricipale,sd.beneficiare,sum(sd.expose),sum(sd.paye))"
				+ " from Sinistre s JOIN SinistreDetail sd ON s.numPolice=sd.numPolice"
				+ " and s.numDossier=sd.numDossier "
				+ " group by s.dateDeclare,sd.numDossier,sd.numPolice,s.souscriptuer,sd.AssurePricipale,"
				+ "sd.beneficiare");
		return req.getResultList();
	}

	@Override
	public List<AssuPrinc> listparAssuPrincipal(Date date_deb, Date date_fin) {
		Query req = em.createQuery("select new com.entities.AssuPrinc(s.dateDeclare,sd.numDossier,"
				+ "sd.numPolice,s.souscriptuer,sd.assurePricipale,sd.beneficiare,sum(sd.expose),sum(sd.paye))"
				+ " from Sinistre s JOIN SinistreDetail sd ON s.numPolice=sd.numPolice"
				+ "   and s.numDossier=sd.numDossier"
				+ " where s.date>=? and s.date<=? "
				+ " group by s.dateDeclare,sd.numDossier,sd.numPolice,s.souscriptuer,sd.assurePricipale,"
				+ "sd.beneficiare order by sum(sd.expose) desc,sum(sd.paye) desc ");

		System.out.println("\n\\n\n\n cccc \n\n\n\n date_debut: "+date_deb+" date_fin: "+date_fin);
		
		req.setParameter(1,date_deb,TemporalType.DATE);
		req.setParameter(2,date_fin,TemporalType.DATE);
//		System.out.println("req toString : "+req.toString());
//		List<Object> pp=req.getResultList();
//		System.out.println("size: "+pp.size());
//		List<AssuPrinc> l=new ArrayList<>();
//		for (Object object : pp) {
//			try {
//				AssuPrinc a=(AssuPrinc) object;
//				l.add(a);
//				System.out.println("AssuPrinc : caste reussi");
//			} catch (Exception e) {
//				System.out.println("AssuPrinc : echec caste");
//			}
//			
//		}
		
		return req.getResultList();
	}

	@Override
	public List<Sinistre> listSinPayeParAssur(Date date_deb, Date date_fin) {
		Query req = em.createQuery("select new com.entities.Sinistre(s.dateDeclare,s.numDossier,s.numPolice,"
				+ "s.souscriptuer,sum(s.paye),s.libelletFacture,s.banque,s.cheque,s.date,s.service.id)"
				+ " from Sinistre s"
				+ " where s.date>=? and s.date<=?"
				+ " group by s.dateDeclare,s.numDossier,s.numPolice,s.souscriptuer,s.cheque,"
				+ " s.date,s.libelletFacture,s.banque,s.service.id order by s.dateDeclare desc,sum(s.paye) desc ");

		System.out.println("\n\\n\n\n cccc \n\n\n\n date_debut: "+date_deb+" date_fin: "+date_fin);
		req.setParameter(1,date_deb,TemporalType.DATE);
		req.setParameter(2,date_fin,TemporalType.DATE);	
		return req.getResultList();
	}

	@Override
	public List<Service> listServices() {
		Query req = em.createQuery("select s from Service s");
		System.out.println("Tatata =: "+req.getResultList().size());
		return req.getResultList();
	}

	@Override
	public List<Sinistre> listSinPayeParAssur(Date date_deb, Date date_fin, int id) {
		Query req = em.createQuery("select new com.entities.Sinistre(s.dateDeclare,s.numDossier,s.numPolice,"
				+ "s.souscriptuer,sum(s.paye),s.libelletFacture,s.banque,s.cheque,s.date,s.service.id)"
				+ " from Sinistre s"
				+ " where s.service.id=?"
				+ " and s.date>=? and s.date<=? "
				+ " group by s.dateDeclare,s.numDossier,s.numPolice,s.souscriptuer,s.cheque,"
				+ " s.date,s.libelletFacture,s.banque,s.service.id order by s.dateDeclare desc,sum(s.paye) desc ");

		System.out.println("\n\\n\n\n cccc \n\n\n\n date_debut: "+date_deb+" date_fin: "+date_fin);
		req.setParameter(1, id);
		req.setParameter(2,date_deb,TemporalType.DATE);
		req.setParameter(3,date_fin,TemporalType.DATE);	
		return req.getResultList();
	}

	@Override
	public List<Prestataires> listBeneficiaires() {
		Query req = em.createQuery("select distinct new com.entities.Prestataires(b.beneficiare) from Sinistre b");
		
		return req.getResultList();
	}

	@Override
	public List<Sinistre> listSinPayeParAssurBenef(Date date_deb, Date date_fin, int id, String benef) {
		Query req = em.createQuery("select new com.entities.Sinistre(s.dateDeclare,s.numDossier,s.numPolice,"
				+ "s.souscriptuer,s.beneficiare,sum(s.paye),s.libelletFacture,s.banque,s.cheque,s.date,s.service.id)"
				+ " from Sinistre s"
				+ " where s.service.id=?"
				+ " and s.beneficiare=?"
				+ " and s.date>=? and s.date<=? "
				+ " group by s.dateDeclare,s.numDossier,s.numPolice,s.souscriptuer,s.cheque,"
				+ " s.date,s.libelletFacture,s.banque,s.service.id,s.beneficiare order by s.dateDeclare desc,sum(s.paye) desc ");

		System.out.println("\n\\n\n\n cccc \n\n\n\n date_debut: "+date_deb+" date_fin: "+date_fin);
		req.setParameter(1, id);
		req.setParameter(2, benef);
		req.setParameter(3,date_deb,TemporalType.DATE);
		req.setParameter(4,date_fin,TemporalType.DATE);	
		
		return req.getResultList();
	}

	@Override
	public List<Sinistre> listSinPayeParAssurBenef(Date date_deb, Date date_fin, String benef) {
		Query req = em.createQuery("select new com.entities.Sinistre(s.dateDeclare,s.numDossier,s.numPolice,"
				+ "s.souscriptuer,s.beneficiare,sum(s.paye),s.libelletFacture,s.banque,s.cheque,s.date,s.service.id)"
				+ " from Sinistre s"
				+ " where s.beneficiare=?"
				+ " and s.date>=? and s.date<=? "
				+ " group by s.dateDeclare,s.numDossier,s.numPolice,s.souscriptuer,s.cheque,"
				+ " s.date,s.libelletFacture,s.banque,s.beneficiare,s.service.id order by s.dateDeclare desc,sum(s.paye) desc ");

		System.out.println("\n\\n\n\n cccc \n\n\n\n date_debut: "+date_deb+" date_fin: "+date_fin);
		req.setParameter(1, benef);
		req.setParameter(2,date_deb,TemporalType.DATE);
		req.setParameter(3,date_fin,TemporalType.DATE);	
		
		return req.getResultList();
	}
	
	/*@Override
	 * 
	 * 
	 * private Date dateDeclare;
	private String numDossier;
	private int numPolice;
	private String souscriptuer;
	private double expose;
	private double paye;
	private String libelletFacture;
	private String banque;
	private String cheque;
	 * 
	 * 
	 * 
	 * 
	public List<AssuPrinc> listparAssuPrincipal(Date date_deb, Date date_fin) {
		Query req = em.createNativeQuery("select s.dateDeclare as daterecp,sd.numDossier as dossier,"+
				"		sd.numPolice as police,s.souscriptuer as souscripteur,"+
				"		sd.AssurePricipale as assure,sd.beneficiare as beneficiaire," + 
				"  		sum(sd.expose) as somExpose,sum(sd.paye) as somPaye " + 
				"  from SINISTRE s "+
				"  JOIN SinistreDetail sd on s.numPolice=sd.numPolice and s.numDossier=sd.numDossier" + 
				"  where s.dateDeclare>='2018-01-01'" + 
				"  		and s.dateDeclare<='2018-02-28' ");
		List l=req.getResultList();

		System.out.println("req: "+l.size());
		return l;
	}
	*/

	/*
	 * @Override public List<AssuPrinc> listparAssuPrincipal(int page,int size) {
	 * Query req = em.
	 * createQuery("select new com.entities.AssuPrinc(s.dateDeclare,sd.numDossier,"
	 * +
	 * "sd.numPolice,s.souscriptuer,sd.AssurePricipale,sd.beneficiare,sum(sd.expose),sum(sd.paye))"
	 * + " from Sinistre s JOIN SinistreDetail sd ON s.numPolice=sd.numPolice" +
	 * " and s.numDossier=sd.numDossier " + " and s.anneeProd=sd.anneProd" +
	 * " group by s.dateDeclare,sd.numDossier,sd.numPolice," +
	 * "s.souscriptuer,sd.AssurePricipale,sd.beneficiare" +
	 * " order by sd.expose,s.dateDeclare desc ");
	 * req.setFirstResult(size*page).setMaxResults(size);
	 * 
	 * return req.getResultList(); }
	 */

}
