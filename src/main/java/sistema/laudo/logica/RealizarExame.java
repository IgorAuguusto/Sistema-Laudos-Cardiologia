package sistema.laudo.logica;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sistema.laudo.logica.util.GeradorPDF;
import sistema.laudo.model.dao.ExameDao;
import sistema.laudo.model.entities.Exame;
import sistema.laudo.model.entities.Medico;

public class RealizarExame implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		try {
			
			String pacienteCpf = request.getParameter("examePacienteCpf").trim();
			Exame exame = ExameDao.procurarExame(pacienteCpf);
			HttpSession session = request.getSession(false);
			Medico medico = (Medico) session.getAttribute("medico");		
			
			GeradorPDF.gerarPDF(exame, medico, request.getServletContext());
			ExameDao.atualizarExame(exame);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "realizacaoDeExame.jsp";
	}//executa()

}//RealizarExame
