<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Instrutor</title>

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
	<form action="InstrutorAdd" method="get">
		<label>Nome:</label> 
		<input type="text" name="nome"> <br>
		<label>CPF:</label> 
		<input type="text" name="cpf"> <br>
		<label>Email:</label> 
		<input type="text" name="email"> <br>
		<label>Telefone:</label> 
		<input type="text" name="telefone"> <br>
		<label>Especialidade:</label>
		<input type="text" name="especialidade"> <br>
		<label>Atividade: </label>
		<select name="idAtividade"> <br>
					<c:forEach var="atividade" items="${atividades}"> 
						<option value="${atividade.id}">  ${atividade.nome}
						</option> 	
					</c:forEach>
				</select>  <br>
		<br> <br>
		<input class="btnSubmit" type="submit">
		
		
	</form>
</body>
</html>