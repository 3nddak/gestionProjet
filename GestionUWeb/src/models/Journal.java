package models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.lang.NonNull;

@Entity
@Table(name="JOURNAL")
public class Journal  implements Serializable{
	@Id
	@NonNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String codeEtudiant;
	private Date dateOperation;
	private String libelleOperation;
	private String valeur;
	private String reference;
	private boolean valide;
	@ManyToOne
	@JoinColumn(name="CODE_USER")
	private Utilisateurs utilisateurs;
	
	public Journal() {
		super();
	}

	public Journal(String codeEtudiant, Date dateOperation, String libelleOperation, String valeur, String reference,
			boolean valide) {
		super();
		this.codeEtudiant = codeEtudiant;
		this.dateOperation = dateOperation;
		this.libelleOperation = libelleOperation;
		this.valeur = valeur;
		this.reference = reference;
		this.valide = valide;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getCodeEtudiant() {
		return codeEtudiant;
	}

	public void setCodeEtudiant(String codeEtudiant) {
		this.codeEtudiant = codeEtudiant;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public String getLibelleOperation() {
		return libelleOperation;
	}

	public void setLibelleOperation(String libelleOperation) {
		this.libelleOperation = libelleOperation;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public Utilisateurs getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(Utilisateurs utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	
	
}
