package org.uweb.uv;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.RequestScope;
import org.uweb.uv.beans.LoginBean;
import org.uweb.uv.metier.imetier.IMetierUtilisateurs;

/**
 * Handles requests for the application home page.
 */
@ManagedBean(name="login")
@RequestScope
@Controller
public class HomeController {
	private IMetierUtilisateurs metier;
	
	private LoginBean login=new LoginBean();
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("loginForm", new LoginBean());
		return "index";
	}
	
	@RequestMapping(value = "/recherUser",method=RequestMethod.GET)
	public boolean authentifier() {
		FacesMessage message = null;
        boolean loggedIn = false;
        
        //System.out.println("RechercheUser =="+musers);
         //System.out.println("RechercheUser =="+musers.rechercheUser(username, password));
         //System.out.println(musers.toString());
        if(metier.rechercheUser(login.getLogin(), login.getPassword())) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", login.getLogin());
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
		return false;
	}
	
}
