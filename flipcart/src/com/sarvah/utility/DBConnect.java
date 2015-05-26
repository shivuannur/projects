package com.sarvah.utility;
import java.sql.*;
public class DBConnect 
{
	private static final DBConnect only_one = new DBConnect();

	private Connection con = null;
	private DBConnect()
	{
		try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		
	}
	public static DBConnect getOnlyOne() {
		return only_one;
	}
	public  Connection getCon() {
		return con;
	}
	@Override
		protected void finalize() throws Throwable {
			if(con!=null)
			{
				con.close();
			}
		}
}
