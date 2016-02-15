<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="person" items="${persons}">
		<li><a href="#"><c:out value="${person.firstname}" /></a></li>
		<li><a href="#"><c:out value="${person.lastname}" /></a></li>
		<li><a href="#"><c:out value="${person.dob}" /></a></li>
		<%--  <c:if test="${not empty person.passportID}"> --%>
		<li><a href="#"><c:out value="${person.passportID}" /></a></li>


	</c:forEach>

</body>
</html>