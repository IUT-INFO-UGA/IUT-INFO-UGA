package exercice3.utilitaires;

import exercice3.JuryGroupe;
import exercice3.JuryEtudiant;


// A COMPLETER
public class JuryUtilitaire {
    
    /**
     * Méthode permettant l'affichage de l'objet de type JuryEtudiant passé en paramètre
     * 
     * @param juryEtu 
     */
    public static void afficherJuryEtudiant(JuryEtudiant juryEtu) {
        
        // 1/ Affichage du nom complet de l'étudiant
        System.out.println("Jury de l'étudiant : "+ juryEtu.getEtudiant().getNomComplet());
        System.out.println("Moyenne générale : " + juryEtu.getMoyenne_generale());

        // 2/ Affichage de la moyenne générale et des moyennes des modules
        
        // A COMPLETER
        
    }
    
    /**
     * Méthode permettant l'affichage de l'objet de type JuryGroupe passé en paramètre
     * 
     * @param jury 
     */
    public static void afficherJuryGroupe(JuryGroupe jury) {
        
        // Affichage du jury de chaque étudiant (classé par rang)
        
        // A COMPLETER
        
    }
}
