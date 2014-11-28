package tn.edu.esprit.Pidev.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.Pidev.Entity.Category;

/**
 * Session Bean implementation class GestionCategory
 */
@Stateless
@LocalBean
public class GestionCategory implements GestionCategoryRemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em ;
    public GestionCategory() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void persistCategory(Category category) {
		em.persist(category);
		
	}

	@Override
	public void updateCategory(Category category) {
          em.merge(category);
	}

	@Override
	public void removeCategory(Category category) {
		em.remove(em.merge(category));
		
	}

	@Override
	public Category searchcategoryByid(int id) {
		Category category = em.find(Category.class, id);
		return category;
	}

	@Override
	public Category searchcategoryByName(String name) {
		Category category = em.find(Category.class, name);
		return category;
	}

	@Override
	public List<Category> allcategory() {
	
			Query query = em.createQuery("select c from Category c");
			return query.getResultList();
		}

	@Override
	public List<Category> searchisByName(String nameCategory) {
//		String jpql = "select c from Category c where c.nameCatgory:=nameCategory";
//		Query query = em.createNamedQuery(jpql).setParameter("nameCtegory", nameCategory);
//		return query.getResultList();
		try {
			String query = "select u from Category u where u.nameCategory=:nameCategory";
			javax.persistence.Query queryu = em.createQuery(query)
					.setParameter("nameCategory", nameCategory);
			return queryu.getResultList();
		} catch (Exception ex) {
			return new ArrayList<Category>();
		}
	
	}
		
	}


