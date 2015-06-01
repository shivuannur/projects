package com.sarvah.DAO;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;



import org.apache.log4j.Logger;

import com.sarvah.DTO.AdminLoginDTO;
import com.sarvah.controller.UserLoginController;

public class AdminLoginDAO {
	ResultSet result = null;
	PreparedStatement pstmt = null;
	Connection con = null;
	static Logger log = Logger.getLogger(AdminLoginDAO.class);

	public ResultSet verifyAdmin(AdminLoginDTO bean) {
		try {
			
			URL filePath = AdminLoginDAO.class.getClassLoader().getResource("db.properties");
			
			Properties props = new Properties();
			props.load(filePath.openStream());

			Class.forName(props.getProperty("Driver"));

			con = DriverManager.getConnection(props.getProperty("Url"),
					props.getProperty("User"), props.getProperty("Password"));

			String query = "select username,password from admin where username=? and password=?";
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, bean.getEmail());
			pstmt.setString(2, bean.getPassword());
			result = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

}
