package tn.edu.esprit.Pidev.Entity;

import java.io.Serializable;
import java.lang.Integer;
import java.sql.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Orders
 *
 */
@Entity

public class Orders implements Serializable {

	
	private Integer IdOrders;
	private Date DateOrders;
	private boolean StateOrders;
	private static final long serialVersionUID = 1L;

	public Orders() {
		super();
	}   
	@Id    
	public Integer getIdOrders() {
		return this.IdOrders;
	}

	public void setIdOrders(Integer IdOrders) {
		this.IdOrders = IdOrders;
	}   
	public Date getDateOrders() {
		return this.DateOrders;
	}

	public void setDateOrders(Date DateOrders) {
		this.DateOrders = DateOrders;
	}   
	public boolean getStateOrders() {
		return this.StateOrders;
	}

	public void setStateOrders(boolean StateOrders) {
		this.StateOrders = StateOrders;
	}
   
}
