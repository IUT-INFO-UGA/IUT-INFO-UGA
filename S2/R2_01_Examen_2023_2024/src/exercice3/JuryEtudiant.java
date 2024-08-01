package exercice3;

import java.util.HashMap;

// A COMPLETER
public class JuryEtudiant {


    private int moyenne_generale;
    private HashMap<Module, Double> moyenne_modules;
    private Semestre semestre;
    private Etudiant etudiant;

    public JuryEtudiant(Semestre semestre, Etudiant etudiant){
        this.semestre = semestre;
        this.etudiant = etudiant;
    }
    public Etudiant getEtudiant() {
        return etudiant;
    }

    // A COMPLETER
    public double getMoyenne_generale() {return 0}
}
