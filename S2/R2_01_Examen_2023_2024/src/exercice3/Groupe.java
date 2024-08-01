package exercice3;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * NE PAS MODIFIER
 * 
 * @author fbm
 */
public class Groupe {
    
    private String libelle;
    
    // Les étudiants du groupe
    private HashSet<Etudiant> etudiants;
    
    public Groupe(String libelle) {
        this.libelle = libelle;
        etudiants = new HashSet<Etudiant>();
    }
    
    
    /**
     * Ajoute un étudiant au groupe (synchronisé avec l'étudiant)
     * 
     * @param etudiant 
     */
    public void addEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
        etudiant.setGroupe(this);
    }

    /**
     * Retourne la liste des étudiants du groupe 
     * 
     * @return 
     */
    public Set<Etudiant> getEtudiants() {
        return etudiants;
    }
    
    
    
    
    
}
