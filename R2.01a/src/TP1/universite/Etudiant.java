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
	private String login;
	private String nom;
	private String prenom;
	private String adresse;

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
	 * check if string adress is not empty or null
	 * 
	 * @return if adresse is empty or null
	 */
	public boolean existAdresse() {
		return (adresse == null || adresse.isEmpty());
	}
}
