import java.util.Scanner;

public class Es {
    public static void main(String[] args) {
        int n;
        float r;
        char car;
        String ch;
        // création d'un lecteur sur la console
        Scanner lecteur = new Scanner(System.in);

        System.out.print("saisir un entier  : ");
        // Instruction(s) de saisie de la valeur de n (À COMPLÉTER)
        //---------------------------------------------------------------
        n = lecteur.nextInt();
        lecteur.nextLine();
        //---------------------------------------------------------------
        System.out.print("saisir un réel (avec une virgule comme séparateur décimal) : ");
        // Instruction(s) de saisie de la valeur de r (À COMPLÉTER)
        //---------------------------------------------------------------
        r = lecteur.nextFloat();
        lecteur.nextLine();
        //---------------------------------------------------------------
        System.out.print("saisir une chaîne de caractères  : ");
        // Instruction(s) de saisie de la valeur de ch (À COMPLÉTER)
        //---------------------------------------------------------------
        ch = lecteur.nextLine();
        //---------------------------------------------------------------
        System.out.print("Saisir un caractère  : ");
        // Instruction(s) de saisie de la valeur de car (À COMPLÉTER)
        //---------------------------------------------------------------
        car = lecteur.next().charAt(0);
        lecteur.nextLine();
        //-------------------------------------------------------------------------------
        // Instruction(s) d'affichage des valeurs de n, r, ch et car (À COMPLÉTER)
        //-------------------------------------------------------------------------------
        System.out.println("la valleur n:"  + n + ", la valeur r: " + r + ", la valleur ch: "+ch + ", la valleur car: "+car);





    }
}
