import java.util.Scanner;

public class Nim {
    private static int saisieEntSupEgalMin(int min) {
        Scanner l = new Scanner(System.in);
        int value;
        do {
            System.out.print("Entrez un entier plus grand ou égal à " + min + ": ");
            value = l.nextInt();
            l.nextLine();
        } while (value < min);
        return value;
    }

    private static int unePrise(int reste, int max) {
        Scanner l = new Scanner(System.in);
        int value;
        do {
            System.out.print("Entrez un entier (min 1, max " + max + "): ");
            value = l.nextInt();
            l.nextLine();
        } while (value > reste || value > max || value < 1);
        return value;
    }

    public static void main(String[] args) {
        final int MINJOUEURS = 2;
        final int MAXPRISE = 3;
        int nbJoueurs, nbAllumettes, numJoueur, nbCoups;
        numJoueur = 1;
        nbCoups = 0;


        System.out.println("------------------------------------------------");
        System.out.println("Nombre de joueurs ?");
        nbJoueurs = saisieEntSupEgalMin(MINJOUEURS);
        System.out.println("------------------------------------------------");
        System.out.println("Nombre d'allumettes ?");
        nbAllumettes = saisieEntSupEgalMin(3 * MINJOUEURS);
        System.out.println("------------------------------------------------");

        System.out.println("********************************");
        System.out.println("* Nombre de joueurs: " + nbJoueurs);
        System.out.println("* Nombre d'allumettes: " + nbAllumettes);
        System.out.println("********************************");
        while (nbAllumettes > 0) {
            System.out.println("Joueur N°" + numJoueur + ", combien prenez-vous d'allumettes ?");
            nbAllumettes -= unePrise(nbAllumettes, MAXPRISE);
            System.out.println("-> Il reste " + nbAllumettes + " allumettes");
            nbCoups++;
            numJoueur = numJoueur == 1 ? 2 : 1;
        }
        System.out.println("*****************************************************************");
        System.out.println("Victoire du joueur N°" + (numJoueur == 1 ? 2 : 1) + " après " + nbCoups + " coups !");
        System.out.println("*****************************************************************");
    }
}
