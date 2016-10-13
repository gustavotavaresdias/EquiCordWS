package au.com.equicord.resource;

import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import au.com.equicord.controller.ContactController;
import au.com.equicord.controller.HorseController;
import au.com.equicord.model.Contact;
import au.com.equicord.model.Horse;

/**
 * Class responsible for having the web service's access methods for contact.
 *
 * @author Gustavo <gustavotavaresdias@gmail.com>
 */
@Path("/contact")
public class ContactResource {
	private static final String SUCCESS_RESULT = "success";
	private static final String FAILURE_RESULT = "failure";

	/**
	 * Method responsible for GET all contacts in a Json format.
	 * 
	 * @return ArrayList<Category> - List of contacts
	 */
	@GET
	@Path("/getContacts")
	@Produces("application/json")
	public ArrayList<Contact> getContacts() {
		ArrayList<Contact> result = new ArrayList<Contact>();
		result = new ContactController().getContacts();
		return result;
	}

	
	/**
	 * Method responsible for POST a contact object.
	 *
	 * @param contact object
	 * @return String - (Success or Failure)
	 */
	@POST
	@Path("/addContact")
	@Produces("application/json")
	public String addContact(Contact contact) {
		boolean result;

		result = new ContactController().addContact(contact);

		if (result) {
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}

	/**
	 * Method responsible for PUT a contact object.
	 *
	 * @param contact object
	 * @return String - (Success or Failure)
	 */
	@PUT
	@Path("/updateContact")
	@Produces("application/json")
	public String updateContact(Contact contact) {
		boolean result;

		result = new ContactController().updateContact(contact);

		if (result) {
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}
	
	/**
	 * Method responsible for DELETE a contact object.
	 *
	 * @param int - Id of contact
	 * @return String - (Success or Failure)
	 */
	@DELETE
	@Path("deleteContact/{id}")
	@Produces("application/json")
	public String deleteContact(@PathParam("id") int idContact) {
		boolean result;

		result = new ContactController().deleteContact(idContact);

		if (result) {
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}
	
	/**
	 * Method responsible for get all Contacts by USER ID.
	 *
	 * @param int - Id user
	 * @return ArrayList<Contact> - List of Contact by User
	 */
	@GET
	@Path("/getContactsByUser/{idUser}")
	@Produces("application/json")
	public ArrayList<Contact> getContactsByUser(@PathParam("idUser") int idUser) {
		ArrayList<Contact> result = new ArrayList<Contact>();
		result = new ContactController().getContactsByUser(idUser);
		return result;
	}
	
	/**
	 * Method responsible for POST a contact object.
	 *
	 * @param contact object
	 * @return String - (Success or Failure)
	 */
	@POST
	@Path("/addContactByUser")
	@Produces("application/json")
	public String addContactByUser(Contact contact) {
		boolean result;

		result = new ContactController().addContactByUser(contact);

		if (result) {
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}
}