package com.lazy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.entities.AssuPrinc;

@SuppressWarnings("deprecation")
@ManagedBean
@ApplicationScoped
public class AssurPrincService implements Serializable{
	     
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		private final static String[] souscripteur;
	     
	    private final static String[] AssurePrincipal;
	     
	    static {
	    	souscripteur = new String[10];
	        souscripteur[0] = "SOMAPHY CADRE";
	        souscripteur[1] = "SOMAPHY NON CADRE";
	        souscripteur[2] = "SOMAPHY WEST AFRICA CADRE";
	        souscripteur[3] = "SOMAPHY WEST AFRICA NON  CADRE";
	        souscripteur[4] = "SOMAPHY WEST AFRICA NON CADRE";
	        souscripteur[5] = "SOMAPHY WEST AFRIKA CADRE";
	        souscripteur[6] = "SOMAPHY WEST AFRIKA NON CADRE";
	        souscripteur[7] = "SOMAPHY WEWT AFRIKA CADRE";
	        souscripteur[8] = "SOMAPHY WEWT AFRIKA NON CADRE";
	        souscripteur[9] = "SOSETRANS";

	        AssurePrincipal = new String[10];
	        AssurePrincipal[0] = "THIAW CHEIKH SADIBOU";
	        AssurePrincipal[1] = "NDIAYE FATIMATA COUMBA SALL";
	        AssurePrincipal[2] = "NDIAYE DEMBA";
	        AssurePrincipal[3] = "FATY MOUSCOUTA";
	        AssurePrincipal[4] = "CAMARA MAME NDIEME";
	        AssurePrincipal[5] = "MBAYE IBRAHIMA";
	        AssurePrincipal[6] = "SY AL HASSANE";
	        AssurePrincipal[7] = "LO MBAYANG";
	        AssurePrincipal[8] = "SECK MAME MARIANNE";
	        AssurePrincipal[9] = "BADJI ROSALIE GEORGETTE";	        
	        
	    }
	     
	    public List<AssuPrinc> createAssu(int size) {
	        List<AssuPrinc> list = new ArrayList<AssuPrinc>();
	        for(int i = 0 ; i < size ; i++) {
	            //list.add(new AssuPrinc(getRandomId(), getRandomBrand(), getRandomYear(), getRandomColor(), getRandomPrice(), getRandomSoldState()));
	        	
	        	list.add(new AssuPrinc(getDateDeclare(new Date(2018, 1, 1), new Date(2018, 12, 31)),
	        			getString(), getInt(), getRandomSouscripteur(), getRandomAssurePrincipal(), getString(), getDouble(), getDouble()));
	        }
	         
	        return list;
	    }
	     
	    private Date getDateDeclare(Date startDate,Date endDate) {
	    	
	    	 long random = ThreadLocalRandom.current().nextLong(startDate.getTime(), endDate.getTime());
	    	    Date date = new Date(random);
	    	
	        return date;
	    }
	     
	    private String getString() {
	        return UUID.randomUUID().toString().substring(0, 8);
	    }
	    
	    
	    private int getInt() {
	        return (int) (Math.random() *10000);
	    }
	    
	    private double getDouble() {
	        return (double) (Math.random() *10000);
	    }
	     
	    private String getRandomSouscripteur() {
	        return souscripteur[(int) (Math.random() * 10)];
	    }
	     
	    private String getRandomAssurePrincipal() {
	        return AssurePrincipal[(int) (Math.random() * 10)];
	    }
	     
	    public int getRandomPrice() {
	        return (int) (Math.random() * 100000);
	    }
	     
	    public boolean getRandomSoldState() {
	        return (Math.random() > 0.5) ? true: false;
	    }
	 
	    public List<String> getColors() {
	        return Arrays.asList(souscripteur);
	    }
	     
	    public List<String> getBrands() {
	        return Arrays.asList(AssurePrincipal);
	    }

}
