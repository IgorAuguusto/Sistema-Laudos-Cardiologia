<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sistema de Laudos</title>
	<link rel="icon" href="imagens/icon.png">
</head>
<body>
	<c:if test="${ empty sessionScope.medico }">
		<jsp:forward page="login.jsp" />
	</c:if>
</body>
</html>