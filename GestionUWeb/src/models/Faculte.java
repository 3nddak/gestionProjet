package models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

import org.springframework.lang.NonNull;

@Entity
@Table(name="FACULTE")
public class Faculte implements Serializable {
	@Id
	@NonNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String nomFaculte;
	private Date dateCreation;
	private String nomDoyen;
	@ManyToMany
	@JoinTable(
			name="FAC_SERV",
			joinColumns=@JoinColumn(name="CODE_FAC"),
			inverseJoinColumns=@JoinColumn(name="CODE_SERV")
			)
	private Collection<ServiceslUV> services;
	@OneToMany(mappedBy="faculte",fetch=FetchType.LAZY)
	private Collection<Etudiant> etudiants;
	@OneToMany(mappedBy="faculte",fetch=FetchType.LAZY)
	private Collection<Section> sections;
	@ManyToOne
	@JoinColumn(name="ID_UNIV")
	private Universite universtite;
	
	public Faculte() {
		super();
	}

	public Faculte(String nomFaculte, Date dateCreation, String nomDoyen) {
		super();
		this.nomFaculte = nomFaculte;
		this.dateCreation = dateCreation;
		this.nomDoyen = nomDoyen;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNomFaculte() {
		return nomFaculte;
	}

	public void setNomFaculte(String nomFaculte) {
		this.nomFaculte = nomFaculte;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getNomDoyen() {
		return nomDoyen;
	}

	public void setNomDoyen(String nomDoyen) {
		this.nomDoyen = nomDoyen;
	}

	public Collection<ServiceslUV> getServices() {
		return services;
	}

	public void setServices(Collection<ServiceslUV> services) {
		this.services = services;
	}

	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public Collection<Section> getSections() {
		return sections;
	}

	public void setSections(Collection<Section> sections) {
		this.sections = sections;
	}
	
}
