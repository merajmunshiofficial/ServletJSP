/**
 * Servlet implementation class Login
 */

package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login")  // to avoid the use of configuration through web.xml
public class Login extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		LoginDao dao = new LoginDao();  // Servlet is calling the services of DAO layer to access Database

		// if (uname.equals("debasis") && pass.equals("debasis")) // earlier implementation without database dao
		if (dao.check(uname, pass)) // Value returned from DAO class LoginDao is either true or false - in case this is true then
		{
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			response.sendRedirect("welcome.jsp");
		}
		else
			response.sendRedirect("login.jsp");
	}
}
