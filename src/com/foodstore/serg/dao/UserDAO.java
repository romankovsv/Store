package com.foodstore.serg.dao;

import com.foodstore.serg.model.User;

public interface UserDAO {
	
	boolean addUser(User user);
	
	User getUser(long id);
	
	boolean update(long id, User user);
	
	boolean remove(long id);
	
}
