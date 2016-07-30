package com.foodstore.serg.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.foodstore.serg.model.Meal;
import com.foodstore.serg.model.User;

public class UserRepository implements UserDAO{
	
	public static final Logger LOGGER = Logger.getLogger(UserRepository.class.getSimpleName());
	private static List<User> users = new ArrayList<>();

	@Override
	public boolean add(User user) {
		boolean res;
		try{
			 res = users.add(user);
			 if(res){
				 LOGGER.info("User was added to DB"); 
				 return true;
			 }
			 LOGGER.info("User was not added to DB"); 
			 return false;
		}catch(Exception e){
			LOGGER.error("Exception by adding user to DB");
			e.printStackTrace();
		}
		LOGGER.info("User was not added to DB"); 
		return false;
	}
	
	@Override
	public User findUser(User anotherUser) {
		LOGGER.info("Search User in DB");
		for(User user: users){
			if(user.equals(anotherUser)){
				LOGGER.info("User was found");
				return user;
			}
		}
		LOGGER.info("User wasn`t found");
		return null;
	}
	
}
