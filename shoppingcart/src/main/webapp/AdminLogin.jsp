<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
</head>
<body bgcolor="pink">
<form action="AdminLoginCheck" method="post">
<table align="center">
	<caption>Admin Login Page</caption>
	
	<tr>
			<td><label >Email:</label></td>	
			<td><input type="text" required autofocus  name="email" ></td>
		</tr>
		<tr>
			<td><label >Password:</label></td>
			<td><input type="password" required autofocus name="password"></td>
		</tr>

		<tr>
			<td><button type="submit">Login</button></td>	
			<td><button type="reset">Cancel</button></td></tr>
			<tr><td><a href="index.jsp">UserLogin</a></td>
		</tr>
	
		</table>
		<input type="hidden" name="T" value="1"/>
	</form>
</body>
</html>