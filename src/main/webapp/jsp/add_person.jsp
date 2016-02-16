<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADD PERSON</title>
</head>
<body>
	<form action="/helloProjectWeb/person" method="POST">
		<input type="hidden" name="add">
		<ul>
			<li>First name : <input type="text" name="firstname">
			</li>
			<li>Last name : <input type="text" name="lastname">
			</li>
			<li>DOB : <input type="text" name="dob">
			</li>
			<li>Passport Number : <input type="text" name="passportnumber">
			</li>
			<li>Valid Date : <input type="text" name="valid_date">dd-M-yyyy
			</li>
		</ul>
		<input type="submit" value="add">
	</form>
	<a href="/helloProjectWeb/persons">go back to person list</a>
</body>
</html>