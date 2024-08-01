package exercice3;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class Module {
    private final String libelle;
    private Semestre semestre;
    private Set<Epreuve> epreuves;

    public Module(String libelle, Semestre semestre){
        this.libelle = libelle;
        this.semestre = semestre;
        epreuves = new HashSet<>();
        if(semestre!=null){
            semestre.addModule(this);
        }
    }
    public String getLibelle() {
        return libelle;
    }

    public int getCoefficient() {
        int coef = 0;
        Iterator<Epreuve> i = epreuves.iterator();
        while (i.hasNext()){
            final Epreuve m = i.next();
            coef+= m.getCoefficient();
        }
        return coef;
    }

    public Set<Epreuve> getEpreuves() {
        return epreuves;
    }

    public void setSemestre(Semestre semestre){
        if(this.semestre!=null){
            this.semestre.removeMoudule(this);
        }
        this.semestre = semestre;
    }

    public void addEpreuve(Epreuve epreuve){
        epreuves.add(epreuve);
    }
}
