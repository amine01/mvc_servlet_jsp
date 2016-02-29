<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="person" items="${persons}">
		<li><c:out value="${person.firstname}" /> <c:out
				value="${person.lastname}" /> <a
			href="${person.url}&edit">Edit</a> | <a
			href="${person.url}&delete=${person.id}">Delete</a> |
			<a href="${person.url}&view=${person.id}">View</a></li>
			</li>
		<!-- url -->
	</c:forEach>
	<a href="/helloProjectWeb/single?add">add a single person</a> |
	<a href="/helloProjectWeb/married?add">add a married person</a>

</body>
</html>