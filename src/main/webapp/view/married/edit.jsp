<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
			format: 'dd-mm-yyyy',
			});
	});
</script>
<title>EDIT MARRIED PERSON</title>
</head>
<body>
	<div class="container">
		<h1>${married.firstname}&nbsp;${married.firstname}&nbsp;<small>Edit</small>
		</h1>
		<form:form class="form-horizontal" commandName="married"
			action="/helloProjectWeb/married?edit&id=${married.id}" method="POST">
			<input type="hidden" name="edit">

			<spring:bind path="firstname">
				<div class="form-group	${status.error ? 'has-error' : '' }">
					<label class="control-label col-sm-2">First name : </label>
					<div class="col-sm-6">
						<form:input class="form-control" type="text" path="firstname"
							name="firstname" value="${married.firstname}" />
					</div>
					<div class="col-sm-4">
						<strong><form:errors path="firstname"
								cssClass="help-inline alert-danger" /></strong>
					</div>
				</div>
			</spring:bind>

			<spring:bind path="lastname">
				<div class="form-group	${status.error ? 'has-error' : '' }">
					<label class="control-label col-sm-2">Last name :</label>
					<div class="col-sm-6">
						<form:input class="form-control" type="text" path="lastname"
							name="lastname" value="${married.lastname}" />
					</div>
					<div class="col-sm-4">
						<strong><form:errors path="lastname"
								cssClass="help-inline alert-danger" /></strong>
					</div>
				</div>
			</spring:bind>

			<spring:bind path="dob">
				<div class="form-group	${status.error ? 'has-error' : '' }">
					<label for="dob" class="col-sm-2 control-label">Date Of
						Birth :</label>
					<div class="col-sm-6">
						<form:input type="text" class="form-control date" path="dob"
							name="dob" value="${married.dob}" />
					</div>
					<div class="col-sm-4">
						<strong><form:errors path="dob"
								cssClass="help-inline alert-danger" /></strong>
					</div>
				</div>
			</spring:bind>

			<div class="col-sm-offset-2 col-sm-10">
				<input class="btn btn-default" type="submit" value="Edit"> <a
					href="/helloProjectWeb/persons" class="btn btn-default">Go back
					to the list of persons</a>
			</div>
		</form:form>
	</div>
</body>
</html>