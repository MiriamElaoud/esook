package tn.esprit.jsf.esook.managedBean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import tn.edu.esprit.Pidev.Entity.User;
import tn.edu.esprit.Pidev.services.GestionUser;

@RequestScoped
@ManagedBean(name = "inscrit")
public class RegistrationBean {
	public RegistrationBean() {
		super();
	}

	private String firstName;
	private String lastName;
	private String address;
	private String login;
	private String password;
	//@PostConstruct ==> t3abbi el model just ba3d m ta3mlou w 9bal m t3ayatlou 

	@EJB
	private GestionUser gestionUser;
	
	public String doRegister(){
		User user=new User(lastName, firstName, login, password, null, null, null);
		gestionUser.persistUser(user);
		return "login?faces-redirect=true";
	}
	public String doReset(){
		firstName =null;
		lastName=null;
		address=null;
		password=null;
		login=null;
		return "register?faces-reirect=true";
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
