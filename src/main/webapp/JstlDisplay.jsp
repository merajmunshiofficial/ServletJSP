<!--  Jstl with core tag -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL display</title>
</head>
<body>
	<%
		// String name = request.getAttribute("label").toString();
		// out.println("The scriplet JSP display of name: " +name);
	%>
	
	<!-- to avoid the complexity of java code above we employ the JSTL expression language below: -->
	
	<br/><p/>The Expression Language (EL) display of name: ${label}
	
	<!-- Using JSTL with user defined tag for the same output -->
	<br/><br /><c:out value="Hello Debasis Welcome from JSTL taglib" />
	
	<!-- Combination of JSTL and Expresssion Language -->
	<br/><br /><c:out value="${label} now in JSTL + EL" />  <!--  earlier version of jdk 1.2 -->
	
	<!--  Import an url  -->
	<!-- <c:import url="https://pcsglobal.biz/"></c:import> -->
	
	<!--  Jstl using object (Students) -->
	<!-- <br/><br/>${student}<br/> --> <!--  produces a hash code, we want to print the name, rollno, marks -->
	<!-- <br/>Name: ${student.name }<br/> -->
	<!-- <br/>Roll No.: ${student.rollno }<br/> -->
	<!-- <br/>Marks: ${student.marks }<br/> -->
	
	<!--  Iterating through the multiple rows in the students object -->
	<br/><td >Name</td>  <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>  <td>Roll No</td>
	<c:forEach items="${students}" var="s">
		<br/>${s.name} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${s.rollno} 
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${s.marks}
	</c:forEach>
	
</body>
</html>