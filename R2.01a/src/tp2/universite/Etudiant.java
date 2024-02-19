package tp2.universite;

import java.util.ArrayList;

import tp2.contrainte.Note;

public class Etudiant extends Personne {
	private String adresseParent;
	private ArrayList<Note> notes;

	Etudiant(String login, String prenom, String nom) {
		super(login, prenom, nom);
		notes = new ArrayList<Note>();
	}

	Etudiant(String login, String prenom, String nom, String adresse, String adresseParent) {
		super(login, prenom, nom, adresse);
		this.adresseParent = adresseParent;
		notes = new ArrayList<Note>();
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

	// notes
	public void addNote(double valeur) {
		notes.add(new Note(valeur));
	}

	public double getAvrange() {
		if (notes.isEmpty())
			return Double.NaN;
		double sum = 0;
		for (Note note : notes) {
			sum += note.getValeur();
		}
		return sum / notes.size();
	}

	public boolean existAdresse() {
		return adresseParent != null && adresseParent.trim() != "";
	}
}
