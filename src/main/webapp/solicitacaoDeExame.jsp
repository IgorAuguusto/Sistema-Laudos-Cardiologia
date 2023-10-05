<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="autenticacaoMedico.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sistema de Laudos</title>
<link rel="icon" href="imagens/icon.png">
<link rel="stylesheet" href="styleSolicitacaoExame.css">
</head>
<body>
	<div class="center">
		<h1>Solicitar Exame</h1>
		<form method="post"
			action="Controller">
			<input type="hidden" value="SolicitaExame" name="logica">
			<div class="txt_field">
				<input type="text" name="paciente" required> <span></span> <label>Informe
					o CPF do paciente</label>
			</div>
			<fieldset>
				<legend>Selecione o tipo do exame:</legend>

				<div>
					<input type="radio" class="check" name="exame"
						value="Ecocardiograma" checked /> <label for="Ecocardiograma">Ecocardiograma</label>
				</div>

				<div>
					<input type="radio" class="check" name="exame"
						value="Eletrocardiograma" /> <label for="Eletrocardiograma">Eletrocardiograma</label>
				</div>

			</fieldset>

			<select name="hipotese" required="required">
				<option value="">Selecione a Hipótese</option>
				<option value="I46 - Parada cardíaca">I46 - Parada cardíaca</option>
				<option value="I47 - Taquicardia paroxística">I47 -
					Taquicardia paroxística</option>
				<option value="I48 - Flutter e fibrilação atrial">I48 -
					Flutter e fibrilação atrial</option>
				<option value="I49 - Outras arritmias cardíacas">I49 -
					Outras arritmias cardíacas</option>
				<option value="I42 - Cardiomiopatias">I42 - Cardiomiopatias</option>
			</select> <input type="submit" value="Solicitar exame">
			
			<div class="button-link-div">
				<a href="http://localhost:8080/SistemasDeLaudosDeCardiologia/paginaPrincipal.jsp" class="button-link">Voltar</a>
			</div>
			
			<c:if test="${not empty requestScope.pacientePossuiExame}">
				<div id="error_mensagem">
					<strong>O paciente já possui o exame selecionado</strong>
				</div>
			</c:if>
			<c:if test="${not empty requestScope.pacienteNaoExiste}">
				<div id="error_mensagem">
					<strong>Paciente não encontrado no sistema</strong>
				</div>
			</c:if>
			<c:if test="${not empty requestScope.consultaMarcada}">
				<div id="error_mensagem">
					<strong>Consulta marcada com sucesso</strong>
				</div>
			</c:if>
		</form>
	</div>
</body>
</html>
