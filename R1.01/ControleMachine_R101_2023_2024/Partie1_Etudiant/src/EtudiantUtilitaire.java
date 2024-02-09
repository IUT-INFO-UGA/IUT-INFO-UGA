import java.util.Scanner;

public class EtudiantUtilitaire {
    /**
     * À ÉCRIRE - Exercice 1
     * @return cf. postcondition
     */
    public static float saisirNote() {
        // { } =>
        // { résultat = une valeur de type float dans l'intervalle [0,0 .. 20,0]
        //                 saisie par l'utlllisateur }
        final Scanner in = new Scanner(System.in);
        float value;
        do {
            System.out.print("Entrer un float entre 0 et 20,0: ");
            value = in.nextFloat();
            in.nextLine();
        } while (value < 0f || value > 20f);
        return value;
    }

}
