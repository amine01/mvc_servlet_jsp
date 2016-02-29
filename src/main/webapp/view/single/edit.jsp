<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EDIT SINGLE PERSON</title>
</head>
<body>
	<form action="/helloProjectWeb/single?edit&id=${single.id}"
		method="POST">
		<input type="hidden" name="edit">
		<ul>
			<li>First name : <input type="text" name="firstname"
				value="${single.firstname}">
			</li>
			<li>Last name : <input type="text" name="lastname"
				value="${single.lastname}">
			</li>
			<li>DOB : <input type="text" name="dob" value="${single.dob}">
			</li>
			<c:set var="passport" value="${single.passport}"></c:set>
			<li>Passport Number : <input type="text" name="passportnumber"
				value="${passport.passportNumber}">
			</li>
			<li>Valid Date : <input type="text" name="valid_date"
				value="${passport.valid_date}">dd-M-yyyy
			</li>
		</ul>
		<input type="submit" value="edit">
	</form>
		<a href="/helloProjectWeb/persons">Go back to the list of persons</a>
</body>
</html>