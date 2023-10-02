<%@page import="sistema.laudo.model.entities.MedicoResidente"%>
<%@page import="sistema.laudo.model.entities.MedicoDocente"%>
<%@page import="sistema.laudo.model.entities.Medico"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="autenticacao.jsp" %>
<%! 
    public boolean isMedicoDocente(Medico medico) {
        return medico instanceof MedicoDocente;
    }
%>

<%! 
    public boolean isMedicoResidente(Medico medico) {
        return medico instanceof MedicoResidente;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sistema de Laudos</title>
    <link rel="icon" href="imagens/icon.png">
    <link rel="stylesheet" href="stylePaginaPrincipal.css">
</head>
<body>
	 <div class="center">
	        <h1>Sistema de Laudos</h1>
	        <c:choose>
	            <c:when test="<%=isMedicoDocente((Medico)session.getAttribute(\"medico\"))%>">
	                <div class="button-link-div">
	                	<a href="http://localhost:8080/SistemasDeLaudosDeCardiologia/atualizarLaudo.jsp" class="button-link">Atualizar Laudo</a>
	                </div>
	            </c:when>
	             <c:when test="<%=isMedicoResidente((Medico)session.getAttribute(\"medico\"))%>">
	                <div class="button-link-div">
	                	<a href="http://localhost:8080/SistemasDeLaudosDeCardiologia/realizacaoDeExame.jsp" class="button-link">Realização de Exame</a>
	                </div>
	                <div class="button-link-div">
	                	<a href="http://localhost:8080/SistemasDeLaudosDeCardiologia/gerarLaudo.jsp" class="button-link">Gerar Laudo</a>
	                </div>
	            </c:when>
	            <c:otherwise>
	                <div class="button-link-div">
	                	<a href="http://localhost:8080/SistemasDeLaudosDeCardiologia/solicitacaoDeExame.jsp" class="button-link">Solicitação de Exame</a>
	                </div>
	                <div class="button-link-div">
	                <a href="http://localhost:8080/SistemasDeLaudosDeCardiologia/consultaExame.jsp" class="button-link">Consultar Exame</a>
	                </div>
	            </c:otherwise>
	        </c:choose>
	        <form  method="post" action="http://localhost:8080/SistemasDeLaudosDeCardiologia/Controller">
	        	<input type="hidden" value="Logout" name="logica">
	        	<input id="logout" type="submit" value="Sair">
	        </form>
	  </div>
</body>
</html>
