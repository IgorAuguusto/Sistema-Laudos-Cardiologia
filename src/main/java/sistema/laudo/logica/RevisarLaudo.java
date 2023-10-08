package sistema.laudo.logica;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sistema.laudo.model.dao.LaudoDAO;
import sistema.laudo.model.entities.Laudo;

public class RevisarLaudo implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "atualizarLaudo.jsp";
		 try {
	            int laudoId = Integer.parseInt(request.getParameter("laudoId"));
	            
	            Laudo laudo = LaudoDAO.procurarLaudo(laudoId);

	            HttpSession sessao = request.getSession();
	            sessao.setAttribute("laudo", laudo);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            //url = "erro.jsp";
	        }
		return url;
	}

}//RevisarLaudo
