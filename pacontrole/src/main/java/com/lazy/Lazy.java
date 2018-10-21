package com.lazy;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

import com.entities.AssuPrinc;
import com.session.IMetierLocale;

@SuppressWarnings("deprecation")
@ManagedBean
@RequestScoped
public class Lazy implements Serializable{
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		private LazyDataModel<AssuPrinc> lazyModel;
	     
	    private AssuPrinc selectedCar;
	    @EJB
	    private IMetierLocale metier;
	    private AssurPrincService service;
	     
	    @PostConstruct
	    public void init() {
	        lazyModel = new LazyAssurPrinDataModel(service.createAssu(200));
	    }
	 
	    public LazyDataModel<AssuPrinc> getLazyModel() {
	        return lazyModel;
	    }
	 
	    public AssuPrinc getSelectedAssu() {
	        return selectedCar;
	    }
	 
	    public void setSelectedAssu(AssuPrinc selectedCar) {
	        this.selectedCar = selectedCar;
	    }
	     
	    public void setService(AssurPrincService service) {
	        this.service = service;
	    }
	     
	    public void onRowSelect(SelectEvent event) {
	        FacesMessage msg = new FacesMessage("Car Selected", ((AssuPrinc) event.getObject()).getDateDeclare().toString());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }

}
