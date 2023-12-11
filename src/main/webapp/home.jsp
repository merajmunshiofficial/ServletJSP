<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- Include Directive include -->
<%@ include file="index8.html" %> 

<!-- Page Directive Error -->
<%@ page errorPage="error.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Directive</title>
</head>
<body>
	<%
		String name = request.getParameter("uname"); 
		pageContext.setAttribute("uname", name, PageContext.SESSION_SCOPE); 
		// the attribute name with value <text parameter from index8.html> will be available for all the pages of the entire session
		// and not restricted to the current page only
		// the pageContext is the JSP object supported by Tomcat from PageContext Class/object of JSP
		// out.println("From pageCntext object of JSP: <br>"+ (String)pageContext.getAttribute("uname"));
		out.println("From pageCntext object of JSP: <br>"+ name);
		out.println("<br><hr>");
				
		config.getInitParameter("uname");
		//out.println("From config object of JSP: "+config.getInitParameter("uname"));
		out.println("From config object of JSP: <br>"+name);
		out.println("<br><hr>");
		// Similarly we do not need to instantiate the ServletConfig (interface) object in Servlet, 
		// as Tomcat provides the config object in JSP
	%>
	
<!-- Exception handling in JSP --> 

	<%
    /*  	
    try { 
			int k = 9/0; 
		} 
	catch (Exception e)	{
			out.println("Error: " + e.getMessage());
		}   
	*/
		// unchecked error introduced -> division by zero. If run like this it will encounter error 500 on browser
		// We can do the java exception handling using try catch, but the output will be on the same page in browser, 
		// which is not desirable
		// So, we introduce Directive tag <%@ page errorPage="err_url"
		
		int k = 9/3;
		// This will invoke error.jsp as per the page directive		
	%>
	
</body>
</html>