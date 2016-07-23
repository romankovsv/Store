package com.foodstore.serg.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodstore.serg.model.Meal;
import com.foodstore.serg.service.MealService;
import static com.foodstore.serg.constants.ServletConstants.*;
import org.apache.log4j.*;
import static  org.apache.log4j.Logger.*;

@WebServlet(name = "RemoveMealServlet", urlPatterns = "/remove")
public class RemoveMealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger LOGGER = Logger.getLogger(RemoveMealServlet.class.getSimpleName());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.debug("GET request");
		LOGGER.debug("GET request redirected to dashboard.jsp");
		response.sendRedirect("dashboard.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.debug("POST request");
		PrintWriter out = response.getWriter();
		response.setContentType(CONTENT_TYPE);
		
		try{	
			long idForRemoving = Long.parseLong(request.getParameter(ID));
			LOGGER.debug("Parsing given parameter to integer");
			
			if(MealService.remove(idForRemoving)){
				LOGGER.info("Meal was deleted");
				request.setAttribute(TITLE, request.getParameter("title"));
				request.setAttribute(SUCCESS_REMOVE, SUCCESS_DELETE);
				
			}else{
				LOGGER.info("Meal was deleted");
				request.setAttribute(UNSUCCESS_REMOVE, NOT_DELETED);
			}
		}catch(NumberFormatException e){
			LOGGER.error("Wrong parameter",e);
			request.setAttribute(UNSUCCESS_REMOVE,INCORRECT_INPUT);
		}catch(Exception e){
			LOGGER.error("Wrong parameter",e);
			request.setAttribute(UNSUCCESS_REMOVE, EXCEPTION);
		}
		LOGGER.debug("Forwarding request to display");
		getServletContext().getRequestDispatcher("/display").forward(request, response);
	}

}
