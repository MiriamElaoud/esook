package tn.edu.esprit.Pidev.Entity;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: claim
 *
 */
@Entity

public class claim implements Serializable {

	
	private String content;
	private String answer ;
	private String UserName;
	private ClaimPk claimPk = new ClaimPk(); 
	private Admin admin ;
	private User user; 
	private static final long serialVersionUID = 1L;

	public claim() {
		super();
	}   
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}   
	public String getUserName() {
		return this.UserName;
	}

	public void setUserName(String UserName) {
		this.UserName = UserName;
	}
	
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@ManyToOne
	@JoinColumn(name="idAccount",referencedColumnName="idAccount",insertable=false,updatable=false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@EmbeddedId
	public ClaimPk getClaimPk() {
		return claimPk;
	}
	public void setClaimPk(ClaimPk claimPk) {
		this.claimPk = claimPk;
	}
	@ManyToOne
	@JoinColumn(name="idAccount",referencedColumnName="idAccount",insertable=false,updatable=false)
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
   
}
