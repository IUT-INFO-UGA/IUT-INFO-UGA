import java.util.Scanner;

public class RectangleUtilitaire {
	public static int sasiePos() {
		// { } => { résultat : un entier >= 0 }
		Scanner in = new Scanner(System.in);
		System.out.print("Entrer un entier positif ou nul: ");
		int value = -1;
		while (value < 0) {
			value = in.nextInt();
			in.nextLine();
		}
		return value;
	}

	public static int saisiePlusGrand(int n) {
		// { } => { résultat : un entier > n }
		Scanner in = new Scanner(System.in);
		System.out.print("Entrer un entier superieur a: " + n);
		int value;
		do {
			value = in.nextInt();
			in.nextLine();
		} while (value < n);
		return value;
	}

	public static Rectangle saisirRectangle() {
		// { } => { résultat = un objet de type Rectangle dont les attributs
		// sont saisis par l'utilisateur }
		System.out.println("Saisie des coordonnées des coins supérieur gauche et inférieur droit d'un rectangle");
		System.out.print("- Abscisse du point haut gauche ");
		final int xHG = sasiePos();
		System.out.println("- Abscisse du point bas droit");
		final int xBD = saisiePlusGrand(xHG);
		System.out.println("- Ordonnée du point bas droit");
		final int yBD = sasiePos();
		System.out.println("- Ordonnée du point haut gauche");
		final int yHG = saisiePlusGrand(yBD);
		return new Rectangle(xHG, yHG, xBD, yBD);
	}

	public static void afficherRectangle(Rectangle unRectangle) {
		// { } => { les caractéristiques du rectangle représenté par unRectangle ont
		// été affichées : coordonnées des points HG et BD, longueur des
		// côtés et longueur des diagonales }
		// (1) coordonnées des points CHG et CBD sous la forme (x, y)
		System.out.println("- Coordonnées du point haut gauche : " + unRectangle.yHG);
		System.out.println("- Coordonnées du point bas droit : " + unRectangle.xBD);
		System.out.println("- Longueur du côté horizontal : " + (unRectangle.xBD - unRectangle.xHG));
		System.out.println("- Longueur du côté vertical : " + (unRectangle.yHG - unRectangle.yBD));
		System.out.println("- Longueur des diagonales : " + unRectangle.getLongueurDiagonale());


	}
}
