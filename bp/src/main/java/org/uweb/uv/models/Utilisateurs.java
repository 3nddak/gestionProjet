package org.uweb.uv.models;

import java.io.Serializable;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

import org.springframework.lang.NonNull;
@Entity
@Table(name="UTILISATEURS")
public class Utilisateurs implements  Serializable{
	@Id
	@NonNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String nomUser;
	private String prenomUser;
	private String login;
	private String passwd;
	private boolean verouiller;
	private boolean etat;
	private boolean connecte;
	private Date dateCreation;
	private Date dateChangementPwd;
	private String tel;
	private String EMEI;
	@ManyToOne
	@JoinColumn(name="CODE_PROFIL")
	private Profil profil;
	@OneToMany(mappedBy="utilisateurs",fetch=FetchType.LAZY)
	private Collection<Journal> journals;
	@ManyToMany(mappedBy="utilisateurs",fetch=FetchType.LAZY)
	private Collection<Pages> pages;
	@ManyToOne
	@JoinColumn(name="CODE_SERV")
	private ServiceslUV serviceslUV;
	
	
	public Utilisateurs() {
		super();
	}


	public Utilisateurs(String nomUser, String prenomUser, String login, String passwd, boolean verouiller, boolean etat,
			boolean connecte, Date dateCreation, Date dateChangementPwd, String tel, String eMEI) {
		super();
		this.nomUser = nomUser;
		this.prenomUser = prenomUser;
		this.login = login;
		this.passwd = passwd;
		this.verouiller = verouiller;
		this.etat = etat;
		this.connecte = connecte;
		this.dateCreation = dateCreation;
		this.dateChangementPwd = dateChangementPwd;
		this.tel = tel;
		EMEI = eMEI;
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getNomUser() {
		return nomUser;
	}


	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}


	public String getPrenomUser() {
		return prenomUser;
	}


	public void setPrenomUser(String prenomUser) {
		this.prenomUser = prenomUser;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public boolean isVerouiller() {
		return verouiller;
	}


	public void setVerouiller(boolean verouiller) {
		this.verouiller = verouiller;
	}


	public boolean isEtat() {
		return etat;
	}


	public void setEtat(boolean etat) {
		this.etat = etat;
	}


	public boolean isConnecte() {
		return connecte;
	}


	public void setConnecte(boolean connecte) {
		this.connecte = connecte;
	}


	public Date getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	public Date getDateChangementPwd() {
		return dateChangementPwd;
	}


	public void setDateChangementPwd(Date dateChangementPwd) {
		this.dateChangementPwd = dateChangementPwd;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getEMEI() {
		return EMEI;
	}


	public void setEMEI(String eMEI) {
		EMEI = eMEI;
	}


	public Profil getProfil() {
		return profil;
	}


	public void setProfil(Profil profil) {
		this.profil = profil;
	}


	public Collection<Journal> getJournals() {
		return journals;
	}


	public void setJournals(Collection<Journal> journals) {
		this.journals = journals;
	}


	public Collection<Pages> getPages() {
		return pages;
	}


	public void setPages(Collection<Pages> pages) {
		this.pages = pages;
	}
	
}
