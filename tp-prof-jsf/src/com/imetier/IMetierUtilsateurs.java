package com.imetier;

import com.entities.Utilisateurs;

public interface IMetierUtilsateurs {
	public Utilisateurs rechercherUser(String login, String password);
	public void ajoutUser(Utilisateurs u);

}
