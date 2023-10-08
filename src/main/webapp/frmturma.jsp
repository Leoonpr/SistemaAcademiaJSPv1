<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Turmas</title>
<style>
	form{
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		height: 100vh;}
		
	.btnSubmit{
		cursor: pointer;
	}
	
	input, select{
		width: 250px;	
	}
	
	
</style>
	
</head>
<body>
<form action="TurmaAdd" method="get">
	<label>Nome: </label>
	<input type="text" name="nome"> <br>
	<label>Dias da Semana:</label>
	<input type="text" name="dia"> <br>
	<label>Hórario:</label>
	<input type="text" name="horario"> <br>
	<label>Instrutor:</label>
	<select name="idInstrutor"> <br>
					<c:forEach var="instrutor" items="${instrutores}"> 
						<option value="${instrutor.id}">  ${instrutor.nome} - ${instrutor.especialidade}
						</option> 	
					</c:forEach>
				</select> <br> <br>
				<input type="submit">
</form>
</body>
</html>