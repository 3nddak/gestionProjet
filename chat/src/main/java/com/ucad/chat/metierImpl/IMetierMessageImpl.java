package com.ucad.chat.metierImpl;

import java.util.List;

import javax.transaction.Transactional;

import com.ucad.chat.Idao.IMessage;
import com.ucad.chat.entites.Messages;
import com.ucad.chat.metier.IMetierMessage;
@Transactional
public class IMetierMessageImpl implements IMetierMessage{
	private IMessage dao;

	@Override
	public List<Messages> listeMessageUser(int idUtilisateur) {
		
		return dao.listeMessageUser(idUtilisateur);
	}

}
