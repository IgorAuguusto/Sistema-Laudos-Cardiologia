package sistema.laudo.model.entities;

public class MedicoDocente extends Medico{
	private Titulacao titulo;

	public Titulacao getTitulo() {
		return titulo;
	}

	public void setTitulo(Titulacao titulo) {
		this.titulo = titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = Titulacao.converterStringParaTitulacao(titulo);
	}
	
}//MedicoDocente
