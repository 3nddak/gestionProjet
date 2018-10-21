package com.ucad.chat.Idao;

import java.util.List;

import com.ucad.chat.entites.Messages;

public interface IMessage {
	List<Messages> listeMessageUser (int idUtilisateur);

}
