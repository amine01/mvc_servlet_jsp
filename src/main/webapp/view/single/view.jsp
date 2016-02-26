<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VIEW SINGLE PERSON</title>
</head>
<body>
	<h1>${single.firstname}</h1>
	<ul>
		<li>${single.firstname}</li>
		<li>${single.lastname}</li>
		<li>${passport.passportNumber}</li>
	</ul>
	<a href="/helloProjectWeb/singles">list persons</a>

</body>
</html>