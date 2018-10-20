package models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

import org.springframework.lang.NonNull;
@Entity
@Table(name="MATIERES")
public class Matieres implements Serializable {
	@Id
	@NonNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String nomMatiere;
	private Date dateCreation;
	private String coefficient;
	private int nombreHeures;
	@ManyToOne
	@JoinColumn(name="CODE_SECTION")
	private Section section;
	@ManyToOne
	@JoinColumn(name="CODE_ETUDIANT")
	private Etudiant etudiant;
	@ManyToMany(mappedBy="listeMatieres")
	private Collection<CorpsEnseignant> corpsEnseignants;
	
	
	public Matieres() {
	}


	public Matieres(String nomMatiere, Date dateCreation, String coefficient, int nombreHeures) {
		super();
		this.nomMatiere = nomMatiere;
		this.dateCreation = dateCreation;
		this.coefficient = coefficient;
		this.nombreHeures = nombreHeures;
	}


	public String getNomMatiere() {
		return nomMatiere;
	}


	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}


	public Date getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	public String getCoefficient() {
		return coefficient;
	}


	public void setCoefficient(String coefficient) {
		this.coefficient = coefficient;
	}


	public int getNombreHeures() {
		return nombreHeures;
	}


	public void setNombreHeures(int nombreHeures) {
		this.nombreHeures = nombreHeures;
	}


	public Section getSection() {
		return section;
	}


	public void setSection(Section section) {
		this.section = section;
	}


	public Etudiant getEtudiant() {
		return etudiant;
	}


	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}


	public Collection<CorpsEnseignant> getCorpsEnseignants() {
		return corpsEnseignants;
	}


	public void setCorpsEnseignants(Collection<CorpsEnseignant> corpsEnseignants) {
		this.corpsEnseignants = corpsEnseignants;
	}
	
	

}
