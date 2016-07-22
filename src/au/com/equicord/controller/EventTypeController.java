package au.com.equicord.controller;

import java.util.ArrayList;

import au.com.equicord.dao.EventTypeDAO;
import au.com.equicord.model.EventType;

/**
 * Class responsible for being the controller between resource class and DAO
 * class.
 * 
 * @author Gustavo <gustavotavaresdias@gmail.com>
 */
public class EventTypeController {
	
	public ArrayList<EventType> getEventTypes(){
		return EventTypeDAO.getIntance().getEventTypes();
	}
}
