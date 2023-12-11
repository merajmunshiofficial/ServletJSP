// Request Dispatcher Servlet
// During creation of Class type HttpServlet can be done by using the following steps
// New>>Class>>SuperClass:>>type "httpservlet">>Browse>>select "javax.servlet.http.HttpServlet">>Ok>>Finish

package com.pcsglobal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddSqReqDispatcher extends HttpServlet 
{
	int sum =0;
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
	{
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));

		int sum = i + j;

		/*
		 * Now let's call another Servlet "SquareServlet" from this servlet for the Square
		 * function There are 2 methods to call a Servlet 1. RequestDispatcher 2.
		 * Redirect RequestDispatcher is an Interface so it will use the request object
		 * for specifying the Servlet to which the request is dispatched
		 */

		/*
		 * Also, now we want to Dispatch the value of sum to the called Servlet for
		 * Square function We can do that by 1) Session Management (sending data from
		 * one servlet to other servlet) 2) Easier method by setting attribute to
		 * Request object - Here we will do the attribute method
		 */

		req.setAttribute("summation", sum); // passing a "key", value pair
		
		RequestDispatcher rd = req.getRequestDispatcher("square");
		// mention the servlet url, this needs to go to web.xml to call the mapped Servlet
		
		rd.forward(req, res);
		// Forwards a request from a servlet to another resource (servlet, JSP file,or HTML file) on the server.
		// This method allows one servlet to do preliminary processing of a request and another resource to generate the response.
	}
}
