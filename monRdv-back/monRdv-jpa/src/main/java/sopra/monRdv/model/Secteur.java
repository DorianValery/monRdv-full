package sopra.monRdv.model;

public enum Secteur {
	SECTEUR_1("Secteur 1"), SECTEUR_2("Secteur 2"), SECTEUR_3("Secteur 3");
	private final String label;

	private Secteur(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
