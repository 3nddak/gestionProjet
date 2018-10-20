package dao.impldao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.idao.IDaoSalleClasse;
import models.SalleClasse;

public class DaoSalleClasseImpl implements IDaoSalleClasse{
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
		Query req=em.createQuery("select o from SalleClasse o");
		return req.getResultList();
	}

	@Override
	public Object delete(int id) {
		SalleClasse sal=em.find(SalleClasse.class, id);
		em.remove(sal);
		return sal;
	}

	@Override
	public Object findMc(String mc) {
		Query req=em.createQuery("select o from SalleClasse o where o.nomSalle like:x");
		req.setParameter("x", "%"+mc+"%");
		return req.getResultList();
	}

	@Override
	public Object findOne(int id) {
		SalleClasse sal=em.find(SalleClasse.class, id);
		return sal;
	}

}
