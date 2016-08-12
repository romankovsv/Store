package com.foodstore.serg.service;

import com.foodstore.serg.dao.ListUserDAOImpl;
import com.foodstore.serg.dao.UserDAO;
import com.foodstore.serg.model.User;

public class UserService {
	
	private static UserDAO userDAO = new ListUserDAOImpl();
	
	public static boolean add(User user){
		return userDAO.addUser(user);
	}
	
	public static User get(long id){
		return userDAO.getUser(id);
	}
}
