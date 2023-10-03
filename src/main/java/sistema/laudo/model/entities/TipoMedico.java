package sistema.laudo.model.entities;

public enum TipoMedico {
	MEDICO("medico"),
	MEDICO_DOCENTE("medico-docente"), 
	RESIDENTE("residente");

	private String tipoMedico;

	private TipoMedico(String tipoMedico) {
		this.tipoMedico = tipoMedico;
	}

	public String getTipoMedico() {
		return tipoMedico;
	}

	public static TipoMedico converterStringParaTipoMedico(String string) {
		if (string.isBlank()) {
			return null;
		}

		for (TipoMedico tipo : TipoMedico.values()) {
			if (tipo.getTipoMedico().equalsIgnoreCase(string)) {
				return tipo;
			}
		}
		return null;
	}//converterStringParaTipoMedico()

}// TipoMedico
