package com.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Service {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String nom;
	@OneToMany(mappedBy="service")
	private Collection<Sinistre> sinistres;
	
	
	
	public Service() {
		super();
	
	}
	
	public Collection<Sinistre> getSinistre() {
		return sinistres;
	}


	public void setSinistre(Collection<Sinistre> sinistre) {
		this.sinistres = sinistre;
	}




	public Service(int id) {
		super();
		this.id = id;
	}

	public Service(String nom) {
		super();
		this.nom = nom;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

}
