package tn.edu.esprit.Pidev.Entity;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity

public class Admin extends Account implements Serializable {

	
	private Integer cin;
//	List<Category> listCategory=new ArrayList<Category>();
	private static final long serialVersionUID = 1L;

	public Admin() {
		super();
	}   
	
//	@OneToMany(mappedBy="admin")
//	public List<Category> getListCategory() {
//		return listCategory;
//	}


//	public void setListCategory(List<Category> listCategory) {
//		this.listCategory = listCategory;
//	}


	public Integer getCin() {
		return this.cin;
	}

	public void setCin(Integer cin) {
		this.cin = cin;
	}

	public Admin(String lastName, String firstName, String login,
			String password,Integer cin ) {
		super(lastName, firstName, login, password);
		this.cin = cin ;
	}
   
}
