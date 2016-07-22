package au.com.equicord.resource;

import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import au.com.equicord.controller.HorseController;
import au.com.equicord.model.Horse;

/**
 * Class responsible for having the web service's access methods for horse.
 *
 * @author Gustavo <gustavotavaresdias@gmail.com>
 */
@Path("/horse")
public class HorseResource {
	private static final String SUCCESS_RESULT = "success";
	private static final String FAILURE_RESULT = "failure";

	/**
	 * Method responsible for GET all horses in a Json format.
	 * 
	 * @return ArrayList<Horse> - List of Horses
	 */
	@GET
	@Path("/getHorses")
	@Produces("application/json")
	public ArrayList<Horse> getHorses() {
		return new HorseController().getHorses();
	}

	
	/**
	 * Method responsible for POST a horse object.
	 *
	 * @param horse object
	 * @return String - (Success or Failure)
	 */
	@POST
	@Path("/addHorse")
	@Produces("application/json")
	public String addHorse(Horse horse) {
		boolean result;

		result = new HorseController().addHorse(horse);

		if (result) {
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}

	/**
	 * Method responsible for PUT a horse object.
	 *
	 * @param horse object
	 * @return String - (Success or Failure)
	 */
	@PUT
	@Path("/updateHorse")
	@Produces("application/json")
	public String updateHorse(Horse horse) {
		boolean result;

		result = new HorseController().updateHorse(horse);

		if (result) {
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}
	
	/**
	 * Method responsible for DELETE a horse object.
	 *
	 * @param int - Id of horse
	 * @return String - (Success or Failure)
	 */
	@DELETE
	@Path("deleteHorse/{id}")
	@Produces("application/json")
	public String deleteHorse(@PathParam("id") int idHorse) {
		boolean result;

		result = new HorseController().deleteHorse(idHorse);

		if (result) {
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}
}