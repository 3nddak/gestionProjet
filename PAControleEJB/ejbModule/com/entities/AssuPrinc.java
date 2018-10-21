package com.entities;

import java.util.Date;

public class AssuPrinc {
	
	private Date dateDeclare;
	private String numDossier;
	private int numPolice;
	private String souscripteur;
	private String AssurePricipale;
	private String beneficiare;
	private double expose;
	private double paye;
	
	
	
	public AssuPrinc() {
		super();
	}

	public AssuPrinc(Date dateDeclare, String numDossier, int numPolice, String souscripteur, String assurePricipale,
			String beneficiare, double expose, double paye) {
		super();
		this.dateDeclare = dateDeclare;
		this.numDossier = numDossier;
		this.numPolice = numPolice;
		this.souscripteur = souscripteur;
		AssurePricipale = assurePricipale;
		this.beneficiare = beneficiare;
		this.expose = expose;
		this.paye = paye;
	}

	public String getSouscripteur() {
		return souscripteur;
	}

	public void setSouscripteur(String souscripteur) {
		this.souscripteur = souscripteur;
	}

	public String getNumDossier() {
		return numDossier;
	}

	public void setNumDossier(String numDossier) {
		this.numDossier = numDossier;
	}



	public int getNumPolice() {
		return numPolice;
	}



	public void setNumPolice(int numPolice) {
		this.numPolice = numPolice;
	}



	public Date getDateDeclare() {
		return dateDeclare;
	}
	public void setDateDeclare(Date dateDeclare) {
		this.dateDeclare = dateDeclare;
	}
	public String getAssurePricipale() {
		return AssurePricipale;
	}
	public void setAssurePricipale(String assurePricipale) {
		AssurePricipale = assurePricipale;
	}
	public String getBeneficiare() {
		return beneficiare;
	}
	public void setBeneficiare(String beneficiare) {
		this.beneficiare = beneficiare;
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
	
	

}
