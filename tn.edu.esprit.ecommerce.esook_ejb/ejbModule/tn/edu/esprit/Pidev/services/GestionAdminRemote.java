package tn.edu.esprit.Pidev.services;

import javax.ejb.Remote;

import tn.edu.esprit.Pidev.Entity.Admin;
import tn.edu.esprit.Pidev.Entity.User;

@Remote
public interface GestionAdminRemote {
	public void persistAdmin(Admin admin);
	public void updateAdmin(Admin admin);
	public void removeAdmin (Admin admin);
	public Admin searchadminByid(int id);
	public Admin searchUserByid(int id);
	public Admin retrieveAdminByCredentials(String login,
			String password);


}
