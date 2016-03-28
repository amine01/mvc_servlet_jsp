<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset='utf-8'">
<link rel = "stylesheet" href = "assets/css/bootstrap.min.css" >
<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
<!-- assets/css/bootstrap.css -->
<title>Insert title here</title>
</head>
<body>
	<button class="btn btn-primary"> OK </button>
	<c:forEach var="person" items="${persons}">
		<li><c:out value="${person.firstname}" /> <c:out
				value="${person.lastname}" /> <a href="${person.url}&edit">Edit</a>
			| <a href="${person.url}&delete">Delete</a> | <a
			href="${person.url}&view">View</a></li>
		<!-- url -->
	</c:forEach>
	<a href="/helloProjectWeb/single?add">add a single person</a> |
	<a href="/helloProjectWeb/married?add">add a married person</a>
</body>
</html>