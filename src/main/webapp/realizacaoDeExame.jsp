<%@ page import="java.util.List" %>
<%@ page import="sistema.laudo.model.dao.ExameDao" %>
<%@ page import="sistema.laudo.model.entities.Exame" %>
<%@ page import="sistema.laudo.model.entities.StatusExame" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de Exames</title>
</head>
<body>

    <h2>Lista de Exames</h2>

    <c:set var="exameList" value="${ExameDao.pesquisarTodosExames()}" />
    
    <c:set var="exameListFiltrada" value="${exameList.stream()
                        .filter(e -> !e.getStatusStr().equals(StatusExame.LAUDO_REALIZADO.getStatusExame()))
                        .toList()}" />

    <table border="1">
        <thead>
            <tr>
                <th>Paciente CPF</th>
                <th>Tipo de Exame</th>
                <th>Status</th>
                <th>Hipótese</th>
                <th>Data do Pedido</th>
                <th>Médico CRM</th>
                <th>Nome do Médico</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="exame" items="${exameListFiltrada}">
                <tr>
                    <td>${exame.pacienteCpf}</td>
                    <td>${exame.tipoExame}</td>
                    <td>${exame.statusStr}</td>
                    <td>${exame.hipotese}</td>
                    <td>${exame.dataPedidoStr}</td>
                    <td>${exame.medicoCrm}</td>
                    <td>${exame.nomeMedico}</td>
                    <td>
                        <form method="post" action="http://localhost:8080/SistemasDeLaudosDeCardiologia/Controller">
                            <input type="hidden" name="examePacienteCpf" value="${exame.pacienteCpf}" />
                            <input type="hidden" name="exameMedicoCrm" value="${exame.pacienteCrm}" />
                            <input type="submit" value="Realizar Exame" />
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
