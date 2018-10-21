package com.metierImpl;

import org.springframework.transaction.annotation.Transactional;

import com.entities.SinistreDetail;
import com.idao.IDaoSinistreDetail;
import com.imetier.IMetierSinistreDetail;

@Transactional
public class MetierSinistreDetailImpl implements IMetierSinistreDetail{
	
	private IDaoSinistreDetail dao1;

	public void setDao1(IDaoSinistreDetail dao) {
		this.dao1 = dao;
	}

	@Override
	public void ajouterSinistreDetail(SinistreDetail sinistreD) {
		
		dao1.ajouterSinistreDetail(sinistreD);
		
	}
	
	
	

}
