<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Visualização de Pessoas</title>
</head>
<body>
	<%@ page import="com.github3.dao.*, com.github3.beans.*, java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<h1>Listagem de Pessoas</h1>
	
	<%
	List<Pessoa> list = PessoaDao.getAllPessoas();
	request.setAttribute("list", list);
	%>
	
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Civil</th>
			<th>Sexo</th>
			<th>Editar</th>
			<th>Excluir</th>
		</tr>
		<c:forEach items="${list}" var="pessoa">
			<tr>
				<td>${pessoa.getId()}</td>
				<td>${pessoa.getNome()}</td>
				<td>${pessoa.getCivil()}</td>
				<td>${pessoa.getSexo()}</td>
				<td><a href="editform.jsp?id=${pessoa.getId()}">Editar</a></td>
                <td><a href="deletepessoa.jsp?id=${pessoa.getId()}">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<br>
	
	<a href="addpessoaform.jsp">Adicionar Nova Pessoa</a>

</body>
</html>