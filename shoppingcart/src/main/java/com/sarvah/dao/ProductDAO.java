package com.sarvah.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.sarvah.dto.ProductBean;
import com.sarvah.utility.DBConnect;

public class ProductDAO implements DAOInterface {
	boolean res=false;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	Connection con=null;
	ResultSet result=null;
	static Logger log = Logger.getLogger(ProductDAO.class);
	public boolean insertProduct(ProductBean bean) 
	{
		try
		{
			DBConnect dbconnect = DBConnect.getOnlyOne();
			Connection con =  (Connection) dbconnect.getCon(); 
		
		String query="insert into flipkart.product(Pid,SCid,PName,Price,ModifiedDate) values(?,?,?,?,?)";
		pstmt=con.prepareStatement(query); 
		pstmt.setInt(1, bean.getPid());
		pstmt.setInt(2, bean.getScid());
		pstmt.setString(3, bean.getPname());
		pstmt.setDouble(4, bean.getPrice());
		pstmt.setString(5, bean.getModifieddate());
		res=pstmt.execute();
		String query1="update userdb.inventory set InventoryCount=InventoryCount+1 where InventoryId=1";
		stmt=con.createStatement();
		stmt.execute(query1);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return res;
	}
	public ResultSet searchProduct(ProductBean bean)
	{
		try {
			DBConnect dbconnect = DBConnect.getOnlyOne();
			Connection con =  (Connection) dbconnect.getCon(); 
			
			String query="select Pid,SCid,Pname,Price,ModifiedDate from flipkart.product where Pname=?";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, bean.getPname());
			result=pstmt.executeQuery();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean  deleteProduct(ProductBean bean)
	{
		try {
			
			DBConnect dbconnect = DBConnect.getOnlyOne();
			Connection con =  (Connection) dbconnect.getCon(); 
			String query="delete from flipkart.product where Pname=?";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, bean.getPname());
			res=pstmt.execute();
			
			String query1="update userdb.inventory set InventoryCount=InventoryCount-1 where InventoryId=1";
			stmt=con.createStatement();
			stmt.execute(query1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

}
