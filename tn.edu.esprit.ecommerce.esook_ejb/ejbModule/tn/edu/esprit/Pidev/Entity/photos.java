package tn.edu.esprit.Pidev.Entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: photos
 *
 */
@Entity

public class photos implements Serializable {

	
	private Integer idPhoto;
	private String path;
	private String Description;
	Poduit produit;
	private static final long serialVersionUID = 1L;

	public photos() {
		super();
	}   
	@Id    
	public Integer getIdPhoto() {
		return this.idPhoto;
	}

	public void setIdPhoto(Integer idPhoto) {
		this.idPhoto = idPhoto;
	}   
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}   
	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}
	@ManyToOne
	public Poduit getProduit() {
		return produit;
	}
	public void setProduit(Poduit produit) {
		this.produit = produit;
	}
	
   
}
