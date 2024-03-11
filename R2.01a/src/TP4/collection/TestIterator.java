package TP4.collection;

import java.util.ArrayList;

public class TestIterator {
	public static void main(String[] args) {
		ArrayList<Integer> premiereListeDEntiers = new ArrayList<>();
		premiereListeDEntiers.add(5);
		premiereListeDEntiers.add(1);
		premiereListeDEntiers.add(10);
		premiereListeDEntiers.add(3);
		premiereListeDEntiers.add(20);
		premiereListeDEntiers.add(5);
		// Création d'une deuxième liste d'entiers
		ArrayList<Integer> deuxiemeListeDEntiers = new ArrayList<>(premiereListeDEntiers);
		ArrayList<Integer> troisiemmeListeDEntiers = new ArrayList<>(premiereListeDEntiers);
		// Affichage de la première liste d'entiers
		CollectionUtilitaire.afficheCollection("Affichage de la première liste d'entiers", premiereListeDEntiers);
		// Enlever les entiers inferieurs à 10 dans la première liste d'entiers en
		// utilisant un FOR
		for (int i = 0; i < premiereListeDEntiers.size(); i++) {
			if (premiereListeDEntiers.get(i) < 10)
				premiereListeDEntiers.remove(i);
		}
		// Affichage de la liste première d'entiers après filtre
		CollectionUtilitaire.afficheCollection("Affichage de la liste première d'entiers après filtre",
				premiereListeDEntiers);
		// Affichage de la deuxième liste d'entiers
		CollectionUtilitaire.afficheCollection("Affichage de la deuxième liste d'entiers", deuxiemeListeDEntiers);
		// Enlever les entiers inferieurs à 10 dans la deuxième liste d'entiers en
		// utilisant un WHILE
		int i = 0;
		while (i < deuxiemeListeDEntiers.size()) {
			if (deuxiemeListeDEntiers.get(i) < 10)
				deuxiemeListeDEntiers.remove(i);
			else
				i++;
		}
		// Affichage de la deuxième liste d'entiers après filtre
		CollectionUtilitaire.afficheCollection("Affichage de la deuxième liste d'entiers après filtre",
				deuxiemeListeDEntiers);

		// affichage de la troisième liste d'entiers
		CollectionUtilitaire.afficheCollection("Affichage de la troisième liste d'entiers", troisiemmeListeDEntiers);
		// Enlever les entiers inferieurs à 10 dans la troisième liste d'entiers grace a
		// l'ITERATOR
		troisiemmeListeDEntiers.removeIf(i1 -> i1 < 10);
		// Affichage de la troisième liste d'entiers après filtre
		CollectionUtilitaire.afficheCollection("Affichage de la troisième liste d'entiers après filtre",
				troisiemmeListeDEntiers);
	}
}
