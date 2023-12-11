<!-- JSTL Function Tag -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL SQL Tags</title>
</head>
<body>
	<c:set var="str" value="Debasis is a Java trainer"></c:set>
	
	<!--  Using length function -->
	Length of &nbsp;&nbsp; "${str}" &nbsp;&nbsp;: ${fn:length(str)}   
	
	<!--  Using split function to print each word separated by ' ' -->    
	<c:forEach items="${fn:split(str, ' ')}" var="s">
		<br/>
		${s}
	</c:forEach>        
	
	<!-- indexOf() -->
	<br/>Index : ${fn:indexOf(str,'is')} 

	<!-- Contains() -->	    
	<br/>Is "Java" there : ${fn:contains(str,"Ja")}
	
	<!--  If condition -->
	<c:if test="${fn:contains(str,'Java')}">
		<br/>Java is there
	</c:if>

	<!--  endsWith() -->
	<c:if test="${fn:endsWith(str,'trainer')}">
		<br/>You are a trainer
	</c:if>
	
	<!-- Upper & Lowercase -->
	<br/>${fn:toUpperCase(str)}
	<br/>${fn:toLowerCase(str)}
	
</body>
</html>