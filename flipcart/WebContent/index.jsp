<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
<form action="UserLoginController" method="post">
<table align="center">
	<caption>User Login Page</caption>
	
	<tr>
			<td><label >UserName</label></td>	
			<td><input type="text" required autofocus  name="UserName" pattern="[A-za-z]{3,10}"></td>
		</tr>
		<tr>
			<td><label >Password</label></td>
			<td><input type="password" required autofocus name="Password" pattern="[A-Za-z0-9]{5,15}"></td>
		</tr>

		<tr>
			<td><button type="submit">Submit</button></td>	
			<td><button type="reset">Reset</button></td>
		</tr>
		<tr>
		<td>
		<a href="UserRegister.jsp">Register here</a>
		</td>
		<td><a href="AdminLogin.jsp">AdminLogin</a></td>
		</tr>
		</table>
		<input type="hidden" name="T" value="1"/>
	</form>
</body>
</html>