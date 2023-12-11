package com.pcsglobal;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class BusInfoServlet extends HttpServlet
{
	private ServletConfig config;

	//Setting JSP page
	String page="success.jsp";

	@Override
	public void init(ServletConfig config) 	throws ServletException
	{
		this.setConfig(config);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
		PrintWriter out = response.getWriter();
		
		//Establish connection to MySQL database
		HttpSession session = request.getSession();

		String connectionURL = "jdbc:mysql://localhost:3306/jsp";
		Connection connection = null;
		ResultSet rs;
		
		response.setContentType("text/html");

		try {

			String itm = request.getParameter("item");
			session.setAttribute("buses", itm);
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			String ccno = request.getParameter("ccno");
			String tickets = request.getParameter("tickets");
			//int t = Integer.parseInt(tickets);
			String bkno = request.getParameter("booknum");
			String date = request.getParameter("date");
			//session.setAttribute("ids",id);
			session.setAttribute("nam",name);
			session.setAttribute("add",address);
			session.setAttribute("mail",email);
			session.setAttribute("cc",ccno);
			String d = (String)session.getAttribute("dep");
			String a = (String)session.getAttribute("arr");
			String b = (String)session.getAttribute("buses");

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(connectionURL, "root", "pass");
			PreparedStatement pst = connection.prepareStatement("insert into customer values(?,?,?,?,?)");
			pst.setString(1,id);
			pst.setString(2,name);
			pst.setString(3,address);
			pst.setString(4,email);
			pst.setString(5,ccno);
			
			int i = pst.executeUpdate();

			PreparedStatement pst1 = connection.prepareStatement("insert into booking values(?,?,?)");
			pst1.setString(1,bkno);
			pst1.setString(2,id);
			pst1.setString(3,date);

			int j = pst1.executeUpdate();

			String sql = "select bus_id from bus where bus_name ='" + b + "' and departure='" + d + "' and arrival= '" + a + "'";
			Statement s = connection.createStatement();
			s.executeQuery (sql);

			rs = s.getResultSet();
			
			String bid = rs.getString("bus_id");
			
			PreparedStatement pst2 = connection.prepareStatement("insert into booking_list values(?,?,?)");
			pst2.setString(1,bkno);
			pst2.setString(2,bid);
			pst2.setString(3,tickets);

			int k = pst2.executeUpdate();
			
			rs.close ();
			s.close ();
			
		}catch(Exception e){ System.out.println("Exception is ;"+e); }

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