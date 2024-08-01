package tp2.universite;

public class UniversiteUtilitaire {
	/**
	 * Capitalizes the first letter of a given string and converts the rest of the
	 * letters to lowercase.
	 * 
	 * @param var the string to be capitalized
	 * @return the capitalized string
	 */
	public static String capitalize(String var) {
		if (var == null)
			return var;
		final String[] split = var.split("-");
		for (int i = 0; i < split.length; i++) {
			split[i] = split[i].substring(0, 1).toUpperCase() + (split[i].substring(1)).toLowerCase();
		}
		return String.join("-", split);
	}

	public static void affichePersonne(Personne personne) {
		System.out.println("\n\n-----------------\nlogin: " + personne.getLogin() +
				"\n nom complet: " + personne.getNomComplet() +
				"\n Mail: " + personne.getMail() +
				"\n Adresse: " + personne.getAdresse());
	}

	public static void affichePersonnel(Personnel personnel) {
		System.out.println("\n\n-----------------\nlogin: " + personnel.getLogin() +
				"\n nom complet: " + personnel.getNomComplet() +
				"\n Mail: " + personnel.getMail() +
				"\n Adresse: " + personnel.getAdresse() +
				"\n Echelon: " + personnel.getEchelon() +
				"\n Point d'indice: " + personnel.getPointDIndice() +
				"\n Salaire: " + personnel.getSalaire());
	}
}
