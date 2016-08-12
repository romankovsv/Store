package com.foodstore.serg.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.*;

import com.foodstore.serg.model.Meal;
import com.foodstore.serg.service.MealService;
import static com.foodstore.serg.constants.ServletConstants.*;
import static  org.apache.log4j.Logger.*;


@WebServlet(name = "DisplayAllMealServlet", urlPatterns = "/display")
public class DisplayAllMealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger LOGGER = LogManager.getLogger(DisplayAllMealServlet.class.getSimpleName());
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LOGGER.debug("GET request");
		LOGGER.debug("Go to doPost");
		doPost(request,response);//Использован doPost() т.к. в нем выбираются данные для meals
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType(CONTENT_TYPE);
		
		List<Meal> meals = MealService.getAll();
		
		if(meals.isEmpty()){
			LOGGER.debug("No products");
			request.setAttribute(SUCCESS_MESSAGE, NO_PRODUCT);
		}else{
			LOGGER.debug("Get all products");
			request.setAttribute(SUCCESS_MESSAGE, LIST_OF_MEALS);
			request.setAttribute(FOOD, meals);
		}
		LOGGER.debug("Forwarding request to dashboard.jsp");
		getServletContext().getRequestDispatcher("/dashboard.jsp").forward(request, response);
	}

}
