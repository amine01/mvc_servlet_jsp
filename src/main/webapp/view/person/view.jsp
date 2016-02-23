<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${person.firstname}</h1>
	<ul>
		<li>${person.firstname}</li>
		<li>${person.lastname}</li>
		<li>${passport.passportNumber}</li>
	</ul>
	<a href="/helloProjectWeb/persons">list persons</a>

</body>
</html>