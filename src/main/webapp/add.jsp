<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- Directive JSP tag -->
<%@page import="java.util.Date" %>

<!DOCTYPE html>
<html>
<head>
   <meta charset="ISO-8859-1">
   <title>JSP Page</title>
</head>
<body style="background-color:powderblue; font:bold; font-family:fantasy; font-size:large;"> 
<!-- <body style="background-color:purple; font: bold; font-family: fantasy; font-size:large;"> -->


<!-- 
	Scriptlet: to implement a service() method of Servlet - Implicit Java code inside JSP page 
	JSP provides "request" object automatically
	JSP provides "out" object for JspWriter -> JspWriter out - add._jspService(HttpServletRequest, HttpServletResponse) 
-->

	
<!-- 	
	Declaration: to declare a variable or a method outside service() method
	Directive: to import package/packages
	Expression: to print the output as response object 
-->
<!--  Declaration: -->
	<%! 
		int coef = 3;
	    String msg = "We are learning JSP";
	%>
	
<!--  Scriptlet: -->	
	<% 
		int i = Integer.parseInt(request.getParameter("num1"));
		int j = Integer.parseInt(request.getParameter("num2"));
		
		Date dt = new Date(); // to demonstrate the Directive JSP tag
		out.println(dt.getDate()+"/"+ (dt.getMonth()+1) +"/"+ (dt.getYear()-100) +"\n");
		out.println("\n<br/>");
		
		int sum = i + j;
		out.println(msg);
		out.println("\n\n<br/>Result is : "+sum);
		out.println("\n<br/>");
		
	%>
<!--  Expression: -->
	<br/>The declarative variable <b>"coef"</b> is 
	<%= coef %> 
	<br/>
	The sum is: <%= sum %>
	
</body>
</html>