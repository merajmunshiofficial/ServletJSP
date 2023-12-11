// Servlet with doPost() method without service()
// doGet() and doPost() difference


package com.pcsglobal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddServletPost extends HttpServlet 
{
	/*
	 * doPost() & doGet() methods are given by Webserver (Tomcat)  
	 * It can prevent accepting any get requests from the HTML form
	 * We can control the form to accept only post requests
	 */
	  
	// doPost() doGet() methods overrides service() method
	// But in any case the application server internally calls the service() method
	@Override   
	protected void doPost(HttpServletRequest req, HttpServletResponse res)  throws IOException, ServletException
	{ 
		int i = Integer.parseInt(req.getParameter("num1"));    // getting the input parameters from the request objects
		int j = Integer.parseInt(req.getParameter("num2"));

		// now add the values
		int sum = i + j;

	    //System.out.println("Result is: "+ sum);

		// We create the PrintWriter object from the response object and use that object to print or send to client console
		try 
		{
			PrintWriter out = res.getWriter();
			out.println("in doPost()/doGet() ===> Result is: "+ sum);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}

		/*
		 * Even if HTML form sends a get request by using doPost we can prevent user tampering the query string
		 * by using form "Inspection"
		 * 
		 */
	  
	}
}	

