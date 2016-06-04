package au.com.equicord.controller;

import java.util.ArrayList;

import au.com.equicord.dao.CategoryDAO;
import au.com.equicord.model.Category;

/**
 * Class responsible for being the controller between resource class and DAO
 * class.
 * 
 * @author Gustavo <gustavotavaresdias@gmail.com>
 */
public class CategoryController {
	
	public ArrayList<Category> getCategory(){
		return CategoryDAO.getIntance().getCategory();
	}

	
}
