package org.uweb.uv.metier.imetier;

public interface IMetierProfil extends IMetier{
	public void ajouterPageProfil(int idPage,int idProfil);
	public void retiterPageProfil(int idPage, int idProfil);
	public boolean utilProfil(String id);

}
