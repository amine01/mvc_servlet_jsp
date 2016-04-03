<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix='form' %>


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


<title>ADD SINGLE PERSON</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h2>Add Single Personnel</h2>
		</div>
	
		<form:form action="/helloProjectWeb/single"  method="POST" modelAttribute="single"
			class="form-horizontal">
			
				<form:errors path="*" ></form:errors>
				
			<input type="hidden" name="add">

			<div class="form-group">
				<label for="firstname" class="col-sm-2 control-label">First
					name :</label>
				<div class="col-sm-10">
					<input id="firstname" class="form-control" type="text"
						name="firstname" placeholder="First Name">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="lastname">Last
					Name :</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="lastname"
						placeholder="Last Name" name="lastname">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="dob">Date Of
					Birth :</label>
				<div class="col-sm-10">
					<input class="form-control date" name="dob" id="dob"
						placeholder="Date Of Birth" type="text">
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="passportid">Passport
					Number :</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="passportnumber"
					id="passportid" placeholder="Passport Number" data-mask="aa9999">
						
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="valid_date">Valid
					Date :</label>
				<div class="col-sm-10">
					<input class="form-control date" name="valid_date" id="valid_date"
						placeholder="Valid Date" type="text">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" value="add" class="btn btn-default"> <a
						href="/helloProjectWeb/persons" class="btn btn-default">Personnel
						List</a>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>