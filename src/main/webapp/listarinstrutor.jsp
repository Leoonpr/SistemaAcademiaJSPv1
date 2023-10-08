<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Intrutores</title>
</head>
<body>
	<c:forEach var="instrutor" items="${instrutores}">
		<p> ${instrutor.id} - ${instrutor.nome} - ${instrutor.especialidade}</p>
	</c:forEach>
</body>
</body>
</html>