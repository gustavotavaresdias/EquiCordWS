package au.com.equicord.controller;

import java.util.ArrayList;

import au.com.equicord.dao.ContactDAO;
import au.com.equicord.model.Contact;

/**
 * Class responsible for being the controller between resource class and DAO
 * class.
 * 
 * @author Gustavo <gustavotavaresdias@gmail.com>
 */
public class ContactController {
	
	public ArrayList<Contact> getContacts(){
		return ContactDAO.getIntance().getContacts();
	}

	public boolean addContact(Contact contact) {
		return ContactDAO.getIntance().addContact(contact);
	}

	public boolean updateContact(Contact contact) {
		return ContactDAO.getIntance().updateContact(contact);
	}

	public boolean deleteContact(int idContact) {
		return ContactDAO.getIntance().deleteContact(idContact);
	}
}
