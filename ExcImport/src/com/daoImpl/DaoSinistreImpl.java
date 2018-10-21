package com.daoImpl;

import com.entities.Sinistre;
import com.idao.IDaoSinistre;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class DaoSinistreImpl implements IDaoSinistre{
	@PersistenceContext
	private EntityManager em;

	@Override
	public void AjouterSinistre(Sinistre sinistre) {
		
		em.persist(sinistre);
		
		
	}

}
