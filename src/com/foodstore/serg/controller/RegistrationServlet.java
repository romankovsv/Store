package com.foodstore.serg.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.foodstore.serg.model.User;
import com.foodstore.serg.utils.UserUtils;

@WebServlet(name = "/RegistrationServlet", urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public static final Logger LOGGER = Logger.getLogger(RegistrationServlet.class.getSimpleName());
	
	private static final String REGISTRATION = "registration.jsp";
	private static final String EMAIL = "email";
	private static final String PASSWORD = "password";
	private static final String PASSWORD_CONFORMATION = "passwordConform";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LOGGER.debug("GET request redirected to "+REGISTRATION);
		response.sendRedirect(REGISTRATION);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		
		LOGGER.debug("Filtering POST request");
		
		LOGGER.debug("Creating new user");
		
		User user = UserUtils.createUser(request.getParameter(EMAIL), request.getParameter(PASSWORD),
				request.getParameter(PASSWORD_CONFORMATION));
		
		
		/*
		 * User newUser = UserUtil.createUser(request.getParameter(PARAM_MAIL), request.getParameter(PARAM_PASS),
				request.getParameter(PARAM_CONF_PASS));

		if (UserService.add(newUser)) {

			LOG.debug("New user successfully registered");
			message = SUCCESS;
			type = TYPE_SUCCESS;

		} else {

			LOG.warn("Could not register new user");
			message = DATABASE_ERROR;
			type = TYPE_ERROR;
		}

		LOG.debug("Forwarding request to {}", REDIRECT_TO_HOME);
		request.setAttribute(MESSAGE, message);
		request.setAttribute(TYPE, type);
request.getRequestDispatcher(REDIRECT_TO_HOME).forward(request, response);
		 */
	}

}
