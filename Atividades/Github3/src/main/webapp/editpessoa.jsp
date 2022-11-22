<%@page import="com.github3.dao.PessoaDao"%>
<jsp:useBean id="p" class="com.github3.beans.Pessoa"></jsp:useBean>
<jsp:setProperty property="*" name="p"/>

<%
int i = PessoaDao.updatePessoa(p);
response.sendRedirect("viewpessoas.jsp");
%>