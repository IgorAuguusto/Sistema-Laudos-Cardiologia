<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="sistema.laudo.model.entities.MedicoResidente"%>
<%@ page import="sistema.laudo.model.entities.MedicoDocente"%>
<%@ page import="sistema.laudo.model.entities.Medico"%>
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
	<link rel="stylesheet" href="stylePaginaPrincipal.css">
</head>
<body>
	 <div class="center">
	        <h1>Sistema de Laudos</h1>
	        <c:choose>
	            <c:when test="<%=isMedicoDocente((Medico)session.getAttribute(\"medico\"))%>">
	                <div class="button-link-div">
	                	<a href="revisarLaudos.jsp" class="button-link">Revisar Laudos</a>
	                </div>
	            </c:when>
	             <c:when test="<%=isMedicoResidente((Medico)session.getAttribute(\"medico\"))%>">
	                <div class="button-link-div">
	                	<a href="realizacaoDeExame.jsp" class="button-link">Realização de Exame</a>
	                </div>
	                <div class="button-link-div">
	                	<a href="laudos.jsp" class="button-link">Laudos</a>
	                </div>
	            </c:when>
	            <c:otherwise>
	                <div class="button-link-div">
	                	<a href="solicitacaoDeExame.jsp" class="button-link">Solicitação de Exame</a>
	                </div>
	                <div class="button-link-div">
	                <a href="consulta.jsp" class="button-link">Consulta</a>
	                </div>
	            </c:otherwise>
	        </c:choose>
	        <form  method="post" action="Controller">
	        	<input type="hidden" value="Logout" name="logica">
	        	<input id="logout" type="submit" value="Sair">
	        </form>
	  </div>
</body>
</html>
