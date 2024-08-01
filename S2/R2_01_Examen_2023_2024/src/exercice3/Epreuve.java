package exercice3;

import java.util.ArrayList;
import java.util.Objects;

// A COMPLETER
public class Epreuve {

    private final int coefficient;
    private final TypeEpreuve type;
    private final Module module;

    private final ArrayList<Note> notes;

    public Epreuve(TypeEpreuve type, Module module, int coefficient){
        this.coefficient = coefficient;
        this.type = type;
        this.module = module;
        notes = new ArrayList<>();
        module.addEpreuve(this);
    }


    // A COMPLETER
    public TypeEpreuve getType() {
        return type;
    }

    // A COMPLETER
    public int getCoefficient() {
        return coefficient;
    }

    public void addNotes(Note note){
        notes.add(note);
    }

    public boolean containsNote(Etudiant etudiant){
        boolean found = false;
        for (int i = 0; (i < notes.size() && !found); i++) {
			if (Objects.equals(notes.get(i).getEtudiant().getNomComplet(), etudiant.getNomComplet())) {
				found = true;
			}
        }
        return  found;
    }

    public double getValeurNote(Etudiant etudiant){
        double note = -1;
        for (int i = 0; (i < notes.size() && note==-1); i++) {
            if (Objects.equals(notes.get(i).getEtudiant().getNomComplet(), etudiant.getNomComplet())) {
                note = notes.get(i).getValeur();

            }
        }
        return  note;
    }
}
