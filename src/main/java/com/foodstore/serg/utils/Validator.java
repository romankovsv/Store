package com.foodstore.serg.utils;
import java.util.regex.*;

public class Validator {
	
	
	/**
	 * Validates followings:
	 * first part of email before @ can be 4 to 31 length, can contain
	 * numbers and letters and also . (dot) and _ (underscore)
	 * Part after @ can be at least 1 character long and first character
	 * must be a letter. If in this part there are more symbols than one first one should be 
	 * letter
	 * Part after . can be either 2 or 3 characters long
	 * @param emailToCheck string contains email field
	 * @return boolean emailToCheck passed the validation or not
	 */
	public static boolean validateEmail(String emailToCheck){
		
		final String MAIL_PATTERN = "^[A-Za-z0-9\\._]{4,31}+@[A-Za-z]{1}+[A-Za-z0-9]{0,}\\.[A-Za-z]{2,3}$";
		
		Pattern pattern = Pattern.compile(MAIL_PATTERN);
		Matcher matcher = pattern.matcher(emailToCheck);
		
		return matcher.matches();
	}
	
	/**
	 * Validates password to contain any character and to be 
	 * from 5 through 25 characters length
	 * @param passwordToCheck string contains password field
	 * @return boolean passwordToCheck passed the validation or not
	 */
	public static boolean validatePassword(String passwordToCheck){
		
		final String PASSWORD_PATTERN = "^.{5,25}$";
		
		Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
		Matcher matcher = pattern.matcher(passwordToCheck);
		
		return matcher.matches();
	}
}
