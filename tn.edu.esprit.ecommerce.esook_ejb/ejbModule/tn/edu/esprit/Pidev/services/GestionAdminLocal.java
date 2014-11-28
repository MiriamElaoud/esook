package tn.edu.esprit.Pidev.services;

import javax.ejb.Local;

import tn.edu.esprit.Pidev.Entity.Admin;

@Local
public interface GestionAdminLocal {
	public void persistAdmin(Admin admin);
	public void updateAdmin(Admin admin);
	public void removeAdmin (Admin admin);
	public Admin searchadminByid(int id);
	public Admin searchUserByid(int id);
	public Admin retrieveAdminByCredentials(String login,
			String password);


}
