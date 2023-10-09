<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="autenticacaoMedico.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="styleSolicitacaoExame.css">
</head>
<body>
	<div class="center consulta">
		<h1>Consulta</h1>
		<form method="post" action="Controller"> 
		<input type="hidden" value="Consulta" name="logica">
			<div class="txt_field">
				<input type="text" name="paciente" required> <span></span> 
				<label>Informe o CPF do paciente</label>
			</div>
			
			<input type="submit" value="Solicitar exame">
			
			<div class="button-link-div">
				<a href="paginaPrincipal.jsp" class="button-link">Voltar</a>
			</div>
		</form>
	</div>
</body>
</html>
