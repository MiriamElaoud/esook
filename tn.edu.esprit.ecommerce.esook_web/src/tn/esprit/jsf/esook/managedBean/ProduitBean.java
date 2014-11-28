package tn.esprit.jsf.esook.managedBean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.edu.esprit.Pidev.Entity.Poduit;
import tn.edu.esprit.Pidev.services.GestionProduitLocal;

@ManagedBean
@SessionScoped
public class ProduitBean {

	private Poduit poduit = new Poduit();

	@EJB
	GestionProduitLocal gestionProduitLocal;

	public void ajouterProduit() {
		System.out.println("****************************");
		gestionProduitLocal.persistProduit(poduit);
		System.out.println("ttttttttttttttttttttttttttt");

	}

	public Poduit getPoduit() {
		return poduit;
	}

	public void setPoduit(Poduit poduit) {
		this.poduit = poduit;
	}

}
