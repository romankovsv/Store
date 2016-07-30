package com.foodstore.serg.dao;

import com.foodstore.serg.model.User;

public interface UserDAO {
	
	public boolean add(User user);
	public User findUser();
}
