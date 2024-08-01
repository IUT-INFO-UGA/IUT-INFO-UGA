package exercice3;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// A COMPLETER
public class Semestre {
    private final String libelle;
    private Set<Module> modules;

    public Semestre(String  libelle){
        this.libelle = libelle;
        modules = new HashSet<>();
    }
    public String getLibelle() {
        return libelle;
    }

    // A COMPLETER
    public int getCoefficient() {
        int coef = 0;
        Iterator<Module> i = modules.iterator();
        while (i.hasNext()){
            final Module m = i.next();
            coef+= m.getCoefficient();
        }

        return coef;
    }

    // A COMPLETER
    public Set<Module> getModules() {
        return modules;
    }

    public void addModule(Module module){
        module.setSemestre(this);
        modules.add(module);
    }

    public void removeMoudule(Module module){
        modules.remove(module);
    }
}
