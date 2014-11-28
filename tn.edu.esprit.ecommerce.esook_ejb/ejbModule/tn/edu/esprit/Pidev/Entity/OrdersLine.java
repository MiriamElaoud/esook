package tn.edu.esprit.Pidev.Entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: OrdersLine
 *
 */
@Entity

public class OrdersLine implements Serializable {

	private Integer QtProduit ;
	private OrderlinePk OrderlinePk = new OrderlinePk();
	private Orders Orders;
	private Tansaction transaction ;
	private static final long serialVersionUID = 1L;
	

	public OrdersLine() {
		super();
	}


	public Integer getQtProduit() {
		return QtProduit;
	}


	public void setQtProduit(Integer qtProduit) {
		QtProduit = qtProduit;
	}

	@EmbeddedId
	public OrderlinePk getOrderslinePk() {
		return OrderlinePk;
	}


	public void setOrderslinePk(OrderlinePk OrderslinePk) {
		this.OrderlinePk = OrderslinePk;
	}

	@ManyToOne
	@JoinColumn(name="IdOrders",referencedColumnName="IdOrders",insertable=false,updatable=false)
	public Orders getOrders() {
		return Orders;
	}


	public void setOrders(Orders Orders) {
		this.Orders = Orders;
	}

	@ManyToOne
	@JoinColumn(name="idTransaction",referencedColumnName="idTransaction",insertable=false,updatable=false)
	public Tansaction getTransaction() {
		return transaction;
	}


	public void setTransaction(Tansaction transaction) {
		this.transaction = transaction;
	}

	
	
	
   
}
