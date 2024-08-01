package tp2.telephone;

public class Processeur {
	final private String libelle;
	final private double frequence;

	public Processeur(String libelle, double frequence) {
		this.libelle = libelle;
		this.frequence = frequence;
	}

	public String getLibelle() {
		return libelle;
	}

	public double getFrequence() {
		return frequence;
	}

	@Override
	public String toString() {
		return libelle + " (" + frequence + "Ghz)";
	}
}
