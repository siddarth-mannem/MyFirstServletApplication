<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Hellooo... Below are list of all users in your Data base</h1>

	<table style="width: 100%">
	
		<tr>
			<th>User Id</th>
			<th>Firstname</th>
			<th>Lastname</th>
			<th>UserName</th>
			<th>Created Date</th>
			<th>Updated Date</th>
		</tr>
		
		<c:forEach var="user" items="${usersList}">
			<tr>
				<td><c:out value="${user.userId}"/></td>
				<td><c:out value="${user.firstName}"/></td>
				<td><c:out value="${user.lastName}"/></td>
				<td><c:out value="${user.username}"/></td>
				<td><c:out value="${user.createDate}"/></td>
				<td><c:out value="${user.updatedDate}"/></td>
			</tr>
		</c:forEach>
		
	</table>

</body>
</html>