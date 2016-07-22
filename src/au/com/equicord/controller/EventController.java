package au.com.equicord.controller;

import java.util.ArrayList;

import au.com.equicord.dao.EventDAO;
import au.com.equicord.model.Event;


/**
 * Class responsible for being the controller between resource class and DAO
 * class.
 * 
 * @author Gustavo <gustavotavaresdias@gmail.com>
 */
public class EventController {
	
	public ArrayList<Event> getEvents(){
		return EventDAO.getIntance().getEvents();
	}

	public boolean addEvent(Event event) {
		return EventDAO.getIntance().addEvent(event);
	}

	public boolean updateEvent(Event event) {
		return EventDAO.getIntance().updateEvent(event);
	}

	public boolean deleteEvent(int idEvent) {
		return EventDAO.getIntance().deleteEvent(idEvent);
	}
}
