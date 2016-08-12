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
		boolean result = password.equals(passwordConformation);
		if(result){
			LOGGER.debug("password and conformation are equals");
		}else{
			LOGGER.debug("password and conformation are different");
		}
		return result;
	}
	
	private static boolean checkUserParams(String email, String password, String passwordConformation){
		
		boolean result = !(email.isEmpty() || email == null || password.isEmpty() || password == null ||
				passwordConformation.isEmpty() || passwordConformation == null);
		
		if(result){
			LOGGER.debug("email or password is not empty or null");
		
		}else{
			LOGGER.debug("email and/or password is empty or null");
			
		}
		
		return result;
	}
}
