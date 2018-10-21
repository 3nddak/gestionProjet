package com.entities;

import java.io.Serializable;

public class Prestataires implements Serializable{
	private String nom;

	
	
	public Prestataires() {
		super();
	}
	
	public Prestataires(String nom) {
		super();
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

}
