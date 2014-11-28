package tn.edu.esprit.Pidev.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.edu.esprit.Pidev.Entity.User;

/**
 * Session Bean implementation class GestionUser
 */
@Stateless
@LocalBean
public class GestionUser implements GestionUserRemote,GestionUserLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	EntityManager em;

	public GestionUser() {
	}

	@Override
	public void persistUser(User user) {
		em.persist(user);

	}

	@Override
	public void updateUser(User user) {
		em.merge(user);

	}

	@Override
	public void removeUser(User user) {
		em.remove(em.merge(user));

	}

	@Override
	public User searchUserByid(int iduser) {
		User user = em.find(User.class, iduser);
		return user;
	}

	@Override
	public User authentificatUser(String login, String password) {
		try {
			String query = "select u from Account u where u.login=:login and u.password=:password";
			javax.persistence.Query queryu = em.createQuery(query)
					.setParameter("login", login)
					.setParameter("password", password);
			return (User) queryu.getSingleResult();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	@Override
	public List<User> getAllUsers() {
		Query query = em.createQuery("select c from User c");
		return query.getResultList();
	}

	public User retrieveUserByCredentials(String login,
			String password) {
		TypedQuery<User> query = em
				.createQuery(
						"select a from User a where a.login= :login and a.password= :password",
						User.class);
		query.setParameter("password", password);
		query.setParameter("login", login);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
