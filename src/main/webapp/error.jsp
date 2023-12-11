<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true" %>
<!--  Page directive attribute isErrorPage -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>
<body style="background-color:red;">
	<h2>Error!!!!</h2>
	<!-- We need to print the exception message 
		 We can do that by using page directive isErrorPage="true" to make it understand that it is an error page
	 -->
	 <%= exception.getMessage() %>
	 <!-- exception is an Object in Jsp if the the page is an ErrorPage -->

</body>
</html>