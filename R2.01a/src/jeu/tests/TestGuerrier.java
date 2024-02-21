package jeu.tests;

import jeu.Guerrier;
import jeu.GuerrieurUtilitaire;

public class TestGuerrier {
	public static void main(String[] args) {
		final Guerrier g1 = new Guerrier();
		final Guerrier g2 = new Guerrier();

		System.out.println("Guerrier 1 : " + GuerrieurUtilitaire.gerrierToString(g1));
		System.out.println("Guerrier 2 : " + GuerrieurUtilitaire.gerrierToString(g2));

		System.out.println("\nGuerrier 1 fight with Guerrier 2");
		while (g1.estVivant() && g2.estVivant()) {
			System.out.println("\nGuerrier 1 fight Guerrier 2");
			g1.attaquer(g2);
			System.out.println("Guerrier 1 : " + GuerrieurUtilitaire.gerrierToString(g1));
			System.out.println("Guerrier 2 : " + GuerrieurUtilitaire.gerrierToString(g2));
			if (g2.estVivant()) {
				System.out.println("\nGuerrier 2 fight Guerrier 1");
				g2.attaquer(g1);
				System.out.println("Guerrier 1 : " + GuerrieurUtilitaire.gerrierToString(g1));
				System.out.println("Guerrier 2 : " + GuerrieurUtilitaire.gerrierToString(g2));
			}
		}
	}
}
