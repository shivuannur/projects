package com.sarvah.springmailservice;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.*;  
import org.springframework.beans.factory.xml.XmlBeanFactory;  
import org.springframework.core.io.*; 
@WebServlet("/Test")
public class Test extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		      System.out.println("started");
			Resource r=new ClassPathResource("applicationContext.xml");  
			System.out.println("1");
		
			
			BeanFactory b=new XmlBeanFactory(r);  
			System.out.println("2");
			MailMail msg=(MailMail)b.getBean("mailMail");  
			System.out.println("3");
			String sender="harish990088@gmail.com";//write here sender gmail id  
			String receiver="shivus476@gmail.com";//write here receiver id  
			System.out.println("4");
			msg.sendMail(sender,receiver,"hi shivu","welcome shivu");  
			System.out.println("success");  
			}  


	}

