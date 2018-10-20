package dao.impldao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.idao.IDaoPages;
import models.Pages;

public class DaoPageImpl implements IDaoPages{
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
		Query req=em.createQuery("select o from Pages o ");
		return req.getResultList();
	}

	@Override
	public Object delete(int id) {
		Pages p=em.find(Pages.class, id);
		em.remove(p);
		return p;
	}

	@Override
	public Object findMc(String mc) {
		Query req=em.createQuery("select o from Pages o where o.libelle like:x");
		req.setParameter("x", "%"+mc+"%");
		return req.getResultList();
	}

	@Override
	public Object findOne(int id) {
		Pages p=em.find(Pages.class, id);
		return p;
	}

	@Override
	public int insertPage(String idModule, String url, String libelle, String defaut, String etat, String surentete) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifPage(String id, String idModule, String url, String libelle, String defaut, String etat,
			String surentete) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean ordreExiste() {
		// TODO Auto-generated method stub
		return false;
	}

}
