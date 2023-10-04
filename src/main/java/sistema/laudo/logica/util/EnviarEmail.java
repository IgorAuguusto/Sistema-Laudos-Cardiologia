package sistema.laudo.logica.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import sistema.laudo.model.entities.Exame;
import sistema.laudo.model.entities.Medico;
import sistema.laudo.model.entities.Paciente;

public class EnviarEmail {
	
	 public static void enviarEmail(String emailPara, String mensagem) {
	        String seuEmail = "medicopestedoidao@gmail.com"; 
	        String suaSenha = "vike qmhn hcqr glte"; 
	        String hostName = "smtp.gmail.com"; 
	        String assunto = "Consulta marcada";
	        
	        SimpleEmail email = new SimpleEmail();
	        email.setHostName(hostName);
	        email.setSmtpPort(465); 
	        email.setAuthenticator(new DefaultAuthenticator(seuEmail, suaSenha));
	        email.setSSLOnConnect(true);

	        try {
	            email.setFrom(seuEmail);
	            email.addTo(emailPara);
	            email.setSubject(assunto);
	            email.setMsg(mensagem);

	            email.send();
	        } catch (EmailException e) {
	            e.printStackTrace();
	        }
	    }//enviarEmail()
	 
	 public static String montarMensagemEmail(Paciente paciente, Medico medico, Exame exame) {
		 var sb = new StringBuilder();
		 
		 sb.append("Bom dia, ").append(paciente.getNome()).append("!\n\nSua consulta com o doutor ")
		 .append(medico.getNome()).append(" foi agendada").append(" para o dia: ").append(exame.getDataPedidoStr())
		 .append("\n\n").append("Favor seguir as orientações abaixo..").append("\n\n")
		 .append("Evitar cafeína e alimentos estimulantes nas horas que antecedem o exame.")
		 .append("\n\nAtenciosamente, ").append("Hospital dos Loucos.");
		 
		 return sb.toString();
	 }//montarMensagemEmail();

}//EnviarEmail
