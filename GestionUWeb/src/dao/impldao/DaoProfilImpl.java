package dao.impldao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.idao.IDaoProfil;
import models.Pages;
import models.Profil;

public class DaoProfilImpl implements IDaoProfil{
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
		Query req=em.createQuery("select o from Profil o");
		return req.getResultList();
	}

	@Override
	public Object delete(int id) {
		Profil p=em.find(Profil.class, id);
		em.remove(p);
		return p;
	}

	@Override
	public Object findMc(String mc) {
		Query req=em.createQuery("select o from Profil o where o.libelleProfil like:x");
		req.setParameter("x", "%"+mc+"%");
		return req.getResultList();
	}

	@Override
	public Object findOne(int id) {
		Profil p=em.find(Profil.class, id);
		return p;
	}

	@Override
	public void ajouterPageProfil(int idPage, int idProfil) {
		Pages pa=em.find(Pages.class, idPage);
		Profil pro=em.find(Profil.class, idProfil);
		em.persist(pro.getPages().add(pa));
	}

	@Override
	public void retiterPageProfil(int idPage, int idProfil) {
		Pages pa=em.find(Pages.class, idPage);
		Profil pro=em.find(Profil.class, idProfil);
		em.remove(pro.getPages().add(pa));
		
	}

	@Override
	public boolean utilProfil(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
