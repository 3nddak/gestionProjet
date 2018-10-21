package com.ucad.chat.IdaoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.ucad.chat.Idao.IUtilisateurs;
import com.ucad.chat.entites.Utilisateurs;
@Transactional
public class IUtilisateurImpl implements IUtilisateurs{
	@PersistenceContext
	private EntityManager em;

	@Override
	public Utilisateurs login(String login, String password) {
		
try {
			
			Query req = em.createQuery("select u from Utilisateurs u where u.username=:x1 and u.password=:x2");
			req.setParameter("x1", login);
			req.setParameter("x2", password);

			if (req.getSingleResult() != null) {
				Utilisateurs cp = (Utilisateurs) req.getSingleResult();
				return cp;
			}

		} catch (Exception e) {
		}
		return null;
	}

}
