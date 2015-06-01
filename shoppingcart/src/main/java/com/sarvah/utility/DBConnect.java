package com.sarvah.utility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.sarvah.dto.UserBean;
public class DBConnect 
{
	static Logger log = Logger.getLogger(UserBean.class);
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
