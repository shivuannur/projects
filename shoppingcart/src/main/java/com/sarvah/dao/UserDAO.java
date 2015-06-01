package com.sarvah.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.sarvah.dto.UserBean;


public class UserDAO {
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet result=null;
	boolean res=false;
	static Logger log = Logger.getLogger(UserDAO.class);
	public ResultSet verifyUser(UserBean bean)
	{
		try {
			Driver d=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d); 
			
			con=DriverManager.getConnection("jdbc:mysql://localhost/sample","root","root");
			
			String query="select UserName,Password from userdetails where UserName=? and Password=?";
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1,bean.getUserName());
			pstmt.setString(2, bean.getPassword());
			result=pstmt.executeQuery();
	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean registerUser(UserBean bean)
	{
		
		try {
			Driver d = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);
			con=DriverManager.getConnection("jdbc:mysql://localhost/sample","root","root");
						String query="insert into userdetails values(?,?,?,?,?)";
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, bean.getUserName());
			pstmt.setString(2, bean.getPassword());
			pstmt.setInt(3, bean.getAge());
			pstmt.setString(4, bean.getGender());
			pstmt.setLong(5, bean.getPhoneNumber());
			res=pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res; 
	}

}
