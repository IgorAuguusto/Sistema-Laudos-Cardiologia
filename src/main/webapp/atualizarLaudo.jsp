<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="autenticacaoDocente.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="style.css">
</head>
<body>

	<div class="center center_geraLaudo">
		<h1>Laudo</h1>
		<form method="post" action="Controller">
			<h2>Dados do Laudo</h2>
			<p class="paragraph">
				<span><strong>ID: </strong>${laudo.id}</span>
			</p>
			<p class="paragraph">
				<span><strong> Exame ID: </strong> ${laudo.exameId}</span>
			</p>
			<p class="paragraph">
				<span><strong>Conclusão: </strong> ${laudo.conclusao}</span>
			</p>
			<p class="paragraph">
				<span><strong>Status: </strong>${laudo.getStatusStr()}</span>
			</p>
			<p><strong>Descrição:</strong></p>
			<div class="container_descricao">
				<p>${laudo.descricao}</p>
			</div>
			<div class="button_div">
				<input type="hidden" value="AtualizarLaudo" name="logica" />
				<input type="hidden" name="laudoId" value="${laudo.id}" /> 
				<input class="save" type="submit" value="Definir Laudo Como Definitivo" />
				
				<a class="button_link" href="revisarLaudos.jsp" class="button-link">Voltar</a>
			</div>
		</form>
	</div>
</body>
</html>
