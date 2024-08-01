package tp2.contrainte;

import java.util.Scanner;

public class ContrainteUtilitaire {
	public static ReelContraint saisir(double min, double max) {
		final Scanner in = new Scanner(System.in);
		final ReelContraint out = new ReelContraint(min, max);
		double valeur;
		do {
			System.out.println("Saisir une valeur entre " + min + " et " + max);
			valeur = in.nextDouble();
		} while (valeur < min || valeur > max);
		out.setValeur(valeur);
		in.close();
		return out;
	}
}
