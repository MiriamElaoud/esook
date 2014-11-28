package tn.edu.esprit.Pidev.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.esprit.Pidev.Entity.Poduit;

/**
 * Session Bean implementation class GestionProduit
 */
@Stateless
@LocalBean

public class GestionProduit implements GestionProduitRemote,GestionProduitLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
	
    public GestionProduit() {
       
    }

	@Override
	public void persistProduit(Poduit poduit) {
		em.persist(poduit);
		
	}

	@Override
	public void UpdateProduit(Poduit poduit) {
		em.merge(poduit);		
	}

	@Override
	public void RemoveProduit(Poduit poduit) {
		
		//em.remove(em.merge(poduit));
		em.remove(em.find(Poduit.class, poduit.idProduit));
		
		
	}

	@Override
	public Poduit SearchProduit(int idProduit) {
		Poduit poduit =em.find(Poduit.class, idProduit);
		return poduit;
	}

	@Override
	public List<Poduit> allProduit() {
		
		String jpql ="select p from Poduit p ";
		 javax.persistence.Query query = em.createQuery(jpql);
	        return (List<Poduit>) query.getResultList();
	}
	

}
