import java.text.NumberFormat;

public class PaysDeCont implements Comparable<PaysDeCont> {
    private String nom; // nom d'un pays
    private int population; // nombre d'habitants recensés
    private int superficie; // superficie

    // constructeur
    public PaysDeCont(String nom, int population, int superficie) {
        this.nom = nom;
        this.population = population;
        this.superficie = superficie;
    }

    // getters
    public String getNom() {
        return nom;
    }

    public int getPopulation() {
        return population;
    }

    public int getSuperficie() {
        return superficie;
    }

    // ordre sur le nom
    @Override
    public int compareTo(PaysDeCont o) {
        // { } =>
        //  { résultat =  * -1 si le nom de cet objet précède celui de o (casse prise en compte)
        //                    * 0  si le nom est égal à celui de o (casse prise en compte
        //                    * 1  sinon  }
        if (this.nom.compareTo(o.getNom()) < 0) {
            return -1;
        } else if (this.nom.compareTo(o.getNom()) == 0)  {
            return 0;
        } else {
            return 1;
        }
    }
    @Override
    public String toString() {
        //  les entiers sont formatées pour être affichés selon les normes françaises
        //  (exemple : 12345678 sera affiché 12 345 678)
        NumberFormat formatter =  java.text.NumberFormat.getInstance(java.util.Locale.FRENCH);
        return ( nom +  " (" + formatter.format(population) + " hab. - "  + formatter.format(superficie) + " km2)");
    }
}
