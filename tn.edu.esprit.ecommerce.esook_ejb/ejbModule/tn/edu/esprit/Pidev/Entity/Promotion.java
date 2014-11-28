package tn.edu.esprit.Pidev.Entity;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Integer;
import java.sql.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Promotion
 *
 */
@Embeddable

public class Promotion implements Serializable {

	
	private Integer idPromotion;
	private Float PricePromotion;
	private Date DatePromotion;
	private static final long serialVersionUID = 1L;

	public Promotion() {
		super();
	}   
	    
	public Integer getIdPromotion() {
		return this.idPromotion;
	}

	public void setIdPromotion(Integer idPromotion) {
		this.idPromotion = idPromotion;
	}   
	public Float getPricePromotion() {
		return this.PricePromotion;
	}

	public void setPricePromotion(Float PricePromotion) {
		this.PricePromotion = PricePromotion;
	}   
	public Date getDatePromotion() {
		return this.DatePromotion;
	}

	public void setDatePromotion(Date DatePromotion) {
		this.DatePromotion = DatePromotion;
	}
   
}
