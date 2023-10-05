package sistema.laudo.model.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Exame {
	private Integer id;
	private String pacienteCpf;
	private TipoExame tipoExame;
	private StatusExame status;
	private Hipotese hipotese;
	private LocalDateTime dataPedido;
	private String medicoCrm;
	private String nomeMedico;
	private byte[] pdf;
	private LocalDateTime dataRealizacao;
	
	private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyy");
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getPacienteCpf() {
		return pacienteCpf;
	}
	
	public void setPacienteCpf(String pacienteCpf) {
		this.pacienteCpf = pacienteCpf;
	}
	
	public String getTipoExame() {
		return tipoExame.getTipoExame();
	}
	
	public void setTipoExame(String tipoExame) {
		this.tipoExame = TipoExame.converterStringParaTipoExame(tipoExame);
	}
	
	public StatusExame getStatus() {
		return status;
	}
	
	public String getStatusStr() {
		return status.getStatusExame();
	}
	
	public void setStatus(String status) {
		this.status = StatusExame.converterStringParaStatusExame(status);
	}

	public String getHipotese() {
		return hipotese.getHipotese();
	}
	
	public void setHipotese(String hipotese) {
		this.hipotese = Hipotese.converterStringParaHipotese(hipotese);
	}
	
	public LocalDateTime getDataPedido() {
		return dataPedido;
	}
	
	public String getDataPedidoStr() {
		return dataPedido.format(dateTimeFormatter);
	}
	
	
	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}
	
	public String getMedicoCrm() {
		return medicoCrm;
	}
	
	public void setMedicoCrm(String medicoCrm) {
		this.medicoCrm = medicoCrm;
	}
	
	public String getNomeMedico() {
		return nomeMedico;
	}

	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}

	public byte[] getPdf() {
		return pdf;
	}
	
	public void setPdf(byte[] pdf) {
		this.pdf = pdf;
	}
	
	public LocalDateTime getDataRealizacao() {
		return dataRealizacao;
	}
	
	public String getDataRealizacaoStr() {
		return dataRealizacao.format(dateTimeFormatter);
	}
	
	public void setDataRealizacao(LocalDateTime dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}
	
}//Exame
