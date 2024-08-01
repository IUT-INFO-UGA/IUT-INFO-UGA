package TP4.dalton;

public enum Taille {
	PETIT("petit"),
	MOYEN("moyen"),
	GRAND("grand");

	private String libelle;

	private Taille(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return libelle;
	}
}
