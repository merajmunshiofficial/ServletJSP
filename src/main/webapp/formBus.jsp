<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Fillup</title>
</head>
<body>
	<h1>Fill the form -->></h1>
	
	<form name="input" action="InfoServlet" method="post">
		Id: <input type="text" name="id" /> <br>
		<br> Name : <input type="text" name="name" /> <br>
		<br> Address : <input type="text" name="address" /> <br>
		<br> E_mail : <input type="text" name="email" /> <br>
		<br> Credit Card Number : <input type="text" name="ccno" /> <br>
		<br> Tickets : <input type="text" name="tickets" /> <br> <br>
		Book Number : <input type="text" name="booknum" /> <br> <br>
		Date : <input type="text" name="date" /> <input type="submit"
			value="Submit" />
	</form>
</body>
</html>