package TP1.universite;

public class TestEtudiant {
	public static void main(String[] args) {

		final Etudiant etudiant1 = new Etudiant("DUPONTP", "pierre", "DUPONT", new Groupe("A"));
		final Etudiant etudiant2 = new Etudiant("martinf", "francis", "martin");
		etudiant2.addNote(8.5);
		etudiant2.addNote(10.0);
		etudiant2.addNote(11.5);
		etudiant2.setAdresse("2 Place Doyen Gosse");
		System.out.println(EtudiantUtilitaire.affiche(etudiant1));
		System.out.println();
		System.out.println();
		System.out.println(EtudiantUtilitaire.affiche(etudiant2));
	}
}
