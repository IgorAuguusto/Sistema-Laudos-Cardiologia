<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="sistema.laudo.model.entities.Laudo"%>
<%@ page import="sistema.laudo.model.entities.StatusLaudo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="autenticacao.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="styleRealizacaoExame.css">
</head>
<body>
	<c:import url="cabecalho.jsp" />
	
	<c:if test="${not empty sessionScope.laudoS}">
		<div id="conteiner-principal">
			<table border="1">
				<thead>
					<tr>
						<th>ID</th>
						<th>ID Exame</th>
						<th>Médico CRM</th>
						<th>Conclusao</th>
						<th>Status</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="laudo" items="${sessionScope.laudoS}">
						<tr>
							<td>${laudo.id}</td>
							<td>${laudo.exameId}</td>
							<td>${laudo.crm}</td>
							<td>${laudo.conclusao}</td>
							<td>${laudo.getStatusStr()}</td>
							<td>
								<form method="post" action="Controller">
									<input type="hidden" value="VisualizarConsulta" name="logica">
									<input type="hidden" name="exameId" value="${laudo.exameId}" />
									<input type="submit" value="Consultar" />
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="button-link-div">
				<a href="consulta.jsp" class="button-link">Voltar</a>
			</div>
		</div>
	</c:if>
	
	<c:if test="${empty sessionScope.laudoS}">
		<div class="center">
			<h1>Não há laudos definitivos</h1>
			<div class="button-link-div">
				<a href="paginaPrincipal.jsp" class="button-link">Voltar</a>
			</div>
		</div>
	</c:if>

</body>
</html>