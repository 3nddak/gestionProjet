package com.Controleur;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import metier.imetier.IMetierUtilisateurs;

//@Controller
@ManagedBean(name="login")
@SessionScoped
public class LoginModel implements Serializable{
	//private IMetierUtilisateurs metier;
	private static final long serialVersionUID = 7412338055378806074L;
	private String username;
	private String password;
	//@Autowired(required=true)
	private IMetierUtilisateurs metier;
	

	
	
	public LoginModel() {
		
        metier=(IMetierUtilisateurs) ContextProvider.context.getBean("metier");	
	}

	public String getUsername() {
		return username;
	}

	
	/*public LoginModel(@Autowired IMetierUtilisateurs metier) {
		this.metier = metier;
	}*/

	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void login() {
        FacesMessage message = null;
        boolean loggedIn = false;
        System.out.println("-----------------------------------------------------------------");
        System.out.println("*********");
        System.out.println(username);
        System.out.println("*********");
        System.out.println("Resultat rechercheUser ="+metier.rechercheUser(username, password));
        System.out.println(password);
        System.out.println("-------------------------------------------------------------------");
        //boolean vrais=true;
        
        if(metier.rechercheUser(username, password)) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
            	try {
					FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
				} catch (IOException e) {
					e.printStackTrace();
				}
			
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erreur de nom d'utilisateur", "Invalid credentials");
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
    }
}
