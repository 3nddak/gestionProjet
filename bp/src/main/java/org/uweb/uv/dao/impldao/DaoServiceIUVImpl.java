package org.uweb.uv.dao.impldao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.uweb.uv.dao.idao.IDaoServicesIUV;
import org.uweb.uv.models.ServiceslUV;

public class DaoServiceIUVImpl implements IDaoServicesIUV{
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
		Query req=em.createQuery("select o from ServiceslUV o");
		return req.getResultList();
	}

	@Override
	public Object delete(int id) {
		ServiceslUV s=em.find(ServiceslUV.class, id);
		return s;
	}

	@Override
	public Object findMc(String mc) {
		Query req=em.createQuery("select o from ServiceslUV o where o.nomServicelUV like:x");
		req.setParameter("x", "%"+mc+"%");
		return req.getResultList();
	}

	@Override
	public Object findOne(int id) {
		ServiceslUV s=em.find(ServiceslUV.class, id);
		return s;
	}

}
