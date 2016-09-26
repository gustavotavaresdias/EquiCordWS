package au.com.equicord.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import au.com.equicord.controller.UserController;
import au.com.equicord.model.User;
import au.com.equicord.util.BCrypt;

/**
 * Class responsible for having the web service's access methods for user.
 *
 * @author Gustavo <gustavotavaresdias@gmail.com>
 */
@Path("/user")
public class UserResource {
	private static final String SUCCESS_RESULT = "success";
	private static final String FAILURE_RESULT = "failure";

	/**
	 * Method responsible for GET all users in a Json format.
	 * 
	 * @return ArrayList<User> - List of Users
	 */
	@GET
	@Path("/getUsers")
	@Produces("application/json")
	public ArrayList<User> getUsers() {
		ArrayList<User> result = new ArrayList<User>();
		result = new UserController().getUsers();
		return result;
	}

	/**
	 * Method responsible for GET a user by ID object.
	 *
	 * @param int - Id of user
	 * @return User
	 */
	@GET
	@Path("/getUserById/{id}")
	@Produces("application/json")
	public User getUserById(@PathParam("id") int idUser) throws SQLException {
		User resultUser = new User();
		resultUser = new UserController().getUserById(idUser);
		return resultUser;
	}
	
	/**
	 * Method responsible for GET a user by Email.
	 *
	 * @param String - User email
	 * @return User
	 * @throws SQLException 
	 */
	@GET
	@Path("/getUserByEmail/{email}")
	@Produces("application/json")
	public User getUserByEmail(@PathParam("email")String email) throws SQLException {
		User resultUser = new User();
		resultUser = new UserController().getUserByEmail(email);
		return resultUser;
	}
	
	/**
	 * Method responsible for Check a user by Email and Password.
	 *
	 * @param String - User email
	 * @param String - User password
	 * @return User
	 * @throws SQLException 
	 */
	@POST
	@Path("/login")
	@Produces("application/json")
	public User checkLogin(User user) throws SQLException {
		User resultUser = new User();		
		resultUser = new UserController().checkLogin(user);
		return resultUser;
	}
	/**
	 * Method responsible for POST a user object.
	 *
	 * @param user object
	 * @return new User ID - user Id
	 * @throws SQLException 
	 */
	@POST
	@Path("/addUser")
	@Produces("application/json")
	public User addUser(User user) throws SQLException {
		User resultUser = new User();
		resultUser = new UserController().addUser(user);		
		return resultUser;
	}

	/**
	 * Method responsible for PUT a user object.
	 *
	 * @param user object
	 * @return String - (Success or Failure)
	 */
	@PUT
	@Path("/updateUser")
	@Produces("application/json")
	public String updateUser(User user) {
		boolean result;

		result = new UserController().updateUser(user);

		if (result) {
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}
	
	/**
	 * Method responsible for DELETE a user object.
	 *
	 * @param int - Id of user
	 * @return String - (Success or Failure)
	 */
	@DELETE
	@Path("deleteUser/{id}")
	@Produces("application/json")
	public String deleteUser(@PathParam("id") int idUser) {
		boolean result;

		result = new UserController().deleteUser(idUser);

		if (result) {
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}
}