package com.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Sinistre {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable=true)
	private Date dateDeclare;
	@Column(nullable=true)
	private String anneeProd;
	@Column(nullable=true)
	private int codeBranche;
	@Column(nullable=true)
	private String numDossier;
	@Column(nullable=true)
	private int numPolice;
	@Column(nullable=true)
	private String numAvenant;
	@Column(nullable=true)
	private String souscriptuer;
	@Column(nullable=true)
	private String beneficiare;
	@Column(nullable=true)
	private double expose;
	@Column(nullable=true)
	private double paye;
	@Column(nullable=true)
	private double recours;
	@Column(nullable=true)
	private double rejet;
	@Column(nullable=true)
	private double partPA;
	@Column(nullable=true)
	private String libelletFacture;
	@Column(nullable=true)
	private String codeSem;
	@Column(nullable=true)
	private String banque;
	@Column(nullable=true)
	private String cheque;
	@Column(nullable=true)
	private Date date;
	@Column(nullable=true)
	private String observation;
	@ManyToOne
	@JoinColumn(name="id_service",insertable=true,updatable=true)
	private Service service;
	public Sinistre() {
		
	}





	public Sinistre(Date dateDeclare, String anneeProd, int codeBranche, String numDossier, int numPolice,
			String numAvenant, String souscriptuer, String beneficiare, double expose, double paye, double recours,
			double rejet, double partPA, String libelletFacture, String codeSem, String banque, String cheque,
			Date date, String observation,int id) {
		super();
		this.dateDeclare = dateDeclare;
		this.anneeProd = anneeProd;
		this.codeBranche = codeBranche;
		this.numDossier = numDossier;
		this.numPolice = numPolice;
		this.numAvenant = numAvenant;
		this.souscriptuer = souscriptuer;
		this.beneficiare = beneficiare;
		this.expose = expose;
		this.paye = paye;
		this.recours = recours;
		this.rejet = rejet;
		this.partPA = partPA;
		this.libelletFacture = libelletFacture;
		this.codeSem = codeSem;
		this.banque = banque;
		this.cheque = cheque;
		this.date = date;
		this.observation = observation;
		this.service = new Service(id);
	}
	
	
	public Sinistre(Date dateDeclare, String anneeProd, int codeBranche, String numDossier, int numPolice,
			String numAvenant, String souscriptuer, String beneficiare, double expose, double paye, double recours,
			double rejet, double partPA, String libelletFacture, String codeSem, String banque, String cheque,
			Date date, String observation) {
		super();
		this.dateDeclare = dateDeclare;
		this.anneeProd = anneeProd;
		this.codeBranche = codeBranche;
		this.numDossier = numDossier;
		this.numPolice = numPolice;
		this.numAvenant = numAvenant;
		this.souscriptuer = souscriptuer;
		this.beneficiare = beneficiare;
		this.expose = expose;
		this.paye = paye;
		this.recours = recours;
		this.rejet = rejet;
		this.partPA = partPA;
		this.libelletFacture = libelletFacture;
		this.codeSem = codeSem;
		this.banque = banque;
		this.cheque = cheque;
		this.date = date;
	}

	




	public Sinistre(Date dateDeclare, String numDossier, int numPolice, String souscriptuer, double paye,
			String libelletFacture, String banque, String cheque, Date date) {
		super();
		this.dateDeclare = dateDeclare;
		this.numDossier = numDossier;
		this.numPolice = numPolice;
		this.souscriptuer = souscriptuer;
		this.paye = paye;
		this.libelletFacture = libelletFacture;
		this.banque = banque;
		this.cheque = cheque;
		this.date = date;
	}





	public Sinistre(int id, Date dateDeclare,String souscriptuer, String beneficiare,
			double expose, double paye) {
		super();
		this.id = id;
		this.dateDeclare = dateDeclare;
		this.souscriptuer = souscriptuer;
		this.beneficiare = beneficiare;
		this.expose = expose;
		this.paye = paye;
	}


	public Sinistre(Date dateDeclare, String numDossier, int numPolice, String souscriptuer, double paye,
			String libelletFacture, String banque, String cheque, Date date,int id) {
		super();
		this.dateDeclare = dateDeclare;
		this.numDossier = numDossier;
		this.numPolice = numPolice;
		this.souscriptuer = souscriptuer;
		this.paye = paye;
		this.libelletFacture = libelletFacture;
		this.banque = banque;
		this.cheque = cheque;
		this.date = date;
		this.service=new Service(id);
	}
	




	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
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


	public String getAnneeProd() {
		return anneeProd;
	}


	public void setAnneeProd(String anneeProd) {
		this.anneeProd = anneeProd;
	}


	public int getCodeBranche() {
		return codeBranche;
	}


	public void setCodeBranche(int codeBranche) {
		this.codeBranche = codeBranche;
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


	public String getNumAvenant() {
		return numAvenant;
	}


	public void setNumAvenant(String numAvenant) {
		this.numAvenant = numAvenant;
	}


	public String getSouscriptuer() {
		return souscriptuer;
	}


	public void setSouscriptuer(String souscriptuer) {
		this.souscriptuer = souscriptuer;
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


	public double getRecours() {
		return recours;
	}


	public void setRecours(double recours) {
		this.recours = recours;
	}


	public double getRejet() {
		return rejet;
	}


	public void setRejet(double rejet) {
		this.rejet = rejet;
	}


	public double getPartPA() {
		return partPA;
	}


	public void setPartPA(double partPA) {
		this.partPA = partPA;
	}


	public String getLibelletFacture() {
		return libelletFacture;
	}


	public void setLibelletFacture(String libelletFacture) {
		this.libelletFacture = libelletFacture;
	}


	public String getCodeSem() {
		return codeSem;
	}


	public void setCodeSem(String codeSem) {
		this.codeSem = codeSem;
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


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getObservation() {
		return observation;
	}


	public void setObservation(String observation) {
		this.observation = observation;
	}
	
}
