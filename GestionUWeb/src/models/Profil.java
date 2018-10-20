package models;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

import org.springframework.lang.NonNull;

@Entity
@Table(name="PROFILS")
public class Profil implements Serializable{
	@Id
	@NonNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String libelleProfil;
	private int delaiexpirationpawd;
	@OneToMany(mappedBy="profil",fetch=FetchType.LAZY)
	private Collection<Utilisateurs> utilisateurs;
	@OneToMany(mappedBy="profils",fetch=FetchType.LAZY)
	private Collection<Pages> pages;
	
	public Profil() {
		super();
	}

	public Profil(String libelleProfil, int delaiexpirationpawd) {
		super();
		this.libelleProfil = libelleProfil;
		this.delaiexpirationpawd = delaiexpirationpawd;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getLibelleProfil() {
		return libelleProfil;
	}

	public void setLibelleProfil(String libelleProfil) {
		this.libelleProfil = libelleProfil;
	}

	public int getDelaiexpirationpawd() {
		return delaiexpirationpawd;
	}

	public void setDelaiexpirationpawd(int delaiexpirationpawd) {
		this.delaiexpirationpawd = delaiexpirationpawd;
	}

	public Collection<Utilisateurs> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(Collection<Utilisateurs> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Collection<Pages> getPages() {
		return pages;
	}

	public void setPages(Collection<Pages> pages) {
		this.pages = pages;
	}
	

}
