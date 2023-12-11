<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"> 
<title>Login Page</title>
</head>
<body>
	<form action="Login" method="get">
		<table>
		<tr><td>Enter Username: <input type="text" name="uname" onfocus="this.value=''"><br/>
		Enter Password: <input type="password" name="pass" onfocus="this.value=''"><br/></td></tr>
		<tr><td><input type="submit" value="login"></td></tr>
		</table>
	</form>
</body>
</html>