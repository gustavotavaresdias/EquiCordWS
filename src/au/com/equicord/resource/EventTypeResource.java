package au.com.equicord.resource;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import au.com.equicord.controller.EventTypeController;
import au.com.equicord.model.EventType;

/**
 * Class responsible for having the web service's access methods for Event Type.
 *
 * @author Gustavo <gustavotavaresdias@gmail.com>
 */
@Path("/eventType")
public class EventTypeResource {
	private static final String SUCCESS_RESULT = "success";
	private static final String FAILURE_RESULT = "failure";

	/**
	 * Method responsible to GET all Event Types registers in a Json format.
	 *  
	 * @return ArrayList<EventType> - List of Categories
	 */
	@GET
	@Path("/getEventTypes")
	@Produces("application/json")
	public ArrayList<EventType> getEventTypes() {
		return new EventTypeController().getEventTypes();
	}

	
}