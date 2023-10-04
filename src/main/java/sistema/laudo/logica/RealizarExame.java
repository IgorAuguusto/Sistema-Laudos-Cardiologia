package sistema.laudo.logica;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sistema.laudo.model.dao.ExameDao;
import sistema.laudo.model.entities.Exame;
import sistema.laudo.model.entities.StatusExame;

public class RealizarExame implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		try {
			List<Exame> exameList = ExameDao.pesquisarTodosExames();
			exameList = exameList.stream().filter((e) -> e.getStatusStr() != StatusExame.LAUDO_REALIZADO.getStatusExame()).toList();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}//executa()

}//RealizarExame
