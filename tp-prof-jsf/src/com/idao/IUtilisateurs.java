package com.idao;

import com.entities.Utilisateurs;

public interface IUtilisateurs {
	
	public Utilisateurs rechercherUser(String login, String password);
	public void ajoutUser(Utilisateurs u);

}
