<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>				
	<body>	
		<c:if test="${not empty empresa}">
			Empresa cadastrada com sucesso:	${empresa}
		</c:if>		
		
		<c:if test="${empty empresa}">
			Nenhuma empresa cadastrada!
		</c:if>	
	</body>			
</html>			