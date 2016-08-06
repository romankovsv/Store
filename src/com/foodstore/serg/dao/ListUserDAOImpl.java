package com.foodstore.serg.dao;

import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import com.foodstore.serg.model.Meal;
import com.foodstore.serg.model.User;

public class ListUserDAOImpl implements UserDAO {

	public static final Logger LOGGER = Logger.getLogger(UserRepository.class.getSimpleName());

	private static List<User> users = UserRepository.getUsers();
	
	public static List<User> getlistOfUsers(){
		return users;
	}

	@Override
	public boolean addUser(User user) {
		try {
			if (users.contains(user)) {
				LOGGER.info("DB already contains user with such credentials");
				return false;
			}
			LOGGER.info("Add User to DB");
			return users.add(user);
		} catch (Exception e) {
			LOGGER.error("Exception by adding user to DB");
			e.printStackTrace();
		}
		LOGGER.info("User was not added to DB");
		return false;
	}

	@Override
	public User getUser(long id) {
		LOGGER.info("Search User in DB");
		for (User user : users) {
			if (user.getID() == id) {
				LOGGER.info("User was found");
				return user;
			}
		}
		LOGGER.info("User wasn`t found");
		return null;
	}

	@Override
	public boolean update(long id, User userToUpdate) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getID() == id) {
				users.set(i, userToUpdate);
				LOGGER.info(String.format("User with ID:%s was updated", id));
				return true;
			}
		}
		LOGGER.info(String.format("User with ID:%s wasn`t updated", id));
		return false;
	}
	
	@Override
	public boolean remove(long id) {
		Iterator<User> iter = users.iterator();
		while (iter.hasNext()) {
			User user = iter.next();
			if (user.getID() == id) {
				iter.remove();
				LOGGER.info(user + " was removed");
				return true;
			}
		}
		LOGGER.info("User wasn`t removed");
		return false;
	}
	

}
