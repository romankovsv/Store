package com.foodstore.serg.service;

import com.foodstore.serg.dao.ListUserDAOImpl;
import com.foodstore.serg.dao.UserDAO;
import com.foodstore.serg.model.User;

public class UserService {
	
	private static UserDAO userDAO = new ListUserDAOImpl();
	
	public static boolean add(User user){
		return userDAO.addUser(user);
	}
	/*
	 * private static UserDAO userDao = new UserToListDAOimpl();

	public static boolean add(User user) {

		return userDao.add(user);
	}

	public static boolean findUser(String mail, String password) {

		return userDao.findUser(mail, password);

	}

	public static int getUserId(String mail) {

		return userDao.getUserId(mail);

}
	 */
}
