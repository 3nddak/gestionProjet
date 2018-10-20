package models;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

import org.springframework.lang.NonNull;

@Entity
@Table(name="MODULE")
public class Module implements Serializable{
	@Id
	@NonNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String libelle;
	private String image;
	private String codeModule;
	private String libelleEN;
	@ManyToMany
	@JoinColumn(name="CODE_PAGE")
	private Collection<Pages> pages;
	
	public Module() {
		super();
	}

	public Module(String libelle, String image, String codeModule, String libelleEN) {
		super();
		this.libelle = libelle;
		this.image = image;
		this.codeModule = codeModule;
		this.libelleEN = libelleEN;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCodeModule() {
		return codeModule;
	}

	public void setCodeModule(String codeModule) {
		this.codeModule = codeModule;
	}

	public String getLibelleEN() {
		return libelleEN;
	}

	public void setLibelleEN(String libelleEN) {
		this.libelleEN = libelleEN;
	}

	public Collection<Pages> getPages() {
		return pages;
	}

	public void setPages(Collection<Pages> pages) {
		this.pages = pages;
	}



}
