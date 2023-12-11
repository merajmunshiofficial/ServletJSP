// SquareServlet is called by AddSqReqDispatcher servlet for processing the square of the sum of numbers sent by it by Request object
// SquareServlet is called by AddSqsendRedirect servlet for processing the square of the numbers sent by it by Response object


package com.pcsglobal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SquareServlet extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//int result = 0;
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		// Data send by sendRedirect needs to be captured using request getParameter (* req.getAttribute is wrong)
		// RequestDispatcher or sendRedirect::
		
		// URL re-writing:: we have to process the request data passed by the request url from sendRedirect method of response object
		// ----------------
		// int result =  Integer.parseInt(req.getParameter("sum"));  // getParameter for sendRedirect 
		
		// Session:: we have to process the request data passed by the session, 
		// --------- when working with multiple servlets over a single session, using sendRedirect and not RequestDispatcher
		/*
		HttpSession session = req.getSession();   // get hold of the session object
		int result = (int) session.getAttribute("sum");   // we are converting the object to int by typecasting 
		*/
		
		// Cookie:: we have to process the request data passed by the cookie
		// -------- when working with multiple servlets, using sendRedirect and not RequestDispatcher
		///*
		int result = 0;
		Cookie cookies[] = req.getCookies();
		
		for (Cookie c : cookies)  // enhanced for loop
		{
			if (c.getName().equals("sum")) {
				result = Integer.parseInt(c.getValue());  // convert string to int
				//System.out.println("sum = "+result);
			}
		}
		//*/
		
		/*
		* Accept the cookie. It is getCookies because there can be lot many cookies sent by client request
		* It is a request object because the technique is sendRedirect servlet call which sends the response
		* to the client and the client requests the calling servlet with the Cookie data
		* Application server gives all the Cookies it has and it is now the servlet that needs to pick up the desired cookie 
		* enhanced for loop iterates through the cookies array 
		*/
		
		// Square the sum
		result = result * result;
		
		PrintWriter out = res.getWriter();
		out.println("Square is: " +result);
		// out.println("From getAttribute: " );
		// out.println("From Session: " );
		out.println("From Cookie: " );
		
		// to remove the data from the session
		/*
		 * session.removeAttribute("sum");
		 */
	}
}