package sistema.laudo.logica;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Logout implements Logica {
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession(false);
		sessao.invalidate();
		return "login.jsp";
	}//executa();
	
}//Logout
