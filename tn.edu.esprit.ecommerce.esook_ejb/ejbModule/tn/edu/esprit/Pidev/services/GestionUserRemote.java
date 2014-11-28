package tn.edu.esprit.Pidev.services;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.Pidev.Entity.User;

@Remote
public interface GestionUserRemote {
	public void persistUser(User user);
	public void updateUser(User user);
	public void removeUser (User user);
	public User searchUserByid(int id);
	public User authentificatUser(String login ,String password);
	public List<User> getAllUsers();
	public User retrieveUserByCredentials(String login,
			String password);

}
