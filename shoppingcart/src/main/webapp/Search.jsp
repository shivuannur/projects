<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
<form action="ProductController" method="post">
		
<h1 align="center">Search Product</h1>
<table align="center">
<tr><td><label>Enter Product Name:</label></td><td><input type="text" name="pname"></td></tr>
<tr><td><input type="submit" value="search"/></td><td><input type="reset" value="Clear" ></td></tr>
</table>
<input type="hidden" name="T" value="2"/>
<h2 align="center"><a href="Home.jsp">HOME</a></h2>
</form>
</body>
</html>