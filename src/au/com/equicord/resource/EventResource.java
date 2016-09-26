package au.com.equicord.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import au.com.equicord.controller.ContactController;
import au.com.equicord.controller.EventController;
import au.com.equicord.model.Contact;
import au.com.equicord.model.Event;
import au.com.equicord.util.Util;

/**
 * Class responsible for having the web service's access methods for Event.
 *
 * @author Gustavo <gustavotavaresdias@gmail.com>
 */
@Path("/event")
public class EventResource {
	private static final String SUCCESS_RESULT = "success";
	private static final String FAILURE_RESULT = "failure";

	/**
	 * Method responsible for GET all events in a Json format.
	 * 
	 * @return ArrayList<Event> - List of Events
	 */
	@GET
	@Path("/getEvents")
	@Produces("application/json")
	public ArrayList<Event> getEvents() {
		ArrayList<Event> result = new ArrayList<Event>();
		result = new EventController().getEvents();
		return result;
	}

	
	/**
	 * Method responsible for POST a Event object.
	 *
	 * @param event object
	 * @return String - (Success or Failure)
	 */
	@POST
	@Path("/addEvent")
	@Produces("application/json")
	public String addEvent(Event event) {
		boolean result;

		result = new EventController().addEvent(event);

		if (result) {
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}

	/**
	 * Method responsible for PUT a event object.
	 *
	 * @param event object
	 * @return String - (Success or Failure)
	 */
	@PUT
	@Path("/updateEvent")
	@Produces("application/json")
	public String updateEvent(Event event) {
		boolean result;

		result = new EventController().updateEvent(event);

		if (result) {
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}
	
	/**
	 * Method responsible for DELETE a event object.
	 *
	 * @param int - Id of event
	 * @return String - (Success or Failure)
	 */
	@DELETE
	@Path("deleteEvent/{id}")
	@Produces("application/json")
	public String deleteEvent(@PathParam("id") int idEvent) {
		boolean result;

		result = new EventController().deleteEvent(idEvent);

		if (result) {
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}
	
	/**
	 * Method responsible for UPLOAD image for horse.
	 *
	 * @param int - Id of horse
	 * @return String - (Success or Failure)
	 * @throws IOException 
	 */
	@POST
	@Path("/upload")
	@Produces("application/json")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public String uploadFile(byte[] fileData) throws IOException {
		String result;
		String imageName;
		String SERVER_UPLOAD_LOCATION_FOLDER = "commercialgraphics.com.au\\httpdocs\\uploads\\";
		//String SERVER_UPLOAD_LOCATION_FOLDER = "dir:\\var\\www\\vhosts\\commercialgraphics.com.au\\httpdocs\\uploads\\";
		
		
		Calendar tempDate = Calendar.getInstance();
		imageName = "event_" + tempDate.getTimeInMillis() + ".jpg";
		String filePath = SERVER_UPLOAD_LOCATION_FOLDER + imageName;
		result = Util.saveImage(fileData, filePath);
		
		//String webAppPath2 = new File(".").getCanonicalPath();
		String webAppPath = this.getClass().getProtectionDomain().getCodeSource().getLocation().toString();
		
		return result + "*****" + webAppPath + "*****" +filePath;

	}
}