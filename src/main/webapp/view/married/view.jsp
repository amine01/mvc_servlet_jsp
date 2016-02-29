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
	</ul>
		<a href="/helloProjectWeb/persons">Go back to the list of persons</a>

</body>
</html>