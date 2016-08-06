package com.foodstore.serg.model;

import java.util.Objects;

public class User {
	
	private String email;
	private String password;
	
	public User(String email, String password){
		this.email = email;
		this.password = password;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getPassword(){
		return password;
	}
	
	@Override
	public boolean equals(Object anotherUser){
		if(this == anotherUser) return true;
		
		if(anotherUser instanceof User){
			User other = (User)anotherUser;
			
			return 	Objects.equals(email, other.getEmail())
					&& Objects.equals(password, other.getPassword());
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(email, password);
	}
	

}
