package TP1.forme;

public class FormeUtilitaire {
	public static void affichePoint(Point p) {
		System.out.println("x = " + p.getX() + " y = " + p.getY());
	}

	public static void afficheCercle(Cercle c) {
		System.out.println("rayon = " + c.getRayon() + " centre :(" + c.getCentre().getX() + "," + c.getCentre().getY()
				+ ")" + " perimetre = " + c.getPerimetre() + " aire = " + c.getAire());
	}

	public static void afficheRectangle(Rectangle r) {
		System.out.println("longueur = " + r.getLongueur() + " largeur = " + r.getLargeur() + " origine :("
				+ r.getOrigine().getX() + "," + r.getOrigine().getY() + ")" + " perimetre = " + r.getPerimetre()
				+ " aire = " + r.getAire());
	}
}