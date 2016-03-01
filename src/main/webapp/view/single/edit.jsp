<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EDIT SINGLE PERSON</title>
</head>
<body>
	<form action="/helloProjectWeb/single?edit&id=${single.id}"
		method="POST">
		<input type="hidden" name="edit">
		<ul>
			<li>First name : <input type="text" name="firstname"
				value="${single.firstname}">
			</li>
			<li>Last name : <input type="text" name="lastname"
				value="${single.lastname}">
			</li>
			<li>DOB : <input type="text" name="dob" value="${single.dob}">
			</li>
			<c:set var="passport" value="${single.passport}"></c:set>
			<li>Passport Number : <input type="text" name="passportnumber"
				value="${passport.passportNumber}">
			</li>
			<li>Valid Date : <input type="text" name="valid_date"
				value="${passport.valid_date}">dd-M-yyyy
			</li>
			<li>married friend :<select name="marriedf">
					<option value="0">--select--</option>
					<c:forEach var="marriedf" items="${marriedfs}">
						<c:choose>
							<c:when test="${marriedf == single.marriedFriend}">
								<option value="${marriedf.id}" selected>${marriedf.lastname}</option>
							</c:when>
							<c:otherwise>
								<option value="${marriedf.id}">${marriedf.lastname}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
			</select></li>

			<li>single friend :<select name="singlef">
					<option value="0">--select--</option>
					<c:forEach var="singlef" items="${singlefs}">
						<c:choose>
							<c:when test="${singlef == single.singleFriend}">
								<option value="${singlef.id}" selected>${singlef.lastname}</option>
							</c:when>
							<c:otherwise>
								<option value="${singlef.id}">${singlef.lastname}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
			</select></li>
		</ul>
		<input type="submit" value="edit">
	</form>
	<a href="/helloProjectWeb/persons">Go back to the list of persons</a>
</body>
</html>