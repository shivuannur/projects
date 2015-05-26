package com.sarvah.controller;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sarvah.DAO.DAOInterface;
import com.sarvah.DAO.ProductDAO;
import com.sarvah.DTO.ProductBean;

/**
 * Servlet implementation class ProductInsertController
 */
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
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
			System.out.println("Insert Called");
			int pid=Integer.parseInt(request.getParameter("pid"));
			int scid=Integer.parseInt(request.getParameter("scid"));
			String catalogno=request.getParameter("catalogno");
			String pname=request.getParameter("pname");
			double price=Double.parseDouble(request.getParameter("price"));
			String modifieddate=request.getParameter("modifieddate");
			
			ProductBean bean=new ProductBean();
			bean.setPid(pid);
			bean.setScid(scid);
			bean.setCatalogno(catalogno);
			bean.setPname(pname);
			bean.setPrice(price);
			bean.setModifieddate(modifieddate);
			
			DAOInterface dao=new ProductDAO();
			boolean res=dao.insertProduct(bean);
			if(res!=true)
			{
				RequestDispatcher dispatcher=request.getRequestDispatcher("/Welcome.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
				RequestDispatcher dispatcher=request.getRequestDispatcher("/Error.jsp");
				dispatcher.forward(request, response);	
			}
		} 
		
		
		if(i==2)
		{
			//search
			System.out.println("search operation");
			String pname=request.getParameter("pname");
			ProductBean bean=new ProductBean();
			bean.setPname(pname);
			DAOInterface dao=new ProductDAO();
			
			ResultSet res=dao.searchProduct(bean);
			try {
				if(res.next())
				{
					HttpSession session=request.getSession(true);
					session.setAttribute("pid", res.getInt("Pid"));
					session.setAttribute("scid", res.getInt("SCid"));

					session.setAttribute("catalogno", res.getString("CatalogNumber"));
					session.setAttribute("pname", res.getString("Pname"));
					session.setAttribute("price", res.getString("Price"));
					session.setAttribute("modifieddate", res.getString("ModifiedDate"));
					RequestDispatcher dispatcher=request.getRequestDispatcher("/Welcome1.jsp");
					dispatcher.forward(request, response);
				}
				else
				{
					RequestDispatcher dispatcher=request.getRequestDispatcher("/Error1.jsp");
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
			System.out.println("delete operation");
			String pname=request.getParameter("pname");
			ProductBean bean=new ProductBean();
			bean.setPname(pname);
			DAOInterface dao=new ProductDAO();
			boolean res=dao.deleteProduct(bean);
			if(res!=true)
			{
				RequestDispatcher dispatcher=request.getRequestDispatcher("/Welcome3.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
				RequestDispatcher dispatcher=request.getRequestDispatcher("/Error.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

}
