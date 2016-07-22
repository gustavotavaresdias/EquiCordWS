package au.com.equicord.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import au.com.equicord.factory.ConnectionFactory;
import au.com.equicord.model.EventType;

/**
 * Class responsible for having all database methods from EventType Table
 * 
 * @author Gustavo <gustavotavaresdias@gmail.com>
 */
public class EventTypeDAO extends ConnectionFactory {
	
	private static EventTypeDAO instance;

	public static EventTypeDAO getIntance() {
		if (instance == null) {
			instance = new EventTypeDAO();
		}
		return instance;
	}

	/**
	 * Method responsible for getting all event types from DB
	 * 
	 * @return ArrayList<EventType> - List of EventTypes
	 */
	public ArrayList<EventType> getEventTypes() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EventType> eventList = null;

		conn = createConnection();
		eventList = new ArrayList<EventType>();

		try {
			pstmt = conn.prepareStatement("SELECT * FROM eventType");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				EventType eventType = new EventType();

				eventType.seteTypeID(rs.getInt("eTypeID"));
				eventType.seteType(rs.getString("eType"));

				eventList.add(eventType);
			}
		} catch (Exception e) {
			System.out.println("Error when select Event Type:" + e);
			e.printStackTrace();
		} finally {
			closeConnection(conn, pstmt, rs);
		}

		return eventList;
	}
}
