<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Atividades</title>
</head>
<body>
	<c:forEach var="atividade" items="${atividades}">
		<p> ${atividade.id} - ${atividade.nome}</p>
	</c:forEach>
</body>
</html>