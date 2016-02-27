<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EDIT MARRIED PERSON</title>
</head>
<body>
	<form action="/helloProjectWeb/married?edit&id=${married.id}"
		method="POST">
		<input type="hidden" name="edit">
		<ul>
			<li>First name : <input type="text" name="firstname"
				value="${married.firstname}">
			</li>
			<li>Last name : <input type="text" name="lastname"
				value="${married.lastname}">
			</li>
			<li>DOB : <input type="text" name="dob" value="${married.dob}">
			</li>
		</ul>
		<input type="submit" value="edit">
	</form>
	<a href="/helloProjectWeb/persons">go back to person list</a>
</body>
</html>