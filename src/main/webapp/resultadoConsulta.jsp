<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="sistema.laudo.model.entities.Laudo"%>
<%@ page import="sistema.laudo.model.entities.StatusLaudo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="autenticacaoMedico.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="styleRealizacaoExame.css">
</head>
<body>
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
				<c:if test="${not empty sessionScope.laudoS}">
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
									<input type="hidden" name="exameId" value="${laudo.exameId}" /> <input
										type="submit" value="Consultar" />
								</form>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		<div class="button-link-div">
			<a href="consulta.jsp" class="button-link">Voltar</a>
		</div>
	</div>

</body>
</html>