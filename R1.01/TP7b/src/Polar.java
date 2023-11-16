 public class Polar implements Comparable<Polar>{

    // attributs
    private int annee; // année de première parution de ce Polar
    private String auteur; // auteur de ce Polar
    private String titre; // titre de ce Polar

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
        // { résultat = -1 si l'auteur de ce Polar précède celui de o
        // dans l'ordre lexicographique (casse prise en compte)
        // ou si l'auteur de ce Polar est le même que celui de o
        // et l'année de ce Polar précède strictement celle de o
        //
        // résultat = 0 si l'auteur de ce Polar et celui de o sont les mêmes
        // et l'année de ce Polar est égale à celle de o
        //
        // résultat = 1 dans tous les autres cas }
        if(this.auteur.compareTo(o.getAuteur())<0) return -1;
        else if(this.auteur.compareTo(o.getAuteur())==0){
            if(this.annee<o.annee) return -1;
            else if (this.annee == o.annee) return 0;
        } else {
            return 1;
        }
		return 1;
	}

     @Override
     public String toString() {
        // { } => { résultat = chaîne représentant ce Polar
        // sous la forme (auteur, annee, titre) }
         return '('+this.auteur+','+this.annee+','+this.titre+')';
    }
}