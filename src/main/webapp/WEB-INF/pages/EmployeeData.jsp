<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>WELCOME TO EMPLOYEE DATA PAGE'S !!</h3>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Salary</th>
		</tr>
		
		<c:forEach items="${employees}" var="emp">
		<tr>
			<td>${emp.empId}</td>
			<td>${emp.empName}</td>
			<td>${emp.empSal}</td>
		</tr>
		</c:forEach>
		
	</table><br>
	<a href="delete?eid=${empId}">Delete</a>
</body>
</html>