package com.ucad.chat.entites;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("VIDEO")
public class Videos extends Messages{
	private Date dateVideos;

}
