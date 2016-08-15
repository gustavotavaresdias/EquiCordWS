package au.com.equicord.resource;

import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import au.com.equicord.controller.EventTypeController;
import au.com.equicord.controller.UserController;
import au.com.equicord.model.EventType;
import au.com.equicord.model.User;

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
	@Path("/getUser/{id}")
	@Produces("application/json")
	public User GetUserByID(@PathParam("id") int idUser) {
		return new UserController().getUserByID(idUser);
	}
	
	/**
	 * Method responsible for POST a user object.
	 *
	 * @param user object
	 * @return new User ID - user Id
	 */
	@POST
	@Path("/addUser")
	@Produces("application/json")
	public String addUser(User user) {
		String result;

		result = String.valueOf(new UserController().addUser(user));		
		return result;
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