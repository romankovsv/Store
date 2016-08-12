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
public class MailFilter implements Filter{
	
	public static final Logger LOGGER = LogManager.getLogger(MailFilter.class);
	
	private static final String MAIL = "mail";
	
	private FilterConfig filterConfig = null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		if( ! httpRequest.getMethod().equalsIgnoreCase("POST")){
			
			chain.doFilter(request, response); 
		}else{
			String email = request.getParameter(MAIL);
			
			if(Validator.validateEmail(email)){
				chain.doFilter(request, response);
				LOGGER.debug(String.format("Email for registration is correct: ServletPath = %s",
						httpRequest.getServletPath()));
				LOGGER.debug("Request recieved from: " +httpRequest.getRemoteHost()+
						" for: "+httpRequest.getRequestURL());
				
			}
		}
		
		
	}

	
	
	@Override
	public void destroy() {
		filterConfig = null;
	}


}
