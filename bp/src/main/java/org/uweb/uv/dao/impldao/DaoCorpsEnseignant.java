package org.uweb.uv.dao.impldao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.uweb.uv.dao.idao.IDaoCorpsEnseignant;
import org.uweb.uv.models.CorpsEnseignant;


public class DaoCorpsEnseignant implements IDaoCorpsEnseignant{
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
		Query req=em.createQuery("select o from CorpsEnseignant o");
		return req.getResultList();
	}

	@Override
	public Object delete(int id) {
		CorpsEnseignant ce=em.find(CorpsEnseignant.class, id);
		em.persist(ce);
		return ce;
	}

	@Override
	public Object findMc(String mc) {
		Query req=em.createQuery("select e from CorpsEnseignant e where e.nomProf like :x");
		req.setParameter("x","%"+mc+"%");
		return req.getResultList();
	}

	@Override
	public Object findOne(int id) {
		CorpsEnseignant ce=em.find(CorpsEnseignant.class, id);
		return ce;
	}

}
