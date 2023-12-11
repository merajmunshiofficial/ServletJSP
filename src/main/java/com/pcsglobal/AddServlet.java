// AddServlet class extending HttpServlet class
// HttpServlet class extended service() method
// Request & Response objects
// Respond back / write to client


package com.pcsglobal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * ctrl+space to show Template proposals
 * Class AddServlet becomes a Servlet by simply extending a HttpServlet class
 * service() method in Servlet needs a mandatory implementation as a server component service is what Servlet needs to provide 
 */


public class AddServlet extends HttpServlet 
{
	//int sum = 0;
	public void service(HttpServletRequest req, HttpServletResponse res)  
	// the request and response objects are prepared by Tomcat 
	// No need to create/instantiate the objects 
	{
		int i = Integer.parseInt(req.getParameter("num1"));    // getting the input parameters from the request objects
		int j = Integer.parseInt(req.getParameter("num2"));
		
		// now add the values
		int sum = i + j;
		
		// System.out.println("Result is: "+ sum);
		
		// We create the PrintWriter object from the response object and use that object to print or send to client console
		try 
		{
			PrintWriter out = res.getWriter();
			out.println("Result is: "+ sum);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	
		/*
		 * When index1.html is run it generates the following url:
		 * http://localhost:8080/Debasis-JspServlet/add?num1=10&num2=20 --> the function name add along with input parameters
		 * is called "Query String"
		 * But, still the servlet "AddServlet" is not called, though it goes to Tomcat
		 * This does not happen because the add action in HTML form is not linked with the servlet 
		 * the mapping is done at the web.xml the deployment descriptor 
		 * Once the mapping is done in web.xml Tomcat knows which servlet is to be called for the "add" action
		 * Now running index1.html calls the servlet AddServlet and displays the result on the console
		 */
	}
}
