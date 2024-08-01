package exercice3;

/**
 * 
 * NE PAS MODIFIER
 * 
 * @author fbm
 */
public enum TypeEpreuve {
    
    ///////////////////// IMPORTANT
    // Exemple d'utilisation
    // TypeEpreuve.ControleContinu
    /////////////////////
    
    // 
    ControleContinu("Contrôle continu"),
    ControleFinal("Contrôle final"),
    Projet("Projet");
    
    // Libelle associé au type d'epreuve
    private String libelle;
    
    // Constructeur
    private TypeEpreuve(String libelle) {
        this.libelle = libelle;
    }

    /**
     * Retourne le libelle du type d'epreuve
     * 
     * @return 
     */
    @Override
    public String toString() {
        return libelle;
    }
    
    
}
