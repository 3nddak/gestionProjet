package models;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@DiscriminatorValue("ENSEI")
public class CorpsEnseignant extends ServiceslUV {
	private String nomProf;
	private String prenomProf;
	private String adresseProf;
	private String tel;
	private Etudiant etudiant;
	@ManyToMany
	@JoinTable(
			name="ENSEI_MATIERE",
			joinColumns=@JoinColumn(name="CODE_ENS"),
			inverseJoinColumns=@JoinColumn(name="CODE_MATIERE")
			)
	private Collection<Matieres> listeMatieres;
	@ManyToOne
	@JoinColumn(name="CODE_SALLE")
	private SalleClasse salleClasse;
	
	public CorpsEnseignant() {
	}

	public CorpsEnseignant(String nomProf, String prenomProf, String adresseProf, String tel) {
		this.nomProf = nomProf;
		this.prenomProf = prenomProf;
		this.adresseProf = adresseProf;
		this.tel = tel;
	}

	public String getNomProf() {
		return nomProf;
	}

	public void setNomProf(String nomProf) {
		this.nomProf = nomProf;
	}

	public String getPrenomProf() {
		return prenomProf;
	}

	public void setPrenomProf(String prenomProf) {
		this.prenomProf = prenomProf;
	}

	public String getAdresseProf() {
		return adresseProf;
	}

	public void setAdresseProf(String adresseProf) {
		this.adresseProf = adresseProf;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}


}
