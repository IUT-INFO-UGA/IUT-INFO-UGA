package TP1.forme;

public class TestPoint {
	public static void main(String[] args) {
		// créer un objet point1 de type Point
		// avec le constructeur par défaut Point()
		Point point1 = new Point();
		// créer un objet point2 de type Point
		Point point2 = new Point(-1, 4);
		// afficher les Points avec la méthode affiche()
		// de la classe FormeUtilitaire
		System.out.println("---------");
		System.out.println("Les points :");
		FormeUtilitaire.affichePoint(point1);
		FormeUtilitaire.affichePoint(point2);
		// déplacer le Point point1 de dX=23 et de dY=-2
		// déplacer le Point point2 de dX=-10 et de dY=20
		System.out.println("---------");
		System.out.println("Les points se déplacent");
		point1.deplaceXY(23, -2);
		point2.deplaceXY(-10, -6);
		// afficher les Points
		// avez vous vérifié si x et/ou y étaient négatifs ?
		// un point doit toujours avoir un x et un y supérieur ou égal à 0
		System.out.println("---------");
		System.out.println("Les points :");
		FormeUtilitaire.affichePoint(point1);
		FormeUtilitaire.affichePoint(point2);
	}
}
