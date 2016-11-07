package au.com.equicord.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Class responsible for having methods for open and close database connection
 * 
 * @author Gustavo <gustavotavaresdias@gmail.com>
 */
public class ConnectionFactory {

	// Path for Database
	private final String DRIVER = "com.mysql.jdbc.Driver";
	/*LocalHost Connection*/
//	private final String URL = "jdbc:mysql://localhost:3306/equicord_base_crud";
//	private final String USER = "root";
//	private final String PASS = "root";
	
	/*Web Server Connection*/
	private final String URL = "jdbc:mysql://223.27.22.119:3306/equicord_base_crud";
	private final String USER = "test_root";
	private final String PASS = "root123";
	
	/**
	 * Method responsible for creating database connection
	 * 
	 * @return
	 * @author Gustavo <gustavotavaresdias@gmail.com>
	 */
	public Connection createConnection() {

		Connection connection = null;

		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASS);

		} catch (Exception e) {
			System.out.println("Error when opening the connection database: "
					+ URL);
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * Method responsible for close database connection
	 * 
	 * @param connection
	 * @param pstmt
	 * @param rs
	 * 
	 * @author Gustavo <gustavotavaresdias@gmail.com>
	 */
	public void closeConnection(Connection connection, PreparedStatement pstmt,
			ResultSet rs) {

		try {
			if (connection != null) {
				connection.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}

		} catch (Exception e) {
			System.out.println("Error when closing the connection database: "
					+ URL);
			e.printStackTrace();
		}
	}

}