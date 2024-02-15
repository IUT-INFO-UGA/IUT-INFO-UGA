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
	 *
	 * @param stud the Etudiant object to be displayed
	 * @return a formatted string representation of the student's information
	 */
	public static String affiche(Etudiant stud) {
		String returns = "login : " +
				stud.getLogin() +
				"\nNom complet : " +
				stud.getNomComplet() +
				"\n  groupe : " +
				(stud.existGroupe() ? stud.getGroupe().getLibelle() : "aucun") +
				"\nMail : " + stud.getMail() +
				"\nAdresse : " +
				stud.getAdresse() +
				"\nMoyenne : " +
				(Double.isNaN(stud.getMoyenne())
						? "aucune"
						: Double.toString(stud.getMoyenne()));

		if (stud.getNbNotes() > 0) {
			returns += "\n" + stud.getNbNotes() + " Notes : ";
			for (int i = 0; i < stud.getNbNotes(); i++) {
				returns += stud.getNotes(i) + " ";
			}
		}
		return returns;
	}
}
