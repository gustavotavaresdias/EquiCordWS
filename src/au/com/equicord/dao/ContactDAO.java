package au.com.equicord.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import au.com.equicord.factory.ConnectionFactory;
import au.com.equicord.model.Contact;
import au.com.equicord.model.Event;
import au.com.equicord.model.Horse;

/**
 * Class responsible for having all database methods from ContactTable
 * 
 * @author Gustavo <gustavotavaresdias@gmail.com>
 */
public class ContactDAO extends ConnectionFactory {

	private static ContactDAO instance;

	public static ContactDAO getIntance() {
		if (instance == null) {
			instance = new ContactDAO();
		}
		return instance;
	}

	/**
	 * Method responsible for getting all contacts from DB
	 * 
	 * @return ArrayList<Contact> - List of Contacts
	 */
	public ArrayList<Contact> getContacts() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Contact> listContacts = null;

		conn = createConnection();
		listContacts = new ArrayList<Contact>();

		try {
			pstmt = conn.prepareStatement("SELECT * FROM contactTable "
					+ "INNER JOIN categoryTable "
					+ "ON contactTable.CategoryID = categoryTable.categoryID");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Contact contact = new Contact();

				contact.setId(rs.getInt("cID"));
				contact.setName(rs.getString("cName"));
				contact.setPhone(rs.getInt("ctPhone"));
				contact.setAddress(rs.getString("cAddress"));
				contact.setPostcode(rs.getInt("cPostcode"));
				contact.setEmail(rs.getString("cEmail"));
				contact.setPrivate(rs.getBoolean("clsPrivate"));
				contact.setCategoryId(rs.getInt("CategoryID"));
				contact.setCategoryType(rs.getString("cType"));
				contact.setCategoryDescription(rs.getString("cTypeDesc"));
				contact.setPeriodId(rs.getInt("pPeriodID"));
				contact.setStart(rs.getDate("pStart"));
				contact.setEnd(rs.getDate("pEnd"));
				contact.setPrice(rs.getDouble("cPrice"));
				contact.setSearchId(rs.getInt("SearchID"));
				contact.setGoogleId(rs.getString("GoogleID"));
				contact.setPaypal(rs.getBoolean("payPal"));
				contact.setcSNumber(rs.getInt("cSNumber"));
				contact.setcSName(rs.getString("cSName"));
				contact.setcSuburb(rs.getString("cSuburb"));
				contact.setcState(rs.getString("cState"));
				contact.setcCountry(rs.getString("cCountry"));
				contact.setcPicture(rs.getString("cPicture"));

				listContacts.add(contact);
			}
		} catch (Exception e) {
			System.out.println("Error when select contact:" + e);
			e.printStackTrace();
		} finally {
			closeConnection(conn, pstmt, rs);
		}

		return listContacts;
	}

	/**
	 * Method responsible for add object Contact into the database
	 * 
	 * @param contact - object contact
	 * @return boolean - true or false
	 */
	public boolean addContact(Contact contact) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = createConnection();
		try {
			pstmt = conn.prepareStatement("INSERT INTO contactTable VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			pstmt.setString(1, contact.getName());
			pstmt.setInt(2, contact.getPhone());
			pstmt.setString(3, contact.getAddress());
			pstmt.setInt(4, contact.getPostcode());
			pstmt.setString(5, contact.getEmail());
			pstmt.setBoolean(6, contact.isPrivate());
			pstmt.setInt(7, contact.getCategoryId());
			pstmt.setInt(8, contact.getPeriodId());
			pstmt.setDate(9, new Date(contact.getStart().getTime()));
			pstmt.setDate(10, new Date(contact.getEnd().getTime()));
			pstmt.setDouble(11, contact.getPrice());
			pstmt.setInt(12, contact.getSearchId());
			pstmt.setString(13, contact.getGoogleId());
			pstmt.setBoolean(14, contact.isPaypal());
			pstmt.setInt(15, contact.getcSNumber());
			pstmt.setString(16, contact.getcSName());
			pstmt.setString(17, contact.getcSuburb());
			pstmt.setString(18, contact.getcState());
			pstmt.setString(19, contact.getcCountry());
			pstmt.setString(20, contact.getcPicture());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error when try add contact - " + e);
			e.printStackTrace();
			return false;
		} finally {
			closeConnection(conn, pstmt, rs);
		}
		return true;
	}

	/**
	 * Method responsible for update object Contact into the database
	 * 
	 * @param contact - object contact
	 * @return boolean - true or false
	 */
	public boolean updateContact(Contact contact) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = createConnection();
		try {
			pstmt = conn.prepareStatement("UPDATE contactTable SET cName = ?, "
					+ "ctPhone = ?, cAddress = ?, cPostcode = ?, cEmail = ?, clsPrivate = ?, CategoryID = ?, "
					+ "pPeriodID = ?, pStart = ?, pEnd = ?, cPrice = ?, SearchID = ?, GoogleID = ?, payPal = ? "
					+ "WHERE cID = ?");

			pstmt.setString(1, contact.getName());
			pstmt.setInt(2, contact.getPhone());
			pstmt.setString(3, contact.getAddress());
			pstmt.setInt(4, contact.getPostcode());
			pstmt.setString(5, contact.getEmail());
			pstmt.setBoolean(6, contact.isPrivate());
			pstmt.setInt(7, contact.getCategoryId());
			pstmt.setInt(8, contact.getPeriodId());
			pstmt.setDate(9, new Date(contact.getStart().getTime()));
			pstmt.setDate(10, new Date(contact.getEnd().getTime()));
			pstmt.setDouble(11, contact.getPrice());
			pstmt.setInt(12, contact.getSearchId());
			pstmt.setString(13, contact.getGoogleId());
			pstmt.setBoolean(14, contact.isPaypal());
			pstmt.setInt(15, contact.getId());

			pstmt.executeUpdate();			
		} catch (Exception e) {
			System.out.println("Error when try update contact - " + e);
			e.printStackTrace();
			return false;
		} finally {
			closeConnection(conn, pstmt, rs);
		}
		return true;
	}

	/**
	 * Method responsible for delete object contact from the database
	 *
	 * @param int - idContact
	 * @return boolean - true or false
	 */
	public boolean deleteContact(int idContact) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = createConnection();
		try {
			pstmt = conn.prepareStatement("DELETE FROM contactTable WHERE cID = ?");
			pstmt.setInt(1, idContact);			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error when try add contact - " + e);
			e.printStackTrace();
			return false;
		} finally {
			closeConnection(conn, pstmt, rs);
		}
		return true;
	}

	/**
	 * Method responsible for getting all contacts by user from DB
	 * 
	 * @return ArrayList<Contact> - List of Contacts by User
	 */
	public ArrayList<Contact> getContactsByUser(int userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Contact> listContacts = null;

		conn = createConnection();
		listContacts = new ArrayList<Contact>();

		try {
			pstmt = conn.prepareStatement("SELECT DISTINCT contactTable . * , categoryTable . * "
					+ "FROM contactTable, masterMapping, categoryTable "
					+ "WHERE contactTable.cID = masterMapping.cID "
					+ "AND masterMapping.uID = ? "
					+ "AND contactTable.CategoryID = categoryTable.categoryID "
					+ "GROUP BY contactTable.cID");
			
			pstmt.setInt(1, userId);	
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Contact contact = new Contact();

				contact.setId(rs.getInt("cID"));
				contact.setName(rs.getString("cName"));
				contact.setPhone(rs.getInt("ctPhone"));
				contact.setAddress(rs.getString("cAddress"));
				contact.setPostcode(rs.getInt("cPostcode"));
				contact.setEmail(rs.getString("cEmail"));
				contact.setPrivate(rs.getBoolean("clsPrivate"));
				contact.setCategoryId(rs.getInt("CategoryID"));
				contact.setCategoryType(rs.getString("cType"));
				contact.setCategoryDescription(rs.getString("cTypeDesc"));
				contact.setPeriodId(rs.getInt("pPeriodID"));
				contact.setStart(rs.getDate("pStart"));
				contact.setEnd(rs.getDate("pEnd"));
				contact.setPrice(rs.getDouble("cPrice"));
				contact.setSearchId(rs.getInt("SearchID"));
				contact.setGoogleId(rs.getString("GoogleID"));
				contact.setPaypal(rs.getBoolean("payPal"));
				contact.setcSNumber(rs.getInt("cSNumber"));
				contact.setcSName(rs.getString("cSName"));
				contact.setcSuburb(rs.getString("cSuburb"));
				contact.setcState(rs.getString("cState"));
				contact.setcCountry(rs.getString("cCountry"));
				contact.setcPicture(rs.getString("cPicture"));

				listContacts.add(contact);
			}
		} catch (Exception e) {
			System.out.println("Error when select contact:" + e);
			e.printStackTrace();
		} finally {
			closeConnection(conn, pstmt, rs);
		}
		return listContacts;
	}
	
	/**
	 * Method responsible for add object Contact by User into the database
	 * 
	 * @param Contact - object Contact with user id
	 * @return boolean - true or false
	 */
	public boolean addContactByUser(Contact contact) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO contactTable VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int newContactId = -1;
		boolean mapResult = false;
		
		conn = createConnection();
		try {
			pstmt = conn.prepareStatement(sql, pstmt.RETURN_GENERATED_KEYS);

			pstmt.setString(1, contact.getName());
			pstmt.setInt(2, contact.getPhone());
			pstmt.setString(3, contact.getAddress());
			pstmt.setInt(4, contact.getPostcode());
			pstmt.setString(5, contact.getEmail());
			pstmt.setBoolean(6, contact.isPrivate());
			pstmt.setInt(7, contact.getCategoryId());
			pstmt.setInt(8, contact.getPeriodId());
			pstmt.setDate(9, new Date(contact.getStart().getTime()));
			pstmt.setDate(10, new Date(contact.getEnd().getTime()));
			pstmt.setDouble(11, contact.getPrice());
			pstmt.setInt(12, contact.getSearchId());
			pstmt.setString(13, contact.getGoogleId());
			pstmt.setBoolean(14, contact.isPaypal());
			pstmt.setInt(15, contact.getcSNumber());
			pstmt.setString(16, contact.getcSName());
			pstmt.setString(17, contact.getcSuburb());
			pstmt.setString(18, contact.getcState());
			pstmt.setString(19, contact.getcCountry());
			pstmt.setString(20, contact.getcPicture());
			
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				newContactId = rs.getInt(1);
				System.out.println("Added - " + contact.toString());				
				mapResult = addToMasterMapping(newContactId, contact.getuID());
			}			
			
		} catch (Exception e) {
			closeConnection(conn, pstmt, rs);
			System.out.println("Error when try add new CONTACT - " + e);
			e.printStackTrace();
			return false;
		} finally {
			closeConnection(conn, pstmt, rs);
		}
		return mapResult;
	}
	
	/**
	 * Method responsible for add Contact ID and User ID to MasterMapping Table
	 * 
	 * @param eventId - event Id
	 * @param userId - user id
	 * @return boolean - true or false
	 */
	private boolean addToMasterMapping(int contactId, int userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO masterMapping VALUES (null,?,null,?,null)";
		int returnId = -1;
		
		conn = createConnection();
		try {
			pstmt = conn.prepareStatement(sql, pstmt.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, contactId);
			pstmt.setInt(2, userId);
			
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				returnId = rs.getInt(1);
			}
			System.out.println("Added to MasterMapping - mapID:" + returnId + "contactId:"+ contactId + "userId:"+ userId);
			closeConnection(conn, pstmt, rs);
			return true;
			
		} catch (Exception e) {
			System.out.println("Error when try add to MasterMapping - " + e);
			e.printStackTrace();
			closeConnection(conn, pstmt, rs);
			return false;
		}
	}
}
