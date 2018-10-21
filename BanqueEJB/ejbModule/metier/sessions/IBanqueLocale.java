package metier.sessions;

import java.util.List;

import javax.ejb.Local;

import metier.entities.Compte;

@Local
public interface IBanqueLocale {
	public void addCompte(Compte c);
	public List<Compte> listCompe();
	public Compte getCompte(Long code);
	public void verver(double mt,Long code);
	public void retirer(double mt,Long code);
	public void virement(double mt,Long cpt1,Long cpt2);
	public void update(Compte c);
	public void supprimerCompte(Long code);
	

}
