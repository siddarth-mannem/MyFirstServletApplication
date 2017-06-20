<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<h2>Welcome to My First Web Application</h2>

<form action="/MyFirstServletApplication/userLogin" method="post">

  <c:if test="${not empty userNameErr}">
			<p style="color:red">
				<c:out value="${userNameErr}" />
			</p>
		</c:if>
		
		<c:if test="${not empty passwordErr}">
			<p style="color:red">
				<c:out value="${passwordErr}" />
			</p>
		</c:if>
		
		username: <input type="text" value="" name ="userName"/> </br>
		
		password: <input type="password" value="" name= "password"/> </br>
		
		<input type="submit" value="Login" />


</form>

</body>
</html>