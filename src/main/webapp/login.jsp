<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sistema de Laudos</title>
<link rel="icon" href="imagens/icon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="center">
      <h1>Sistema de Laudos</h1>
	  <form method="post" action="http://localhost:8080/SistemasDeLaudosDeCardiologia/Controller">
        <input type="hidden" value="Login" name="logica">
        <div class="txt_field">
           <input type="text" name="crm" required>
          <span></span>
          <label>CRM</label>
        </div>
        <div class="txt_field">
           <input type="password" name="senha" required>
          <span></span>
          <label>Senha</label>
        </div>
        <input type="submit" value="Entrar">
        <c:if test="${not empty requestScope.medicoNaoRegistrado}">
        	<div id="error_mensagem">
        		<strong>Credenciais Inválidas</strong>
        	</div>
        </c:if>
      </form>
    </div>
</body>
</html>