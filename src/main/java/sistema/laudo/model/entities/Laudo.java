package sistema.laudo.model.entities;

public class Laudo {
	private Integer id;
	private Integer exameId;
	private String crm;
	private String descricao;
	private String conclusao;
	private StatusLaudo status;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getExameId() {
		return exameId;
	}

	public void setExameId(Integer exameId) {
		this.exameId = exameId;
	}

	public String getCrm() {
		return crm;
	}
	
	public void setCrm(String crm) {
		this.crm = crm;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getConclusao() {
		return conclusao;
	}
	
	public void setConclusao(String conclusao) {
		this.conclusao = conclusao;
	}
	
	public StatusLaudo getStatus() {
		return status;
	}
	
	public String getStatusStr() {
		return status.getStatusLaudo();
	}
	
	public void setStatus(StatusLaudo status) {
		this.status = status;
	}
	
}//Laudo
