package metier.imetier;

public interface IMetierPages extends IMetier{
	public int insertPage(String idModule,String url,String libelle, String defaut, String etat,String surentete);
	public int modifPage(String id,String idModule,String url,String libelle, String defaut, String etat,String surentete);
	public boolean ordreExiste();

}
