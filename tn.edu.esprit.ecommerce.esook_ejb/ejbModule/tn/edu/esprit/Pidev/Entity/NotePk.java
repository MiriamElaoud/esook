package tn.edu.esprit.Pidev.Entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * Entity implementation class for Entity: NotePk
 * 
 */
@Embeddable
public class NotePk implements Serializable {

	private Integer idAccount;
	private Integer idProduit;
	private static final long serialVersionUID = 1L;

	public NotePk() {
		super();
	}

	public Integer getIdAccount() {
		return idAccount;
	}

	public NotePk(Integer idAccount, Integer idProduit) {
		super();
		this.idAccount = idAccount;
		this.idProduit = idProduit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idAccount == null) ? 0 : idAccount.hashCode());
		result = prime * result
				+ ((idProduit == null) ? 0 : idProduit.hashCode());
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
		NotePk other = (NotePk) obj;
		if (idAccount == null) {
			if (other.idAccount != null)
				return false;
		} else if (!idAccount.equals(other.idAccount))
			return false;
		if (idProduit == null) {
			if (other.idProduit != null)
				return false;
		} else if (!idProduit.equals(other.idProduit))
			return false;
		return true;
	}

	public void setIdAccount(Integer idAccount) {
		this.idAccount = idAccount;
	}

	public Integer getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Integer idProduit) {
		this.idProduit = idProduit;
	}

}
