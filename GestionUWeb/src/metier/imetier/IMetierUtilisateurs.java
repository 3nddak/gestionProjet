package metier.imetier;

import java.sql.ResultSet;

public interface IMetierUtilisateurs extends IMetier{
	/*Méthode permettant de vérouiller la connection d'un utilisateur*/
	public void bloquerUser(int idUser);
	/* Méthode permettant de changer le mot de passe d'un utilisateur*/
	public int changerMotDePasse(String id,String pwd);
	/*Méthode permettant de vérouiller la connection d'un utilisateur*/
	public int changerEtatConnection(String id,String connecte);
	public int AffecterCode(String id,String code);
	public int suprimUser(String id);
	public String RetourneCodeUser(int idUser);
	boolean isCaissier(String codeUser);
	public void afficherchangeUser();
	/*Fonction permettant de voir si un caissier est affectee a une caisse*/
	public boolean userAffectCaisse(String codeUser);
	/*Fonction permettant de voir si un caissier est affectee a une caisse*/
	public boolean userAffectCaisseDefaut(String codeUser);
	/*Fonction permettant de voir si un caissier est affectee a une caisse avec une devise*/
	public boolean userAffectCaisse(String codeUser,String idDevise);
	/* Fonction permettant de voir si un utilisateur de même login existe */
	public boolean existLogin(String login);
	//fonctions cryptages avec SHA1 en java
	public String convertToHex(byte[] data);
	public String SHA1(String text);
	/* Methode permettant de rechercher un enregistrement*/
    public ResultSet rechercheLogin(String login);
    /* Methode permetant d'afficher les infos d'un utilisateur*/
    public boolean rechercheUser(String login,String pwd);
    /* Methode permetant de recherche un utilisateur*/
    public ResultSet afficherUserBis(String login);
    /** Methode statique permettant a partir de l'id d'un utilisateur
     * d'avoir le profil correspondant
     */
    public int profilUser(int idUser);

}
