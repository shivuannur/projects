package com.sarvah.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.sarvah.dto.ProductBean;


public class ProductDAO implements ProductInterface {
	boolean res=false;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet result=null;
	Connection conn=null;
	static Logger log = Logger.getLogger(ProductDAO.class);
	@Autowired
	private DataSource dataSource;
	 
	 
	
	public boolean insertProduct(ProductBean bean) 
	{
		String query1 = "INSERT INTO flipkart.product " +
				"(Pid,SCid,PName,Price,ModifiedDate) VALUES (?, ?, ?, ?, ?)";
		
		String query2="update userdb.inventory set InventoryCount=InventoryCount+1 where InventoryId=1";
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query1);
			pstmt.setInt(1, bean.getPid());
			pstmt.setInt(2, bean.getScid());
			pstmt.setString(3, bean.getPname());
			pstmt.setDouble(4, bean.getPrice());
			pstmt.setString(5, bean.getModifieddate());
			res=pstmt.execute();
			
			stmt=conn.createStatement();
			stmt.execute(query2);
			pstmt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally
		{
			try
			{
				if (conn != null) 
				{
					conn.close();
				}
				if(pstmt != null)
				{
					pstmt.close();
				}
				if(stmt!=null)
				{
					stmt.close();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
		return res;
	}
	
	
	public ResultSet searchProduct(ProductBean bean)
	{
		String query="select Pid,SCid,Pname,Price,ModifiedDate from flipkart.product where Pname=?";
		try {
			
			conn=dataSource.getConnection();
			
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, bean.getPname());
			result=pstmt.executeQuery();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(conn!=null)
				{
					conn.close();
				}
				if(pstmt!=null)
				{
					pstmt.close();
				}
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	
	public boolean  deleteProduct(ProductBean bean)
	{
		String query1="delete from flipkart.product where Pname=?";
		String query2="update userdb.inventory set InventoryCount=InventoryCount-2 where InventoryId=1";
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(query1);
			pstmt.setString(1, bean.getPname());
			res=pstmt.execute();
			
			stmt=conn.createStatement();
			stmt.execute(query2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(conn!=null)
				{
					conn.close();
				}
				if(pstmt!=null)
				{
					pstmt.close();
				}
				if(stmt!=null)
				{
					stmt.close();
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return res;
	}

}
