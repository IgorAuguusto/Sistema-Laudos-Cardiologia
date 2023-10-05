package sistema.laudo.logica.util;

import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Random;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;

import jakarta.servlet.ServletContext;
import sistema.laudo.model.entities.Exame;
import sistema.laudo.model.entities.Medico;
import sistema.laudo.model.entities.StatusExame;
import sistema.laudo.model.entities.TipoExame;



public class GeradorPDF {
	
	private static final String CAMINHO_IMAGENS_EXAME = "/imagens/exames/";
	
	public static void gerarPDF(Exame exame, Medico medico,  ServletContext context) throws SQLException  {
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PdfWriter pdfWriter = new PdfWriter(byteArrayOutputStream);
	    PdfDocument pdf = new PdfDocument(pdfWriter);
	    Document document = new Document(pdf);

	    LocalDateTime dataRealizacao = LocalDateTime.now();
	    exame.setDataRealizacao(dataRealizacao);
	    
	    document.add(new Paragraph(String.format("Medico: %s", medico.getNome())));
	    document.add(new Paragraph(String.format("CRM: %s", medico.getCrm())));
	    
	    document.add(new Paragraph(String.format("Paciente CPF: %s", exame.getPacienteCpf())));
	    document.add(new Paragraph(String.format("Tipo do Exame: %s", exame.getTipoExame())));
	    document.add(new Paragraph(String.format("Hipótese: %s", exame.getHipotese())));
	    document.add(new Paragraph(String.format("Data agendamendo: %s", exame.getDataPedidoStr())));
	    document.add(new Paragraph(String.format("Exame Realizado em: %s", exame.getDataRealizacaoStr())));
	    
	    
	    String pastaImagem = exame.getTipoExame().equals(TipoExame.ECOCARDIOGRAMA.getTipoExame())
	    		            ? "ecocardiograma/" : "eletrocardiograma/";
	    int numeroImagem = gerarNumero(pastaImagem.equals("ecocardiograma") ? 10 : 9);
	    
	    String caminhoRelativoImagens = String.format("%s%s%d.jpeg", CAMINHO_IMAGENS_EXAME, pastaImagem, numeroImagem);

	    String contextoPath = context.getRealPath("/");
	    
	    String caminhoAbsolutoImagens = String.format("%s%S",  contextoPath, caminhoRelativoImagens);
	    
	    ImageData imageData;
		try {
			imageData = ImageDataFactory.create(caminhoAbsolutoImagens);
			Image imagem = new Image(imageData);
			document.add(imagem);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}	    

	    document.close();
	    byte[] pdfBytes = byteArrayOutputStream.toByteArray();
	    exame.setPdf(pdfBytes);
	    exame.setStatus(StatusExame.AGUARDANDO_LAUDO.getStatusExame());
	    
	}//gerarPDF()

	 private static int gerarNumero(int maximo) {
	        Random random = new Random();
	        int numeroAleatorio = random.nextInt(maximo) + 1;
	        return numeroAleatorio;
	}//gerarNumero()
	 
}//GeradorPDF
