package tn.edu.esprit.Pidev.Entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Account
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Account implements Serializable {

	
	private Integer idAccount;
	private String lastName;
	private String firstName;
	private String login;
	private String password;
	private static final long serialVersionUID = 1L;

	public Account() {
		super();
	}   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdAccount() {
		return this.idAccount;
	}

	public void setIdAccount(Integer idAccount) {
		this.idAccount = idAccount;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}   
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}   
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Account(String lastName, String firstName, String login,
			String password) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.login = login;
		this.password = password;
	}
	public Account(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	
   
}
