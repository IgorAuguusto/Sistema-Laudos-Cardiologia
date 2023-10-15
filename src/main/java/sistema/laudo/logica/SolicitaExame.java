package sistema.laudo.logica;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sistema.laudo.logica.util.EnviarEmail;
import sistema.laudo.model.dao.ExameDao;
import sistema.laudo.model.dao.PacienteDAO;
import sistema.laudo.model.entities.Exame;
import sistema.laudo.model.entities.Medico;
import sistema.laudo.model.entities.Paciente;
import sistema.laudo.model.entities.StatusExame;

public class SolicitaExame implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "solicitacaoDeExame.jsp";
		try {
			String cpf = request.getParameter("paciente");
			List<Exame> exameList = ExameDao.pesquisarTodosExames().stream().filter((e) -> e.getPacienteCpf().equals(cpf)).toList();
			
			for (Exame exame : exameList) {
				if (exame != null && exame.getTipoExame().equals(request.getParameter("exame")) && exame.getStatus().equals(StatusExame.AGUARDANDO_EXAME)) {
					request.setAttribute("pacientePossuiExame", true);
					return url;
				}
			}
			
			Paciente paciente = PacienteDAO.procurarPaciente(cpf);
			
			if (paciente == null) {
				request.setAttribute("pacienteNaoExiste", true);
				return url;
			}
			
			Exame exame = new Exame();
			
			exame.setPacienteCpf(paciente.getCpf());
			exame.setTipoExame(request.getParameter("exame"));
			exame.setStatus(StatusExame.AGUARDANDO_EXAME.getStatusExame());
			exame.setHipotese(request.getParameter("hipotese"));
			exame.setDataPedido(LocalDateTime.now().plusDays(3));
			
			HttpSession session = request.getSession(false);
			Medico medico = (Medico) session.getAttribute("medico");
			
			exame.setMedicoCrm(medico.getCrm());
			exame.setNomeMedico(medico.getNome());
			
			ExameDao.inserirExame(exame);
			
			String mensagemEmail = EnviarEmail.montarMensagemEmail(paciente, medico, exame);
			String assunto = "Consulta marcada";
			
			ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.submit(() -> {
            	EnviarEmail.enviarEmail(paciente.geteMail(), assunto, mensagemEmail);
            });
			
			request.setAttribute("consultaMarcada", true);
			
			return url;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return url;
	}//executa()

}// SolicitaExame 
