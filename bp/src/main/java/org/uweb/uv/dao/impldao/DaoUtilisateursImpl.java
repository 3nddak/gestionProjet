package org.uweb.uv.dao.impldao;

import java.sql.ResultSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.uweb.uv.dao.idao.IDaoUtilisateurs;
import org.uweb.uv.models.Utilisateurs;

public class DaoUtilisateursImpl implements IDaoUtilisateurs{
	@PersistenceContext
	 EntityManager em;

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
	public List<Utilisateurs> findAll() {
		Query req=em.createQuery("select o from Utilisateurs o");
		return req.getResultList();
	}

	@Override
	public Object delete(int id) {
		Utilisateurs user=em.find(Utilisateurs.class, id);
		em.remove(user);
		return user;
	}

	@Override
	public Object findMc(String mc) {
		Query req=em.createQuery("select o from Utilisateurs o");
		return req.getResultList();
	}

	@Override
	public Object findOne(int id) {
		Utilisateurs user=em.find(Utilisateurs.class, id);
		return user;
	}

	@Override
	public void bloquerUser(int idUser) {
		Query req=em.createQuery("update Utilisateurs o set o.etat=false where o.Id =:x");
		req.setParameter("x", idUser);
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
	public int profilUser(int idUser) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean rechercheUser(String login, String pwd) {
		try {
			Query req=em.createQuery("select u from Utilisateurs u where u.login=:x1 and u.passwd=:x2");
			req.setParameter("x1", login);
			req.setParameter("x2", pwd);
			if(req.getSingleResult()!=null)
			{
				return true;
			}
			
		} catch (Exception e) {
		}
		return false;
	}
	
	@Override
	public ResultSet afficherUserBis(String login) {
		// TODO Auto-generated method stub
		return null;
	}

}
