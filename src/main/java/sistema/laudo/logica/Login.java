package sistema.laudo.logica;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sistema.laudo.model.dao.MedicoDAO;
import sistema.laudo.model.entities.Medico;

public class Login implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "login.jsp";

        try {
            String crm = request.getParameter("crm");
            String senha = request.getParameter("senha");

            Medico medico = MedicoDAO.procurarMedico(crm, senha);

            if (medico != null) {
                HttpSession sessao = request.getSession();
                sessao.setAttribute("status", true);
                sessao.setAttribute("medico", medico);
                return "paginaPrincipal.jsp";
            } else {
                request.setAttribute("medicoNaoRegistrado", true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //url = "erro.jsp";
        }
        
        return url;
    }//executa()
    
}//Login
