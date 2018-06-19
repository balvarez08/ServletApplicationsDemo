package com.pluralsight.demos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Preview
 */
@WebServlet("/Preview")
public class Preview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Preview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String guestName = request.getParameter("guestName");
		String email = request.getParameter("email");
		
	    response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Preview</title></head>");
		out.println("<body><h3>Confirm Information</h3>");
	
		out.println("<div>Guest Name: " + guestName + "</div>");
		out.println("<div>Email: " + email + "</div>");
		out.println("<form name='frm' action='SaveData' method='post'>");
		out.println("<input type='hidden' name='guestName' value='" + guestName + "'/>");
		out.println("<input type='hidden' name='email' value='" + email + "'/>");
		out.println("<div><input type='submit' value='Save Data' name='btnSave'/></div>");
		out.println("</body></html>");
	}

}
