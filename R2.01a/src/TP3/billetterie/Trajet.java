package TP3;

public class Trajet {
	private String depart;
	private String arrivee;
	private int distance;

	public Trajet(String depart, String arrivee, int distance) {
		this.depart = depart;
		this.arrivee = arrivee;
		this.distance = distance;
	}

	public String getDepart() {
		return depart;
	}

	public String getArrivee() {
		return arrivee;
	}

	public int getDistance() {
		return distance;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public void setArrivee(String arrivee) {
		this.arrivee = arrivee;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Trajet [depart=" + depart + ", arrivee=" + arrivee + ", distance=" + distance + "]";
	}
}
