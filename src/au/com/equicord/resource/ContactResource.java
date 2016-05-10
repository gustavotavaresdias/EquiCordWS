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
import au.com.equicord.model.Contact;

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
	 * 
	 * @return
	 */
	@GET
	@Path("/getContacts")
	@Produces("application/json")
	public ArrayList<Contact> getContacts() {
		return new ContactController().getContacts();
	}

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
}