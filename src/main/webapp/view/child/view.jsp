<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/bootstrap.css">


<script src="https://code.jquery.com/jquery.js"></script>
<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

<title>VIEW CHILD PERSON</title>
</head>
<body>
	<div class="container">
		<h1>${child.firstname}
			${child.married.lastname} <small>${child.passport.passportNumber}</small>
		</h1>
<a href="${child.married.url}&view" class="btn btn-default">Go back to you dad
			${child.married.firstname}</a>
	</div>


</body>
</html>