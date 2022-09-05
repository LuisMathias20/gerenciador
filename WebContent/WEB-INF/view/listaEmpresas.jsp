<%@page import="java.util.List"%>
<%@page import="br.com.alura.gerenciador.modelo.Empresa"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
		<title>Listar empresas</title>
	</head>
	<body>
		<c:import url="logout-parcial.jsp" />
	
		Usuario Logado: ${usuarioLogado.login}
	
		<c:if test="${not empty empresa}">
			Empresa cadastrada com sucesso:	${empresa}
		</c:if>		
	
		Lista de empresas: <br />
		
		<ul> 
			<c:forEach items="${empresas}" var="empresa">
				<li>
					${empresa.id} - ${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
					<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}">edita</a>
					<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id}">remove</a>
				</li>
			</c:forEach>
		</ul>
	
	</body>
</html>