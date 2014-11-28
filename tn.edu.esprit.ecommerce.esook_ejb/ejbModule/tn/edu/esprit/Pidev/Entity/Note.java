package tn.edu.esprit.Pidev.Entity;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Note
 *
 */
@Entity

public class Note implements Serializable {

	
	private Integer noteProduit;
	NotePk notePk=new NotePk();
	Poduit produit;
	User user; 
	private static final long serialVersionUID = 1L;

	public Note() {
		super();
	}   
	@ManyToOne
	@JoinColumn(name="idAccount",referencedColumnName="idAccount",insertable=false,updatable=false)
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

    @ManyToOne
	@JoinColumn(name="idProduit",referencedColumnName="idProduit",insertable=false,updatable=false)
	public Poduit getProduit() {
		return produit;
	}



	public void setProduit(Poduit produit) {
		this.produit = produit;
	}



	@EmbeddedId
	public NotePk getNotePk() {
		return notePk;
	}


	public void setNotePk(NotePk notePk) {
		this.notePk = notePk;
	}


	public Integer getNoteProduit() {
		return this.noteProduit;
	}

	public void setNoteProduit(Integer noteProduit) {
		this.noteProduit = noteProduit;
	}
   
}
