package com.ucad.chat.entites;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_USER",discriminatorType=DiscriminatorType.STRING,length=10)
public class Utilisateurs implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUtilisateur;
	@ManyToMany(mappedBy="userRecepteur",fetch=FetchType.LAZY)
	private Collection<Utilisateurs> idInterlocuteur;
	private String nom;
	private String prenom;
	private String login;
	private String mdp;
	@ManyToMany
	@JoinTable(name="INTER_RECP",
	joinColumns=@JoinColumn(name="ID_RECP"),
	inverseJoinColumns=@JoinColumn(name="ID_INTER"))
	private Collection<Utilisateurs> userRecepteur;
	@OneToMany(mappedBy="utilisateur")
	private Collection<Messages> message;
	

}
