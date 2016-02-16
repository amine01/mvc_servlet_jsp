<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="person" items="${persons}">
		<li><a href="/helloProjectWeb/person?id=${person.id}"><c:out
					value="${person.firstname}" /> <c:out value="${person.lastname}" /></a></li>


	</c:forEach>
	<a href="/helloProjectWeb/person?add">add person</a>

</body>
</html>