package com.pluralsight.demos;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Step2
 */
@WebServlet("/Step2")
public class Step2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Step2() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String guestName = request.getParameter("guestName");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Greetings</title></head>");
		out.println("<body><h3>Welcome " + guestName + "</h3>");
		out.println("<form name='frm' action='Preview' method='post'>");
		out.println("<input type='hidden' name='guestName' value='" + guestName + "'/>");
		out.println("<p>Enter Email Id: </p>");
		out.println("<input type='email' name='email' />");
		out.println("<input type='submit' value='Preview' name='btnPreview' /></form></body></html>");
		
	}

}