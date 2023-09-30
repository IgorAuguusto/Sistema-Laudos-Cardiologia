package sistema.laudo.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sistema.laudo.logica.Logica;

public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nomeClasse = "sistema.laudo.logica." + request.getParameter("logica");

        try {
            // Obtém a classe com o nome fornecido
            Class<?> classe = Class.forName(nomeClasse);

            // Cria uma instância da classe
            Logica logica = (Logica) classe.getDeclaredConstructor().newInstance();

            // Executa a lógica e obtém a URL resultante
            String url = logica.executa(request, response);

            // Redireciona para a página resultante
            request.getRequestDispatcher(url).forward(request, response);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            // Trata ou registra a exceção adequadamente
            e.printStackTrace();
            // Pode redirecionar para uma página de erro, se apropriado
            //response.sendRedirect("erro.jsp");
        }
    }
}
