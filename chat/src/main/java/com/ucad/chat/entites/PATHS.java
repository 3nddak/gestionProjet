package com.ucad.chat.entites;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PATHS")
public class PATHS extends Utilisateurs implements Serializable{
	private String poste;
	

}
