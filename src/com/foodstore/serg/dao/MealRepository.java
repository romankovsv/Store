package com.foodstore.serg.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.foodstore.serg.controller.SearchMealServlet;
import com.foodstore.serg.model.Meal;
import org.apache.log4j.*;

public class MealRepository {
	public static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(MealRepository.class.getSimpleName());
	private static List<Meal> listOfMeals = new ArrayList<>();
	
	public static boolean add(final Meal meal){
		LOGGER.info(meal.getTitle()+" was added");
		return listOfMeals.add(meal);
	}
	
	public static boolean remove(final long id){
		Iterator<Meal> iter = listOfMeals.iterator();
		while(iter.hasNext()){
			Meal meal = iter.next();
			if(meal.getId() == id){
				iter.remove();
				LOGGER.info(meal.getTitle()+" was removed");
				return true;
			}
		}
		LOGGER.info("Meal wasn`t removed");
		return false;
	}
		
	
	public static List<Meal> getAll() {
		LOGGER.info("Get all Meals");
		return listOfMeals;
	}
	
	public static Meal getMealById(final long id){
		for(Meal meal : listOfMeals){
			if(meal.getId() == id){
				LOGGER.info("Get Meal:"+meal.getTitle());
				return meal;
			}
		}
		LOGGER.info("No Meal with such id:"+id);
		return null;
	}
	
	public static List<Meal> search(final String searchedField){
		
		List<Meal> resultOfSearch = new ArrayList<>();
		LOGGER.info("Searching meal");
		
		for(Meal meal: listOfMeals){
			if(searchedField.equalsIgnoreCase(meal.getTitle()) || 
					searchedField.equalsIgnoreCase(meal.getDescription()) || 
					searchedField.equalsIgnoreCase(meal.getOwner())||
					searchedField.equalsIgnoreCase(meal.getType()) ||
					searchedField.equalsIgnoreCase(String.valueOf(meal.getId()))||
					searchedField.equalsIgnoreCase(String.valueOf(meal.getPrice())) || 
					searchedField.equalsIgnoreCase(String.valueOf(meal.isAvailable()))) {
				
				resultOfSearch.add(meal);
			}
		}
		LOGGER.info("Number of found Meal(s):"+resultOfSearch.size());
		return resultOfSearch;
	}
}
