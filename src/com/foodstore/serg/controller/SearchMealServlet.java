package com.foodstore.serg.controller;

import java.io.IOException;
import static com.foodstore.serg.constants.ServletConstants.*;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodstore.serg.model.Meal;
import com.foodstore.serg.service.MealService;
import org.apache.log4j.*;
import static  org.apache.log4j.Logger.*;

@WebServlet(name = "SearchMealServlet", urlPatterns = "/search")
public class SearchMealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger LOGGER = Logger.getLogger(SearchMealServlet.class.getSimpleName());
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.debug("GET request");
		LOGGER.debug("Go to doPost");
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.debug("POST request");
		PrintWriter out = response.getWriter();
		response.setContentType(CONTENT_TYPE);
		
		final String search = request.getParameter(SEARCH);
		
		if(search == null ||search.isEmpty()){
			LOGGER.info("Search parameter is empty");
			request.setAttribute(MESSAGE, SEARCH_IS_EMPTY);
		}else{	
			List<Meal> resultList = MealService.search(search);
			request.setAttribute(FOOD, resultList);
		
			if(resultList.isEmpty()){
				LOGGER.info("Meal wasn`t found");
				request.setAttribute(MESSAGE, NO_SUCH_MEAL);
			}else{
				LOGGER.info("Meal was found successfully");
				request.setAttribute(SUCCESS_MESSAGE, FOUND_MEAL);
			}
		}
		LOGGER.debug("Forwarding request to dashboard.jsp");
		getServletContext().getRequestDispatcher("/dashboard.jsp").forward(request, response);
	}

}
