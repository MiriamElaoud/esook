package tn.edu.esprit.Pidev.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.edu.esprit.Pidev.Entity.Admin;
import tn.edu.esprit.Pidev.Entity.User;

/**
 * Session Bean implementation class GestionAdmin
 */
@Stateless
@LocalBean
public class GestionAdmin implements GestionAdminRemote,GestionAdminLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em ;
    public GestionAdmin() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void persistAdmin(Admin admin) {
		em.persist(admin);
		
	}

	@Override
	public void updateAdmin(Admin admin) {
		em.merge(admin);
		
	}

	@Override
	public void removeAdmin(Admin admin) {
		em.remove(admin);
		
	}

	@Override
	public Admin searchadminByid(int id) {
		Admin admin = em.find(Admin.class, id);
		return admin;
	}

	@Override
	public Admin searchUserByid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Admin retrieveAdminByCredentials(String login,
			String password) {
		
		TypedQuery<Admin> query = em
				.createQuery(
						"select a from Admin a where a.login= :login and a.password= :password",
						Admin.class);
		query.setParameter("password", password);
		query.setParameter("login", login);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
