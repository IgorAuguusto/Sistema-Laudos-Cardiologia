package sistema.laudo.logica;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sistema.laudo.model.dao.ExameDao;
import sistema.laudo.model.entities.Exame;

public class GerarLaudo implements Logica {
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String url = "gerarLaudo.jsp";

	        try {
	            String pacienteCpf = request.getParameter("exameCpf");
	            
	            Exame exame = ExameDao.procurarExame(pacienteCpf);

	            HttpSession sessao = request.getSession();
	            sessao.setAttribute("exame", exame);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            //url = "erro.jsp";
	        }
	        
	        return url;
	    }//executa()

}//GerarLaudo
