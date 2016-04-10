<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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

		<form:form class="form-horizontal" action="/helloProjectWeb/married"
			method="POST" commandName="married">
			<input type="hidden" name="add">

			<!-- # # -->
			<spring:bind path="firstname">
				<div class="form-group	${status.error ? 'has-error' : '' }">
					<label for="firstName" class="col-sm-2 control-label">First
						Name :</label>
					<div class="col-sm-6">
						<form:input type="text" path="firstname" class="form-control"
							id="firstname" placeholder="Last Name" />
					</div>
					<div class="col-sm-4">
						<strong><form:errors path="firstname"
								cssClass="help-inline alert-danger" /></strong>
					</div>
				</div>
			</spring:bind>
			<!-- # # -->

			<spring:bind path="lastname">
				<div class="form-group	${status.error ? 'has-error' : '' }">
					<label for="lastname" class="col-sm-2 control-label">Last
						Name :</label>
					<div class="col-sm-6">
						<form:input type="text" path="lastname" class="form-control"
							id="lastname" placeholder="Last Name" />
					</div>
					<div class="col-sm-4">
						<strong><form:errors path="lastname"
								cssClass="alert-danger"></form:errors></strong>
					</div>
				</div>
			</spring:bind>


			<!-- ######## -->
			<spring:bind path="dob">
				<div class="form-group	${status.error ? 'has-error' : '' }">
					<label for="dob" class="col-sm-2 control-label">Date Of
						Birth :</label>
					<div class="col-sm-6">
						<form:input type="text" class="form-control date" path="dob"
							placeholder="Date Of Birth" />
					</div>

					<div class="col-sm-4 ">
						<strong><form:errors path="dob" cssClass="help-inline alert-danger"></form:errors></strong>
					</div>
				</div>
			</spring:bind>
			<!-- ### ##### -->


			<!-- #### Buttons #### -->
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