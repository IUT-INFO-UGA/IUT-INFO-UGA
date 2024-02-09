import java.util.ArrayList;

/**
 * CLASSE À COMPLÉTER - Exercices 2 et 3
 */
public class Etudiant {
    // attributs : nom, prenom et notes - Exercice 2
	String nom;
	String prenom;
	ArrayList<Float> notes = new ArrayList<>();

    // constructeur avec nom et prenom comme paramètres - Exercice 2
	public Etudiant(String nom, String prenom){
		this.nom = nom;
		this.prenom = prenom;
	}

    // Accesseur
    // notes de cet Etudiant - Exercice 2

	public ArrayList<Float> getNotes() {
		return notes;
	}


	// Autres méthodes
    // Consultation du nom complet de cet Etudiant - Exercice 2
	public String getNomComplet(){
		return (this.prenom + ' ' + this.nom);
	}

    // Ajout d'un élément dans notes de cet Etudiant - Exercice 2
	public void addNote(float notes){
		this.notes.add(notes);
	}
    // Nombre de notes de cet Etudiant - Exercice 2  
	public int getNbNotes(){
		return this.notes.size();
	}

    // Consultation de la moyenne de notes pour cet Etudiant
    // V1 - Moyenne sachant que notes n'est pas vide - Exercice 2
	public float getMoyenneV1(){
		float tot = 0;
		for (Float note : this.notes) {
			tot += note;
		}
		return (tot / this.notes.size());
	}

    // V2 - Moyenne sachant que notes est peut-être vide - Exercice 3
	public float getMoyenneV2() throws ExceptionMoyenneNonCalculable {
		if (this.notes.isEmpty()) {
			throw new ExceptionMoyenneNonCalculable(getNomComplet()+" n'a pas de notes !");
		}
		float tot = 0;
		for (Float note : this.notes) {
			tot += note;
		}
		return (tot / this.notes.size());
	}
}
