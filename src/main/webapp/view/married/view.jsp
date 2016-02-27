<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VIEW MARRIED PERSON</title>
</head>
<body>
	<h1>${single.firstname}</h1>
	<ul>
		<li>${married.firstname}</li>
		<li>${married.lastname}</li>
		<li>${married.passportNumber}</li>
	</ul>
	<a href="/helloProjectWeb/singles">list persons</a>

</body>
</html>