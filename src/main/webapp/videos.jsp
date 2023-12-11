<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Videos Page</title>
</head>
<body>
	<!--  This is an Secure page -->
	<!-- It disallows a user to directly use the videos.jsp url and redirects to login by checking the login username -->
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
	
	<h1>Videos here</h1>

	<iframe width="560" height="315"
		src="https://www.youtube.com/embed/gBBM9YbMPIw"
		title="Aloke Halder YouTube Angular JS" frameborder="0"
		allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
		allowfullscreen> 
	</iframe>

	<br/><br/>
	<form action="Logout">
		<input type="submit" value="logout">
	</form>
</body>
</html>