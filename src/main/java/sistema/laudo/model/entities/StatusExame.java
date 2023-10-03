package sistema.laudo.model.entities;

public enum StatusExame {
	AGUARDANDO_LAUDO("Aguardando laudo"),
	LAUDO_REALIZADO("Laudo realizado"), 
	AGUARDANDO_EXAME("Aguardando exame"),
	EXAME_CANCELADO("Exame cancelado");

	private String statusExame;

	private StatusExame(String statusExame) {
		this.statusExame = statusExame;
	}

	public String getStatusExame() {
		return statusExame;
	}

	public static StatusExame converterStringParaStatusExame(String string) {
		if (string.isBlank()) {
			return null;
		}

		for (StatusExame exame : StatusExame.values()) {
			if (exame.getStatusExame().equalsIgnoreCase(string)) {
				return exame;
			}
		}
		return null;
	}//converterStringParaStatusExame()
	
}//StatusExame
