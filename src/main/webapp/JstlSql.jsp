<!-- JSTL connection to Database -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL SQL Tags</title>
</head>
<body>
		<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/jsp" user="root" password="password" />
		<sql:query var="rs" dataSource="${db}">select * from jsp.gadgets</sql:query>
		
		<!-- mysql connector/J mysql connector driver library needs to be copied under WEB-INF/lib folder -->
		<c:forEach items="${rs.rows}" var="gadget">
			<br/><c:out value="${gadget.gid}"></c:out> : <c:out value="${gadget.gname}"></c:out> : <c:out value="${gadget.price}"></c:out>
		</c:forEach>
		                                                 
</body>
</html>