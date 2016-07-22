package au.com.equicord.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import au.com.equicord.factory.ConnectionFactory;
import au.com.equicord.model.User;

/**
 * Class responsible for having all database methods from UserTable
 * 
 * @author Gustavo <gustavotavaresdias@gmail.com>
 */
public class UserDAO extends ConnectionFactory{
	
	private static UserDAO instance;

	public static UserDAO getIntance() {
		if (instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}

	/**
	 * Method responsible for getting all users from DB
	 * 
	 * @return ArrayList<User> - List of Users
	 */
	public ArrayList<User> getUsers() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<User> userList = null;

		conn = createConnection();
		userList = new ArrayList<User>();

		try {
			pstmt = conn.prepareStatement("SELECT * FROM userTable ");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				User user = new User();

				user.setuID(rs.getInt("uID"));
				user.setuName(rs.getString("uName"));
				user.setuPhone(rs.getInt("uPhone"));
				user.setuAddress(rs.getString("uAddress"));
				user.setuPostcode(rs.getInt("uPostcode"));
				user.setuEmail(rs.getString("uEmail"));
				user.setuPasscode(rs.getInt("uPasscode"));
				user.setuGoogleID(rs.getString("uGoogleID"));
				
				userList.add(user);
			}
		} catch (Exception e) {
			System.out.println("Error when select USER:" + e);
			e.printStackTrace();
		} finally {
			closeConnection(conn, pstmt, rs);
		}

		return userList;
	}
	
	/**
	 * Method responsible for getting an user by ID from DB
	 * 
	 * @param userID - User ID
	 * @return User - User
	 */
	public User getUserById(int userID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = new User();

		conn = createConnection();

		try {
			pstmt = conn.prepareStatement("SELECT * FROM userTable WHERE uID = ?");
			pstmt.setInt(1, userID);
			
			rs = pstmt.executeQuery();

			user.setuID(userID);
			user.setuName(rs.getString("uName"));
			user.setuPhone(rs.getInt("uPhone"));
			user.setuAddress(rs.getString("uAddress"));
			user.setuPostcode(rs.getInt("uPostcode"));
			user.setuEmail(rs.getString("uEmail"));
			user.setuPasscode(rs.getInt("uPasscode"));
			user.setuGoogleID(rs.getString("uGoogleID"));
			
		} catch (Exception e) {
			System.out.println("Error when select USER BY ID:" + e);
			e.printStackTrace();
		} finally {
			closeConnection(conn, pstmt, rs);
		}

		return user;
	}

	/**
	 * Method responsible for add object User into the database
	 * 
	 * @param User - object user
	 * @return boolean - true or false
	 */
	public boolean addUser(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = createConnection();
		try {
			pstmt = conn.prepareStatement("INSERT INTO userTable VALUES (null,?,?,?,?,?,?,?)");

			pstmt.setString(1, user.getuName());
			pstmt.setInt(2, user.getuPhone());
			pstmt.setString(3, user.getuAddress());
			pstmt.setInt(4, user.getuPostcode());
			pstmt.setString(5, user.getuEmail());
			pstmt.setInt(6, user.getuPasscode());
			pstmt.setString(7, user.getuGoogleID());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error when try add new USER - " + e);
			e.printStackTrace();
			return false;
		} finally {
			closeConnection(conn, pstmt, rs);
		}
		return true;
	}

	/**
	 * Method responsible for update object User into the database
	 * 
	 * @param User - object user
	 * @return boolean - true or false
	 */
	public boolean updateUser(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = createConnection();
		try {
			pstmt = conn.prepareStatement("UPDATE userTable SET uName = ?, "
					+ "uPhone = ?, uAddress = ?, uPostcode = ?, uEmail = ?, uPasscode = ?, uGoogleID = ?"
					+ "WHERE uID = ?");

			pstmt.setString(1, user.getuName());
			pstmt.setInt(2, user.getuPhone());
			pstmt.setString(3, user.getuAddress());
			pstmt.setInt(4, user.getuPostcode());
			pstmt.setString(5, user.getuEmail());
			pstmt.setInt(6, user.getuPasscode());
			pstmt.setString(7, user.getuGoogleID());
			pstmt.setInt(8, user.getuID());

			pstmt.executeUpdate();			
		} catch (Exception e) {
			System.out.println("Error when try update USER - " + e);
			e.printStackTrace();
			return false;
		} finally {
			closeConnection(conn, pstmt, rs);
		}
		return true;
	}

	/**
	 * Method responsible for delete object user from the database
	 *
	 * @param int - idUser
	 * @return boolean - true or false
	 */
	public boolean deleteUser(int idUser) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = createConnection();
		try {
			pstmt = conn.prepareStatement("DELETE FROM userTable WHERE uID = ?");
			pstmt.setInt(1, idUser);			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error when try delete USER - " + e);
			e.printStackTrace();
			return false;
		} finally {
			closeConnection(conn, pstmt, rs);
		}
		return true;
	}
}
