package com.pluralsight.demos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.util.Date;
/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("destroy method called " + this.getClass().getName());
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter method called " + this.getClass().getName());
		String username = request.getParameter("username");
		String password = request.getParameter("pswd");
		String ipAddress = request.getRemoteAddr();
		
		if (username.equals("test") && password.equals("test"))
		{
			System.out.println("User logged in at " + ipAddress + "at this time " + new Date().toString());
			chain.doFilter(request, response);
		}
		else {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<h3>Sorry Can't Access Site</h3>");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init method called " + this.getClass().getName());
	}

}
