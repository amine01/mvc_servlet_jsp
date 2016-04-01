<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset='utf-8'">
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/datepicker.css">

<script src="https://code.jquery.com/jquery.js"></script>
<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="assets/js/bootstrap-datepicker.js" type="text/javascript"></script>
<script type="text/javascript">
	// When the document is ready
	$(document).ready(function() {

		$('.date').datepicker({
			weekStart : 2
		});

	});
</script>

<title>ADD CHILD PERSON</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h2>Add Child</h2>
		</div>

		<form action="/helloProjectWeb/child" method="POST"
			class="form-horizontal">

			<input type="hidden" name="add"> <input type="hidden"
				name="married_id" value="${married.id}">

			<div class="form-group">
				<label for="firstName" class="col-sm-2 control-label"> First
					Name : </label>
				<div class="col-sm-10">
					<input type="text" name="firstname" class="form-control"
						placeholder="First Name">
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

			<!--DOB : <input type="text" name="dob"> -->

			<div class="form-group">
				<label for="passportNumber" class="col-sm-2 control-label">Passport
					Number :</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="passportnumber"
						placeholder="Passport Number" id="passportNumber">
				</div>
			</div>

			<!-- ######## -->
			<div class="form-group">
				<label for="validDate" class="col-sm-2 control-label">Valid
					Until :</label>
				<div class="col-sm-10">
					<input type="text" class="form-control date" name="valid_date"
						id="validDate" placeholder="Passport's Date">
				</div>
			</div>
			<!-- ### ##### -->

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" value="Add" class="btn btn-default"> <a
						href="${married.url}&view" class="btn btn-default">Go back to
						${married.lastname}</a>
				</div>
			</div>

		</form>
	</div>
</body>
</html>