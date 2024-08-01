package exercice3.utilitaires;

import exercice3.Epreuve;
import exercice3.Module;
import exercice3.Semestre;

/**
 * 
 * NE PAS MODIFIER
 * 
 * @author fbm
 */
public class MaquetteUtilitaire {
    
    
    /**
     * Méthode permettant l'affichage de l'objet de type Semestre passé en paramètre
     * 
     * @param semestre 
     */
    public static void afficherSemestre(Semestre semestre) {
        
        // 
        System.out.println("\n------------------");
        
        // 1/ Afficher les informations du semestre : libelle et coefficient
        // 2/ Afficher les modules du semestre
        System.out.print("Semestre : " + semestre.getLibelle());
        System.out.println(", coefficient " + semestre.getCoefficient());
        for(Module module : semestre.getModules()) {
            afficherModule(module);
        }
    }

    /**
     * Méthode permettant l'affichage de l'objet de type Module passé en paramètre
     * 
     * @param module 
     */
    private static void afficherModule(Module module) {
        
        // 
        System.out.print("  + Module : ");
        
        // 1/ Afficher les informations du module : libelle et coefficient
        // 2/ Afficher les epreuves du semestre
        System.out.println(module.getLibelle() + ", coefficient " + module.getCoefficient());
        for(Epreuve epreuve : module.getEpreuves()) {
            afficherEpreuve(epreuve);
        }
    }

    /**
     * Méthode permettant l'affichage de l'objet de type Epreuve passé en paramètre
     * 
     * @param epreuve 
     */
    private static void afficherEpreuve(Epreuve epreuve) {
        // 
        System.out.print("    - Epreuve : ");
        
        // 1/ Afficher les informations de l'epreuve : type et coefficient
        // 2/ Afficher les epreuves du semestre
        System.out.println(epreuve.getType() + ", coefficient " + epreuve.getCoefficient());
    }
    
}
