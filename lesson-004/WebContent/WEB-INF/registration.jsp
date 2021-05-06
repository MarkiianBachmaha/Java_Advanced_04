<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<form action="registering" method="post">
	
		<input name="firstName" type="text" placeholder="First name"><br>
			<br> 
		<input name="lastName" type="text" placeholder="Last name"><br>
			<br> 
		<input name="email" type="text" placeholder="Login"><br>
			<br> 
		<input name="password" type="password" placeholder="Password"><br>
			<br> 
		<input name="accessLevel" type="radio" id="user" value="user" checked> 
		<label for="user">USER</label>
			<br>
		<input name="accessLevel" type="radio" id="admin" value="admin">
		<label for="admin">ADMIN</label><br>
			<br> 
		<input type="submit" value="Send">
		
	</form>

	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>