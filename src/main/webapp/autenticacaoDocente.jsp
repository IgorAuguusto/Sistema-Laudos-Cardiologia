<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="sistema.laudo.model.entities.MedicoDocente"%>
<%@ page import="sistema.laudo.model.entities.Medico"%>
<%@ include file="autenticacao.jsp" %>

<%! 
    public boolean isMedicoDocente(Medico medico) {
		return medico instanceof MedicoDocente;
    }
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
	 <c:if test="<%=!isMedicoDocente((Medico)session.getAttribute(\"medico\"))%>">
    	<jsp:forward page="login.jsp" />
	 </c:if>
</body>
</html>