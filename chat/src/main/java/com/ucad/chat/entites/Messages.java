package com.ucad.chat.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_MSG",discriminatorType=DiscriminatorType.STRING,length=10)
public class Messages implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMessage;
	private Date dateEnvoie;
	private String contenu;
	@ManyToOne
	private Utilisateurs utilisateur;
	
	public Messages() {
		super();
	}

	public Messages(Date dateEnvoie, String contenu, Utilisateurs utilisateur) {
		super();
		this.dateEnvoie = dateEnvoie;
		this.contenu = contenu;
		this.utilisateur = utilisateur;
	}

	public int getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}

	public Date getDateEnvoie() {
		return dateEnvoie;
	}

	public void setDateEnvoie(Date dateEnvoie) {
		this.dateEnvoie = dateEnvoie;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Utilisateurs getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateurs utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
	
	
	
	
	
	

}
