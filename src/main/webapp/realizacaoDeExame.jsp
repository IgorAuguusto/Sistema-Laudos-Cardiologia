<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="sistema.laudo.model.dao.ExameDao"%>
<%@ page import="sistema.laudo.model.entities.Exame"%>
<%@ page import="sistema.laudo.model.entities.StatusExame"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="autenticacaoResidente.jsp" %>

<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="styleRealizacaoExame.css">
</head>
<body>

	
	<c:set var="exameList" value="${ExameDao.pesquisarTodosExames()}" />

	<c:set var="exameListFiltrada" value="${exameList.stream().filter(e -> e.getStatusStr().equals(StatusExame.AGUARDANDO_EXAME.getStatusExame())).toList()}" />
	<div id="conteiner-principal">
		<table border="1">
			<thead>
				<tr>
					<th>ID</th>
					<th>CPF do Paciente</th>
					<th>Tipo de Exame</th>
					<th>Status</th>
					<th>Hipótese</th>
					<th>Data do Pedido</th>
					<th>Médico CRM</th>
					<th>Nome do Médico</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="exame" items="${exameListFiltrada}">
					<tr>
						<td>${exame.id}</td>
						<td>${exame.pacienteCpf}</td>
						<td>${exame.tipoExame}</td>
						<td>${exame.statusStr}</td>
						<td>${exame.hipotese}</td>
						<td>${exame.dataPedidoStr}</td>
						<td>${exame.medicoCrm}</td>
						<td>${exame.nomeMedico}</td>
						<td>
							<form method="post"
								action="Controller">
								<input type="hidden" value="RealizarExame" name="logica">
								<input type="hidden" name="examePacienteCpf" value="${exame.pacienteCpf}" /> 
								<input type="submit" value="Realizar Exame"/>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="button-link-div">
			<a href="paginaPrincipal.jsp" class="button-link">Voltar</a>
		</div>
	</div>

</body>
</html>
