package tp2.universite;

public class Etudiant extends Personne {
	private String adresseParent;

	Etudiant(String login, String prenom, String nom) {
		super(login, prenom, nom);
	}

	Etudiant(String login, String prenom, String nom, String adresse, String adresseParent) {
		super(login, prenom, nom, adresse);
		this.adresseParent = adresseParent;
	}

	// getters
	public String getMail() {
		return getPrenom().toLowerCase() + "." + getNom().toLowerCase() + "@etu.univ-grenoble-alpes.fr";
	}

	public String getAdresse() {
		if (super.existAdresse() && existAdresse())
			return adresseParent + " (parent)" + (super.getAdresse() == null ? "aucune" : super.getAdresse())
					+ " (etudiant)";
		else if (super.existAdresse())
			return super.getAdresse();
		else
			return getAdresseParent();
	}

	public String getAdresseParent() {
		return adresseParent == null ? "aucune" : adresseParent;
	}

	// setters
	public void setAdresse(String adresse, String adresseParent) {
		super.setAdresse(adresse);
		this.adresseParent = adresseParent;
	}

	public boolean existAdresse() {
		return adresseParent != null && adresseParent.trim() != "";
	}
}
