package TP4.tabledemultiplication;

import java.util.Scanner;

public class TestTableDeMultiplication {
	final static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Donner un nombre pour la table de multiplication entre 1 et 10 :");
		final int size = readNumber(10, 1);
		System.out.println("Entrainement 1 ou exercice 2 ?");
		final boolean isEntrainement = readNumber(2, 1) == 1;
		System.out.println("Avec erreurs 1 ou sans erreurs 2 ?");
		final TableDeMultiplication tm = new TableDeMultiplication(size, isEntrainement, readNumber(2, 1) == 1);
		for (int i = 0; i < tm.getNombreDeMultiplications(); i++) {
			final Multiplication m = tm.getMultiplication(i);
			System.out.println(m);
			boolean error = true;
			while (error) {
				final int nb = in.nextInt();
				try {
					m.setReponseUtilisateur(nb);
					error = false;
				} catch (ErreurMultiplicationException e) {
					System.out.println("La réponse est incorrecte, veuillez recommencer.");
					System.out.println(m);
				}
			}
		}
		System.out.println("Vous avez " + tm.getNombreReponsesJustes() + " bonnes réponses sur "
				+ tm.getNombreDeMultiplications());
	}

	private static int readNumber(final int max, final int min) {
		int nombre = 0;
		boolean estValide = false;
		do {
			nombre = in.nextInt();
			estValide = nombre >= min && nombre <= max;
			if (!estValide) {
				System.out.println("Le nombre doit être entre " + min + " et " + max);
			}
		} while (!estValide);
		System.out.println("Vous avez choisi " + nombre);
		return nombre;
	}
}
