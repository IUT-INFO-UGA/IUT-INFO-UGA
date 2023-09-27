import java.util.Scanner;
public class Exemple {
    public static void main(String[] args) {
        int k;
        float pi;
        char x;
        String nom;
        String formule;

        k = -65536;
        pi = 3.14f;   // le 'f' sert à indiquer qu'il s'agit d'un float (pas un double)
        x = '!';
        formule = "Bonjour !";

        System.out.print(2);
        System.out.print('k');
        System.out.println(k);

        System.out.println("pi = " + pi);
        System.out.println("x = " + x);
        System.out.println(formule);

        Scanner lecteur = new Scanner(System.in);
        System.out.print("Quel est votre nom ? : ");
        nom = lecteur.nextLine();

        formule = "Au revoir";

        System.out.println(formule + ' ' + nom + " !");
    }
}