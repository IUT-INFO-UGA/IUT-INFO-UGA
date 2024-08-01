package exercice3;

// A COMPLETER
public class Note {
	private final double valeur;
	private Epreuve epreuve;
	private Etudiant etudiant;
	public Note(Epreuve epreuve, Etudiant etudiant, double valeur){
		this.valeur = valeur;
		this.epreuve = epreuve;
		this.etudiant = etudiant;
		epreuve.addNotes(this);
	}

	public double getValeur() {
		return valeur;
	}

	public Etudiant getEtudiant(){
		return etudiant;
	}

	public Epreuve getEpreuve() {
		return epreuve;
	}
}
