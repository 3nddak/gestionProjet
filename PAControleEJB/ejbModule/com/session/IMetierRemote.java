package com.session;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.faces.model.DataModel;

import com.entities.AssuPrinc;
import com.entities.Prestataires;
import com.entities.Service;
import com.entities.Sinistre;
import com.entities.SinistreDetail;
import com.entities.Utilisateurs;

@Remote
public interface IMetierRemote {
	public void ajoutUser(Utilisateurs u);
	public Utilisateurs connection(String username,String password);
	public List<Sinistre> listSinistre();
	public List<SinistreDetail> listeDetailSinitre();
	public List<AssuPrinc> listparAssuPrincipal(Date date_deb, Date date_fin);
	public List<Sinistre> listSinPayeParAssur(Date date_deb, Date date_fin,int id);
	public List<Sinistre> listSinPayeParAssur(Date date_deb, Date date_fin);
	public List<AssuPrinc> listparAssuPrincipal();
	public List<Service> listServices();
	public List<Prestataires> listBeneficiaires();
	public List<Sinistre> listSinPayeParAssurBenef(Date date_deb, Date date_fin,int id,String benef);
	public List<Sinistre> listSinPayeParAssurBenef(Date date_deb, Date date_fin,String benef);

}
