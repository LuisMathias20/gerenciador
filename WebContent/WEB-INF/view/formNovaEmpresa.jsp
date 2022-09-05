<%@page import="java.util.List"%>
<%@page import="br.com.alura.gerenciador.modelo.Empresa"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada?acao=NovaEmpresa" var="linkServletNovaEmpresa"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<c:import url="logout-parcial.jsp" />
	
		<form action="${linkServletNovaEmpresa}" method="post">
			<p>
				Nome: <input type="text" name="nome">
				Data Abertura: <input type="text" name="data"> 
				<input type="submit" />
			</p>
		</form>
	</body>
</html>