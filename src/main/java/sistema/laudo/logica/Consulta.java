package sistema.laudo.logica;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sistema.laudo.model.dao.ExameDao;
import sistema.laudo.model.dao.LaudoDAO;
import sistema.laudo.model.entities.Exame;
import sistema.laudo.model.entities.Laudo;
import sistema.laudo.model.entities.StatusLaudo;

public class Consulta implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "resultadoConsulta.jsp";
		
		String cpf = request.getParameter("cpf");
		try {
		    List<Exame> exameList = ExameDao.pesquisarTodosExames()
		            .stream()
		            .filter(e -> e.getPacienteCpf().equals(cpf))
		            .toList();

		    List<Laudo> laudoList = exameList.stream()
		            .map(e -> {
		                try {
		                    return LaudoDAO.procurarLaudoPorExameId(e.getId());
		                } catch (SQLException e1) {
		                    e1.printStackTrace();
		                    return null;  
		                }
		            })
		            .filter(l -> l != null && l.getStatus().equals(StatusLaudo.DEFINITIVO))
		            .toList();
		    
		    if (exameList.isEmpty()) {
		    	request.setAttribute("cpfInvalido", true);
		    	return "consulta.jsp";
		    }
		    
		    HttpSession sessao = request.getSession();
		    sessao.setAttribute("laudoS", laudoList);

		} catch (SQLException e) {
		    e.printStackTrace();  
		}
		
		
		return url;
	}//executa()
	
}//Consulta
