package models;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

import org.springframework.lang.NonNull;

@Entity
@Table(name="ADMINISTRATION_UV")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_SERVICE",discriminatorType=DiscriminatorType.STRING,length=10)
public class ServiceslUV implements Serializable{
	@Id
	@NonNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JoinColumn(name="ID_SERVICE")
	private int Id;
	private String nomServicelUV;
	private String adresse;
	private String tel;
	private String bp;
	@ManyToOne
	@JoinColumn(name="CODE_SUP")
	private ServiceslUV responsableServ;
	@ManyToMany(mappedBy="services")
	private Collection<Faculte> faculte;
	@OneToMany(mappedBy="serviceslUV",fetch=FetchType.LAZY)
	private Collection<Universite> universtites;
	@OneToMany(mappedBy="serviceslUV",fetch=FetchType.LAZY)
	private Collection<Utilisateurs> utilisateurs;
	
	
	public ServiceslUV() {
		super();
	}


	public ServiceslUV(String nom, String adresse, String tel, String bp) {
		super();
		this.nomServicelUV = nom;
		this.adresse = adresse;
		this.tel = tel;
		this.bp = bp;
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getNom() {
		return nomServicelUV;
	}


	public void setNom(String nom) {
		this.nomServicelUV = nom;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getBp() {
		return bp;
	}


	public void setBp(String bp) {
		this.bp = bp;
	}


	public String getNomServicelUV() {
		return nomServicelUV;
	}


	public void setNomServicelUV(String nomServicelUV) {
		this.nomServicelUV = nomServicelUV;
	}


	public ServiceslUV getResponsableServ() {
		return responsableServ;
	}


	public void setResponsableServ(ServiceslUV responsableServ) {
		this.responsableServ = responsableServ;
	}


	public Collection<Faculte> getFaculte() {
		return faculte;
	}


	public void setFaculte(Collection<Faculte> faculte) {
		this.faculte = faculte;
	}


	public Collection<Universite> getUniverstites() {
		return universtites;
	}


	public void setUniverstites(Collection<Universite> universtites) {
		this.universtites = universtites;
	}
	
	
}
