<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
<h1 align="center">Insert Product</h1>
<form action="ProductController" method="post">
<table align="center">
<tr><td><label>Product_Id :</label></td><td><input type="text" name="pid"></td></tr>
<tr><td><label>SubCategory_Id :</label></td><td><input type="text" name="scid"></td></tr>
<tr><td><label>Product_Name :</label></td><td><input type="text" name="pname"></td></tr>
<tr><td><label>Price :</label></td><td><input type="text" name="price"></td></tr>
<tr><td><label>Modified Date :</label></td><td><input type="text" name="modifieddate"></td></tr>
<tr><td><input type="submit" value="Add"></td><td><input type="reset" value="Clear" ></td></tr>
</table>
<input type="hidden" name="T" value="1"/>
<h2 align="center"><a href="Home.jsp">HOME</a></h2>
</form>
</body>
</html>