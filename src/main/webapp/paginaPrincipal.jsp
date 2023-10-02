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
	                <form  method="post" action="http://localhost:8080/SistemasDeLaudosDeCardiologia/Controller">
	                	<input type="submit" value="Atualização dos Laudos">
	                </form>
	            </c:when>
	             <c:when test="<%=isMedicoResidente((Medico)session.getAttribute(\"medico\"))%>">
	                <form  method="post" action="http://localhost:8080/SistemasDeLaudosDeCardiologia/Controller">
	                	<input type="submit" value="Realização de Exame">
	                </form>
	                <form  method="post" action="http://localhost:8080/SistemasDeLaudosDeCardiologia/Controller">
	                	<input type="submit" value="Gerar Laudo Exame">
	                </form>
	            </c:when>
	            <c:otherwise>
	                <form  method="post" action="http://localhost:8080/SistemasDeLaudosDeCardiologia/Controller">
	                	<input type="submit" value="Solicitação de Exame">
	                </form>
	                <form  method="post" action="http://localhost:8080/SistemasDeLaudosDeCardiologia/Controller">
	                	<input type="submit" value="Consulta Exame">
	                </form>
	            </c:otherwise>
	        </c:choose>
	        <form  method="post" action="http://localhost:8080/SistemasDeLaudosDeCardiologia/Controller">
	        	<input type="hidden" value="Logout" name="logica">
	        	<input id="logout" type="submit" value="Sair">
	        </form>
	  </div>
</body>
</html>
