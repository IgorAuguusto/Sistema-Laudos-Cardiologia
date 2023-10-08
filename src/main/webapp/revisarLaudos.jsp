<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="sistema.laudo.model.dao.LaudoDAO"%>
<%@ page import="sistema.laudo.model.entities.Laudo"%>
<%@ page import="sistema.laudo.model.entities.StatusLaudo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="autenticacaoDocente.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="styleRealizacaoExame.css">
</head>
<body>
	<c:set var="laudoList" value="${LaudoDAO.pesquisarTodosLaudos()}" />
	
	<c:set var="laudoListFiltrada" value="${laudoList.stream().filter(l -> l.getStatusStr().equals(StatusLaudo.PROVISORIO.getStatusLaudo())).toList()}" />
	
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
				<c:forEach var="laudo" items="${laudoListFiltrada}">
					<tr>
						<td>${laudo.id}</td>
						<td>${laudo.exameId}</td>
						<td>${laudo.crm}</td>
						<td>${laudo.conclusao}</td>
						<td>${laudo.getStatusStr()}</td>
						<td>
							<form method="post" action="Controller">
								<input type="hidden" value="RevisarLaudo" name="logica">
								<input type="hidden" name="laudoId" value="${laudo.id}" /> 
								<input type="submit" value="Revisar Laudo"/>
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