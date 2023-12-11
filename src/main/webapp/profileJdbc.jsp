
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- Page directive to import java.sql... -> Step 1 -->
<%@ page import="java.sql.*" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JDBC Query Through JSP</title>
</head>
<body>

	<%
		// JDBC connection using MySQL
		String url = "jdbc:mysql://localhost:3306/jsp";
		String uname = "root";
		String pwd = "password";
		// String sql = "select * from jsp.students";  // For create statement to find all records without placeholder or bind variables
				
		String sql = "select * from jsp.students where rollno in (?, ?, ?) order by rollno desc";  // For prepare statement with placeholder or bind variables
		
		Class.forName("com.mysql.jdbc.Driver");   // Load and register jdbc driver for mysql -> Step 2
												  // Add the mysql-connector jar file into lib folder of WEB-INF
		
		Connection con = DriverManager.getConnection(url, uname, pwd); // Connect to mysql database -> Step 3

		// This portion is to check the Statement object
		// Statement stmt = con.createStatement();
		// This portion is to check the PreparedStatement object
		PreparedStatement pstmt = con.prepareStatement(sql);   // creating the PreparedStatement object -> Step 4

		// Placeholders or bind variables in respective fields
		pstmt.setString(1, "103");  // 1 = first parameter
		pstmt.setString(2, "101");
		pstmt.setString(3, "102");  
		
		// ResultSet rs = stmt.executeQuery(sql);	// execute the Statement object with the SQL string
		ResultSet rs = pstmt.executeQuery();   // execute the PreparedStatement object -> Step 5		
		
		int rownum = 0; 

	%>
	
	<%
		/*
		rs.next() -> place the pointer to the first row of resultset 
		process the data - that is browse through the resultset, fetch the data and print the result -> Step 6
		*/
		while (rs.next() == true) 
		{
	%>
			<!-- Print the fetched record -->
			<br/>Roll No.: <%= rs.getString(1) %> 
			<br/>Name    : <%= rs.getString(2) %> 
			<br/>Marks   : <%= rs.getString(3) %> 
			<br/><hr>
	<%
			rownum = rs.getRow();  
		}
	%>
	
	<br/>No. of row(s) fetched : <%= rownum %> 

	<%
		con.close();   // Close the connection or release the resource -> Step 7	
	%>
	
</body>
</html>