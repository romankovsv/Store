package com.foodstore.serg.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.foodstore.serg.dao.ListUserDAOImpl;
import com.foodstore.serg.dao.UserDAO;
import com.foodstore.serg.dao.UserRepository;
import com.foodstore.serg.model.User;
import com.foodstore.serg.service.UserService;
import com.foodstore.serg.utils.UserUtils;

@WebServlet(name = "/RegistrationServlet", urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public static final Logger LOGGER = Logger.getLogger(RegistrationServlet.class.getSimpleName());
	
	private static final String REGISTRATION = "registration.jsp";
	private static final String EMAIL = "email";
	private static final String PASSWORD = "password";
	private static final String PASSWORD_CONFORMATION = "passwordConform";
	
	private static final String SUCCESS = "User was successfully registered";
	private static final String SUCCESS_MESSAGE = "success_message";
	private static final String UNSUCCESS_MESSAGE =  "message";
	private static final String TYPE = "type";
	 private static final String TYPE_ERROR = "Some error, check your input";
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LOGGER.debug("GET request redirected to "+REGISTRATION);
		request.getRequestDispatcher(REGISTRATION).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LOGGER.debug("Filtering POST request");
		LOGGER.debug("Creating new user");
		
		User user = UserUtils.createUser(request.getParameter(EMAIL), request.getParameter(PASSWORD),
				request.getParameter(PASSWORD_CONFORMATION));
		
		if(user != null && UserService.add(user)){
		
			LOGGER.debug("New user successfully registered");
			request.setAttribute(SUCCESS_MESSAGE, SUCCESS);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}else{
		
			LOGGER.debug("Could not register new user");
			request.setAttribute(UNSUCCESS_MESSAGE, TYPE_ERROR);
			getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
			//request.getRequestDispatcher("").forward(request, response);
		}
	}
}
