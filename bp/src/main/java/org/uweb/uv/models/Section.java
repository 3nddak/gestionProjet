package org.uweb.uv.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name="SECTION")
public class Section implements Serializable{
	@Id
	@NonNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nomSection;
	private Date dateCreation;
	@ManyToOne
	@JoinColumn(name="ID_FAC")
	private Faculte faculte;
	@OneToMany(mappedBy="section",fetch=FetchType.LAZY)
	private Collection<SalleClasse> classes;
	
	public Section() {
	}

	public Section(String nomSection, Date dateCreation) {
		super();
		this.nomSection = nomSection;
		this.dateCreation = dateCreation;
	}

	public String getNomSection() {
		return nomSection;
	}

	public void setNomSection(String nomSection) {
		this.nomSection = nomSection;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Faculte getFaculte() {
		return faculte;
	}

	public void setFaculte(Faculte faculte) {
		this.faculte = faculte;
	}

	public Collection<SalleClasse> getClasses() {
		return classes;
	}

	public void setClasses(Collection<SalleClasse> classes) {
		this.classes = classes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
