package com.login;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Hriday Dubey
 */
public class Authentication implements Filter {

	/**
	 * Checks if user is logged in. If not it redirects to the login.jsf page.
     * @param request
     * @param response
     * @param chain
     * @throws java.io.IOException
     * @throws javax.servlet.ServletException
	 */
    
        @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Get the loginBean from session attribute
		Login loginBean = (Login)((HttpServletRequest)request).getSession().getAttribute("login");
		
		// For the first application request there is no loginBean in the session so user needs to log in
		// For other requests loginBean is present but we need to check if user has logged in successfully
		if (loginBean.isLoggedIn()&&loginBean.getDbrole().equals("u")) {
			String contextPath = ((HttpServletRequest)request).getContextPath();
			((HttpServletResponse)response).sendRedirect(contextPath + "/user/Welcome.jsf");
		}
		
		chain.doFilter(request, response);
			
	}

        @Override
	public void init(FilterConfig config) throws ServletException {
		// Nothing to do here!
	}

        @Override
	public void destroy() {
		// Nothing to do here!
	}	
	
}
