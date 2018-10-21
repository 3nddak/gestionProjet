package com.ucad.chat.entites;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("VIDEO")
public class Enseignant extends Utilisateurs implements Serializable{
	private String matiere;
	

}
