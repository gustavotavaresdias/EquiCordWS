package au.com.equicord.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;

import au.com.equicord.factory.ConnectionFactory;
import au.com.equicord.model.Event;

/**
 * Class responsible for having all database methods from EventsTable
 * 
 * @author Gustavo <gustavotavaresdias@gmail.com>
 */
public class EventDAO extends ConnectionFactory{

	private static EventDAO instance;

	public static EventDAO getIntance() {
		if (instance == null) {
			instance = new EventDAO();
		}
		return instance;
	}
	
	/**
	 * Method responsible for getting all events from DB
	 * 
	 * @return ArrayList<Event> - List of Events
	 */
	public ArrayList<Event> getEvents() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Event> eventList = null;

		conn = createConnection();
		eventList = new ArrayList<Event>();

		try {
			pstmt = conn.prepareStatement("SELECT * FROM eventsTable "
					+ "INNER JOIN eventType ON eventsTable.eTypeID = eventType.eTypeID");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Event event = new Event();

				event.seteID(rs.getInt("eID"));
				event.seteName(rs.getString("eName"));
				event.seteAddress(rs.getString("aAddress"));
				event.setePostcode(rs.getInt("ePostcode"));
				event.seteWeb(rs.getString("eWeb"));
				event.setePhone(rs.getInt("ePhone"));
				event.seteMail(rs.getString("eMail"));
				event.setEcName(rs.getString("ecName"));
				event.setEcAddress(rs.getString("ecAddress"));
				event.setEcPhone(rs.getInt("ecPhone"));
				event.setEcEmail(rs.getString("ecEmail"));
				event.setElsPrivate(rs.getBoolean("elsPrivate"));				
				event.seteTypeID(rs.getInt("eTypeID"));
				event.seteType(rs.getString("eType"));
				event.seteDate(rs.getDate("eDate"));
				event.setePeriod(rs.getInt("ePeriod"));
				event.seteTime(rs.getDate("eTime"));
				event.seteGoogleID(rs.getString("eGoogleID"));				
				event.seteSNumber(rs.getInt("eSNumber"));
				event.seteSName(rs.getString("eSName"));
				event.seteSuburb(rs.getString("eSuburb"));
				event.seteState(rs.getString("eState"));
				event.seteCountry(rs.getString("eCountry"));
				event.setePicture(rs.getString("ePicture"));
				
				eventList.add(event);
			}
		} catch (Exception e) {
			System.out.println("Error when select EVENTS:" + e);
			e.printStackTrace();
		} finally {
			closeConnection(conn, pstmt, rs);
		}

		return eventList;
	}

	/**
	 * Method responsible for add object Event into the database
	 * 
	 * @param Event - object event
	 * @return boolean - true or false
	 */
	public boolean addEvent(Event event) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = createConnection();
		try {
			pstmt = conn.prepareStatement("INSERT INTO eventsTable VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			pstmt.setString(1, event.geteName());
			pstmt.setString(2, event.geteAddress());
			pstmt.setInt(3, event.getePostcode());
			pstmt.setString(4, event.geteWeb());
			pstmt.setInt(5, event.getePhone());
			pstmt.setString(6, event.geteMail());
			pstmt.setString(7, event.getEcName());
			pstmt.setString(8, event.getEcAddress());
			pstmt.setInt(9, event.getEcPhone());
			pstmt.setString(10, event.getEcEmail());
			pstmt.setBoolean(11, event.isElsPrivate());			
			pstmt.setInt(12, event.geteTypeID());
			pstmt.setDate(13, new Date(event.geteDate().getTime()));
			pstmt.setInt(14, event.getePeriod());
			pstmt.setDate(15, new Date(event.geteTime().getTime()));
			pstmt.setString(16, event.geteGoogleID());			
			pstmt.setInt(17, event.geteSNumber());
			pstmt.setString(18, event.geteSName());
			pstmt.setString(19, event.geteSuburb());
			pstmt.setString(20, event.geteState());
			pstmt.setString(21, event.geteCountry());
			pstmt.setString(22, event.getePicture());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error when try add new EVENT - " + e);
			e.printStackTrace();
			return false;
		} finally {
			closeConnection(conn, pstmt, rs);
		}
		return true;
	}

	/**
	 * Method responsible for update object Event into the database
	 * 
	 * @param Event - object event
	 * @return boolean - true or false
	 */
	public boolean updateEvent(Event event) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = createConnection();
		try {
			pstmt = conn.prepareStatement("UPDATE eventsTable SET eName = ?, "
					+ "aAddress = ?, ePostcode = ?, eWeb = ?, ePhone = ?, eMail = ?, ecName = ?, ecAddress = ?, ecPhone = ?, ecEmail = ?, "
					+ "elsPrivate = ?, eTypeID = ?, eDate = ?, ePeriod = ?, eTime = ?, eGoogleID = ?, eSNumber = ?, eSName = ?, "
					+ "eSuburb = ?, eState = ?, eCountry = ?, ePicture = ? "
					+ "WHERE eID = ?");

			pstmt.setString(1, event.geteName());
			pstmt.setString(2, event.geteAddress());
			pstmt.setInt(3, event.getePostcode());
			pstmt.setString(4, event.geteWeb());
			pstmt.setInt(5, event.getePhone());
			pstmt.setString(6, event.geteMail());
			pstmt.setString(7, event.getEcName());
			pstmt.setString(8, event.getEcAddress());
			pstmt.setInt(9, event.getEcPhone());
			pstmt.setString(10, event.getEcEmail());
			pstmt.setBoolean(11, event.isElsPrivate());			
			pstmt.setInt(12, event.geteTypeID());
			pstmt.setDate(13, new Date(event.geteDate().getTime()));
			pstmt.setInt(14, event.getePeriod());
			pstmt.setDate(15, new Date(event.geteTime().getTime()));
			pstmt.setString(16, event.geteGoogleID());
			pstmt.setInt(17, event.geteSNumber());
			pstmt.setString(18, event.geteSName());
			pstmt.setString(19, event.geteSuburb());
			pstmt.setString(20, event.geteState());
			pstmt.setString(21, event.geteCountry());
			pstmt.setString(22, event.getePicture());
			pstmt.setInt(23, event.geteID());

			pstmt.executeUpdate();			
		} catch (Exception e) {
			System.out.println("Error when try update EVENT - " + e);
			e.printStackTrace();
			return false;
		} finally {
			closeConnection(conn, pstmt, rs);
		}
		return true;
	}

	/**
	 * Method responsible for delete object event from the database
	 *
	 * @param int - idEvent
	 * @return boolean - true or false
	 */
	public boolean deleteEvent(int idEvent) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = createConnection();
		try {
			pstmt = conn.prepareStatement("DELETE FROM eventsTable WHERE eID = ?");
			pstmt.setInt(1, idEvent);			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error when try delete EVENT - " + e);
			e.printStackTrace();
			return false;
		} finally {
			closeConnection(conn, pstmt, rs);
		}
		return true;
	}
}
