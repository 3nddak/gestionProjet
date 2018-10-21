package org.uweb.uv.beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean(name="lbean")
@SessionScoped
public class LoginBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String login;
	private String password;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}