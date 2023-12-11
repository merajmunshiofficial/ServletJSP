// ServletContext & ServletConfig
// ServletContext: setting webcontainer with context-param to fetch the name and value into Servlet
// ServletConfig: setting webcontainer with init-param within <servlet></servlet> to fetch the name and value into Servlet
// @WebServlet(<url-pattern>) to take away the web.xml configuration to call a servlet. 
// So there should be no use of <servlet></servlet> and <servlet-mapping></servlet-mapping> 


package com.pcsglobal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
//@WebServlet("/servlet")  // Annotation with URL - default servlet url is /servlet
public class ServletContextConfig extends HttpServlet   
{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
	{
		PrintWriter out = res.getWriter();
		out.print("Hi, \n"); 
		
		String name = (String) req.getAttribute("myName");
		out.print(name); 
		
		// ServletContext: Need to extract the Name and Phone from the Context Param set in web.xml
		// ---------------
		
		ServletContext ctx = req.getServletContext();  // HttpServlet gives the request object with the ServletContext object
												       // ServletContext is an interface like ServletConfig
		String str = ctx.getInitParameter("name");     // <context-param> in web.xml as separate xml block -> ctx object fetches context parameter name which is name
		System.out.println(str);
		out.println(str);
		
		str = ctx.getInitParameter("phone model");   // <context-param> in web.xml as separate xml block -> ctx object fetches context parameter name which is phone
		str = "You have " + str + " phone";
		System.out.println(str);
		out.println(str);
		
		// ServletConfig: Need to extract the name and phone from Config Param set in web.xml
		// --------------
		// When we have multiple servlets but want to use the same parameters in all servlets then use ServletContext
		// When we need to specify particular parameters specific to each Servlet we use ServletConfig under Servlet
		
		ServletConfig cfg = getServletConfig();  // HttpServlet gives the object with the ServletConfig object

		String str1 = cfg.getInitParameter("name");   // <init-param> in web.xml under <servlet> -> cfg object fetches config parameter name which is name
		out.println(str1);
		System.out.println(str1);
		
		str1 = cfg.getInitParameter("phone model");   // <init-param> in web.xml under <servlet> -> cfg object fetches config parameter name which is phone
		str1 = "You have " + str1 + " phone" + "\nAnnotation cannot fetch the config params";
		out.println(str1);
		System.out.println(str1);
		
	}
}
