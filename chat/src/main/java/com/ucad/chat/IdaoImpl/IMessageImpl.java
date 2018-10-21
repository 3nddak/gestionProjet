package com.ucad.chat.IdaoImpl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.ucad.chat.Idao.IMessage;
import com.ucad.chat.entites.Messages;

@Transactional
public class IMessageImpl implements IMessage{
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Messages> listeMessageUser(int idUtilisateur) {
		Query req=em.createQuery("select u from Utilisateurs u");
		return req.getResultList();
	}



}
