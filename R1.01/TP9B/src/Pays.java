public class Pays implements Comparable<Pays> {

    private String nom; // nom d'un pays
    private String continent; // nom de son continent
    private int population; // nombre d'habitants recensés
    private int superficie; // superficie

    // constructeur
    public Pays(String nom, String continent, int population, int superficie) {
        this.nom = nom;
        this.continent = continent;
        this.population = population;
        this.superficie = superficie;
    }

    // getters
    public String getNom() {
        return nom;
    }

    public String getContinent() {
        return continent;
    }

    public int getPopulation() {
        return population;
    }

    public int getSuperficie() {
        return superficie;
    }

    // ORDRE (continent, nom)
    @Override
    public int compareTo(Pays o) {
        // { } =>
        //  { résultat =  * -1 si le continent de cet objet précède celui de o,
        //                          ou si, à continent égal, le nom de cet objet précède
        //                          celui de o (casse prise en compte)
        //                    * 0  si le continent et le nom de cet objet sont égaux
        //                          à ceux de o (casse prise en compte)
        //                     * 1  sinon  }
        if (this.continent.compareTo(o.getContinent()) < 0 |
                (this.continent.compareTo(o.continent) == 0 & this.nom.compareTo(o.getNom()) < 0)) {
            return -1;
        } else if (this.continent.compareTo(o.getContinent()) == 0 && this.nom.compareTo(o.getNom()) == 0)  {
            return 0;
        } else {
            return 1;
        }
    }
    @Override
    public String toString() {
        return (continent + " (" + nom +  " - " + population + " hab. - "  + superficie + " km2)");
    }
}