package sistema.laudo.logica;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Logica {
	public String executa(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException;
}
