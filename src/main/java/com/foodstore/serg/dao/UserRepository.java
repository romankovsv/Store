package com.foodstore.serg.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.foodstore.serg.model.Meal;
import com.foodstore.serg.model.User;

public class UserRepository{
	
	public static final Logger LOGGER = Logger.getLogger(UserRepository.class.getSimpleName());
	
	private static List<User> users = new ArrayList<>();
	
	public static List<User> getUsers(){
		return users;
	}
	

	
}
