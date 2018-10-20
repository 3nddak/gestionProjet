package dao.impldao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.idao.IDaoSection;
import models.Section;

public class DaoSectionImpl implements IDaoSection{
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
		Query req=em.createQuery("select o from Section o");
		return req.getResultList();
	}

	@Override
	public Object delete(int id) {
		Section s=em.find(Section.class, id);
		em.remove(s);
		return s;
	}

	@Override
	public Object findMc(String mc) {
		Query req=em.createQuery("select o from Section o where o.nomSection like:x");
		req.setParameter("x", "%"+mc+"%");
		return req.getResultList();
	}

	@Override
	public Object findOne(int id) {
		Section s=em.find(Section.class, id);
		return s;
	}

}
