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


@WebFilter(filterName = "LoginFilter", servletNames = "LoginServlet")
public class LoginFilter implements Filter{
	
	public static final Logger LOGGER = LogManager.getLogger(LoginFilter.class);
	private static final String  EMAIL = "email";
	private static final String  PASSWORD = "password";
	private static final String REDIRECT_TO_LOG = "login.jsp";
	private static final String USER_ERROR = "You need to provide e-mail";
	private static final String PASSWORD_ERROR = "You need to provide password";
	
	private static final String PARAM_PASSWORD_ERROR = "pass_error";
	private static final String PARAM_MAIL = "mail";
	private static final String PARAM_USER_ERROR = "mail_error";
	private static final String PARAM_TYPE = "type";

private static final String TYPE_ERROR = "error";
	
	private FilterConfig filterConfig = null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String mail = request.getParameter(EMAIL);
		String password = request.getParameter(PASSWORD);
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		if (!httpRequest.getMethod().equalsIgnoreCase("POST")) {
			LOGGER.debug("GET method is ignored");
			chain.doFilter(request, response);
		}else {
			LOGGER.debug("Filtering POST request");
			if (mail == null || mail.isEmpty()) {
				LOGGER.warn("E-mail field is empty");
				httpRequest.setAttribute(PARAM_USER_ERROR, USER_ERROR);
				httpRequest.setAttribute(PARAM_TYPE, TYPE_ERROR);
				LOGGER.debug(REDIRECT_TO_LOG);
				httpRequest.getRequestDispatcher(REDIRECT_TO_LOG).forward(request, response);
			} else if (password == null || password.isEmpty()) {
				LOGGER.warn("Password field is empty");
				httpRequest.setAttribute(PARAM_PASSWORD_ERROR, PASSWORD_ERROR);
				httpRequest.setAttribute(PARAM_TYPE, TYPE_ERROR);
				LOGGER.debug( REDIRECT_TO_LOG);
				httpRequest.getRequestDispatcher(REDIRECT_TO_LOG).forward(request, response);
			} else {
				LOGGER.warn("Redirecting to LoginServlet to validate User");
				chain.doFilter(request, response);
}
}
		
	}

	
	
	@Override
	public void destroy() {
		filterConfig = null;
	}


}
