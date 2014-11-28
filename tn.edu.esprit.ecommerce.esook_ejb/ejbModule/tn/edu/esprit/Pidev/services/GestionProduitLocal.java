package tn.edu.esprit.Pidev.services;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.Pidev.Entity.Poduit;

@Local
public interface GestionProduitLocal {
	public void persistProduit(Poduit poduit);

	public void UpdateProduit(Poduit poduit);

	public void RemoveProduit(Poduit poduit);

	public Poduit SearchProduit(int idProduit);

	public List<Poduit> allProduit();

}
