<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
          <% 
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost/userdb", "root", "root");

            Statement stmt = con.createStatement() ;
            ResultSet rs = stmt.executeQuery("select * from inventory") ; 
			%>
			<table border="1" align="center">
<tr>
<td>InventoryId</td><td>InventoryName</td><td>InventoryCount</td>
</tr>
<% while(rs.next()){ %>
            <TR>
            	
                <TD> <%= rs.getInt(1) %></td>
                <TD> <%= rs.getString(2) %></TD>
                <TD> <%= rs.getInt(3) %></TD>
                </TR>
            <% } %>
            </table>
            <h2 align="center"><a href="Home.jsp">HOME</a></h2>
</body>
</html>