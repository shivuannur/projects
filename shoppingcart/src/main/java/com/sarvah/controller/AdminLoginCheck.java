package com.sarvah.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sarvah.dao.AdminLoginDAO;
import com.sarvah.dto.AdminLoginDTO;



/**
 * Servlet implementation class AdminLoginCheck
 */
@WebServlet("/AdminLoginCheck")
public class AdminLoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	static Logger log = Logger.getLogger(AdminLoginCheck.class);
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		
		AdminLoginDTO bean=new AdminLoginDTO();
		bean.setEmail(email);
		bean.setPassword(password);
		AdminLoginDAO dao=new AdminLoginDAO();
		ResultSet result=dao.verifyAdmin(bean);
		try {
			if(result.next())
			{
				
				 log.info("valid admin!.. Login success");
				 

				 
				 
				RequestDispatcher dispatcher=request.getRequestDispatcher("/Home.jsp");
				dispatcher.forward(request, response);
				
			}
			else
			{
				log.info("InValid admin!.. Login failed");
				RequestDispatcher dispatcher=request.getRequestDispatcher("/Error.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
