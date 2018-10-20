package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.springframework.lang.NonNull;
@Entity
@Table(name="DIPLOMES")
public class Diplomes implements Serializable {
	@Id
	@NonNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String nomDiplome;
	private Faculte diplomesFaculte;
	private Date dateDelivrance;
	@ManyToOne
	@JoinColumn(name="ID_ETUDIANT")
	private Etudiant etudiantDiplome;
	
	public Diplomes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Diplomes(String nomDiplome, Date dateDelivrance) {
		super();
		this.nomDiplome = nomDiplome;
		this.dateDelivrance = dateDelivrance;
	}

	public String getNomDiplome() {
		return nomDiplome;
	}

	public void setNomDiplome(String nomDiplome) {
		this.nomDiplome = nomDiplome;
	}

	public Faculte getDiplomesFaculte() {
		return diplomesFaculte;
	}

	public void setDiplomesFaculte(Faculte diplomesFaculte) {
		this.diplomesFaculte = diplomesFaculte;
	}

	public Date getDateDelivrance() {
		return dateDelivrance;
	}

	public void setDateDelivrance(Date dateDelivrance) {
		this.dateDelivrance = dateDelivrance;
	}

	public Etudiant getEtudiantDiplome() {
		return etudiantDiplome;
	}

	public void setEtudiantDiplome(Etudiant etudiantDiplome) {
		this.etudiantDiplome = etudiantDiplome;
	}
	

}
