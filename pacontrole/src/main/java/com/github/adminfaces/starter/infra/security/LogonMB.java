package com.github.adminfaces.starter.infra.security;

import static com.github.adminfaces.starter.util.Utils.addDetailMessage;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;

import com.entities.Utilisateurs;
import com.github.adminfaces.template.config.AdminConfig;
import com.github.adminfaces.template.session.AdminSession;
import com.session.IMetierLocale;

/**
 * Created by rmpestano on 12/20/14.
 *
 * This is just a login example.
 *
 * AdminSession uses isLoggedIn to determine if user must be redirect to login page or not.
 * By default AdminSession isLoggedIn always resolves to true so it will not try to redirect user.
 *
 * If you already have your authorization mechanism which controls when user must be redirect to initial page or logon
 * you can skip this class.
 */
@Named
@SessionScoped
@Specializes
public class LogonMB extends AdminSession implements Serializable {
	@EJB
	private IMetierLocale metier;
    private String currentUser;
    private String username;
    private String password;
    private Utilisateurs user;
    private boolean remember;
    @Inject
    private AdminConfig adminConfig;


    public void login() throws IOException {
    	System.out.println("Login = "+metier.connection(username, password));
    	user = metier.connection(username, password);
       if(metier.connection(username, password)!=null) {
    	   currentUser=username;
           addDetailMessage("Vous êtes connecté en tant que  <b>" + username + "</b>");
           Faces.getExternalContext().getFlash().setKeepMessages(true);
           Faces.redirect(adminConfig.getIndexPage());
       }
    }
    
    

    public Utilisateurs getUser() {
		return user;
	}



	public void setUser(Utilisateurs user) {
		this.user = user;
	}



	@Override
    public boolean isLoggedIn() {

        return currentUser != null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }
}
