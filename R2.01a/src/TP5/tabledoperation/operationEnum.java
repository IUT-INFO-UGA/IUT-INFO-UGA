package TP5.tabledoperation;

public enum operationEnum {
	ADDITION("ADDITION"),
	SOUSTRACTION("SOUSTRACTION"),
	MULTIPLICATION("MULTIPLICATION");

	private String libelle;

	private operationEnum(String libelle) {
			this.libelle = libelle;
	}

	@Override
	public String toString() {
		return libelle;
	}
}
