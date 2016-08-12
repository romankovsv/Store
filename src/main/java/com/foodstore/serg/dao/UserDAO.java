package com.foodstore.serg.dao;

import com.foodstore.serg.model.User;

public interface UserDAO {
	
	boolean addUser(User user);
	
	User getUser(long id);
	
	boolean updateUser(long id, User user);
	
	boolean removeUser(long id);
	
}
