package TP1.forme;

public class TestCercle {
	public static void main(String[] args) {
		// créer un point
		Point point = new Point(0, 2);
		// créer deux cercles avec le même point pour centre
		Cercle cercle = new Cercle(10, point);
		Cercle cercle2 = new Cercle(2, point);
		// afficher le point et les deux cercles
		FormeUtilitaire.affichePoint(point);
		FormeUtilitaire.afficheCercle(cercle);
		FormeUtilitaire.afficheCercle(cercle2);
		// déplacer un cercle
		System.out.println("On déplace le point de dX=10 et dY=4");
		cercle.deplaceCentre(10, 4);
		// afficher le point et les deux cercles
		FormeUtilitaire.affichePoint(point);
		FormeUtilitaire.afficheCercle(cercle);
		FormeUtilitaire.afficheCercle(cercle2);
	}
}
