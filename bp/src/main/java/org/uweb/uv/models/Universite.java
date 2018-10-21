package org.uweb.uv.models;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

import org.springframework.lang.NonNull;
@Entity
@Table(name="UNIVERSITE")
public class Universite implements Serializable {
	@Id
	@NonNull
	@JoinColumn(name="CODE_UNIV")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String nomUV;
	private String adresseUV;
	private String bpUV;
	private String pays;
	private String ville;
	@OneToMany(mappedBy="universtite",fetch=FetchType.LAZY)
	private Collection<Faculte> facultes;
	@OneToMany(mappedBy="faculte",fetch=FetchType.LAZY)
	private Collection<ServiceslUV> administratifs;
	@ManyToOne
	@JoinColumn(name="CODE_SERV")
	private ServiceslUV serviceslUV;
	
	
	public Universite() {
		super();
	}

	public Universite(String nomUV, String adresseUV, String bpUV, String pays, String ville) {
		super();
		this.nomUV = nomUV;
		this.adresseUV = adresseUV;
		this.bpUV = bpUV;
		this.pays = pays;
		this.ville = ville;
	}


	public String getNomUV() {
		return nomUV;
	}


	public void setNomUV(String nomUV) {
		this.nomUV = nomUV;
	}


	public String getAdresseUV() {
		return adresseUV;
	}


	public void setAdresseUV(String adresseUV) {
		this.adresseUV = adresseUV;
	}


	public String getBpUV() {
		return bpUV;
	}


	public void setBpUV(String bpUV) {
		this.bpUV = bpUV;
	}


	public String getPays() {
		return pays;
	}


	public void setPays(String pays) {
		this.pays = pays;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}

}
