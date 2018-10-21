package com.metierimpl;

import org.springframework.transaction.annotation.Transactional;

import com.entities.Utilisateurs;
import com.idao.IUtilisateurs;
import com.imetier.IMetierUtilsateurs;

@Transactional
public class MetierutilisateursImpl implements IMetierUtilsateurs {
	private IUtilisateurs dao;
	

	public void setDao(IUtilisateurs dao) {
		this.dao = dao;
	}

	@Override
	public Utilisateurs rechercherUser(String login, String password) {
		
		return dao.rechercherUser(login, password);
	}

	@Override
	public void ajoutUser(Utilisateurs u) {
		dao.ajoutUser(u);	
	}

}
