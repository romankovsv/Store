package com.foodstore.serg.service;

import java.util.List;

import com.foodstore.serg.dao.MealRepository;
import com.foodstore.serg.model.Meal;

public class MealService {
	
	
	public static boolean add(Meal meal){
		return MealRepository.add(meal);
	}
	
	public static List<Meal> getAll(){
		return MealRepository.getAll();
	}
	
	public static boolean remove(long id){
		return MealRepository.remove(id);
	}
	
	
	public static List<Meal> search(String searchedField){
		return MealRepository.search(searchedField);
	}
		
}
