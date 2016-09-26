package au.com.equicord.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import au.com.equicord.dao.UserDAO;
import au.com.equicord.model.User;
import au.com.equicord.util.BCrypt;

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

	public User getUserById(int idUser) throws SQLException {
		return UserDAO.getIntance().getUserById(idUser);
	}
	
	public User getUserByEmail(String email) throws SQLException {
		return UserDAO.getIntance().getUserByEmail(email);
	}
	
	public User checkLogin(User user) throws SQLException {
		User resultUser = new User();
		if (!user.getuEmail().equals("") && !user.getuPassword().equals("")) {
			User dbUser = UserDAO.getIntance().getUserByEmail(user.getuEmail());
			
			if (BCrypt.checkpw(user.getuPassword(), dbUser.getuPassword())) {
				System.out.println("It matches");
				resultUser = dbUser;
	        }
		}
		return resultUser;
	}
	
	public User addUser(User user) throws SQLException {
		User resultUser = new User();
		if(getUserByEmail(user.getuEmail()) == null){
			String pw_hash = BCrypt.hashpw(user.getuPassword(), BCrypt.gensalt());
			
			user.setuPassword(pw_hash);		
			int newID = UserDAO.getIntance().addUser(user);
			user.setuID(newID);
			resultUser = user;
		}
		return resultUser;
	}

	public boolean updateUser(User user) {
		return UserDAO.getIntance().updateUser(user);
	}

	public boolean deleteUser(int idUser) {
		return UserDAO.getIntance().deleteUser(idUser);
	}
}
