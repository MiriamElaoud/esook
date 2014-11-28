package tn.edu.esprit.Pidev.services;

import javax.ejb.Local;
import javax.ejb.Remote;

import tn.edu.esprit.Pidev.Entity.Account;
import tn.esprit.Pidev.exception.BadCredentialException;

@Local
public interface GestionAcountLocal {
	public Account authentificat(String login ,String password);
	public Object retrieveAccountByCredentials(String username, String password) throws BadCredentialException;

}
