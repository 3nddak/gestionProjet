package com.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.entities.Utilisateurs;
import com.idao.IUtilisateurs;

public class UtilisateursImpl implements IUtilisateurs{
	@PersistenceContext
	private EntityManager em;

	@Override
	public Utilisateurs rechercherUser(String login, String password) {

		try {
			Query req=em.createQuery("select u from Utilisateurs u where u.login=:x1 and u.password=:x2");
			req.setParameter("x1", login);
			req.setParameter("x2", password);
			
			if(req.getSingleResult()!=null)
			{
				return (Utilisateurs) req.getSingleResult();
				
			}
			
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public void ajoutUser(Utilisateurs u) {
		em.persist(u);
		
	}

}
