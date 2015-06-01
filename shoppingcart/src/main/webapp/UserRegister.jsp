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
	<caption>Registration Page</caption>
	
		<tr>
			<td><label>UserName</label></td>	
			<td><input type="text" required autofocus name="UserName" pattern="[A-za-z]{3,20}"></td>
		</tr>
		<tr>
			<td><label >Password</label></td>	
			<td><input type="password" required autofocus name="Password" pattern="[A-Za-z0-9]{5,15}"></td>
		</tr>
		<tr>
			<td><label>Age</label></td>	
			<td><input type="text" required autofocus name="Age" pattern="[0-9]{2,3}"></td>
		</tr>
		<tr>
			<td><label>Gender</label></td>	
			<td><select name="gender">
  				<option value="Male" required autofocus name="gender">Male</option>
  				<option value="Female" required autofocus name="gender">Female</option>
  				</select>
			</td>
	    </tr>

		
		<tr>
			<td><label >Phone No</label></td>	
			<td><input type="text" required autofocus name="Phone" pattern="[+0-9]{10,15}"></td>
		</tr>
		
		<tr>
			<td><button type="submit">Submit</button></td>	
			<td><button type="reset">Reset</button></td>
		</tr>
	</table>
	<input type="hidden" name="T" value="2"/>
	</form>
</body>
</html>