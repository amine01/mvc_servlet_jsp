<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EDIT PERSON</title>
</head>
<body>
	<form action="/helloProjectWeb/person?edit&id=${person.id}" method="POST">
		<input type="hidden" name="edit">
		<ul>
			<li>First name : <input type="text" name="firstname"
				value="${person.firstname}">
			</li>
			<li>Last name : <input type="text" name="lastname"
				value="${person.lastname}">
			</li>
			<li>DOB : <input type="text" name="dob" value="${person.dob}">
			</li>
			<li>Passport Number : <input type="text" name="passportnumber"
				value="${passport.passportNumber}">
			</li>
			<li>Valid Date : <input type="text" name="valid_date"
				value="${passport.valid_date}">dd-M-yyyy
			</li>
		</ul>
		<input type="submit" value="edit">
	</form>
	<a href="/helloProjectWeb/persons">go back to person list</a>
</body>
</html>