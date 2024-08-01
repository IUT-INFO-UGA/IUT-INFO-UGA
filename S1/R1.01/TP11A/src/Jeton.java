public class Jeton implements Comparable<Jeton> {
    // attributs
    private char lettre;
    private int valeur;

    // constructeur
    public Jeton(char lettre, int valeur) {
        this.lettre = lettre;
        this.valeur = valeur;
    }

    // getters
    public char getLettre() {
        return this.lettre;
    }
    public int getValeur() {
        return this.valeur;
    }

    @Override
    // ordre naturel sur l'attribut valeur – À COMPLÉTER
    public int compareTo(Jeton o) {
        // { résultat = -1 si ce Jeton a une valeur inférieure à celle de o
        //                  0 si la valeur de ce Jeton est égale à celle de o
        //                  1 sinon }
        if (this.valeur < o.valeur) {
            return -1;
        } else if (this.valeur == o.valeur) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    // chaîne représentant ce Jeton
    public String toString()  {
        return "(" + lettre + ", " + valeur + ")";
    }

}
