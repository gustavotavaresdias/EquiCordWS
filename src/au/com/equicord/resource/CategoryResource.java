package au.com.equicord.resource;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import au.com.equicord.controller.CategoryController;
import au.com.equicord.controller.HorseController;
import au.com.equicord.model.Category;
import au.com.equicord.model.Horse;

/**
 * Class responsible for having the web service's access methods for Category.
 *
 * @author Gustavo <gustavotavaresdias@gmail.com>
 */
@Path("/category")
public class CategoryResource {

	/**
	 * Method responsible to GET all categories registers in a Json format.
	 *  
	 * @return ArrayList<Category> - List of Categories
	 */
	@GET
	@Path("/getCategories")
	@Produces("application/json")
	public ArrayList<Category> getCategories() {
		ArrayList<Category> result = new ArrayList<Category>();
		result = new CategoryController().getCategories();
		return result;
	}

	
}