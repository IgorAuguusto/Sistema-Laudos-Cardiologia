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
import sistema.laudo.model.entities.Medico;
import sistema.laudo.model.entities.StatusExame;
import sistema.laudo.model.entities.StatusLaudo;

public class SalvarLaudo implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "laudos.jsp";
		String descricao = request.getParameter("descricao");
		String conclusao = request.getParameter("conclusao");
		
		HttpSession session = request.getSession(false);
		Exame exame = (Exame) session.getAttribute("exame");
		Medico medico = (Medico) session.getAttribute("medico");
		
		exame.setStatus(StatusExame.LAUDO_REALIZADO.getStatusExame());
		
		Laudo laudo = new Laudo();
		laudo.setExameId(exame.getId());
		laudo.setCrm(medico.getCrm());
		laudo.setDescricao(descricao);
		laudo.setConclusao(conclusao);
		laudo.setStatus(StatusLaudo.PROVISORIO);
		
		try {
			ExameDao.atualizarExame(exame);
			LaudoDAO.inserirLaudo(laudo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return url;
	}//executa
	
}//SalvarLaudo
