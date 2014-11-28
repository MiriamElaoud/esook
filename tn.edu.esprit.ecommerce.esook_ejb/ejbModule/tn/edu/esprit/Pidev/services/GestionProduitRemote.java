package tn.edu.esprit.Pidev.services;

import java.util.List;

import javax.ejb.Remote;



import tn.edu.esprit.Pidev.Entity.Category;
import tn.edu.esprit.Pidev.Entity.Poduit;



@Remote
public interface GestionProduitRemote {
	public void persistProduit (Poduit poduit);
	public void UpdateProduit (Poduit poduit);
	public void RemoveProduit (Poduit poduit);
	public Poduit SearchProduit (int idProduit);
	
	public List<Poduit> allProduit();
	

}
