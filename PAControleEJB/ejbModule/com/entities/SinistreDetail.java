package com.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class SinistreDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = true)
	private Date dateDeclare;
	@Column(nullable = true)
	private String anneProd;
	@Column(nullable = true)
	private int codeBranche;
	@Column(nullable = true)
	private String codeSem;
	@Column(nullable = true)
	private int numPolice;
	@Column(nullable = true)
	private String numAvenant;
	@Column(nullable = true)
	private String souscription;
	@Column(nullable = true)
	private String numDossier;
	@Column(nullable = true)
	private String matricule;
	@Column(nullable = true)
	private String assurePricipale;
	@Column(nullable = true)
	private String beneficiare;
	@Column(nullable = true)
	private String prestation;
	@Column(nullable = true)
	private double expose;
	@Column(nullable = true)
	private double paye;
	@Column(nullable = true)
	private double rejet;
	@Column(nullable = true)
	private double parAssu;
	@Column(nullable = true)
	private String motifRejet;
	@Column(nullable = true)
	private String observation;
	@Column(nullable = true)
	private String beneficiareCheque;
	@Column(nullable = true)
	private String referenceFacturePresta;

	public SinistreDetail() {
		super();

	}

	/**
	 * @param dateDeclare
	 * @param anneProd
	 * @param codeBranche
	 * @param codeSem
	 * @param numPolice
	 * @param numAvenant
	 * @param souscription
	 * @param numDossier
	 * @param matricule
	 * @param assurePricipale
	 * @param beneficiare
	 * @param prestation
	 * @param expose
	 * @param paye
	 * @param rejet
	 * @param parAssu
	 * @param motifRejet
	 * @param observation
	 * @param beneficiareCheque
	 * @param referenceFacturePresta
	 * 
	 * 
	 * 
	 */

	public SinistreDetail(Date dateDeclare, String anneProd, int codeBranche, String codeSem, int numPolice,
			String numAvenant, String souscription, String numDossier, String matricule, String assurePricipale,
			String beneficiare, String prestation, double expose, double paye, double rejet, double parAssu,
			String motifRejet, String observation, String beneficiareCheque, String referenceFacturePresta) {
		super();
		this.dateDeclare = dateDeclare;
		this.anneProd = anneProd;
		this.codeBranche = codeBranche;
		this.codeSem = codeSem;
		this.numPolice = numPolice;
		this.numAvenant = numAvenant;
		this.souscription = souscription;
		this.numDossier = numDossier;
		this.matricule = matricule;
		this.assurePricipale = assurePricipale;
		this.beneficiare = beneficiare;
		this.prestation = prestation;
		this.expose = expose;
		this.paye = paye;
		this.rejet = rejet;
		this.parAssu = parAssu;
		this.motifRejet = motifRejet;
		this.observation = observation;
		this.beneficiareCheque = beneficiareCheque;
		this.referenceFacturePresta = referenceFacturePresta;
	}

	public SinistreDetail(Date dateDeclare, String anneProd) {
		super();
		this.dateDeclare = dateDeclare;
		this.anneProd = anneProd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateDeclare() {
		return dateDeclare;
	}

	public void setDateDeclare(Date dateDeclare) {
		this.dateDeclare = dateDeclare;
	}

	public String getAnneProd() {
		return anneProd;
	}

	public void setAnneProd(String anneProd) {
		this.anneProd = anneProd;
	}

	public int getCodeBranche() {
		return codeBranche;
	}

	public void setCodeBranche(int codeBranche) {
		this.codeBranche = codeBranche;
	}

	public String getCodeSem() {
		return codeSem;
	}

	public void setCodeSem(String codeSem) {
		this.codeSem = codeSem;
	}

	public int getNumPolice() {
		return numPolice;
	}

	public void setNumPolice(int numPolice) {
		this.numPolice = numPolice;
	}

	public String getNumAvenant() {
		return numAvenant;
	}

	public void setNumAvenant(String numAvenant) {
		this.numAvenant = numAvenant;
	}

	public String getSouscription() {
		return souscription;
	}

	public void setSouscription(String souscription) {
		this.souscription = souscription;
	}

	public String getNumDossier() {
		return numDossier;
	}

	public void setNumDossier(String numDossier) {
		this.numDossier = numDossier;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getAssurePricipale() {
		return assurePricipale;
	}

	public void setAssurePricipale(String assurePricipale) {
		this.assurePricipale = assurePricipale;
	}

	public String getBeneficiare() {
		return beneficiare;
	}

	public void setBeneficiare(String beneficiare) {
		this.beneficiare = beneficiare;
	}

	public String getPrestation() {
		return prestation;
	}

	public void setPrestation(String prestation) {
		this.prestation = prestation;
	}

	public double getExpose() {
		return expose;
	}

	public void setExpose(double expose) {
		this.expose = expose;
	}

	public double getPaye() {
		return paye;
	}

	public void setPaye(double paye) {
		this.paye = paye;
	}

	public double getRejet() {
		return rejet;
	}

	public void setRejet(double rejet) {
		this.rejet = rejet;
	}

	public double getParAssu() {
		return parAssu;
	}

	public void setParAssu(double parAssu) {
		this.parAssu = parAssu;
	}

	public String getMotifRejet() {
		return motifRejet;
	}

	public void setMotifRejet(String motifRejet) {
		this.motifRejet = motifRejet;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getBeneficiareCheque() {
		return beneficiareCheque;
	}

	public void setBeneficiareCheque(String beneficiareCheque) {
		this.beneficiareCheque = beneficiareCheque;
	}

	public String getReferenceFacturePresta() {
		return referenceFacturePresta;
	}

	public void setReferenceFacturePresta(String referenceFacturePresta) {
		this.referenceFacturePresta = referenceFacturePresta;
	}

}
