package sistema.laudo.logica;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sistema.laudo.model.dao.ExameDao;
import sistema.laudo.model.entities.Exame;

public class BaixarPDF implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String pacienteCpf = request.getParameter("exameCpf");
		String tipoExame = request.getParameter("tipoExame");
		
		try {
			Exame exame = ExameDao.procurarExame(pacienteCpf, tipoExame);
			
			if (exame != null) {
				ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(exame.getPdf());
				PdfReader pdfReader = new PdfReader(byteArrayInputStream);

				response.setContentType("application/pdf");
				response.setHeader("Content-Disposition", "inline; filename=exame.pdf");

				PdfDocument pdfDoc = new PdfDocument(pdfReader, new PdfWriter(response.getOutputStream()));
				Document document = new Document(pdfDoc);

				document.close();
				pdfDoc.close();
				pdfReader.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
