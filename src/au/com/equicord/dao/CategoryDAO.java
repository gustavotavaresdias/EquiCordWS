package au.com.equicord.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import au.com.equicord.factory.ConnectionFactory;
import au.com.equicord.model.Category;

/**
 * Class responsible for having all database methods from CategoryTable
 * 
 * @author Gustavo <gustavotavaresdias@gmail.com>
 */
public class CategoryDAO extends ConnectionFactory{

	private static CategoryDAO instance;

	public static CategoryDAO getIntance() {
		if (instance == null) {
			instance = new CategoryDAO();
		}
		return instance;
	}

	/**
	 * Method responsible for getting all categories from DB
	 * 
	 * @return ArrayList<Category> - List of Categories
	 */
	public ArrayList<Category> getCategory() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Category> listCategory = null;

		conn = createConnection();
		listCategory = new ArrayList<Category>();

		try {
			pstmt = conn.prepareStatement("SELECT * FROM categoryTable");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Category category = new Category();

				category.setId(rs.getInt("categoryID"));
				category.setType(rs.getString("cType"));
				category.setDescription(rs.getString("cTypeDesc"));

				listCategory.add(category);
			}
		} catch (Exception e) {
			System.out.println("Error when select category:" + e);
			e.printStackTrace();
		} finally {
			closeConnection(conn, pstmt, rs);
		}

		return listCategory;
	}
}
