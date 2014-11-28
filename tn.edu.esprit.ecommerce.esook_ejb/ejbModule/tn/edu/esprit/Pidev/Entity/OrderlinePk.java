package tn.edu.esprit.Pidev.Entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: OrderlinePk
 *
 */
@Embeddable

public class OrderlinePk implements Serializable {

	private Integer idTransaction;
	private Integer IdOrder;
	private static final long serialVersionUID = 1L;

	public OrderlinePk() {
		super();
	}

	public Integer getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(Integer idTransaction) {
		this.idTransaction = idTransaction;
	}

	public Integer getIdOrder() {
		return IdOrder;
	}

	public void setIdOrder(Integer idOrder) {
		IdOrder = idOrder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IdOrder == null) ? 0 : IdOrder.hashCode());
		result = prime * result
				+ ((idTransaction == null) ? 0 : idTransaction.hashCode());
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
		OrderlinePk other = (OrderlinePk) obj;
		if (IdOrder == null) {
			if (other.IdOrder != null)
				return false;
		} else if (!IdOrder.equals(other.IdOrder))
			return false;
		if (idTransaction == null) {
			if (other.idTransaction != null)
				return false;
		} else if (!idTransaction.equals(other.idTransaction))
			return false;
		return true;
	}
   
}
