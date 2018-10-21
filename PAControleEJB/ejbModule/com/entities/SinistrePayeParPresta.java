package com.entities;

import java.util.Date;

import javax.persistence.Column;

public class SinistrePayeParPresta {
	
	private Date dateDeclare;
	private String numDossier;
	private int numPolice;
	private String souscriptuer;
	private double expose;
	private double paye;
	private String libelletFacture;
	private String banque;
	private String cheque;
	
	public SinistrePayeParPresta() {
		super();

	}

	public SinistrePayeParPresta(Date dateDeclare, String numDossier, int numPolice, String souscriptuer, double expose,
			double paye, String libelletFacture, String banque, String cheque) {
		super();
		this.dateDeclare = dateDeclare;
		this.numDossier = numDossier;
		this.numPolice = numPolice;
		this.souscriptuer = souscriptuer;
		this.expose = expose;
		this.paye = paye;
		this.libelletFacture = libelletFacture;
		this.banque = banque;
		this.cheque = cheque;
	}

	public Date getDateDeclare() {
		return dateDeclare;
	}

	public void setDateDeclare(Date dateDeclare) {
		this.dateDeclare = dateDeclare;
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

	public String getSouscriptuer() {
		return souscriptuer;
	}

	public void setSouscriptuer(String souscriptuer) {
		this.souscriptuer = souscriptuer;
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

	public String getLibelletFacture() {
		return libelletFacture;
	}

	public void setLibelletFacture(String libelletFacture) {
		this.libelletFacture = libelletFacture;
	}

	public String getBanque() {
		return banque;
	}

	public void setBanque(String banque) {
		this.banque = banque;
	}

	public String getCheque() {
		return cheque;
	}

	public void setCheque(String cheque) {
		this.cheque = cheque;
	}
	
	
	
	
}