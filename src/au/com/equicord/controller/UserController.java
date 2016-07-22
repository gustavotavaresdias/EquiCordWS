package au.com.equicord.controller;

import java.util.ArrayList;

import au.com.equicord.dao.UserDAO;
import au.com.equicord.model.User;

/**
 * Class responsible for being the controller between resource class and DAO
 * class.
 * 
 * @author Gustavo <gustavotavaresdias@gmail.com>
 */
public class UserController {
	
	public ArrayList<User> getUsers(){
		return UserDAO.getIntance().getUsers();
	}

	public User getUserByID(int idUser) {
		return UserDAO.getIntance().getUserById(idUser);
	}
	
	public boolean addUser(User user) {
		return UserDAO.getIntance().addUser(user);
	}

	public boolean updateUser(User user) {
		return UserDAO.getIntance().updateUser(user);
	}

	public boolean deleteUser(int idUser) {
		return UserDAO.getIntance().deleteUser(idUser);
	}
}
