package TP1.universite;

public class EtudiantUtilitaire {
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
		return var.substring(0, 1).toUpperCase() + (var.substring(1)).toLowerCase();
	}

	/**
	 * Returns a formatted string representation of the given Etudiant object.
	 * The string includes the login, full name, email, and address of the student.
	 *
	 * @param stud the Etudiant object to be displayed
	 * @return a formatted string representation of the student's information
	 */
	public static String affiche(Etudiant stud) {
		return "login : " + stud.getLogin() + "\nNom complet : " + stud.getNomComplet() + "\nMail : " + stud.getMail()
				+ "\nAdresse : " + stud.getAdresse();
	}
}
