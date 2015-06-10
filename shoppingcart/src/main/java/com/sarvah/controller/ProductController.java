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
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sarvah.config.HelloConfig;
import com.sarvah.dao.ProductInterface;
import com.sarvah.dao.ProductDAO;
import com.sarvah.dto.ProductBean;

/**
 * Servlet implementation class ProductInsertController
 * @author shivu s
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(ProductController.class);
    /**
     * @see HttpServlet#HttpServlet() Checking into GIT to test
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i=Integer.parseInt(request.getParameter("T"));
		if(i==1)
		{
			//insert
			System.out.println("Insert product is Called");
			int pid=Integer.parseInt(request.getParameter("pid"));
			int scid=Integer.parseInt(request.getParameter("scid"));
			String pname=request.getParameter("pname");
			double price=Double.parseDouble(request.getParameter("price"));
			String modifieddate=request.getParameter("modifieddate");
			
			WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
			 
			ProductInterface pinterface=(ProductInterface) context.getBean("productDAO");
			
			ProductBean bean=new ProductBean(pid,scid,pname,price,modifieddate);
			
			boolean res= pinterface.insertProduct(bean);
			if(res!=true)
			{
				log.info("Product inserted successfully...");
				RequestDispatcher dispatcher=request.getRequestDispatcher("/insertsuccess.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
				log.info("Product insert Failure...");
				RequestDispatcher dispatcher=request.getRequestDispatcher("/insertfail.jsp");
				dispatcher.forward(request, response);	
			}
		} 
		
		
		if(i==2)
		{
			//search
			System.out.println("search product is called");
			String pname=request.getParameter("pname");
			
			WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
			ProductInterface pinterface=(ProductInterface) context.getBean("productDAO");
			
			ProductBean bean=new ProductBean(pname);
		
			ResultSet res=pinterface.searchProduct(bean);
			try {
				if(res.next())
				{
					log.info("Product search success...");
					HttpSession session=request.getSession(true);
					session.setAttribute("pid", res.getInt("Pid"));
					session.setAttribute("scid", res.getInt("SCid"));
					session.setAttribute("pname", res.getString("Pname"));
					session.setAttribute("price", res.getString("Price"));
					session.setAttribute("modifieddate", res.getString("ModifiedDate"));
					RequestDispatcher dispatcher=request.getRequestDispatcher("/searchsuccess.jsp");
					dispatcher.forward(request, response);
				}
				else
				{
					log.info("Product search fails...");
					RequestDispatcher dispatcher=request.getRequestDispatcher("/searchfail.jsp");
					dispatcher.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
		
		if(i==3)
		{
			//delete
			System.out.println("delete product is called");
			String pname=request.getParameter("pname");

			WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
			
			ProductInterface pinterface=(ProductInterface) context.getBean("productDAO");
			ProductBean bean=new ProductBean(pname);
			pinterface.deleteProduct(bean);
			boolean res=pinterface.deleteProduct(bean);
			if(res!=true)
			{
				log.info("Product delete success...");
				RequestDispatcher dispatcher=request.getRequestDispatcher("/deletesuccess.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
				log.info("Product delete failure...");
				RequestDispatcher dispatcher=request.getRequestDispatcher("/deletefail.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

}
