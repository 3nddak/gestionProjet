package org.uweb.uv.dao.idao;

public interface IDaoProfil extends IDao{
	public void ajouterPageProfil(int idPage,int idProfil);
	public void retiterPageProfil(int idPage, int idProfil);
	public boolean utilProfil(String id);
	

}
