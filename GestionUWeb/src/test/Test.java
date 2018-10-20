package test;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import metier.imetier.IMetierUtilisateurs;
public class Test {

	public static void main(String[] args) {
				
				try {
					ApplicationContext 	context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
					IMetierUtilisateurs metier = (IMetierUtilisateurs) context.getBean("metier");
					//metier.addClient(new Client("C4","ADD4"));
					//metier.addClient(new Client("C5","ADD5"));
					//metier.addClient(new Client("C6","ADD6"));
					//metier.addEmploye(new Employes(2L, "E2",));
					//metier.addEmploye(new Employe("Fatou"), 1L);
					//metier.addEmploye(new Employe("Diouck"), 1L);
					//metier.addEmploye(new Employe("Thierno"), 1L);
					//metier.addGroupe(new Groupe("G1"));
					//metier.addGroupe(new Groupe("G3"));
					//metier.addGroupe(new Groupe("G3"));
					//metier.addEmployeToGroupe(1L, 1L);
					//metier.addEmployeToGroupe(2L, 1L);
					//metier.addEmployeToGroupe(3L, 2L);
					//metier.addEmployeToGroupe(4L, 3L);
					//metier.addEmployeToGroupe(5L, 3L);
					//metier.addEmployeToGroupe(6L, 2L);
					//metier.addCompte(new CompteCourant("CC4", new Date(), 389700,100000.0), 2L, 3L);
					//metier.addCompte(new CompteCourant("CC3", new Date(), 389700,100000.0), 3L, 4L);
					//metier.addCompte(new CompteCourant("CC2", new Date(), 14589000,1300000.0), 3L, 1L);
					 // metier.verser(5000000, "CE1", 1L);
					//metier.retirer(5000000, "CE1", 1L);
					//metier.virerement(176000, "CC1", "CC3", 1L);
					//metier.addCompte(new CompteEpargne("CE1", new Date(), 5000000, 3), 1L, 1L);
					//Client cli=metier.consulterClient(1L);
					//System.out.println("Le client "+cli.getNomClient()+" de code "+cli.getCodeClient()+" son addresse est "+cli.getAdresseClient());
					//Compte cp = metier.consulterCompte("CC1");
					//System.out.println("N° Compte "+cp.getNumCompte()+"");
					//Compte cp=metier.consulterCompte("CC1");
					
					//System.out.println(cp.getDateCreation());
					//System.out.println(cp.getNumCompte());
					//System.out.println(cp.getSolde());
					//System.out.println(cp.getClient().getNomClient());
					//System.out.println(cp.getEmploye().getNomEmploye());
					//System.out.println(cp.getOperations().getClass().getName());
					
					//metier.addObj(new Etudiant("NGUISSAN", "Nana", new Date(), "Parcelles", "Togolaise", "781499949", "doqozadji@gmail.com", "EBOO7A"));
					//metier.addObj(new Utilisateurs("N'GUISSAN", "Nana", "sa", "admin", true, true, true, new Date(), new Date(), "781499949", "IMEI0001233"));
					//System.out.println("Résultat de la recharche="+metier.rechercheUser("sa","admin"));
					metier.rechercheUser("sa", "admin");
					System.out.println("Resultat rechercheUser= "+metier.rechercheUser("sa", "admin"));
					} catch (BeansException e) {
					
					
					e.printStackTrace();
				}
					
				

			}

		
		


}
