package com.ucad.chat.entites;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ETUDIANT")
public class Etudiant extends Utilisateurs implements Serializable{
	private String matricule;
	private String classe;
	

}
