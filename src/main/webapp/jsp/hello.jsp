<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello from jsp page</h1>
	<%="salut tout le monde"%>
	<br>
	<h1><%=1 + 19%></h1>
	<c:out value="${name}"/>
	<c:out value="${prenom}"/>
	<br>

</body>
</html>