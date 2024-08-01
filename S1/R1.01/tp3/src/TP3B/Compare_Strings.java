package TP3B;

import java.util.Scanner;

public class Compare_Strings {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String unChat = "chat";
		String unPetitChat = "chaton";
		String unChien = "chien";
		String toBeReplaced = "";

		// 1 - Premiers tests
		System.out.println("------------------------------------------------------");
		System.out.println("Premiers tests de comparaison de chaînes");
		System.out.println("------------------------------------------------------");
		System.out.println("Chaînes comparées...");
		System.out.println("    unChat --> \"" + unChat + "\"");
		System.out.println("    unChien --> \"" + unChien + "\"");
		System.out.println("    unPetitChat --> \"" + unPetitChat + "\"");
		System.out.println("Comparaisons entre ces chaînes (casse prise en compte)");
		System.out.println("    unChat comparé à unChien --> " + unChat.compareTo(unChien));
		System.out.println("    unChien comparé à unPetitChat --> " + unChien.compareTo(unChat));
		System.out.println("    unPetitChat comparé à unChat ---> " + unPetitChat.compareTo(unChat));
		System.out.println("    unPetitChat comparé à unPetitChat ---> " + unPetitChat.compareTo(unPetitChat));
		System.out.println("------------------------------------------------------");

		// 2 - Comparaisons entre des chaînes saisies par l'utilisateur
        /*
            Déclarations - À NE PAS MODIFIER
            (les variables sont initialisées pour que le code soit compilable)
         */
		String ch1 = "", ch2 = ""; // pour les chaines à saisir
		int resComp = 0; // pour le résultat de la comparaison entre ch1 et ch2
		int nbCarCh1 = 0; // pour le nombre de caractères de ch1
		int nbCarCh2 = 0; // pour le nombre de caractères de ch2

		// initialisation par saisie de ch1 - À COMPLÉTER...
		System.out.print("Entrer une chaîne : ");
		ch1 = in.nextLine();
		// initialisation par saisie de ch2 - À COMPLÉTER...
		System.out.print("Entrer une autre chaîne : ");
		ch2 = in.nextLine();
		// nombre de caractères de ch1 - À COMPLÉTER...
		nbCarCh1 = ch1.length();
		// nombre de caractères de ch2 - À COMPLÉTER...
		nbCarCh2 = ch2.length();
		// SI ch1 ou ch2 est vide. : déterminer la valeur de resComp (cf. page 1)
		// - À COMPLÉTER...
		if (nbCarCh1 == 0 || nbCarCh2 == 0) {
			if (nbCarCh1 == 0) resComp = -nbCarCh2;
			if (nbCarCh2 == 0) resComp = nbCarCh1;
		} else {
			// SINON...
			// 1 : position du dernier caractère pouvant être comparé dans ch1 et ch2
			// - À NE PAS MODIFIER !
			int indDerCarToCompare = Math.min(nbCarCh1, nbCarCh2) - 1;
			// 2 : nouvelles déclarations jugées nécessaires et boucle while
			// - À COMPLÉTER...
			int i = 0;
			while (i <= indDerCarToCompare) {
				if (ch1.charAt(i) != ch2.charAt(i)) {
					resComp = ch1.charAt(i) - ch2.charAt(i);
				}
				i++;
			}
			// 3 : en sortie de boucle, déterminer la valeur de resComp (cf. page 1)
			//  - À COMPLÉTER...
			if (resComp == 0) resComp = ch1.length() - ch2.length();
		}



       /*
            Message pour l'utilisateur - À NE PAS MODIFIER !
        */
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Comparaison entre les chaînes \"" + ch1 + "\" et \"" + ch2 + "\"");
		System.out.println("-----------------------------------------------------------------");
		System.out.println();
		System.out.println("Résultat de la comparaison de \"" + ch1 + "\" et \"" + ch2 + "\" par programme : " + resComp);
		System.out.println();
		System.out.println("Vérification...");
		System.out.println("Résultat de la comparaison de \"" + ch1 + "\" et \"" + ch2 + "\" avec compareTo : " + ch1.compareTo(ch2));
	}
}
