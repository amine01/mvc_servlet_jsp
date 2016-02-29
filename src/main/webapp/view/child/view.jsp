<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VIEW CHILD PERSON</title>
</head>
<body>
	<h1>${child.firstname}</h1>
	<ul>
		<li>${child.firstname}</li>
		<li>${child.passport.passportNumber}</li>
	</ul>
	<a href="${child.married.url}&view">Go back to
		${child.married.firstname}</a>

</body>
</html>