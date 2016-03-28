<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset='utf-8'">
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="https://code.jquery.com/jquery.js"></script>
<!-- assets/css/bootstrap.css -->
<title>Insert title here</title>
</head>
<body>
	<div class="container">

		<div class="row">
			<h2>Management Personnel List</h2>
		</div>
		<div class="row">
			<p>
				<a class="btn btn-default btn-xs" href="/helloProjectWeb/single?add">
					<span class="glyphicon glyphicon-plus"></span> Single Person
				</a> <a class="btn btn-default btn-xs"
					href="/helloProjectWeb/married?add"><span
					class="glyphicon glyphicon-plus"></span>Married Person</a>
			</p>
		</div>
		<div class="row">

			<c:if test="${persons.size()>0}">
				<table class="table table-striped table-bordered table-hover">
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Edit</th>
						<th>Delete</th>
						<th>View</th>
					</tr>

					<c:forEach var="person" items="${persons}">
						<tr>
							<td><c:out value="${person.firstname}" /></td>
							<td><c:out value="${person.lastname}" /></td>
							<td><a href="${person.url}&edit">Edit</a></td>
							<td><a href="${person.url}&delete">Delete</a></td>
							<td><a href="${person.url}&view">View</a></td>
						</tr>
						<!-- url -->
					</c:forEach>

				</table>
			</c:if>
		</div>
	</div>

</body>
</html>