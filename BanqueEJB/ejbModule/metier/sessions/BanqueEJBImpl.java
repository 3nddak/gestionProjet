package metier.sessions;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entities.Compte;

@Stateless(name="BK")
public class BanqueEJBImpl implements IBanqueLocale,IBanqueRemote{
	@PersistenceContext
	private EntityManager em;

	@Override
	public void addCompte(Compte c) {
		em.persist(c);
		
	}

	@Override
	public List<Compte> listCompe() {
		Query req=em.createQuery("select c from Compte c where c.active=true");
		return req.getResultList();
	}

	@Override
	public Compte getCompte(Long code) {
		Compte cp=em.find(Compte.class, code);
		if(cp==null) throw new RuntimeException("Compte introvable");
		return cp;
	}

	@Override
	public void verver(double mt, Long code) {
		Compte cp=getCompte(code);
		cp.setSolde(cp.getCode()+mt);
	}

	@Override
	public void retirer(double mt, Long code) {
		Compte cp=getCompte(code);
		cp.setSolde(cp.getSolde()-mt);
		
	}

	@Override
	public void virement(double mt, Long cpt1, Long cpt2) {
		retirer(mt, cpt1);
		verver(mt, cpt2);	
	}

	@Override
	public void update(Compte c) {
		em.merge(c);	
	}

	@Override
	public void supprimerCompte(Long code) {
		Compte cp=getCompte(code);
		em.remove(cp);	
	}

}
