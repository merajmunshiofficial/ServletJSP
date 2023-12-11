// Why do we use JSP
// Coding the servlet with HTML tags

package com.pcsglobal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/add1")
public class WhyJsp extends HttpServlet  
{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
	{
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));

		int sum = i + j;
		
		PrintWriter out = res.getWriter();
		out.println("<html><head><title>Servlet HTML</title></head><body bgcolor='cyan'>");
		out.println("<h3>Result from Servlet is: "+ sum + "</h3>");
		out.println("<br/></body></html>"); 
		
		/*
		 * Now this is just not possible to code in Servlet as it is hard to debug and maintain
		 */
	}
}
