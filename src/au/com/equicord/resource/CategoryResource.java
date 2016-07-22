package au.com.equicord.resource;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import au.com.equicord.controller.CategoryController;
import au.com.equicord.model.Category;

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
	@Path("/getCategories")
	@Produces("application/json")
	public ArrayList<Category> getCategories() {
		return new CategoryController().getCategories();
	}

	
}