package sistema.laudo.model.entities;

public enum Hipotese {
	PARADA_CARDIACA("I46 - Parada cardíaca"),
	TAQUICARDIA_PAROXISTICA("I47 - Taquicardia paroxística"),
	FLUTTER_FIBRACAO_ATRIAL("I48 - Flutter e fibrilação atrial"),
	OUTRAS_ARRITMIAS_CARDIACAS("I49 - Outras arritmias cardíacas"),
	CARDIOMIOPATIAS("I42 - Cardiomiopatias");
	
	private String hipotese;
	
	private Hipotese(String hipotese) {
		this.hipotese = hipotese;
	}
	
	public String getHipotese() {
		return hipotese;
	}

	public static Hipotese converterStringParaHipotese(String string) {
        if (string.isBlank()) {
        	return null;
        }
    	
    	for (Hipotese hipo : Hipotese.values()) {
            if (hipo.getHipotese().equalsIgnoreCase(string)) {
                return hipo;
            }
        }
        return null;
    }
	
}//Hipotese
