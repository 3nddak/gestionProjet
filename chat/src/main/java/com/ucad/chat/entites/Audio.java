package com.ucad.chat.entites;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("AUDI")
public class Audio extends Messages implements Serializable{
	private String duree;
	
	

}
