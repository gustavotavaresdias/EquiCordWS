package au.com.equicord.controller;

import java.util.ArrayList;

import au.com.equicord.dao.HorseDAO;
import au.com.equicord.model.Horse;

/**
 * Class responsible for being the controller between resource class and DAO
 * class.
 * 
 * @author Gustavo <gustavotavaresdias@gmail.com>
 */
public class HorseController {
	
	public ArrayList<Horse> getHorses(){
		return HorseDAO.getIntance().getHorses();
	}

	public boolean addHorse(Horse horse) {
		return HorseDAO.getIntance().addHorse(horse);
	}

	public boolean updateHorse(Horse horse) {
		return HorseDAO.getIntance().updateHorse(horse);
	}

	public boolean deleteHorse(int idHorse) {
		return HorseDAO.getIntance().deleteHorse(idHorse);
	}
	
	public ArrayList<Horse> getHorsesByUser(int idUser){
		return HorseDAO.getIntance().getHorsesByUser(idUser);
	}
}
