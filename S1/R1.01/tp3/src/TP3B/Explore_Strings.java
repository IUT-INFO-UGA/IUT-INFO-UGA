package TP3B;

public class Explore_Strings {
	private static int nbOccCar(String uneChaine, char unCar) {
		// { } => { résultat = nombre de fois où le caractère unCar
		// apparaît dans la chaîne uneChaine }
		int occ = 0;
		for (int i = 0; i < uneChaine.length(); i++) {
			if (uneChaine.charAt(i) == unCar) occ++;
		}
		return occ;
	}

	public static void main(String[] args) {
		final String lipogramme = "Un rond pas tout à fait clos, fini par un trait horizontal";
		final String lesVoyellesSansAcc = "aeiouy";
		final String ch1 = "Il y a huit mots dans cette phrase.";
		final String ch2 = "CE TP GAGNERAIT À ÊTRE TERMINÉ.";
		System.out.println("Analyse de la chaîne " + lipogramme);
		for (int i = 0; i < lesVoyellesSansAcc.length(); i++) {
			System.out.print("* Nombre de '" + lesVoyellesSansAcc.charAt(i) + "': " + nbOccCar(lipogramme, lesVoyellesSansAcc.charAt(i)));
			System.out.println();
		}
		System.out.println("--------------------------\nNOMBRE DE MOTS\n--------------------------");
		System.out.println("Nombre de mots dans la chaîne \"" + ch1 + "\":" + nbMots(ch1));
		System.out.println("Nombre de mots dans la chaîne \"" + ch2 + "\":" + nbMots(ch2));
		System.out.println("---------------------------------------------------------\n" +
				"NOMBRE DE MAJUSCULES NON ACCENTUÉES\n" +
				"---------------------------------------------------------");
		System.out.println("Nombre de majuscules non accentuées dans la chaîne \"" + ch1 + "\":" + nbLettresMajSansAccent(ch1));
		System.out.println("Nombre de majuscules non accentuées dans la chaîne \"" + ch2 + "\":" + nbLettresMajSansAccent(ch2));
		System.out.println("----------------------------------------------------------------\n" +
				"PLUS GRAND NOMBRE DE CARACTÈRES D'UN MOT\n" +
				"----------------------------------------------------------------");
		System.out.println("Nombre maximal de caractères d'un mot de la chaîne \"" + ch1 + "\":" + nbCarMax(ch1));
		System.out.println("Nombre maximal de caractères d'un mot de la chaîne \"" + ch2 + "\":" + nbCarMax(ch2));
	}

	private static int nbLettresMajSansAccent(String uneChaine) {
		// { } => { résultat = nombre de lettres majuscules
		// non accentuées dans uneChaine }
		int maj = 0;
		for (int i = 0; i < uneChaine.length(); i++) {
			if (uneChaine.charAt(i) >= 'A' && uneChaine.charAt(i) <= 'Z') maj++;
		}
		return maj;
	}

	private static int nbMots(String uneChaine) {
		return uneChaine.split(" ").length;
	}

	private static int nbCarMax(String uneChaine) {
		// { uneChaine ne contient que :
		// * des lettres de l'alphabet (accentuées ou non)
		// * des espaces
		// * un point final }
		// => { résultat = plus grand nombre de caractères
		// d'un mot de uneChaine }
		// NOTE : un mot est constitué de lettres de l'alphabet
		uneChaine = uneChaine.substring(0, uneChaine.length() - 1);
		final String[] stringArray = uneChaine.split(" ");
		int max = 0;
		for (int i = 0; i < stringArray.length; i++) {
			if (stringArray[i].length() > max) max = stringArray[i].length();
		}
		return max;
	}
}
