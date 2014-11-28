package tn.edu.esprit.Pidev.services;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.Pidev.Entity.Account;
import tn.edu.esprit.Pidev.Entity.Admin;
import tn.edu.esprit.Pidev.Entity.User;
import tn.esprit.Pidev.exception.BadCredentialException;

/**
 * Session Bean implementation class GestionAcount
 */
@Stateless
@LocalBean
public class GestionAcount implements GestionAcountLocal, GestionAcountRemote {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	EntityManager em;
	@EJB
	GestionUser userServices;
	@EJB
	GestionAdmin adminServices;

	public GestionAcount() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Account authentificat(String login, String password) {
		try {
			Query query = em
					.createQuery("select u from Account u where u.login=:login and u.password=:password");
			query.setParameter("login", login);
			query.setParameter("password", password);
			return (Account) query.getSingleResult();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public Object retrieveAccountByCredentials(String username, String password)
			throws BadCredentialException {

		User user = userServices.retrieveUserByCredentials(username, password);

		if (user != null) {
			return user;

		} else {
			Admin admin = adminServices.retrieveAdminByCredentials(username,
					password);
			if (admin != null) {

				return admin;
			} else {
				throw new BadCredentialException();
			}

		}
	}
}
