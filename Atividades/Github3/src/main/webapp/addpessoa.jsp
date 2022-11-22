<%@page import="com.github3.dao.PessoaDao"%>
<jsp:useBean id="p" class="com.github3.beans.Pessoa"></jsp:useBean>
<jsp:setProperty property="*" name="p"/>

<%
	int i = PessoaDao.salvarPessoa(p);

	if(i > 0){
		response.sendRedirect("addpessoa-sucess.jsp");
	}else{
		response.sendRedirect("addpessoa-error.jsp");
	}
%>