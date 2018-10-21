package com.ucad.chat.metier;

import com.ucad.chat.entites.Utilisateurs;

public interface IMetierUtilisateur{
	Utilisateurs login(String login, String password);

}
