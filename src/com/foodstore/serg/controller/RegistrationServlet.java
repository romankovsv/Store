package com.foodstore.serg.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet(name = "/RegistrationServlet", urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public static final Logger LOGGER = Logger.getLogger(RegistrationServlet.class.getSimpleName());
	
	private static final String REGISTRATION = "registration.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LOGGER.debug("GET request redirected to "+REGISTRATION);
		response.sendRedirect(REGISTRATION);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		
		LOGGER.debug("Filtering POST request");
		
		LOGGER.debug("Creating new user");
	}

}
