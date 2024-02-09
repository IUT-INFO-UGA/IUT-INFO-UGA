public class Polar implements Comparable<Polar>  {

    // attributs
    private int annee; // année de première parution
    private String auteur; // auteur du roman policier
    private String titre; // titre du roman policier

    // constructeur
    public Polar(int annee, String auteur, String titre) {
        this.annee = annee;
        this.auteur = auteur;
        this.titre = titre;
    }

    // getters
    public int getAnnee() {
        return annee;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getTitre() {
        return titre;
    }

    @Override
    public int compareTo(Polar o) {
        // { } =>
        // { résultat = * -1 si l'auteur de ce Polar précède celui de o
        //                        dans l'ordre lexicographique (casse prise en compte),
        //                        ou,
        //                        si, l'auteur de cet Polar est le même que celui de o,
        //                        mais l'année de ce Polar précède strictement celle de o
        //                 *  0  si ce Polar et o ont le même auteur et la même année
        //                 *  1  dans tous les autres cas }
        if (this.auteur.compareTo(o.getAuteur()) < 0
                || (this.auteur.compareTo(o.getAuteur()) == 0 && this.annee < o.getAnnee())) {
            return -1;
        } else if (this.auteur.compareTo(o.getAuteur()) == 0 && this.annee == o.getAnnee()) {
            return 0;
        } else {
            return 1;
        }
    }
    @Override
    public String toString() {
        return "(" + auteur + ", " + annee + ", " + titre + ")";
    }
}
