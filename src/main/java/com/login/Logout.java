/**
 * Servlet implementation class Logout
 */

package com.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/Logout")
public class Logout extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		session.removeAttribute("username");   // atribute name is "username"
		session.invalidate();  // invalidate all the session data
		
		response.sendRedirect("login.jsp");   // redirect the page to login page after logout
		
	}
}
