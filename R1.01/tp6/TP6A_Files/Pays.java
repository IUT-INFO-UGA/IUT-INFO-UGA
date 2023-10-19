public class Pays implements Comparable<Pays> {

    // attributs
    private String nom; // nom de cePays
    private String continent; // continent de cePays
    private int population; // nombre d'habitants de cePays
    private int superficie; // superficie de cePays

    // constructeur
/*    public Pays(String nom, String continent, int population, int superficie) {
	// À COMPLÉTER...




    }
*/

    // getters
/*    public String getNom() {
	// À COMPLÉTER...



    }
*/

/*    public String getContinent() {
	// À COMPLÉTER...



    }
*/

/*    public int getPopulation() {
	// À COMPLÉTER...



    }
*/

/*    public int getSuperficie() {
	// À COMPLÉTER...



    }
*/

    // ordre sur le nom des pays
    @Override
    public int compareTo(Pays o) {
        // { } =>
        // { résultat = * -1 si le nom de ce Pays précède celui de o dans l'ordre lexicographique
        //                 *  0 si le nom de ce Pays est égal à celui de o
        //                 *  1 si le nom de ce Pays  suit celui de o dans l'ordre lexicographique
        //  À MODIFIER...


        return 0;

    }

    // chaîne représentant ce Pays
    // À NE PAS MODIFIER...
    @Override
    public String toString() {
        return nom + "\n - continent : " + continent
                + "\n - population : " + population + "\n - superficie : " + superficie;
    }
}