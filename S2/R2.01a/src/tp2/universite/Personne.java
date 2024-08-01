package tp2.universite;

public abstract class Personne {
	private String login;
	private String nom;
	private String prenom;
	private String adresse;

	Personne(String login, String prenom, String nom) {
		setNom(nom);
		setPrenom(prenom);
		setLogin(login);
	}

	Personne(String login, String prenom, String nom, String adresse) {
		this(login, prenom, nom);
		setAdresse(adresse);
	}

	// getters
	public String getLogin() {
		return login;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getNom() {
		return nom;
	}

	public String getAdresse() {
		return adresse == null ? "aucune" : adresse;
	}

	public String getNomComplet() {
		return getPrenom() + " " + getNom();
	}

	public abstract String getMail();

	// setters
	/**
	 * Sets the login for the person.
	 * The login is converted to lowercase before being assigned.
	 * 
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login.toLowerCase();
	}

	/**
	 * Sets the name of the person.
	 * the name is capitalized before being assigned.
	 * 
	 * @param nom the name to set
	 */
	public void setNom(String nom) {
		this.nom = UniversiteUtilitaire.capitalize(nom);
	}

	/**
	 * Sets the first name of the person.
	 * the first name is capitalized before being assigned.
	 * 
	 * @param nom the first name to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = UniversiteUtilitaire.capitalize(prenom);
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public boolean existAdresse() {
		return adresse != null && adresse.trim() != "";
	}
}
