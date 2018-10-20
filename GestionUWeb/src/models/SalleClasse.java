package models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

import org.springframework.lang.NonNull;

@Entity
@Table(name="SALLE")
public class SalleClasse implements Serializable {
	@Id
	@NonNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nomSalle;
	private String SurfaceSalle;
	private Date dateCreationSalle;
	@OneToMany(mappedBy="salleClasse",fetch=FetchType.LAZY)
	private Collection<CorpsEnseignant> corpsEnseignant;
	@OneToMany(mappedBy="salleClasse",fetch=FetchType.LAZY)
	private Collection<Etudiant> etudiants;
	@ManyToMany
	@JoinTable(name="CLASS_SECTION",
	joinColumns=@JoinColumn(name="ID_CLASS"),
	inverseJoinColumns=@JoinColumn(name="ID_SECTION"))
	private Collection<Section> section;
	
	public SalleClasse() {
	}

	public SalleClasse(String nomSalle, String surfaceSalle, Date dateCreationSalle) {
		super();
		this.nomSalle = nomSalle;
		SurfaceSalle = surfaceSalle;
		this.dateCreationSalle = dateCreationSalle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomSalle() {
		return nomSalle;
	}

	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}

	public String getSurfaceSalle() {
		return SurfaceSalle;
	}

	public void setSurfaceSalle(String surfaceSalle) {
		SurfaceSalle = surfaceSalle;
	}

	public Date getDateCreationSalle() {
		return dateCreationSalle;
	}

	public void setDateCreationSalle(Date dateCreationSalle) {
		this.dateCreationSalle = dateCreationSalle;
	}

	public Collection<CorpsEnseignant> getCorpsEnseignant() {
		return corpsEnseignant;
	}

	public void setCorpsEnseignant(Collection<CorpsEnseignant> corpsEnseignant) {
		this.corpsEnseignant = corpsEnseignant;
	}

	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
}
