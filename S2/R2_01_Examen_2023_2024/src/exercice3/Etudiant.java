package exercice3;


/**
 * 
 * NE PAS MODIFIER
 * 
 * @author fbm
 */
public class Etudiant {
     
    private String prenom;
    private String nom;
    private Groupe groupe;

    public Etudiant(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    /**
     * Ajoute un groupe à l'étudiant (synchronisé avec le groupe)
     * 
     * @param groupe 
     */
    public void setGroupe(Groupe groupe) {
        if (this.groupe != groupe) {
            this.groupe = groupe;
            groupe.addEtudiant(this);
        }
    }
    
    public String getNomComplet() {
        return getNom() + " " + getPrenom();
    }
    
}
