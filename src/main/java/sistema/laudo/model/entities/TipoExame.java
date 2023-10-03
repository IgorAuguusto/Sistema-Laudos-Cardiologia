package sistema.laudo.model.entities;

public enum TipoExame {
	ECOCARDIOGRAMA("Ecocardiograma"),
	ELETROCARDIOGRAMA("Eletrocardiograma");
	
	private String tipoExame;
	
	private TipoExame(String tipoExame) {
		this.tipoExame = tipoExame;
	}
	
	public String getTipoExame() {
		return tipoExame;
	}

	public static TipoExame converterStringParaTipoExame(String string) {
        if (string.isBlank()) {
        	return null;
        }
    	
    	for (TipoExame exame : TipoExame.values()) {
            if (exame.getTipoExame().equalsIgnoreCase(string)) {
                return exame;
            }
        }
        return null;
    }//converterStringParaTipoExame()
	
}//TipoExame
