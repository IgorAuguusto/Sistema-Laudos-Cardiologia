package sistema.laudo.logica;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sistema.laudo.model.dao.LaudoDAO;
import sistema.laudo.model.entities.Laudo;
import sistema.laudo.model.entities.StatusLaudo;

public class AtualizarLaudo implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "revisarLaudos.jsp";
		int laudoId = Integer.parseInt(request.getParameter("laudoId"));
		
		try {
			Laudo laudo = LaudoDAO.procurarLaudo(laudoId);
			laudo.setStatus(StatusLaudo.DEFINITIVO);
			LaudoDAO.atualizarLaudo(laudo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return url;
	}//executa()

}//AtualizarLaudo
