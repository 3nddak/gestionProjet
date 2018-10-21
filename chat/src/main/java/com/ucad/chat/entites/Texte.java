package com.ucad.chat.entites;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MSG")
public class Texte extends Messages implements Serializable{
	private String contenu;
	

}
