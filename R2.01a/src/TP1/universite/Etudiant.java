package TP1.universite;

/**
 * La classe Etudiant représente la notion d'étudiant (login, nom, prénom
 * et adresse).
 * ATTENTION des contraintes sur la notion d’étudiant :
 * – un étudiant doit toujours avoir un login en minuscule
 * – un étudiant doit toujours avoir un nom et un prénom avec
 * le premier caractère en majuscule et les autres en minuscule.
 * 
 * @author https://github.com/UnelDev
 */
public class Etudiant {
	private double[] notes = new double[5];
	private int nbNotes = 0;
	private String login;
	private String nom;
	private String prenom;
	private String adresse;
	private Groupe groupe;

	/**
	 * create Etudent object
	 * 
	 * @param nom    this text has been capitalize
	 * @param prenom this text has been capitalize
	 * @param login  this text has been lowerize
	 */
	public Etudiant(String nom, String prenom, String login) {
		setLogin(login);
		setNom(nom);
		setPrenom(prenom);
	}

	/**
	 * create Etudent object
	 * 
	 * @param nom    this text has been capitalize
	 * @param prenom this text has been capitalize
	 * @param login  this text has been lowerize
	 * @param groupe Groupe object
	 */
	public Etudiant(String nom, String prenom, String login, Groupe groupe) {
		setLogin(login);
		setNom(nom);
		setPrenom(prenom);
		this.groupe = groupe;
	}

	/**
	 * Returns the group of the student.
	 * If the student is not assigned to any group, it returns a default group with
	 * the name "aucun".
	 *
	 * @return the group of the student
	 * @see existGroupe
	 */
	public Groupe getGroupe() {
		if (groupe == null)
			return new Groupe("aucun");
		return groupe;
	}

	public int getNbNotes() {
		return nbNotes;
	}

	public String getLogin() {
		return login;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getAdresse() {
		return adresse == null ? "aucune" : adresse;
	}

	public String getNomComplet() {
		return (prenom + " " + nom);
	}

	/**
	 * @return prenom.nom@@etu.univ-grenoble-alpes.fr"
	 */
	public String getMail() {
		return (prenom + "." + nom) + "@etu.univ-grenoble-alpes.fr";
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	/**
	 * login sera en minuscule
	 * 
	 * @param login String
	 */
	public void setLogin(String login) {
		this.login = login.toLowerCase();
	}

	/**
	 * le nom sera sous la forme Name
	 * 
	 * @param nom string
	 */
	public void setNom(String nom) {
		this.nom = EtudiantUtilitaire.capitalize(nom);
	}

	/**
	 * le prenom sera sous la forme Name
	 * 
	 * @param prenom string
	 */
	public void setPrenom(String prenom) {
		this.prenom = EtudiantUtilitaire.capitalize(prenom);
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * Calcule et retourne la moyenne des notes de l'étudiant.
	 * Si l'étudiant n'a aucune note, la valeur NaN est retournée.
	 *
	 * @return la moyenne des notes de l'étudiant | NaN
	 */
	public double getMoyenne() {
		if (nbNotes == 0)
			return Double.NaN;
		double moyenne = 0;
		for (int i = 0; i < nbNotes; i++) {
			moyenne += notes[i];
		}
		return moyenne / nbNotes;
	}

	/**
	 * Returns the grade at the specified index.
	 * 
	 * @param index the index of the grade to retrieve
	 * @return the grade at the specified index, or Double.NaN if the index is out
	 *         of bounds
	 */
	public double getNotes(int index) {
		if (index < 0 || index >= nbNotes)
			return Double.NaN;
		return notes[index];
	}

	/**
	 * check if the student is assigned to a group
	 * 
	 * @return true if the student is assigned to a group else return false
	 */
	public boolean existGroupe() {
		return groupe != null;
	}

	/**
	 * check if string adress is not empty or null
	 * 
	 * @return if adresse is empty or null
	 */
	public boolean existAdresse() {
		return (adresse == null || adresse.isEmpty());
	}

	public void addNote(double note) {
		if (nbNotes >= 5)
			return;
		notes[nbNotes] = note;
		nbNotes++;

	}
}
