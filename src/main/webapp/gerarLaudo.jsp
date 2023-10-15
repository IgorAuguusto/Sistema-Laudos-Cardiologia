<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="autenticacaoResidente.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<div class="center center_geraLaudo">
		<h1>Laudo</h1>
		<form method="post" action="Controller">
			<h2>Dados do Exame</h2>
			<p class="paragraph">
				<span><strong>ID: </strong>${exame.id}</span>
				<span><strong> Paciente CPF: </strong> ${exame.pacienteCpf}</span>
				<span><strong>Tipo: </strong> ${exame.tipoExame}</span>
			</p>
			
			<div><span><strong>Hipótese: </strong>${exame.hipotese}</span></div>
			<span><strong>Realizado em: </strong>${exame.getDataRealizacaoStr()}</span>
			
			<p class="paragraph">
				<span><strong>Médico Responsável: </strong>${exame.nomeMedico}</span>
				<span><strong>CRM: </strong>${exame.medicoCrm}</span>
			</p>
			<h2>Laudo</h2>
			

			<label for="descricao">Descrição:</label>
			<textarea id="descricao" name="descricao" rows="4" cols="50" required></textarea>

			<label for="conclusao">Conclusão</label>
			<select name="conclusao" required="required">
				<option value="">Informe a conclusão</option>
				<option value="I46 - Parada cardíaca">I46 - Parada cardíaca</option>
				<option value="I47 - Taquicardia paroxística">I47 -
					Taquicardia paroxística</option>
				<option value="I48 - Flutter e fibrilação atrial">I48 -
					Flutter e fibrilação atrial</option>
				<option value="I49 - Outras arritmias cardíacas">I49 -
					Outras arritmias cardíacas</option>
				<option value="I42 - Cardiomiopatias">I42 - Cardiomiopatias</option>
			</select>

			<div class="button_div">
				<input type="hidden" value="SalvarLaudo" name="logica" />
				<input class="save" type="submit" value="Salvar Laudo" />
				
				<a class="button_link" href="laudos.jsp" class="button-link">Voltar</a>
			</div>
		</form>
	</div>
</body>
</html>
