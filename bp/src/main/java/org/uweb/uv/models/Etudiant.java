package org.uweb.uv.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

import org.springframework.lang.NonNull;

@Entity
@Table(name="ETUDIANTS")
public class Etudiant implements Serializable{
	@Id
	@NonNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ETUDIANT")
	private int Id;
	private String  nom;
	private String prenom;
	private Date dateNaissance;
	private String adresse;
	private String nationalite;
	private String telephone;
	private String email;
	private String numeroPiece;
	@ManyToOne
	@JoinColumn(name="CODE_UV")
	private Universite universite;
	@OneToMany(mappedBy="etudiant",fetch=FetchType.LAZY)
	private Collection<Matieres> matieres;
	@OneToMany(mappedBy="etudiant",fetch=FetchType.LAZY)
	private Collection<CorpsEnseignant> proffesseurs;
	@ManyToOne
	@JoinColumn(name="CODE_FILIERE")
	private SalleClasse filliere;
	@OneToMany(mappedBy="etudiantDiplome",fetch=FetchType.LAZY)
	private Collection<Diplomes> diplomes;
	@ManyToOne
	@JoinColumn(name="CODE_SALLE")
	private SalleClasse salleClasse;
	@ManyToOne
	@JoinColumn(name="ID_FAC")
	private Faculte faculte;
	
	
	public Etudiant() {
		super();
	}
	
	public Etudiant(String nom, String prenom, Date dateNaissance, String adresse, String nationalite, String telephone,
			String email, String numeroPiece) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.nationalite = nationalite;
		this.telephone = telephone;
		this.email = email;
		this.numeroPiece = numeroPiece;
	}

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumeroPiece() {
		return numeroPiece;
	}
	public void setNumeroPiece(String numeroPiece) {
		this.numeroPiece = numeroPiece;
	}
	public Universite getUniversite() {
		return universite;
	}
	public void setUniversite(Universite universite) {
		this.universite = universite;
	}
	public Collection<Matieres> getMatieres() {
		return matieres;
	}
	public void setMatieres(Collection<Matieres> matieres) {
		this.matieres = matieres;
	}
	public Collection<CorpsEnseignant> getCorpsEnseignant() {
		return proffesseurs;
	}
	public void setCorpsEnseignant(Collection<CorpsEnseignant> proffesseurs) {
		this.proffesseurs = proffesseurs;
	}
	public SalleClasse getFilliere() {
		return filliere;
	}
	public void setFilliere(SalleClasse filliere) {
		this.filliere = filliere;
	}
	public Collection<Diplomes> getDiplomes() {
		return diplomes;
	}
	public void setDiplomes(Collection<Diplomes> diplomes) {
		this.diplomes = diplomes;
	}
}
