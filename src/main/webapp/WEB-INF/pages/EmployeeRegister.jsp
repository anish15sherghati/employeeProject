<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Welcome to Employee Register</h3>
<form action="save" method="POST">
Name: <input type="text" name="empName"/><br>
Salary:<input type="text" name="empSal"/><br>
<input type="submit" value="Register"/><br>
</form>
${message}
</body>
</html>