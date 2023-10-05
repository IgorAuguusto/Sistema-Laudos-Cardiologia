package sistema.laudo.logica.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import sistema.laudo.model.entities.Exame;
import sistema.laudo.model.entities.Medico;
import sistema.laudo.model.entities.Paciente;
import sistema.laudo.model.entities.TipoExame;

public class EnviarEmail {
	
	 public static void enviarEmail(String emailPara, String assunto,String mensagem) {
	        String seuEmail = "medicopestedoidao@gmail.com"; 
	        String suaSenha = "vike qmhn hcqr glte"; 
	        String hostName = "smtp.gmail.com"; 
	        
	        
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
		 .append(medico.getNome()).append(", CRM: ").append(medico.getCrm()).append(", foi agendada")
		 .append(" para o dia: ").append(exame.getDataPedidoStr())
		 .append("\n\n").append("Favor seguir as orientações abaixo..").append("\n\n");
		 
		 if (exame.getTipoExame().equals(TipoExame.ECOCARDIOGRAMA.getTipoExame())) {
			 sb.append("Vestuário adequado: Use roupas confortáveis e que permitam fácil acesso ao peito, pois ")
			 .append("será necessário remover a parte superior do vestuário para realizar o exame.")
			 .append("\n\nEvitar cafeína: Algumas pessoas são sensíveis à cafeína, que pode afetar a frequência ")
			 .append("cardíaca. Se possível, evite cafeína algumas horas antes do exame.");
		 }
		 else {
			 sb.append("Vestuário adequado: Use roupas que permitam fácil acesso ao peito, pois eletrodos serão ")
			 .append("colocados na pele para registrar a atividade elétrica do coração.")
			 .append("\n\nEvitar loções e cremes: Evite aplicar loções, cremes ou óleos na pele do peito no dia do ")
			 .append("exame, pois isso pode interferir com a aderência dos eletrodos.");
		 }
		 
		 sb.append("\n\nAtenciosamente, ").append("Hospital dos Loucos.");
		 
		 return sb.toString();
	 }//montarMensagemEmail();

}//EnviarEmail
