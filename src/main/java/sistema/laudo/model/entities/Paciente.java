package sistema.laudo.model.entities;

import java.time.LocalDate;

public class Paciente {
	private String cpf;
	private String nome;
	private String eMail;
	private Character sexo;
	private Integer idade;
	private LocalDate dataNascimento;
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String geteMail() {
		return eMail;
	}
	
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	public Character getSexo() {
		return sexo;
	}
	
	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}
	
	public Integer getIdade() {
		return idade;
	}
	
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}//Paciente
