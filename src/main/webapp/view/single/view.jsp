<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/bootstrap.css">


<script src="https://code.jquery.com/jquery.js"></script>
<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

<title>VIEW SINGLE PERSON</title>
</head>
<body>
	<div class="container">

		<h1>${single.lastname}&nbsp;${single.firstname}&nbsp;<small>Details</small></h1>
		<table class="table table-striped">
			<tr>
				<td><h4>Passport ID :</h4></td>
				<td>${single.passport.passportNumber}</td>
			</tr>
			<tr>
				<td><h4>Married Friends :</h4></td>
				<td>${single.marriedFriend.firstname}&nbsp;${single.marriedFriend.lastname}</td>
			</tr>
			<tr>
				<td><h4>Single Friends :</h4></td>
				<td>${single.singleFriend.firstname}&nbsp;${single.singleFriend.lastname}</td>
			</tr>
		</table>

		<a href="/helloProjectWeb/persons" class="btn btn-default">Go back
			to the list of persons</a>
	</div>
</body>
</html>