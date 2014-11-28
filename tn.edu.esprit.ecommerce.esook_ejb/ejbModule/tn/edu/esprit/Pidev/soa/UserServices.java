package tn.edu.esprit.Pidev.soa;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebService;

import tn.edu.esprit.Pidev.Entity.User;
import tn.edu.esprit.Pidev.services.GestionUserLocal;
@Stateless
@WebService()
public class UserServices {

	@EJB
	private GestionUserLocal metier;
	public void addUser(@WebParam(name="firstnamee")String firstname,@WebParam(name="login") String login){
		User user =new User(firstname, login, null, null, firstname, null, login);
		metier.persistUser(user); 
		
	
	}
	}
