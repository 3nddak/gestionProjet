package com.services;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.entities.Utilisateurs;
import com.session.IMetierLocale;

@Stateless
@WebService
public class PAServices {
	@EJB(beanName="PA")
	private IMetierLocale metier;
	
	@WebMethod
	public void ajoutUser(@WebParam(name="nom") String nom,@WebParam(name="prenom") 
	String prenom,@WebParam(name="username") String username,@WebParam(name="password") String password) {
		
		metier.ajoutUser(new Utilisateurs(username, password, nom, prenom, true, new Date()));
	}
	
	@WebMethod
	public Utilisateurs rechercheUser(@WebParam(name="username")
	String username,@WebParam(name="password") String password) {	
		return metier.connection(username, password);
	}

}
