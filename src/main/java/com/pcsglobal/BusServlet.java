package com.pcsglobal;

import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class BusServlet extends HttpServlet
{
	private ServletConfig config;

	//Setting JSP page

	String page="view.jsp";

	public void init(ServletConfig config)

			throws ServletException{

		this.setConfig(config);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException,IOException
	{
		PrintWriter out = response.getWriter();
		//Establish connection to MySQL database

		HttpSession session = request.getSession();

		String connectionURL = "jdbc:mysql://localhost:3306/jsp";
		Connection connection = null;
		ResultSet rs;

		response.setContentType("text/html");

		List<String> dataList = new ArrayList<>();
		String departure = request.getParameter("departure");
		String arrival = request.getParameter("arrival");
		session.setAttribute("dep","departure");
		session.setAttribute("arr","arrival");

		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(connectionURL, "root", "pass");
			String sql = "select bus_name from bus where departure='" + departure + "' and arrival= '" + arrival + "'";
			Statement s = connection.createStatement();
			s.executeQuery (sql);
			rs = s.getResultSet();

			while (rs.next ()){
				//Add records into data list
				dataList.add(rs.getString("bus_name"));
			}

			rs.close ();
			s.close ();

		}catch(Exception e){
			System.out.println("Exception is ;"+e);
		}

		request.setAttribute("data",dataList);
		
		//Disptching request
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);

		if (dispatcher != null){
			dispatcher.forward(request, response);
		}
	}

	public ServletConfig getConfig() 
	{
		return config;
	}

	public void setConfig(ServletConfig config) 
	{
		this.config = config;
	}

}