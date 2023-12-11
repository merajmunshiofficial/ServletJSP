
<%@ page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"> 
<title>Welcome Page</title>
</head>
<body>
	<!--  This is a Secure page -->
	<!-- It disallows a user to directly use the welcome.jsp url and redirects to login by checking the login username -->
	<!-- As well we need to prevent caching of the page for security reasons - that is when pressing back-button from  
		 the successor page it should not come back to this secure page -->
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");  // HTTP 1.1 onwards this works
			
		response.setHeader("Pragma", "no-cache"); // for HTTP 1.0 
		
		response.setHeader("Expires", "0");    // for Proxy servers 
			
		if (session.getAttribute("username")== null)
		{
			response.sendRedirect("login.jsp");
		}
	%>
	
	<!-- Else it welcomes the user - using Scriptlet  -->
	Welcome Page welcomes
	
	<%! String uname; %>
	
	<%
	  try{
		uname = session.getAttribute("username").toString();  // within try catch block because due to implementation of back button
		out.println(uname.toUpperCase());					  // which removes the cache page along with session attribute
	  }catch(Exception e) {out.println(e);}
	%>
	
	<!-- Else it welcomes the user - using JSTL function tag  -->
	<c:set var="str" value="debasis"></c:set>   
	<br/>Welcome Page welcomes ${fn:toUpperCase(str)}
	
	<br/>
	<b><a href="videos.jsp">Click here for Videos..</a></b>
	
	<br/><br/>
	<form action="Logout">
		<input type="submit" value="logout">
	</form>
	
</body>
</html>