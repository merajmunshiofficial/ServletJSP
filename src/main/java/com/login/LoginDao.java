// A DAO Class (Database Access Object) created to 
// connect to JDBC mySQL database to verify login credentials 

package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao 
{
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jsp";
	String username = "root";
	String pass = "password";
	String sql = "select * from login where pass=? and uname=?";
	public boolean check(String uname, String password)
	{
		try 
		{
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,username, pass);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(2, uname);
			st.setString(1, password);
			ResultSet rs = st.executeQuery();
			
			if (rs.next())
			{
				return true;
			}
			else 
			{
				return false;
			}		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
