package tp2.universite;

import java.util.ArrayList;

public class TestUniversite {
	public static void main(String[] args) {
		// Création d'une liste de personnes
		ArrayList<Personne> personnes = new ArrayList<>();
		// Création de deux personnes
		// Personne personne1 = new Personne("martinp", "Philippe", "MARTIN");
		// Personne personne2 = new Personne("blanchonh", "Hervé", "BLANCHON", "2 Place
		// Doyen Gosse");
		// Ajouter les deux personnes à la liste
		// personnes.add(personne1);
		// personnes.add(personne2);
		// Création de trois étudiants
		Etudiant etudiant1 = new Etudiant("SANZF", "FLORIANT", "Sanz");
		Etudiant etudiant2 = new Etudiant("portepa", "Pierre-Antoine", "Porte");
		Etudiant etudiant3 = new Etudiant("burlatn", "nils", "burlat", "1 rue pas loin", "10 rue des parents");
		// Ajouter l'adresse de ses parents à l'étudiant1
		// Ajouter l'adresse personnelle de l'étudiant2
		etudiant1.setAdresse("13 rue à côté", "23 rue beaucoup plus loin");
		etudiant2.setAdresse("30 avenue Berlioz");
		// Ajouter les trois étudiants à la liste
		personnes.add(etudiant1);
		personnes.add(etudiant2);
		personnes.add(etudiant3);
		// Affichage des personnes
		// Utilisation d'une simplifacation d'écriture avec le for
		for (Personne personne : personnes) {
			UniversiteUtilitaire.affichePersonne(personne);
		}

		// Création de deux personnels
		Personnel personnel1 = new Personnel("goulianj", "Jérôme", "Goulian");
		Personnel personnel2 = new Personnel("brunetf", "Francis", "Brunet-Manquat", 0, 1400);
		Personnel personnel3 = new Personnel("lejeuna", "Anne", "Lejeune");
		personnel3.setEchelon(5);
		personnel3.setPointDIndice(900);
		// Ajouter les personnels à la liste personnes
		personnes.add(personnel1);
		personnes.add(personnel2);
		personnes.add(personnel3);
		// Créer et ajouter les personnels à une liste personnels
		ArrayList<Personnel> personnels = new ArrayList<>();
		personnels.add(personnel1);
		personnels.add(personnel2);
		personnels.add(personnel3);
		// Affichage des personnes
		// Utilisation d'une simplifacation d'écriture avec le for
		for (Personne personne : personnes) {
			UniversiteUtilitaire.affichePersonne(personne);
		}
		// Affichage du personnel
		for (Personnel personnel : personnels) {
			UniversiteUtilitaire.affichePersonnel(personnel);
		}
	}
}
