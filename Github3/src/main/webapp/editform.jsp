<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edição de Pessoa</title>
</head>
<body>

    <%@page import="com.github3.beans.*, com.github3.dao.*" %>

    <%
        String id = request.getParameter("id");
        Pessoa pessoa = PessoaDao.getRegistroById(Integer.parseInt(id));
    %>

    <h1>Edição da Pessoa</h1>

    <form action="editpessoa.jsp" method="post">
        <input type="hidden" name="id" value="<%=pessoa.getId()%>"/>
        <table>
            <tr>
                <td>Nome: </td>
                <td><input type="text" name="nome" value="<%=pessoa.getNome()%>"/></td>
            </tr>
            <tr>
                <td>Civil: </td>
                <td><input type="text" name="civil" value="<%=pessoa.getCivil()%>"/></td>
            </tr>
            <tr>
                <td>Sexo: </td>
                <td><input type="text" name="sexo" value="<%=pessoa.getSexo()%>"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Editar Pessoa"></td>
            </tr>
        </table>
    </form>

</body>
</html>