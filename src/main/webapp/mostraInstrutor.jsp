<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>Nome : ${instrutor.getNome()}</p>
<p>CPF: ${instrutor.getCpf()}</p>
<p>Email: ${instrutor.getEmail()}</p>
<p>Telefone: ${instrutor.getTelefone()}</p>
<p>Especialidade: ${instrutor.getEspecialidade()}</p>

<br>
<a href="/sisacademia/index.jsp">Voltar ao Menu Inicial</a>
</body>
</html>