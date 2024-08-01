package TP1.forme;

public class Rectangle {
	private int longueur;
	private int largeur;
	private Point origine;

	public Rectangle(int longueur, int largeur) {
		this.longueur = longueur;
		this.largeur = largeur;
		this.origine = new Point();
	}

	public Rectangle(int longueur, int largeur, int valX, int valY) {
		this.longueur = longueur;
		this.largeur = largeur;
		this.origine = new Point(valX, valY);
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public int getLargeur() {
		return largeur;
	}

	public int getLongueur() {
		return longueur;
	}

	public Point getOrigine() {
		return (new Point(origine.getX(), origine.getY()));
	}

	public int getPerimetre() {
		return 2 * (longueur + largeur);
	}

	public double getAire() {
		return longueur * largeur;
	}

	/**
	 * Moves the origin of the rectangle by the specified coordinates.
	 * if the new coordinates are negative, the point is not moved to 0.
	 *
	 * @warning no gestion of to big values (> Integer.MAX_VALUE)
	 * @param dx the x-coordinate to move the origin by
	 * @param dy the y-coordinate to move the origin by
	 */
	public void deplaceOrigine(int dx, int dy) {
		origine.deplaceXY(dx, dy);
	}
}
