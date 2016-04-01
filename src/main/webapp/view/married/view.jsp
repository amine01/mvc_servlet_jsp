<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/bootstrap.css">


<script src="https://code.jquery.com/jquery.js"></script>
<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

<title>VIEW MARRIED PERSON</title>
</head>
<body>
	<div class="container">
		<h1>${married.firstname}
			${married.lastname} <small> ${married.dob}</small>
		</h1>


		<hr>
		<h3>Children</h3>
		<!-- ############ -->
		<div class="row">
			<c:if test="${married.children.size()>0}">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr class="bg-info">
							<th class="text-center">First Name</th>
							<th class="text-center">Last Name</th>
							<th class="text-center"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="child" items="${married.children}">
							<tr>
								<td class="text-center"><c:out value="${child.firstname}" /></td>
								<td class="text-center"><c:out
										value="${child.married.lastname}" /></td>
								<td class="text-center"><a class="btn btn-danger btn-xs"
									href="${child.url}&delete" title="Delete"> <span
										class="glyphicon glyphicon-trash"></span></a> <a
									class="btn btn-primary btn-xs" href="${child.url}&view"
									title="View"> <span class="glyphicon glyphicon-eye-open"></span>
								</a></td>
							</tr>
							<!-- url -->
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
		<!-- ############## -->
		<a href="child?id=${married.id}&add" class="btn btn-default">Add a
			child</a> <a href="persons" class="btn btn-default">Go back to the
			list of persons</a>
	</div>
</body>
</html>