package com.sarvah.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.sarvah.DTO.ProductBean;
import com.sarvah.utility.DBConnect;

public class ProductDAO implements DAOInterface {
	boolean res=false;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	Connection con=null;
	ResultSet result=null;
	public boolean insertProduct(ProductBean bean) 
	{
		try
		{
			DBConnect dbconnect = DBConnect.getOnlyOne();
			Connection con =  (Connection) dbconnect.getCon(); 
		
		String query="insert into userdb.product(Pid,SCid,CatalogNumber,PName,Price,ModifiedDate) values(?,?,?,?,?,?)";
		pstmt=con.prepareStatement(query); 
		pstmt.setInt(1, bean.getPid());
		pstmt.setInt(2, bean.getScid());
		pstmt.setString(3, bean.getCatalogno());
		pstmt.setString(4, bean.getPname());
		pstmt.setDouble(5, bean.getPrice());
		pstmt.setString(6, bean.getModifieddate());
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
			
			String query="select Pid,SCid,CatalogNumber,Pname,Price,ModifiedDate from userdb.product where Pname=?";
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
			String query="delete from userdb.product where Pname=?";
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
