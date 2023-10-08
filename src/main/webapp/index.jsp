<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu - Index</title>
<style>
	li {
		list-style-type: none;
	}
	
	a{
		text-decoration: none;
		color: black;
	}
	
	a:hover {
		color: blue;
	}
	
	body{
		text-align: left;
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		height: 100vh;
	}
	
</style>
</head>
<body>
<ul>
	<li><a href="/sisacademia/frmatividade.jsp"> Registrar Atividade </a> </li> <br>
	<li><a href="/sisacademia/AtividadeListar?next=listaratividade.jsp"> Listar Atividade </a></li> <br>
	<li><a href="/sisacademia/AtividadeListar?next=frminstrutor.jsp"> Registrar Instrutor </a> </li> <br>
	<li><a href="/sisacademia/InstrutorListar?next=listarinstrutor.jsp"> Listar Instrutor </a></li> <br>
	<li><a href="/sisacademia/InstrutorListar?next=frmturma.jsp"> Regitrar Turma </a> </li><br>
	<li><a href="/sisacademia/ListarTurma?next=listarturma.jsp"> Listar Turma </a></li> <br>
	<li><a href="/sisacademia/ListarTurma?next=frmaluno.jsp"> Registrar Aluno </a></li> <br>
	
	

</ul>

	
</body>
</html>