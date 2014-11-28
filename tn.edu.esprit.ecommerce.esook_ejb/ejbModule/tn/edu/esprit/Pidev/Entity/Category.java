package tn.edu.esprit.Pidev.Entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Category
 * 
 */
@Entity
public class Category implements Serializable {

	private Integer idCategory;
	private String nameCategory;
	private String description;

	public Category(String nameCategory, String description,
			List<Poduit> listproduit) {
		super();
		this.nameCategory = nameCategory;
		this.description = description;
		this.listproduit = listproduit;
	}

	// private Admin admin;
	private List<Poduit> listproduit = new ArrayList<Poduit>();
	private static final long serialVersionUID = 1L;

	public Category() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdCategory() {
		return this.idCategory;
	}

	@ManyToOne
	// public Admin getAdmin() {
	// return admin;
	// }
	// public void setAdmin(Admin admin) {
	// this.admin = admin;
	// }
	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}

	public String getNameCategory() {
		return this.nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	public List<Poduit> getListproduit() {
		return listproduit;
	}

	public void setListproduit(List<Poduit> listproduit) {
		this.listproduit = listproduit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
