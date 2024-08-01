package TP3;

public class BilletReduit extends Billet {
	private double tauxDeReduction;

	public BilletReduit(Trajet trajet, double prixAuKm, double tauxDeReduction) {
		super(trajet, prixAuKm);
		this.tauxDeReduction = tauxDeReduction;
	}

	public double getTauxDeReduction() {
		return tauxDeReduction;
	}

	public double getPrix() {
		return super.getPrix() * (1 - tauxDeReduction);
	}

	public void setTauxDeReduction(double tauxDeReduction) {
		this.tauxDeReduction = tauxDeReduction;
	}

	@Override
	public String toString() {
		return "BilletReduit [tauxDeReduction=" + tauxDeReduction + ", getPrix()=" + getPrix() + "]";
	}
}
