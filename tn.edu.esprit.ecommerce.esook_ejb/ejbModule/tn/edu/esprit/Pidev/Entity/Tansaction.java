package tn.edu.esprit.Pidev.Entity;

import java.io.Serializable;
import java.lang.Integer;
import java.sql.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Tansaction
 *
 */
@Entity

public class Tansaction implements Serializable {

	
	private Integer idTransaction;
	private Integer CardNumber;
	private Integer Code;
	private Date DateTransaction;
	private static final long serialVersionUID = 1L;

	public Tansaction() {
		super();
	}   
	@Id    
	public Integer getIdTransaction() {
		return this.idTransaction;
	}

	public void setIdTransaction(Integer idTransaction) {
		this.idTransaction = idTransaction;
	}   
	public Integer getCardNumber() {
		return this.CardNumber;
	}

	public void setCardNumber(Integer CardNumber) {
		this.CardNumber = CardNumber;
	}   
	public Integer getCode() {
		return this.Code;
	}

	public void setCode(Integer Code) {
		this.Code = Code;
	}   
	public Date getDateTransaction() {
		return this.DateTransaction;
	}

	public void setDateTransaction(Date DateTransaction) {
		this.DateTransaction = DateTransaction;
	}
   
}
