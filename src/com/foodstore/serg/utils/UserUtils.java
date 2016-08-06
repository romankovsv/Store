package com.foodstore.serg.utils;

import org.apache.log4j.Logger;

import com.foodstore.serg.model.Meal;
import com.foodstore.serg.model.User;

public class UserUtils {
	
	public static final Logger LOGGER = Logger.getLogger(UserUtils.class.getSimpleName());
	
	public static User createUser(String email, String password, String passwordConformation){
		
		User user = null;
		
		if(passwordConformationIsEdentiqal(password, passwordConformation) 
				&& checkUserParams(email, password, passwordConformation) ){
			LOGGER.debug("Verifying parameters for user creation");
			return (user = new User(email, password));
		}
		
		return user;
	}
	
	private static boolean passwordConformationIsEdentiqal(String password, String passwordConformation){
	
		return password.equals(passwordConformation);
	}
	
	private static boolean checkUserParams(String email, String password, String passwordConformation){
		
		return !(email.isEmpty() || email == null || password.isEmpty() || password == null ||
				passwordConformation.isEmpty() || passwordConformation == null);
	}
}
