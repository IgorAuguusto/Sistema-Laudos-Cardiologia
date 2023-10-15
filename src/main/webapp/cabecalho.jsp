<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="styleCabecalho.css">
</head>
<body>
	<header>
		<c:if test="${ not empty sessionScope.medico }">
           	<div class="conteiner">
	            <div>
	            	<strong> Olá ${ sessionScope.medico.nome } </strong>
	            </div>
	            <div>
	            	<strong>CRM: ${ sessionScope.medico.crm } </strong>
	            </div>
            </div>
        </c:if>
        <form action="Controller" method="post">
            <input type="text" hidden="true" name="logica" value="Logout">
            <button class="button_saida" type="submit">Sair</button>
        </form>	
	</header>
</body>
</html>