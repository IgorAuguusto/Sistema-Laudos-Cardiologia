
import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sistema.laudo.model.dao.ExameDao;
import sistema.laudo.model.entities.Exame;
import sistema.laudo.model.entities.Laudo;
import sistema.laudo.model.entities.Medico;
import sistema.laudo.model.entities.StatusExame;

public class SalvarLaudo implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "laudos.jsp";
		
		HttpSession session = request.getSession(false);
		Exame exame = (Exame) session.getAttribute("exame");
		Medico medico = (Medico) session.getAttribute("medico");
		
		exame.setStatus(StatusExame.LAUDO_REALIZADO.getStatusExame());
		
		Laudo laudo = new Laudo();
		laudo.setExameId(exame.getId());
		
		try {
			ExameDao.atualizarExame(exame);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return url;
	}//executa
	
}//SalvarLaudo
