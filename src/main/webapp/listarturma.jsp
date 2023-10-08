<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Turmas</title>
</head>
<body>
	<c:forEach var="turma" items="${turmas}"> 
	<p>${turma.id}) Nome: ${turma.nome} - Dias da semana: ${turma.dia} - Horario: ${turma.horario}</p>
	</c:forEach>
</body>
</html>