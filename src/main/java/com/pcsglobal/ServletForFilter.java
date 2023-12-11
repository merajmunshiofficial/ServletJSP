package com.pcsglobal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/filterId")
public class ServletForFilter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		res.getWriter().append("Served at: ").append(req.getContextPath()).append("\n");
		
		PrintWriter out = res.getWriter();
		
		int aid = Integer.parseInt(req.getParameter("aid"));
		String aname = (String) req.getParameter("aname");
		out.println("Welcome Mr./Mrs, ");
		out.print(aname);
		System.out.println("Welcome, "+aname);
	}
}
