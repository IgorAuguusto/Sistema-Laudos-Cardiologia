<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="sistema.laudo.model.entities.Medico"%>
<%@ page import="sistema.laudo.model.entities.MedicoDocente"%>
<%@ page import="sistema.laudo.model.entities.MedicoResidente"%>
<%@ include file="autenticacao.jsp" %>

<%! 
    public boolean isSubMedico(Medico medico) {
		if (medico instanceof MedicoDocente || medico instanceof MedicoResidente){
			return true;
		}
		return false;
    }
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
	 <c:if test="<%=isSubMedico((Medico)session.getAttribute(\"medico\"))%>">
    	<jsp:forward page="login.jsp" />
	 </c:if>
</body>
</html>