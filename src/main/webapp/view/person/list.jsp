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
<title>Insert title here</title>
</head>
<body>
	<div class="container">

		<div class="row">
			<h2>Management Personnel List</h2>
		</div>
		<div class="row">
			<p>
				<a class="btn btn-primary btn-sm" href="/helloProjectWeb/single?add">
					<span class="glyphicon glyphicon-plus"></span> Single Person
				</a> <a class="btn btn-primary btn-sm"
					href="/helloProjectWeb/married?add"><span
					class="glyphicon glyphicon-plus"></span> Married Person</a>
			</p>
		</div>
		<div class="row">

			<c:if test="${persons.size()>0}">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr class="bg-info">
							<th class="text-center">First Name</th>
							<th class="text-center">Last Name</th>
							<th class="text-center"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="person" items="${persons}">
							<tr>
								<td class="text-center"><c:out value="${person.firstname}" /></td>
								<td class="text-center"><c:out value="${person.lastname}" /></td>
								<td class="text-center"><a class="btn btn-warning btn-xs"
									href="${person.url}&edit" title="Edit"> <span
										class="glyphicon glyphicon-pencil"></span>
								</a> <a class="btn btn-danger btn-xs" href="${person.url}&delete"
									title="Delete"> <span class="glyphicon glyphicon-trash"></span></a>
									<a class="btn btn-primary btn-xs" href="${person.url}&view"
									title="View"> <span class="glyphicon glyphicon-eye-open"></span>
								</a></td>
							</tr>
							<!-- url -->
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>

</body>
</html>