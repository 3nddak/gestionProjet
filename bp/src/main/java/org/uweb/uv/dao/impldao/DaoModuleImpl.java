package org.uweb.uv.dao.impldao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.richfaces.application.Module;
import org.uweb.uv.dao.idao.IDaoModule;

public class DaoModuleImpl implements IDaoModule{
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
		Query req=em.createQuery("select o from Module o");
		return req.getResultList();
	}

	@Override
	public Object delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object findMc(String mc) {
		Query req=em.createQuery("select o from Module o where o.libelle like:x");
		req.setParameter("x", "%"+mc+"%");
		return req.getResultList();
	}

	@Override
	public Object findOne(int id) {
		Module m=em.find(Module.class, id);
		return m;
	}

}
