package com.ucad.chat.metier;

import java.util.List;

import com.ucad.chat.entites.Messages;

public interface IMetierMessage {
	List<Messages> listeMessageUser (int idUtilisateur);

}
