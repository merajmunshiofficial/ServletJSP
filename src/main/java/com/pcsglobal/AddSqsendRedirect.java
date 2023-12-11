// sendRedirect servlet to servlet call hosted in different server

package com.pcsglobal;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class AddSqsendRedirect extends HttpServlet 
{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
	{
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));

		int sum = i + j;
		
		// This processing of servlet calling another servlet residing in a separate domain happens in 2 legs
		// servlet sending the response to browser to ask it to redirect 
		// the request to another servlet hosted in a different server
		
		// res.sendRedirect("square");  // Cannot call sendRedirect() after the response has been committed, therefore we comment this
		/*
		 * First step:
		 * here the SquareServlet is called but without any parameters from request object 
		 * This will throw nullpointer exception as the servlet is called without parameter being passed
		 * But in the url if we add query string like /square?sum=9 then in browser client it returns "Square is: 81" 
		 * Second step: adding the query string in the parameter itself
		 */
		
		// HttpSession session = req.getSession();
		// session.setAttribute("sum", sum);
		res.sendRedirect("square?sum="+sum);  // URL rewriting   
		// This technique comes under URL rewriting
		// The other 2 techniques are: Session Management & Cookies

	}
}
