package dao.impldao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.idao.IDaoUniversite;
import models.Universite;

public class DaoUniversiteImpl implements IDaoUniversite{
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
		Query req=em.createQuery("select o from Universite o");
		return req.getResultList();
	}

	@Override
	public Object delete(int id) {
		Universite uv=em.find(Universite.class, id);
		em.remove(uv);
		return uv;
	}

	@Override
	public Object findMc(String mc) {
		Query req=em.createQuery("select o from Universite o where o.nomUV like:x");
		req.setParameter("x", "%"+mc+"%");
		return req.getResultList();
	}

	@Override
	public Object findOne(int id) {
		Universite uv=em.find(Universite.class, id);
		return uv;
	}

}
