package TP1.forme;

public class Cercle {
	private int rayon;
	private Point centre;

	public Cercle(int rayon) {
		this.rayon = rayon;
		this.centre = new Point();
	}

	public Cercle(int rayon, Point centre) {
		this.rayon = rayon;
		this.centre = centre;
	}

	public int getRayon() {
		return rayon;
	}

	public Point getCentre() {
		return centre;
	}

	public double getPerimetre() {
		return 2 * Math.PI * rayon;
	}

	public double getAire() {
		return Math.PI * rayon * rayon;
	}

	public void setRayon(int rayon) {
		this.rayon = rayon;
	}

	/**
	 * Moves the center of the circle to the specified coordinates.
	 * if the new coordinates are negative, the point is not moved to 0.
	 *
	 * @warning no gestion of to big values (> Integer.MAX_VALUE)
	 * @param x the new x-coordinate of the center
	 * @param y the new y-coordinate of the center
	 */
	public void deplaceCentre(int dx, int dy) {
		centre.deplaceXY(dx, dy);
	}
}
