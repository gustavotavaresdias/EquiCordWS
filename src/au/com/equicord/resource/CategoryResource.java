package au.com.equicord.resource;

import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import au.com.equicord.controller.CategoryController;
import au.com.equicord.controller.ContactController;
import au.com.equicord.model.Category;
import au.com.equicord.model.Contact;

/**
 * Class responsible for having the web service's access methods for Category.
 *
 * @author Gustavo <gustavotavaresdias@gmail.com>
 */
@Path("/category")
public class CategoryResource {
	private static final String SUCCESS_RESULT = "success";
	private static final String FAILURE_RESULT = "failure";

	/**
	 * Method responsible to GET all categories registers in a Json format.
	 *  
	 * @return ArrayList<Category> - List of Categories
	 */
	@GET
	@Path("/getCategory")
	@Produces("application/json")
	public ArrayList<Category> getCategory() {
		return new CategoryController().getCategory();
	}

	
}