package au.com.equicord.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class responsible for holding attributes from Event Type Object
 * 
 * @author Gustavo <gustavotavaresdias@gmail.com>
 */
@XmlRootElement
public class EventType {

	private int eTypeID;
	private String eType;

	public int geteTypeID() {
		return eTypeID;
	}

	public void seteTypeID(int eTypeID) {
		this.eTypeID = eTypeID;
	}

	public String geteType() {
		return eType;
	}

	public void seteType(String eType) {
		this.eType = eType;
	}

}
