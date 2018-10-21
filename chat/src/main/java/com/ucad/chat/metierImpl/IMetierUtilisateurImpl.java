package com.ucad.chat.metierImpl;

import javax.transaction.Transactional;

import com.ucad.chat.Idao.IUtilisateurs;
import com.ucad.chat.entites.Utilisateurs;
import com.ucad.chat.metier.IMetierUtilisateur;

@Transactional
public class IMetierUtilisateurImpl implements IMetierUtilisateur{
	private IUtilisateurs dao;
	
	

	public IUtilisateurs getDao() {
		return dao;
	}



	public void setDao(IUtilisateurs dao) {
		this.dao = dao;
	}



	@Override
	public Utilisateurs login(String login, String password) {
		return dao.login(login, password);
	}

}
