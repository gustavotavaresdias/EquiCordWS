package au.com.equicord.resource;

import java.io.IOException;
import java.sql.SQLException;
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

import au.com.equicord.controller.HorseController;
import au.com.equicord.controller.UserController;
import au.com.equicord.model.Horse;
import au.com.equicord.model.User;
import au.com.equicord.util.Util;

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
		ArrayList<Horse> result = new ArrayList<Horse>();
		result = new HorseController().getHorses();
		return result;
	}

	/**
	 * Method responsible for POST a horse object.
	 *
	 * @param horse
	 *            object
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
	 * @param horse
	 *            object
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
		//String SERVER_UPLOAD_LOCATION_FOLDER = "//localhost:8080/httpdocs/uploads/";
		//String SERVER_UPLOAD_LOCATION_FOLDER = "//223.27.22.119:8080/httpdocs/uploads/";
		String SERVER_UPLOAD_LOCATION_FOLDER = "dir:/../../../../www/vhosts/commercialgraphics.com.au/uploads/";
		
		
		Calendar tempDate = Calendar.getInstance();
		imageName = "horse_" + tempDate.getTimeInMillis() + ".jpg";
		String filePath = SERVER_UPLOAD_LOCATION_FOLDER + imageName;
		result = Util.saveImage(fileData, filePath);
		
		//String webAppPath2 = new File(".").getCanonicalPath();
		String webAppPath = this.getClass().getProtectionDomain().getCodeSource().getLocation().toString();
		
		return result + "*****" + webAppPath + "*****" +filePath;

	}	

	/**
	 * Method responsible for DELETE a horse object
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
	
	/**
	 * Method responsible for get all Horses by USER ID.
	 *
	 * @param int - Id user
	 * @return ArrayList<Horse> - List of Horses by User
	 */
	@GET
	@Path("/getHorsesByUser/{idUser}")
	@Produces("application/json")
	public ArrayList<Horse> getHorsesByUser(@PathParam("idUser") int idUser) throws SQLException {
		ArrayList<Horse> result = new ArrayList<Horse>();
		result = new HorseController().getHorsesByUser(idUser);
		return result;
	}
	
	/**
	 * Method responsible for POST a horse object.
	 *
	 * @param horse
	 *            object
	 * @return String - (Success or Failure)
	 */
	@POST
	@Path("/addHorseByUser")
	@Produces("application/json")
	public String addHorseByUser(Horse horse) {
		boolean result;

		result = new HorseController().addHorseByUser(horse);

		if (result) {
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}
}