package tn.edu.esprit.Pidev.services;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.Pidev.Entity.Category;

@Remote
public interface GestionCategoryRemote {
	public void persistCategory(Category category);
	public void updateCategory(Category category);
	public void removeCategory (Category category);
	public Category searchcategoryByid(int id);
	public Category searchcategoryByName(String name);
	public List<Category>allcategory();
	public List<Category>searchisByName(String nameCategory);
 
}
