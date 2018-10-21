package org.uweb.uv.dao.impldao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.uweb.uv.dao.idao.IDaoMatiere;
import org.uweb.uv.models.Matieres;

public class DaoMatiereImpl implements IDaoMatiere{
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
		Query req=em.createQuery("select o from Matieres o");
		return req.getResultList();
	}

	@Override
	public Object delete(int id) {
		Matieres m=em.find(Matieres.class, id);
		em.remove(m);
		return m;
	}

	@Override
	public Object findMc(String mc) {
		Query req=em.createQuery("select o from Matieres o where o.nomMatiere like:x");
		req.setParameter("x", "%"+mc+"%");
		return req.getResultList();
	}

	@Override
	public Object findOne(int id) {
		Matieres m=em.find(Matieres.class, id);
		return m;
	}

}
