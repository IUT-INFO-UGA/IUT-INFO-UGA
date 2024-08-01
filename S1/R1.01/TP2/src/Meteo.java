import java.util.Scanner;

public class Meteo {


    private static boolean ask(String question, Scanner l) {
        String value;
        do {
            System.out.print(question + "(o/n)");
            value = l.next().toLowerCase();
            l.nextLine();
        } while (!value.equals("o") && !value.equals("n"));
        return value.equals("o");
    }

    public static void main(String[] args) {
        boolean pluie, parapluie, tongs, chapeau, bonEquipement;
        Scanner l = new Scanner(System.in);
        pluie = ask("Est-ce qu'il pleut ?", l);
        parapluie = ask("Avez-vous un parapluie ?", l);
        tongs = ask("Avez-vous des tongs ?", l);
        chapeau = ask("Avez-vous un chapeau ?", l);
        if(pluie) {
            if (chapeau || tongs)
                bonEquipement = false;
            else bonEquipement = parapluie;
        } else {
            if (parapluie)
                bonEquipement = false;
            else bonEquipement = chapeau && tongs;
        }

        if (bonEquipement)
            System.out.println("Vous avez un bon équipement !");
        else System.out.println("Vous n'avez pas un bon équipement...");
    }
}
