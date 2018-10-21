package com.metierImpl;

import javax.transaction.Transactional;

import com.entities.Sinistre;
import com.idao.IDaoSinistre;
import com.imetier.IMetierSinistre;

@Transactional
public class MetierSinistreImpl implements IMetierSinistre{
	
	private IDaoSinistre dao;

	public void setDao(IDaoSinistre dao) {
		this.dao = dao;
	}



	@Override
	public void ajouterSinistre(Sinistre sinistre) {
		
		dao.AjouterSinistre(sinistre);
	}

}
