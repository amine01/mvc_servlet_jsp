<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset='utf-8'">

<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/jasny-bootstrap.min.css">

<link rel="stylesheet" href="assets/css/custom_app.css">


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
								<td class="text-center">
								
								<a class="btn btn-warning btn-xs"
									href="${person.url}&edit" title="Edit"> <span
										class="glyphicon glyphicon-pencil"></span>
								</a>
									
										<%-- <form method="post" action="${person.url}&view" id="frm_edit"> --%>
										<a class="btn btn-primary btn-xs" title="View" href="${person.url}&view"> <span
											class="glyphicon glyphicon-eye-open"></span>
										</a> <!-- 	</form> -->


									<form method="post" action="${person.url}&delete"
										id="frm_delete">
										<a class="btn btn-danger btn-xs" title="Delete"
											data-toggle="modal" data-target="#myModal"> <span
											class="glyphicon glyphicon-trash"></span></a>
									</form></td>
							</tr>
							<!-- url -->
						</c:forEach>
					</tbody>
				</table>

				<ul class="pagination">
					<c:if test="${currentPage !=1}">
						<li><a
							href="/helloProjectWeb/persons?page=${currentPage - 1}">Previous</a>
						</li>
					</c:if>

					<!-- Pagination -->

					<c:forEach begin="1" end="${noOfPages}" var="i">
						<c:choose>
							<c:when test="${currentPage eq i}">
								<li class="active"><a>${i}</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="/helloProjectWeb/persons?page=${i}">${i}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<c:if test="${currentPage lt noOfPages}">
						<li><a
							href="/helloProjectWeb/persons?page=${currentPage + 1}">Next</a>
						</li>
					</c:if>
				</ul>



				<!-- End Pagination -->

			</c:if>
		</div>

		<!-- modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title">Deletion confirmation</h4>
					</div>
					<div class="modal-body">
						<p>Are you sure you want to continue ?</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default"
							onclick="$('#frm_delete').submit();">Yes, delete</button>

						<button type="button" class="btn btn-primary" data-dismiss="modal">No,
							don't delete</button>
					</div>
				</div>
			</div>
		</div>
		<!-- End Modal -->
	</div>

</body>
</html>