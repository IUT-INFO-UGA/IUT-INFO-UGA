import java.util.ArrayList;

public class Ile implements Comparable<Ile>{

    private String nom;
    private ArrayList<String> pays;     // liste des pays auxquels l'île appartient
    private float superficie;
    private float longitude;            // voir description sur le sujet
    private float latitude;             // voir description sur le sujet
    private float elevation;              // altitude du point culminant

    public Ile(String nom, ArrayList<String> pays, float superficie, float latitude, float longitude, float elevation) {
        this.nom = nom;
        this.pays = pays;
        this.superficie = superficie;
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<String> getPays() {
        return pays;
    }

    public float getSuperficie() {
        return superficie;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getElevation() {
        return elevation;
    }

    @Override
    /*
        ORDRE(premier pays, superficie) - Exercice 7 (a)
        À DÉCOMMENTER PUIS COMPLÉTER
     */
    public int compareTo(Ile o) {
        // { résultat = * -1 si le premier pays de cette Ile précède strictement celui de o,
        //                        ou si,
        //                        le premier pays de cette Ille est le même que celui de o et
        //                        la superficie de cette Ile est strictement inférieure à celle de o
        //                  *  0 si cette Ile et o ont le même premier pays et la même superficie
        //                  *  1 dans tous les autres cas }
        if (this.pays.get(0).compareTo(o.pays.get(0)) < 0 || (this.pays.get(0).equals(o.pays.get(0)) && this.superficie < o.superficie))
            return -1;
        else if (this.pays.get(0).equals(o.pays.get(0)) && this.superficie == o.superficie)
            return 0;
        else
            return 1;
    }
    public String toString() {
        return "Ile{" +
                "nom=" + nom +
                ", pays=" + pays +
                ", superficie=" + superficie +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", elevation=" + elevation +
                '}';
    }
}
