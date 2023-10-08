<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Atividades</title>

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
	<form action="AtividadeAdd" method="get">
		<label>Nome:</label> 
		<input type="text" name="nome"> <br>
		<br> <br>
		<input class="btnSubmit" type="submit">
		
		
	</form>
</body>
</html>