package tn.edu.esprit.Pidev.Entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ClaimPk
 *
 */
@Embeddable

public class ClaimPk implements Serializable {


	private Integer idAccount;

	private static final long serialVersionUID = 1L;
	

	public ClaimPk() {
		super();
	}


	public Integer getIdAccount() {
		return idAccount;
	}


	public void setIdAccount(Integer idAccount) {
		this.idAccount = idAccount;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idAccount == null) ? 0 : idAccount.hashCode());
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
		ClaimPk other = (ClaimPk) obj;
		if (idAccount == null) {
			if (other.idAccount != null)
				return false;
		} else if (!idAccount.equals(other.idAccount))
			return false;
		return true;
	}
	
   
}
