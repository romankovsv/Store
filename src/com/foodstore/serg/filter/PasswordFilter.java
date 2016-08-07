package com.foodstore.serg.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.foodstore.serg.utils.Validator;

@WebFilter(filterName = "MailFilter", servletNames = "RegistrationServlet")
public class PasswordFilter implements Filter {

	public static final Logger LOGGER = LogManager.getLogger(PasswordFilter.class);

	private FilterConfig filterConfig = null;

	private static final String PASSWORD = "password";
	private static final String PASSWORD_CONFORMATION = "password-conformation";
	private static final String ERROR_PASSWORD = "pass_error";
	private static final String WRONG_PASSWORD = "Wrong password!";
	private static final String REDIRECT_TO_REG = "Forwarding back to registration.jsp";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;

		if (!httpRequest.getMethod().equalsIgnoreCase("POST")) {
			chain.doFilter(request, response);
		} else {

			LOGGER.debug("Registration POST request. Filtering passwords");
			final String password = request.getParameter(PASSWORD);
			final String passwordConformation = request.getParameter(PASSWORD_CONFORMATION);

			if (Validator.validatePassword(password) && Validator.validatePassword(passwordConformation)
					&& password.equals(passwordConformation)) {

				LOGGER.debug("Password is correct");
				LOGGER.debug("Request recieved from: " + httpRequest.getRemoteHost() + " for: "
						+ httpRequest.getRequestURL());
				chain.doFilter(request, response);
			} else {
				LOGGER.debug("Password is incorrect or conformation doesn`t match");
				LOGGER.debug("Request recieved from: " + httpRequest.getRemoteHost() + " for: "
						+ httpRequest.getRequestURL());

				request.setAttribute(ERROR_PASSWORD, WRONG_PASSWORD);
				LOGGER.debug(REDIRECT_TO_REG);
				request.getRequestDispatcher("registration.jsp").forward(request, response);
			}

		}
	}

	@Override
	public void destroy() {
		filterConfig = null;

	}
}
