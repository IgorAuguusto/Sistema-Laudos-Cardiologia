<%@ page import="java.util.List"%>
<%@ page import="sistema.laudo.model.dao.ExameDao"%>
<%@ page import="sistema.laudo.model.entities.Exame"%>
<%@ page import="sistema.laudo.model.entities.StatusExame"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="autenticacaoResidente.jsp"%>

<html>
<head>
<meta charset="UTF-8">
<title>Sistema de Laudos</title>
<link rel="icon" href="imagens/icon.png">
<link rel="stylesheet" href="styleLaudos.css">
</head>
<body>


	<c:set var="exameList" value="${ExameDao.pesquisarTodosExames()}" />

	<c:set var="exameListFiltrada"
		value="${exameList.stream().filter(e -> e.getStatusStr().equals(StatusExame.AGUARDANDO_LAUDO.getStatusExame())).toList()}" />
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
							<form method="post" action="Controller" target="_blank">
								<input type="hidden" name="examePdf" value="${exame.pdf}" /> 
								<input type="hidden" value="VisualizarPDF" name="logica" />
								<input class="gerar-pdf-button" type="submit" value="Visualizar PDF" name="logica" />
								
							</form>
						</td>
						<td>
							<form method="post" action="Controller">
								<div id="conteiner-laudo">
	                                 <input type="hidden" name="exameCpf" value="${exame.pacienteCpf}" /> 
									<input type="hidden" value="GerarLaudo" name="logica" />
									<input class="gerar-pdf-button" type="submit" value="Gerar Laudo" name="logica" />	
								</div>
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
