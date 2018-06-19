package com.pluralsights.demos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LargeServletPage
 */
@WebServlet("/LargeServletPage")
public class LargeServletPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LargeServletPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out;
		
		/*if(GzipUtility.isGzipSupported(request) && GzipUtility.isGzipDisabled(request))
		{
			out = GzipUtility.getGzipWriter(response);
			response.setHeader("Content-Coding", "gzip");
		}
		
		else {out = response.getWriter();}
		*/
		out = response.getWriter();
		
		String dummyLine = "Lorem Ipsum is a dummy text of printing and typesetting industry";
		out.println("<!Doctype HTML>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Demo: Request Headers</title>");
		out.println("</head>");
		out.println("<body>");
		
		for (int i = 0;  i < 10000; i++)
		{
			out.println(dummyLine + "</br>");
		}
		out.println("</body>");
		out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
