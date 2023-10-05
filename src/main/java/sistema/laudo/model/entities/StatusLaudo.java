package sistema.laudo.model.entities;

public enum StatusLaudo {
	PROVISORIO("provisório"),
	DEFINITIVO("Definitivo"); 

	private String statusLaudo;

	private StatusLaudo(String statusLaudo) {
		this.statusLaudo = statusLaudo;
	}

	public String getStatusLaudo() {
		return statusLaudo;
	}

	public static StatusLaudo converterStringParaStatusLaudo(String string) {
		if (string.isBlank()) {
			return null;
		}

		for (StatusLaudo laudo : StatusLaudo.values()) {
			if (laudo.getStatusLaudo().equalsIgnoreCase(string)) {
				return laudo;
			}
		}
		return null;
	}//converterStringParaStatusLaudo()
	
}//StatusLaudo
