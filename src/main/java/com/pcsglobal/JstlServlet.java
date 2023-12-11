// Servlet with JSTL tag
// Servlet with Jstl calling object

package com.pcsglobal;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JstlServlet")
public class JstlServlet extends HttpServlet 
{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String name = "Meraj Munshi Welcome!!!";
		
		// Calling object Student OR creating an Arraylist of Students objects
		List<Students> studs = Arrays.asList(new Students(1, "Meraj",58), new Students(2, "Ambarish", 89), new Students(3, "Arati",98));
		// Student stud = new Student(1, "Meraj");
		
		// req.setAttribute("label", name);
		
		// setting Student object 
		req.setAttribute("students", studs);
		
		RequestDispatcher rd = req.getRequestDispatcher("JstlDisplay.jsp");
		rd.forward(req, res);
	}
}
