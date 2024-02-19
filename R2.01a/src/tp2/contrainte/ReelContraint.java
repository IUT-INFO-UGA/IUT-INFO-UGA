package tp2.contrainte;

public class ReelContraint {
	private double min;
	private double max;
	private double valeur;

	public ReelContraint(double min, double max) {
		this.min = min;
		this.max = max;
		valeur = min;
	}

	public double getValeur() {
		return valeur;
	}

	public void setValeur(double valeur) {
		if (valeur < min) {
			this.valeur = min;
		} else if (valeur > max) {
			this.valeur = max;
		} else {
			this.valeur = valeur;
		}
	}

	public String toString() {
		return "valeur: " + valeur + " min: " + min + " max: " + max;
	}
}
