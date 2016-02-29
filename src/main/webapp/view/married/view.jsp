<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VIEW MARRIED PERSON</title>
</head>
<body>
	<h1>${married.firstname}</h1>
	<ul>
		<li>${married.firstname}</li>
		<li>${married.lastname}</li>
		<li>${married.dob}</li>

		<hr>
		<h3>Children</h3>
		<c:forEach var="child" items="${married.children}">
			<li>${child.firstname}<a href="${child.url}&view">View</a> | <a href="${child.url}&delete&id_ma=${married.id}">Delete</a></li>
		</c:forEach>
	</ul>
	<a href="child?id=${married.id}&add">Add a child</a>
	<a href="persons">Go back to the list of persons</a>

</body>
</html>