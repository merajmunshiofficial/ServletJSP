<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page language="java" import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
	<title>Data Page</title>
</head>
<body>
	<form name="input" action="InfoServlet" method="post">
		<table border="1" <%= 200 %>>
			<tr>
				<td width="200"><b>Bus_Name</b></td>
			</tr>
			<%
				Iterator<String> itr;
			%>
			<%
				List<String> data = (List) request.getAttribute("data");
				for (itr = data.iterator(); itr.hasNext();) 
				{
			%>
			<%
				String item = (String) itr.next();
			%>
			<tr>
				<td width="200"><a href="form.jsp?item={$item}"> <%= item %>
				</a></td>
			</tr>
			
			<%
				}
			%>
			
		</table>
	</form>
</body>
</html>