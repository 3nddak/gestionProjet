package com.daoImpl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.entities.SinistreDetail;
import com.idao.IDaoSinistreDetail;

import javassist.expr.Instanceof;

@Transactional
public class DaoSinistreDetailImpl implements IDaoSinistreDetail{
	
	@PersistenceContext
	private EntityManager em1;
	

	@Override
	public void ajouterSinistreDetail(SinistreDetail sinistreD) {
         
		/*if(!(sinistreD.getDateDeclare() instanceof Date))
		{
			System.out.println("DateDeclare n'est un instance d'une date !");
		}
		else if(!(sinistreD.getAnneProd() instanceof String))
		{
			System.out.println("AnneProd n'est un instance d'un String !");
		}*/
		/*
		else if(!(sinistreD.getCodeSem() instanceof String))
		{
			System.out.println("CodeSem n'est un instance d'un String !");
		}
		else if(!(sinistreD.getNumAvenant() instanceof String))
		{
			System.out.println("NumAvenant n'est un instance d'un String !");
		}
		else if(!(sinistreD.getSouscription() instanceof String))
		{
			System.out.println("Souscription n'est un instance d'un String !");
		}
		else if(!(sinistreD.getNumDossier() instanceof String))
		{
			System.out.println("NumDossier n'est un instance d'un String !");
		}
		else if(!(sinistreD.getMatricule() instanceof String))
		{
			System.out.println("Matricule n'est un instance d'un String !");
		}
		else if(!(sinistreD.getAssurePricipale() instanceof String))
		{
			System.out.println("AssurePricipale n'est un instance d'un String !");
		}
		else if(!(sinistreD.getBeneficiare() instanceof String))
		{
			System.out.println("Beneficiare n'est un instance d'un String !");
		}
		else if(!(sinistreD.getPrestation() instanceof String))
		{
			System.out.println("Prestation n'est un instance d'un String !");
		}
		else if(!(sinistreD.getMotifRejet() instanceof String))
		{
			System.out.println("MotifRejet n'est un instance d'un String !");
		}
		else if(!(sinistreD.getObservation() instanceof String))
		{
			System.out.println("Observation n'est un instance d'un String !");
		}
		else if(!(sinistreD.getBeneficiareCheque() instanceof String))
		{
			System.out.println("BeneficiareCheque n'est un instance d'un String !");
		}
		else if(!(sinistreD.getReferenceFacturePresta() instanceof String))
		{
			System.out.println("ReferenceFacturePresta n'est un instance d'un String !");
		}*/
	
			em1.persist(sinistreD);

	}

}
