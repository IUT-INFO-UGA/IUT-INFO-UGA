package TP3A;

public class Geometrie {
	public static void main(String[] args) {

		Rectangle rect = new Rectangle(Utilitaire.saisieFloatPos(), Utilitaire.saisieFloatPos());
		System.out.println(rect);
		System.out.println("Cercle inscrit dans ce rectangle:");
		System.out.println(rect.cercleInscrit());
		System.out.println("Cercle circonscrit dans ce rectangle:");
		System.out.println(rect.cercleCirconscrit());
/*		Cercle cer = Utilitaire.saisirCercle();
		System.out.println(cer);


		Triangle tri = Utilitaire.saisirTriangle();
		System.out.println(tri);
 */
	}
}
