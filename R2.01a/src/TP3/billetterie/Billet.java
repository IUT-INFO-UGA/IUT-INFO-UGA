package TP3;

public class Billet {
	private double prixAuKm;
	private final Trajet trajet;

	public Billet(Trajet trajet, double prixAuKm) {
		this.prixAuKm = prixAuKm;
		this.trajet = trajet;
	}

	public String getDepart() {
		return trajet.getDepart();
	}

	public String getArrivee() {
		return trajet.getArrivee();
	}

	public int getDistance() {
		return trajet.getDistance();
	}

	public double getPrixAuKm() {
		return prixAuKm;
	}

	public double getPrix() {
		return prixAuKm * trajet.getDistance();
	}
}
