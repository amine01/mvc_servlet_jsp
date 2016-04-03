<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/jasny-bootstrap.min.css">


<script src="https://code.jquery.com/jquery.js"></script>

<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="assets/js/bootstrap-datepicker.js" type="text/javascript"></script>
<script src="assets/js/jasny-bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript">
	// When the document is ready
	$(document).ready(function() {

		$('.date').datepicker({
			weekStart : 2
		});

	});
</script>
<title>EDIT MARRIED PERSON</title>
</head>
<body>
	<div class="container">
		<h1>${married.firstname}&nbsp;${married.firstname}&nbsp;<small>Edit</small></h1>
		<form class="form-horizontal"
			action="/helloProjectWeb/married?edit&id=${married.id}" method="POST">
			<input type="hidden" name="edit">

			<div class="form-group">
				<label class="control-label col-sm-2">First name : </label>
				<div class="col-sm-10">
					<input class="form-control" type="text" name="firstname"
						value="${married.firstname}">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Last name :</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" name="lastname"
						value="${married.lastname}">
				</div>
			</div>


			<div class="form-group">
				<label for="dob" class="col-sm-2 control-label">Date Of
					Birth :</label>
				<div class="col-sm-10">
					<input type="text" class="form-control date" name="dob"
						value="${married.dob}">
				</div>
			</div>

			<div class="col-sm-offset-2 col-sm-10">
				<input class="btn btn-default" type="submit" value="Edit"> <a
					href="/helloProjectWeb/persons" class="btn btn-default">Go back
					to the list of persons</a>
			</div>
		</form>
	</div>

</body>
</html>