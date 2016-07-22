package au.com.equicord.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

import au.com.equicord.factory.ConnectionFactory;
import au.com.equicord.model.Horse;

/**
 * Class responsible for having all database methods from HorseTable
 * 
 * @author Gustavo <gustavotavaresdias@gmail.com>
 */
public class HorseDAO extends ConnectionFactory{

	private static HorseDAO instance;

	public static HorseDAO getIntance() {
		if (instance == null) {
			instance = new HorseDAO();
		}
		return instance;
	}
	
	/**
	 * Method responsible for getting all horses from DB
	 * 
	 * @return ArrayList<Horse> - List of Horses
	 */
	public ArrayList<Horse> getHorses() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Horse> horseList = null;

		conn = createConnection();
		horseList = new ArrayList<Horse>();

		try {
			pstmt = conn.prepareStatement("SELECT * FROM horseTable "
					+ "INNER JOIN eventType ON eventsTable.eTypeID = eventType.eTypeID");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Horse horse = new Horse();

				horse.sethID(rs.getInt("hID"));
				horse.sethName(rs.getString("hName"));
				horse.sethNickname(rs.getString("hNickname"));
				horse.sethSire(rs.getString("hSire"));
				horse.sethBreed(rs.getString("hBreed"));
				horse.sethColour(rs.getString("hColour"));
				horse.sethDOB(rs.getDate("hDOB"));
				horse.sethSex(rs.getString("hSex"));
				horse.sethHeight(rs.getFloat("hHeight"));
				horse.sethMarksScars(rs.getString("hMarksScars"));
				horse.sethPicture(rs.getString("hPicture"));
				horse.sethMicrochip(rs.getString("hMicrochip"));
				horse.sethDietary(rs.getString("hDietary"));
				
				horseList.add(horse);
			}
		} catch (Exception e) {
			System.out.println("Error when select HORSES:" + e);
			e.printStackTrace();
		} finally {
			closeConnection(conn, pstmt, rs);
		}

		return horseList;
	}

	/**
	 * Method responsible for add object Horse into the database
	 * 
	 * @param Horse - object horse
	 * @return boolean - true or false
	 */
	public boolean addHorse(Horse horse) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = createConnection();
		try {
			pstmt = conn.prepareStatement("INSERT INTO horseTable VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			pstmt.setString(1, horse.gethName());
			pstmt.setString(2, horse.gethNickname());
			pstmt.setString(3, horse.gethDame());
			pstmt.setString(4, horse.gethSire());
			pstmt.setString(5, horse.gethBreed());
			pstmt.setString(6, horse.gethColour());
			pstmt.setDate(7, new Date(horse.gethDOB().getTime()));
			pstmt.setString(8, horse.gethSex());
			pstmt.setFloat(9, horse.gethHeight());
			pstmt.setString(10, horse.gethMarksScars());
			pstmt.setString(11, horse.gethPicture());
			pstmt.setString(12, horse.gethMicrochip());
			pstmt.setString(13, horse.gethDietary());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error when try add new HORSE - " + e);
			e.printStackTrace();
			return false;
		} finally {
			closeConnection(conn, pstmt, rs);
		}
		return true;
	}

	/**
	 * Method responsible for update object horse into the database
	 * 
	 * @param Horse - object horse
	 * @return boolean - true or false
	 */
	public boolean updateHorse(Horse horse) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = createConnection();
		try {
			pstmt = conn.prepareStatement("UPDATE horseTable SET hName = ?, "
					+ "hNickname = ?, hDame = ?, hSire = ?, hBreed = ?, hColour = ?, hDOB = ?, hSex = ?, hHeight = ?, hMarksScars = ?"
					+ "hPicture = ?, hMicrochip = ?, hDietary = ?"
					+ "WHERE hID = ?");

			pstmt.setString(1, horse.gethName());
			pstmt.setString(2, horse.gethNickname());
			pstmt.setString(3, horse.gethDame());
			pstmt.setString(4, horse.gethSire());
			pstmt.setString(5, horse.gethBreed());
			pstmt.setString(6, horse.gethColour());
			pstmt.setDate(7, new Date(horse.gethDOB().getTime()));
			pstmt.setString(8, horse.gethSex());
			pstmt.setFloat(9, horse.gethHeight());
			pstmt.setString(10, horse.gethMarksScars());
			pstmt.setString(11, horse.gethPicture());
			pstmt.setString(12, horse.gethMicrochip());
			pstmt.setString(13, horse.gethDietary());
			pstmt.setInt(14, horse.gethID());

			pstmt.executeUpdate();			
		} catch (Exception e) {
			System.out.println("Error when try update HORSE - " + e);
			e.printStackTrace();
			return false;
		} finally {
			closeConnection(conn, pstmt, rs);
		}
		return true;
	}

	/**
	 * Method responsible for delete object horse from the database
	 *
	 * @param int - idHorse
	 * @return boolean - true or false
	 */
	public boolean deleteHorse(int idHorse) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = createConnection();
		try {
			pstmt = conn.prepareStatement("DELETE FROM horseTable WHERE hID = ?");
			pstmt.setInt(1, idHorse);			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error when try delete HORSE - " + e);
			e.printStackTrace();
			return false;
		} finally {
			closeConnection(conn, pstmt, rs);
		}
		return true;
	}
}
