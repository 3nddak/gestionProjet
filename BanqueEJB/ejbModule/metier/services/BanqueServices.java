package metier.services;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import metier.entities.Compte;
import metier.sessions.IBanqueLocale;

@Stateless
@WebService
public class BanqueServices {
	@EJB(beanName="BK")
	private IBanqueLocale metier;
	
	@WebMethod
	public void addCompte(@WebParam(name="solde") double soldeInit) {
		
		Compte cp = new Compte(soldeInit, new Date(), true);
		metier.addCompte(cp);
	}
	
	@WebMethod
	public List<Compte> listCompte(){
		
		return metier.listCompe();
	}
	
	public Compte getCompte(Long code) {
		
		return metier.getCompte(code);
	}
	
	@WebMethod
	public void verser(@WebParam(name="montant") double mt,@WebParam(name="numCpte") Long cpt) {
		metier.verver(mt, cpt);
	}
	
	
	@WebMethod
	public void retirer(@WebParam(name="montant") double mt,@WebParam(name="numCpte") Long cpt) {
		
		metier.retirer(mt, cpt);
	}
	
	@WebMethod
	public void virement(@WebParam(name="montant") double mt, @WebParam(name="numCpt1") Long cpt1, @WebParam(name="numCpt2") Long cpt2) {
		
		metier.virement(mt, cpt1, cpt2);
	}
	

}
