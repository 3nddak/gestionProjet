package com.bean;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;

import com.entities.AssuPrinc;
import com.entities.Prestataires;
import com.entities.Service;
import com.entities.Sinistre;
import com.session.IMetierLocale;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class TableSinistres implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private IMetierLocale metier;
	private List<AssuPrinc> sinistre;
	private List<AssuPrinc> assuPrin;
	private AssuPrinc assurPrinEntite;
	private List<AssuPrinc> assuPrin_periode;
	private Date date_deb;
	private Date date_fin;
	private List<Sinistre> siniPayeParAssu;
	private List<Service> listServices;
	private int service_id;
	private List<Prestataires> listBenef;
	private String beneficiaire;

	@PostConstruct
	public void init() {
		listServices = metier.listServices();
		listBenef = metier.listBeneficiaires();
		System.out.println("Service =: "+listServices.size());
		}



	
	
	public String getBeneficiaire() {
		return beneficiaire;
	}


	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	public List<Prestataires> getListBenef() {
		
		return listBenef;
	}
	
	public void setListBenef(List<Prestataires> listBenef) {
		this.listBenef = listBenef;
	}

	public IMetierLocale getMetier() {
		return metier;
	}

	public void setMetier(IMetierLocale metier) {
		this.metier = metier;
	}

	public List<Sinistre> getSiniPayeParAssu() {
		return siniPayeParAssu;
	}

	public void setSiniPayeParAssu(List<Sinistre> siniPayeParAssu) {
		this.siniPayeParAssu = siniPayeParAssu;
	}

	public void buttonDate() {
		ExternalContext c = FacesContext.getCurrentInstance().getExternalContext();

		assuPrin_periode = (List<AssuPrinc>) metier.listparAssuPrincipal(date_deb, date_fin);
		System.out.println("date debut:" + date_deb + " date fin :" + date_fin);

		try {
			c.redirect("./list-sinistre.jsf");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void buttonSinPaye() {
		ExternalContext c = FacesContext.getCurrentInstance().getExternalContext();
		System.out.println("\n\n id_service"+service_id+"\n\n");
		if(service_id==0 && "0".equals(beneficiaire)) {
			siniPayeParAssu = metier.listSinPayeParAssur(date_deb, date_fin);
			/*for (Sinistre assuPrinc : siniPayeParAssu) {
				
				System.out.println("Liste Tous = "+assuPrinc.getBeneficiare());
				
			}*/
		}
		else if(service_id>0 && "0".equals(beneficiaire)){
			siniPayeParAssu = metier.listSinPayeParAssur(date_deb, date_fin,service_id);
		}
		else if(service_id==0 && !"0".equals(beneficiaire)) {
			siniPayeParAssu = metier.listSinPayeParAssurBenef(date_deb, date_fin, beneficiaire);
		}
		else {
			siniPayeParAssu = metier.listSinPayeParAssurBenef(date_deb, date_fin, service_id, beneficiaire);
		}
		

		System.out.println("date debut:" + date_deb + " date fin :" + date_fin);

		try {
			c.redirect("./list-sinistre-paye-par-prestataires.jsf");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public String getTotalPaye() {
		double sommePaye = 100.98;
		for (Sinistre assuPrinc : siniPayeParAssu) {
			sommePaye += assuPrinc.getPaye();
		}
		String s="dfdsfsdf";

		
		System.out.println("\n\n\n valeur:"+s+"\n\n\n");
		return s ;
	}
	
	public String getNameService(int id)
	{
		if(id>0) {
			for (Service service : listServices) {
				
				if(service.getId()==id) {
					return service.getNom();
				}
			}
		}
		return "service net found";
	}
		
		public String getTotalSin() {
			String s="0";
			if(siniPayeParAssu!=null) {
			double sommePaye = 0;
			for (Sinistre assuPrinc : siniPayeParAssu) {
				sommePaye += assuPrinc.getPaye();
				System.out.println("La somme est :  "+sommePaye);
			}
			s=getFormaterDouble(sommePaye);
			}

		return s;
	}
	
		public List<Service> getListServices() {
			
			return listServices;
		}

		public void setListServices(List<Service> listServices) {
			this.listServices = listServices;
		}

		

		public int getService_id() {
			return service_id;
		}



		public void setService_id(int service_id) {
			this.service_id = service_id;
		}



		public String getFormaterDouble(double d) {
			NumberFormat formater = NumberFormat.getInstance(Locale.FRENCH);
			formater = new DecimalFormat("##,###.##");
		return formater.format(d);
	}

	public List<AssuPrinc> getAssuPrin_periode() {
		return assuPrin_periode;
	}

	public void setAssuPrin_periode(List<AssuPrinc> assuPrin_periode) {
		this.assuPrin_periode = assuPrin_periode;
	}

	public Date getDate_deb() {
		return date_deb;
	}

	public void setDate_deb(Date date_deb) {
		this.date_deb = date_deb;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public List<AssuPrinc> getSinistre() {

		return sinistre;
	}

	public void setSinistre(List<AssuPrinc> sinistre) {
		this.sinistre = sinistre;
	}

	public List<AssuPrinc> getAssuPrin() {
		assuPrin = metier.listparAssuPrincipal();
		return assuPrin;
	}

	public void setAssuPrin(List<AssuPrinc> assuPrin) {
		this.assuPrin = assuPrin;
	}

	public boolean filterByPrice(Object value, Object filter, Locale locale) {
		String filterText = (filter == null) ? null : filter.toString().trim();
		if (filterText == null || filterText.equals("")) {
			return true;
		}

		if (value == null) {
			return false;
		}

		return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
	}

}
