package dao.impldao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.sun.xml.internal.ws.wsdl.writer.document.Fault;

import dao.idao.IDaoFaculte;
import models.Faculte;

public class DaoFaculteImpl implements IDaoFaculte{
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
		Query req=em.createQuery("select o from Faculte o");
		return req.getResultList();
	}

	@Override
	public Object delete(int id) {
		Faculte f=em.find(Faculte.class, id);
		em.remove(f);
		return f;
	}

	@Override
	public Object findMc(String mc) {
		Query req=em.createQuery("select o from Faculte o where o.nomFaculte like:x");
		req.setParameter("x", "%"+mc+"%");
		return req.getResultList();
	}

	@Override
	public Object findOne(int id) {
		Faculte f=em.find(Faculte.class,id);
		return f;
	}

}
