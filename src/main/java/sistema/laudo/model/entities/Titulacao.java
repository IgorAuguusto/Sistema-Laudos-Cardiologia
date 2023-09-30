package sistema.laudo.model.entities;

public enum Titulacao {
	DOUTOR("doutor"),
	ASSISTENTE("assistente"),
	LIVRE_DOCENTE("livre-docente"),
	TITULAR("titular");
	
	private String titulacao;

    
    private Titulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getTitulacao() {
        return titulacao;
    }
   
    public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}

    public static Titulacao converterStringParaTitulacao(String string) {
        if (string.isBlank()) {
        	return null;
        }
    	
    	for (Titulacao titulo : Titulacao.values()) {
            if (titulo.getTitulacao().equalsIgnoreCase(string)) {
                return titulo;
            }
        }
        return null;
    }
    
    public String toString() {
    	return this.getTitulacao();
    }
    
}//Titulacao
