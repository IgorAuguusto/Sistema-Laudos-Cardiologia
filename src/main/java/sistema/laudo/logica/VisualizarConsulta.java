package sistema.laudo.logica;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sistema.laudo.model.dao.ExameDao;
import sistema.laudo.model.dao.LaudoDAO;
import sistema.laudo.model.entities.Exame;
import sistema.laudo.model.entities.Laudo;

public class VisualizarConsulta implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "visualizarConsulta.jsp";
		int exameId = Integer.parseInt(request.getParameter("exameId"));
		
		try {
			Laudo laudo = LaudoDAO.procurarLaudoPorExameId(exameId);
			Exame exame = ExameDao.procurarExame(exameId);
			HttpSession sessao = request.getSession();
		    sessao.setAttribute("laudo", laudo);
		    sessao.setAttribute("exame", exame);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return url;
	
	}//executa()

}//VisualizarConsulta
