package tn.edu.esprit.Pidev.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Poduit
 * 
 */
@Entity
public class Poduit implements Serializable {

	public Integer idProduit;
	private String nomProd;

	public String getNomProd() {
		return nomProd;
	}

	public void setNomProd(String nomProd) {
		this.nomProd = nomProd;
	}

	private String description;
	private Integer qtStoke;
	private Double price;
	List<Note> listNote = new ArrayList<Note>();
	List<photos> listPhotos = new ArrayList<photos>();
	private Category category;
	User user = new User();

	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private Promotion promotion;

	@OneToMany(mappedBy = "produit")
	public List<photos> getListPhotos() {
		return listPhotos;
	}

	public void setListPhotos(List<photos> listPhotos) {
		this.listPhotos = listPhotos;
	}

	private static final long serialVersionUID = 1L;

	public Poduit() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdProduit() {
		return this.idProduit;
	}

	@OneToMany(mappedBy = "produit")
	public List<Note> getListNote() {
		return listNote;
	}

	public void setListNote(List<Note> listNote) {
		this.listNote = listNote;
	}

	public void setIdProduit(Integer idProduit) {
		this.idProduit = idProduit;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQtStoke() {
		return this.qtStoke;
	}

	public void setQtStoke(Integer qtStoke) {
		this.qtStoke = qtStoke;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@ManyToOne
	// (cascade=CascadeType.ALL)//reste a vérifier
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Embedded
	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	// public Poduit(String nomProd, String description, Integer qtStoke,
	// Double price) {
	// super();
	// this.nomProd = nomProd;
	// this.description = description;
	// this.qtStoke = qtStoke;
	// this.price = price;
	// }
	// public Poduit(String nomProd, String description, Integer qtStoke,
	// Double price, List<Note> listNote, List<photos> listPhotos,
	// Category category, User user, Promotion promotion) {
	// super();
	// this.nomProd = nomProd;
	// this.description = description;
	// this.qtStoke = qtStoke;
	// this.price = price;
	// this.listNote = listNote;
	// this.listPhotos = listPhotos;
	// this.category = category;
	// this.user = user;
	// this.promotion = promotion;
	// }
	public Poduit(String nomProd, String description, Integer qtStoke,
			Double price, Category category, User user) {
		super();
		this.nomProd = nomProd;
		this.description = description;
		this.qtStoke = qtStoke;
		this.price = price;
		this.category = category;
		this.user = user;
	}

}
