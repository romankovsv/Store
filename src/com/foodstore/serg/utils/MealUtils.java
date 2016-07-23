package com.foodstore.serg.utils;

import com.foodstore.serg.controller.SearchMealServlet;
import com.foodstore.serg.model.Meal;
import org.apache.log4j.*;
import static  org.apache.log4j.Logger.*;

public class MealUtils {
	
	public static final Logger LOGGER = Logger.getLogger(MealUtils.class.getSimpleName());
	
	private static boolean checkParams(String title, String description, String type, 
			Boolean available, String price, String owner){
		
		LOGGER.debug("Verifying parameters for meal creation");
		return !(title == null || title.isEmpty() || description == null || description.isEmpty()||
				type == null ||type.isEmpty() ||owner == null ||owner.isEmpty() || available == null ||
				price ==  null || price.isEmpty());
	}
	
	public static Meal create(String title, String description, String type, 
			boolean available, String price, String owner){
		
		Meal meal = null;
		
		if(checkParams(title, description, type, available, price, owner)){
			LOGGER.info("Parameters are correct Create new Meal");
				meal = new Meal.MealBuilder()
						.id()
						.title(title)
						.type(type)
						.description(description)
						.available(available)
						.price(price)
						.owner(owner)
						.build();
		}
		return meal;
	}
	
}
