package com.foodstore.serg.model;

import java.util.Objects;

public class User {
	
	private String login;
	private String password;
	private Role role;
	
	public User(String login, String password, Role role){
		this.login = login;
		this.password = password;
		this.role = role;
	}
	
	public String getLogin(){
		return login;
	}
	
	public String getPassword(){
		return password;
	}
	
	public Role getRole(){
		return role;
	}
	
	@Override
	public boolean equals(Object anotherUser){
		if(this == anotherUser) return true;
		if(anotherUser instanceof User){
			User other = (User)anotherUser;
			return (this.login.equals(other.getLogin()) 
					&& this.password.equals(other.password)
					&& this.role == other.getRole());
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(login, password, role);
	}
	

}
