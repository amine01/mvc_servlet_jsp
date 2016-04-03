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
<title>EDIT CHILD PERSON</title>
</head>
<body>

	<div class="container">
	
	<div class="row">
			<h2>${child.firstname}&nbsp;${child.married.lastname}&nbsp;<small>Edit</small></h2>
		</div>
		<form action="/helloProjectWeb/child?edit&id=${child.id}"
			method="POST" class="form-horizontal">

			<input type="hidden" name="edit">
			<div class="form-group">
				<label class="control-label col-sm-2">First name : </label>
				<div class="col-sm-10">
					<input type="text" name="firstname" class="form-control"
						value="${child.firstname}">
				</div>
			</div>

			<c:set var="passport" value="${child.passport}"></c:set>

			<div class="form-group">
				<label class="control-label col-sm-2">Passport Number :</label>

				<div class="col-sm-10">
					<input type="text" name="passportnumber"
						value="${passport.passportNumber}" class="form-control" data-mask="aa9999">
				</div>
			</div>
			
			<div class="form-group">
				<label for="dob" class="col-sm-2 control-label">Valid Date : </label>
				<div class="col-sm-10">
					<input type="text" class="form-control date" name="valid_date"
						value="${passport.valid_date}">
				</div>
			</div>			
			


			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" value="Edit" class="btn btn-default"> <a
					class="btn btn-default" href="${child.married.url}&view">Go back to
					${child.married.firstname}</a>
			</div>
		</form>
	</div>
</body>
</html>