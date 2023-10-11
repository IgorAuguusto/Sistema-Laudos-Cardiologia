package sistema.laudo.logica;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sistema.laudo.logica.util.EnviarEmail;
import sistema.laudo.model.dao.ExameDao;
import sistema.laudo.model.dao.MedicoDAO;
import sistema.laudo.model.dao.PacienteDAO;
import sistema.laudo.model.entities.Exame;
import sistema.laudo.model.entities.Medico;
import sistema.laudo.model.entities.StatusExame;

public class Login implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "login.jsp";

		try {
			String crm = request.getParameter("crm");
			String senha = request.getParameter("senha");

			Medico medico = MedicoDAO.procurarMedico(crm, senha);

			if (medico != null) {
				HttpSession sessao = request.getSession();
				sessao.setAttribute("medico", medico);
				List<Exame> exameCanceladosList = examesCancelados();
				exameCanceladosList.forEach((e) -> {
					try {
						EnviarEmail.enviarEmail(PacienteDAO.procurarPaciente(e.getPacienteCpf()).geteMail(),
								"Exame Cancelado", EnviarEmail.montarMensagemCancelamento(
										PacienteDAO.procurarPaciente(e.getPacienteCpf()), medico, e));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				});
				return "paginaPrincipal.jsp";

			} else {
				request.setAttribute("medicoNaoRegistrado", true);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			// url = "erro.jsp";
		}

		return url;
	}// executa()

	private List<Exame> examesCancelados() throws SQLException {
		List<Exame> exameList = ExameDao.pesquisarTodosExames();
		LocalDateTime dataAtual = LocalDateTime.now();
		exameList = exameList.stream().filter((e) -> e.getDataPedido().isBefore(dataAtual)).toList();
		exameList = exameList.stream().filter((e) -> e.getStatus().equals(StatusExame.AGUARDANDO_EXAME)).toList();
		exameList.forEach((e) -> e.setStatus(StatusExame.EXAME_CANCELADO.getStatusExame()));
		exameList.forEach((e) -> {
			try {
				ExameDao.atualizarExame(e);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});

		return exameList;
	}// examesCalcelados()

}// Login
