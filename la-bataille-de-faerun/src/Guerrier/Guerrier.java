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

	/**
	 * Checks if the warrior is alive.
	 *
	 * @return true if the warrior is alive (pv > 0), false otherwise.
	 **/
	public boolean estVivant() {
		return PointDeVie > 0;
	}

	/**
	 * Attacks another warrior by reducing their hit points.
	 * The amount of damage inflicted depends on the warrior's strength.
	 * attacks with adition of {force} dice of 3 faces
	 *
	 * @param guerrier the warrior to attack
	 */
	public void attaquer(Guerrier guerrier) {
		guerrier.subirDegats(GuerrieurUtilitaire.throwNDice(this.getForce()));
	}

	/**
	 * Reduces the warrior's health points by the specified amount of damage.
	 *
	 * @param degats The amount of damage to be inflicted on the warrior.
	 */
	protected void subirDegats(int degats) {
		PointDeVie -= degats;
	}
}
