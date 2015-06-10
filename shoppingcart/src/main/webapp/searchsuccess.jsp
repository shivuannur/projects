<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
<table border="1" align="center">
<tr><td>PID</td><td>SCID</td><td>CATALOGNO</td><td>PNAME</td><td>PRICE</td><td>MODIFIEDDATE</td></tr>
<tr>
<td>
<%= session.getAttribute("pid") %>
</td>
<td>
<%= session.getAttribute("scid") %>
</td>
<td>
<%= session.getAttribute("catalogno") %>
</td>
<td>
<%= session.getAttribute("pname") %>
</td>

<td>
<%= session.getAttribute("price") %>
</td>

<td>
<%= session.getAttribute("modifieddate") %>
</td>
</table>
<h2 align="center"><a href="Home.jsp">HOME</a></h2>
</body>
</html>