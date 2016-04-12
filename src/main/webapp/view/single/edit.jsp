<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/bootstrap.css">


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
			weekStart : 2
		});
	});
</script>
<title>EDIT SINGLE PERSON</title>
</head>
<body>
	<div class="container">
		
		<h1>${single.firstname}&nbsp;${single.firstname}&nbsp;<small>Edit</small></h1>
	
		<form action="/helloProjectWeb/single?edit&id=${single.id}"
			method="POST" class="form-horizontal">
			<input type="hidden" name="edit">

			<div class="form-group">
				<label for="firstName" class="col-sm-2 control-label">First
					Name :</label>
				<div class="col-sm-10">
					<input type="text" id="firstName" name="firstname"
						value="${single.firstname}" class="form-control">
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">Last Name :</label>
				<div class="col-sm-10">
					<input type="text" id="lastname" name="lastname"
						value="${single.lastname}" class="form-control">
				</div>
			</div>

			<%-- 			DOB : <input type="text" name="dob" value="${single.dob}"> --%>
			<!-- ######## -->
			<div class="form-group">
				<label for="dob" class="col-sm-2 control-label">Date Of
					Birth :</label>
				<div class="col-sm-10">
					<input type="text" class="form-control date" name="dob"
						value="${single.dob}">
				</div>
			</div>
			<!-- ### ##### -->

			<c:set var="passport" value="${single.passport}" />

			<div class="form-group">
				<label class="col-sm-2 control-label" for="passportnumber">Passport
					Number :</label>
				<div class="col-sm-10">
					<input type="text" id="passportnumber" name="passportnumber" data-mask="aa9999"
						value="${passport.passportnumber}" class="form-control">
				</div>
			</div>

			<!-- ######## -->
			<div class="form-group">
				<label for="valid_date" class="col-sm-2 control-label">Valid
					Date :</label>
				<div class="col-sm-10">
					<input type="text" class="form-control date" name="valid_date"
						value="${passport.valid_date}">
				</div>
			</div>
			<!-- ### ##### -->
			<div class="form-group">
				<label for="mfriend" class="col-sm-2 control-label">Married
					friend :</label>
				<div class="col-sm-10">
					<select id="mfriend" name="marriedf" class="form-control">
						<option value="0">--select--</option>
						<c:forEach var="marriedf" items="${marriedfs}">
							<c:choose>
								<c:when test="${marriedf == single.marriedFriend}">
									<option value="${marriedf.id}" selected>${marriedf.lastname}
										${marriedf.firstname}</option>
								</c:when>
								<c:otherwise>
									<option value="${marriedf.id}">${marriedf.lastname}
										${marriedf.firstname}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="singlef" class="col-sm-2 control-label"> Single
					friend :</label>
				<div class="col-sm-10">
					<select id="singlef" name="singlef" class="form-control">
						<option value="0">--select--</option>
						<c:forEach var="singlef" items="${singlefs}">
							<c:choose>
								<c:when test="${singlef == single.singleFriend}">
									<option value="${singlef.id}" selected>${singlef.lastname}
										${singlef.firstname}</option>
								</c:when>
								<c:otherwise>
									<option value="${singlef.id}">${singlef.lastname}
										${singlef.firstname}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" value="Edit" class="btn btn-default">
					<a class="btn btn-default" href="/helloProjectWeb/persons">Personnel
						List</a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>