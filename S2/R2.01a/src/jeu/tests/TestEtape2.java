package jeu.tests;

import jeu.Guerrier;
import jeu.GuerrieurUtilitaire;
import jeu.guerrierChild.ChefElfe;
// import jeu.guerrierChild.ChefNain;
// import jeu.guerrierChild.Elfe;
// import jeu.guerrierChild.Nain;

public class TestEtape2 {
	public static void main(String[] args) {
		final ChefElfe cf1 = new ChefElfe();
		final Guerrier g2 = new Guerrier();

		System.out.println("chefElfe1 : " + GuerrieurUtilitaire.gerrierToString(cf1));
		System.out.println("Guerrier 2 : " + GuerrieurUtilitaire.gerrierToString(g2));

		System.out.println("\nchefElfe1 fight with Guerrier 2");
		while (cf1.estVivant() && g2.estVivant()) {
			System.out.println("\nchefElfe1 fight Guerrier 2");
			cf1.attaquer(g2);
			System.out.println("chefElfe1 : " + GuerrieurUtilitaire.gerrierToString(cf1));
			System.out.println("Guerrier 2 : " + GuerrieurUtilitaire.gerrierToString(g2));
			if (g2.estVivant()) {
				System.out.println("\nGuerrier 2 fight chefElfe1");
				g2.attaquer(cf1);
				System.out.println("chefElfe1 : " + GuerrieurUtilitaire.gerrierToString(cf1));
				System.out.println("Guerrier 2 : " + GuerrieurUtilitaire.gerrierToString(g2));
			}
		}
	}
}
