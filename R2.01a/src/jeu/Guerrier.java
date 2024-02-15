package jeu;

public class Guerrier {
	private int force;
	private int PointDeVie;

	public Guerrier() {
		this.force = 10;
		this.PointDeVie = 100;
	}

	public int getForce() {
		return force;
	}

	public int getPointDeVie() {
		return PointDeVie;
	}

	public void setPointDeVie(int pointDeVie) {
		PointDeVie = pointDeVie;
	}

	public boolean estVivant() {
		return PointDeVie > 0;
	}

	public void attaquer(Guerrier guerrier) {
		// to do
	}
}
