<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Alunos</title>

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
	<form action="AlunoAdd" method="get">
		<label>Nome:</label> 
		<input type="text" name="nome"> <br>
		<label>CPF:</label> 
		<input type="text" name="cpf"> <br>
		<label>Email:</label> 
		<input type="text" name="email"> <br>
		<label>Telefone:</label> 
		<input type="text" name="telefone"> <br>
		<label>Endereço:</label> 
		<input type="text" name="endereco"> <br>
		<label>Cidade:</label> 
		<input type="text" name="cidade"> <br>
		<label>Bairro:</label> 
		<input type="text" name="bairro"> <br>
		<label>Turma:</label>
				<select name="idTurma"> <br>
					<c:forEach var="turma" items="${turmas}"> 
						<option value="${turma.id}">  
						${turma.nome} - ${turma.dia} - ${turma.horario}
						</option> 	
					</c:forEach>
				</select> <br> <br>
		<input class="btnSubmit" type="submit">
		
		
	</form>
</body>
</html>