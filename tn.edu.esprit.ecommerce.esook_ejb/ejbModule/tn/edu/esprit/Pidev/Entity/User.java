package tn.edu.esprit.Pidev.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User extends Account implements Serializable {

	
	private String adress;
	private Integer tel;
	private Date date;
	private String email;
	List<Poduit>poduits=new ArrayList<Poduit>();
	List<Note> listNote=new ArrayList<Note>();
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}  
	@OneToMany(mappedBy="user")
	public List<Poduit> getPoduits() {
		return poduits;
	}
	public void setPoduits(List<Poduit> poduits) {
		this.poduits = poduits;
	}
	@OneToMany(mappedBy="user")
	public List<Note> getListNote() {
		return listNote;
	}

	public void setListNote(List<Note> listNote) {
		this.listNote = listNote;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}   
	public Integer getTel() {
		return this.tel;
	}

	public void setTel(Integer tel) {
		this.tel = tel;
	}   
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public User(String lastName, String firstName, String login, String password, String addresse,Integer tel,String email ) {
		super(lastName, firstName, login, password );
		this.adress = addresse ;
		this.tel=tel;
		this.email=email;
		
	}
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setEmail(String email) {
		this.email = email;
	}
   
}
