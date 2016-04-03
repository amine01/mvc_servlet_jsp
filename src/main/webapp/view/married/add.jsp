<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset='utf-8'">

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
<title>ADD MARRIED PERSON</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<h2>Add Married Personnel</h2>
		</div>

		<form class="form-horizontal" action="/helloProjectWeb/married"
			method="POST">
			<input type="hidden" name="add">
			<div class="form-group">
				<label for="firstName" class="col-sm-2 control-label">First
					Name :</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="firstname"
						id="firstName" placeholder="First Name">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">Last
					Name :</label>
				<div class="col-sm-10">
					<input type="text" name="lastname" class="form-control"
						id="lastname" placeholder="Last Name">
				</div>
			</div>


			<!-- ######## -->
			<div class="form-group">
				<label for="dob" class="col-sm-2 control-label">Date Of
					Birth :</label>
				<div class="col-sm-10">
					<input type="text" class="form-control date" name="dob"
						placeholder="Date Of Birth">
				</div>
			</div>
			<!-- ### ##### -->



			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" value="add" class="btn btn-default"> <a
						href="/helloProjectWeb/persons" class="btn btn-default">Personnel
						List</a>
				</div>
			</div>
		</form>
	</div>

</body>
</html>