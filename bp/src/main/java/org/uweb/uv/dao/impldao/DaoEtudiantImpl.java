package org.uweb.uv.dao.impldao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.uweb.uv.dao.idao.IDaoEtudiant;
import org.uweb.uv.models.Etudiant;


public class DaoEtudiantImpl implements IDaoEtudiant{
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
		Query req=em.createQuery("select o from Etudiant o");
		return req.getResultList();
	}

	@Override
	public Object delete(int id) {
		Etudiant e=em.find(Etudiant.class, id);
		em.remove(e);
		return e;
	}

	@Override
	public Object findMc(String mc) {
		Query req=em.createQuery("select o from Etudiant o where o.nom like:x");
		req.setParameter("x", "%"+mc+"%");
		return req.getResultList();
	}

	@Override
	public Object findOne(int id) {
		Etudiant e=em.find(Etudiant.class, id);
		return e;
	}

}