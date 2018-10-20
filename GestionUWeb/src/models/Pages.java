package models;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

import org.springframework.lang.NonNull;

@Entity
@Table(name="PAGES")
public class Pages implements Serializable{
	@Id
	@NonNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String URL;
	private String libelle;
	private boolean defaut;
	private boolean etat;
	private boolean surentete;
	private String codePage;
	private String libelleEn;
	@ManyToOne
	@JoinColumn(name="CODE_PROFIL")
	private Profil profils;
	@ManyToMany
	@JoinTable(name="USER_PAGES",
	joinColumns=@JoinColumn(name="ID_PAGE"),
	inverseJoinColumns=@JoinColumn(name="ID_UTILISATEURS"))
	private Collection<Utilisateurs> utilisateurs;
	@OneToMany(mappedBy="pages",fetch=FetchType.LAZY)
	private Collection<Module> modules;
	
	public Pages() {
		super();
	}

	public Pages(String uRL, String libelle, boolean defaut, boolean etat, boolean surentete, String codePage,
			String libelleEn) {
		super();
		URL = uRL;
		this.libelle = libelle;
		this.defaut = defaut;
		this.etat = etat;
		this.surentete = surentete;
		this.codePage = codePage;
		this.libelleEn = libelleEn;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public boolean isDefaut() {
		return defaut;
	}

	public void setDefaut(boolean defaut) {
		this.defaut = defaut;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public boolean isSurentete() {
		return surentete;
	}

	public void setSurentete(boolean surentete) {
		this.surentete = surentete;
	}

	public String getCodePage() {
		return codePage;
	}

	public void setCodePage(String codePage) {
		this.codePage = codePage;
	}

	public String getLibelleEn() {
		return libelleEn;
	}

	public void setLibelleEn(String libelleEn) {
		this.libelleEn = libelleEn;
	}

	public Profil getProfils() {
		return profils;
	}

	public void setProfils(Profil profils) {
		this.profils = profils;
	}

	public Collection<Utilisateurs> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(Collection<Utilisateurs> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Collection<Module> getModules() {
		return modules;
	}

	public void setModules(Collection<Module> modules) {
		this.modules = modules;
	}
	

}
