package com.entities;

import javax.persistence.Embeddable;

@Embeddable
public class SinistreID {
	
	private int numPolice;
	
	private String numDossier;

	public SinistreID() {
		super();
	}

	public int getNumPolice() {
		return numPolice;
	}

	public void setNumPolice(int numPolice) {
		this.numPolice = numPolice;
	}

	public String getNumDossier() {
		return numDossier;
	}

	public void setNumDossier(String numDossier) {
		this.numDossier = numDossier;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numDossier == null) ? 0 : numDossier.hashCode());
		result = prime * result + numPolice;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SinistreID other = (SinistreID) obj;
		if (numDossier == null) {
			if (other.numDossier != null)
				return false;
		} else if (!numDossier.equals(other.numDossier))
			return false;
		if (numPolice != other.numPolice)
			return false;
		return true;
	}
	
	

}
