<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register here</title>
</head>
<body>
<h1 align="center">User Registration</h1>
<hr style="width:50%"/>
<c:if test="${not empty passwordErr}">
			<p style="color:red;text-align:center">
				<c:out value="${passwordErr}" />
			</p>
		</c:if>
<c:if test="${not empty error}">
			<p style="color:red;text-align:center">
				<c:out value="${error}" />
			</p>
		</c:if>
<form action="register" method="post" style="text-align:right;">
<table align="center" cellspacing="5" cellpadding="5">
<tr>
<td><label for="Fname">First Name :</label><input type="text" name="fname"/></td>
</tr>
<tr>
<td><label for="Lname">Last Name :</label><input type="text" name="lname"/></td>
</tr>
<tr>
<td><label for="Uname">User Name :</label><input type="text" name="uname"/></td>
</tr>
<tr>
<td><label for="pass">Password :</label><input type="password" name="pass"/></td>
</tr>
<tr>
<td><label for="security_key">Security Key :</label><input type="password" name="security_key"/></td>
</tr>
<tr>
<td><input type="submit" value="Register"/></td>
</tr>
</table>

</form>
<h5><a href="index.jsp">Go To Home</a></h5>


</body>
</html>