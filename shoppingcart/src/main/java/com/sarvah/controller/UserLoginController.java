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

import com.sarvah.dao.UserDAO;
import com.sarvah.dto.UserBean;



/**
 * Servlet implementation class LoginController
 */
@WebServlet("/UserLoginController")
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(UserLoginController.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
  

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
		int i=Integer.parseInt(request.getParameter("T"));
		if(i==1)
		{
		//user login
		String userName=request.getParameter("UserName");
		String password=request.getParameter("Password");
		
		UserBean bean=new UserBean();
		bean.setUserName(userName);
		bean.setPassword(password);
		
		UserDAO dao=new UserDAO();
		ResultSet result=dao.verifyUser(bean);
		try {
			if(result.next())
			{
				log.info("Valid User!... login success...");
				RequestDispatcher dispatcher=request.getRequestDispatcher("/ModelList.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
				log.info("InValid User!... login failure...");
				RequestDispatcher dispatcher=request.getRequestDispatcher("/Error2.jsp");
				dispatcher.forward(request, response);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
		if(i==2)
		{
			//insert user
			String name=request.getParameter("UserName");
			String password=request.getParameter("Password"); 
			int age=Integer.parseInt(request.getParameter("Age"));
			String gender=request.getParameter("gender");
			int phoneno=Integer.parseInt(request.getParameter("Phone"));
			
			
			response.setContentType("text/html");
			
			UserBean bean=new UserBean();
			
			bean.setUserName(name);
			bean.setPassword(password);
			bean.setAge(age);
			bean.setGender(gender);
			bean.setPhoneNumber(phoneno);
			
			UserDAO dao=new UserDAO();
			boolean res=dao.registerUser(bean);
			if(res!=true)
			{
				log.info("User insert success...");

				RequestDispatcher dispatcher=request.getRequestDispatcher("/UserLogin.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
				log.info("User login failure...");

				RequestDispatcher dispatcher=request.getRequestDispatcher("/Error.jsp");
				dispatcher.forward(request, response);
			}
			
			
		}
		
	
	}

}
