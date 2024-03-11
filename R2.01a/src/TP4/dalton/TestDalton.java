package TP4.dalton;

import java.util.TreeSet;

public class TestDalton {
	public static void main() {
		// Création des Daltons
		Dalton joe = new Dalton("Joe", Taille.PETIT);
		Dalton jack = new Dalton("Jack", Taille.MOYEN);
		Dalton william = new Dalton("William", Taille.MOYEN);
		Dalton averell = new Dalton("Averell", Taille.GRAND);
		// Faire un ensemble triés des daltons sur l'ordre naturel (compareTo)
		TreeSet<Dalton> lesDaltons = new TreeSet<Dalton>();
		lesDaltons.add(averell);
		lesDaltons.add(joe);
		lesDaltons.add(william);
		lesDaltons.add(jack);
		// Affichage
		afficheCollection("Les daltons triés par ordre naturel (compareTo) :", lesDaltons);
		// Faire un ensemble triés des daltons avec le comparateur de Taille (solution
		// 1)
		TreeSet<Dalton> lesDaltonsTaille = new TreeSet<Dalton>((d1, d2) -> compareToHeight(d1, d2));
		lesDaltonsTaille.addAll(lesDaltons);
		// Affichage
		// ATTENTION 2 daltons avec la même taille donc vu que les doublons ne sont pas
		// autorisés dans un Set (ensemble)
		// Un des daltons ne sera pas conservé
		afficheCollection("Les daltons triés par taille :", lesDaltonsTaille);
		// Faire un ensemble triés des daltons avec le comparateur de Nom (solution1)
		TreeSet<Dalton> lesDaltonsNom = new TreeSet<Dalton>(new ComparateurNom());
		lesDaltonsNom.addAll(lesDaltons);
	}

	private static void afficheCollection(String message, TreeSet<Dalton> lesDaltons) {
		System.out.println(message);
		for (Dalton d : lesDaltons) {
			System.out.println(d);
		}
	}
}
