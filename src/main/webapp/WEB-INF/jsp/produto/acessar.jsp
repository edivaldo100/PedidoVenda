<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<br />
<div style="background-color: red; color: blue;">

<c:forEach var="error" items="${errors}">
${error.category} - ${error.message}<br />
</c:forEach>
</div>
<form action="http://localhost:8080/vraptor-blank-project/produto/salvar">
<input type="text" name="produto.nome" pleceholder = "Nome">

<input type="number" name="produto.preco" pleceholder = "Preço">
<input type="submit" value="SALVAR">
</form>
<br /><br />

<form action="http://localhost:8080/vraptor-blank-project/produto/pesquisar">
<input type="text" name="pesquisa" pleceholder = "Pesquisa">

<input type="submit" value="pesquisar">
</form>
<br>

<c:forEach var="produto" items="${produtos}">
${produto.nome} - ${produto.preco}<br />
</c:forEach>

</body>
</html>