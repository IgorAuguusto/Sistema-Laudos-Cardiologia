<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="autenticacao.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<div class="center center_geraLaudo">
		<h1>Consulta</h1>
		<form method="post" action="Controller" target="_blank">
			<h2>Dados do Exame</h2>
			<p class="paragraph">
				<span><strong>ID: </strong>${exame.id}</span> <span><strong>
						Paciente CPF: </strong> ${exame.pacienteCpf}</span> <span><strong>Tipo:
				</strong> ${exame.tipoExame}</span>
			</p>

			<div>
				<span><strong>Hipótese: </strong>${exame.hipotese}</span>
			</div>
			<span><strong>Realizado em: </strong>${exame.getDataRealizacaoStr()}</span>

			<p class="paragraph">
				<span><strong>Médico Responsável: </strong>${exame.nomeMedico}</span>
				<span><strong>CRM: </strong>${exame.medicoCrm}</span>
			</p>
			<h2>Dados do Laudo</h2>
			<p class="paragraph">
				<span><strong>ID: </strong>${laudo.id}</span> <span><strong>
						Medico CRM: </strong> ${laudo.crm}</span>
			</p>

			<div>
				<span><strong>Conclusão: </strong>${laudo.conclusao}</span>
			</div>
			<span><strong>Status: </strong>${laudo.getStatusStr()}</span>
			<p>
				<strong>Descrição:</strong>
			</p>
			<div class="container_descricao descricao">
				<p>${laudo.descricao}</p>
			</div>

			<div class="button_div">
				<input type="hidden" name="tipoExame" value="${exame.tipoExame}" />
				<input type="hidden" name="exameCpf" value="${exame.pacienteCpf}" />
				<input type="hidden" value="BaixarPDF" name="logica" /> 
				<input class="gerar_pdf_button" type="submit" value="Visualizar Exame" name="logica" /> 
				<a	class="button_link" href="resultadoConsulta.jsp" class="button-link">Voltar</a>
			</div>
		</form>
	</div>
</body>
</html>
