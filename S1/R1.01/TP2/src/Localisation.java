import java.util.Scanner;

public class Localisation {
    public static void main(String[] args) {
        String again;
        do {
            int x, y;
            Scanner l = new Scanner(System.in);
            System.out.print("Entrez votre x: ");
            x = l.nextInt();
            l.nextLine();
            System.out.print("Entrez votre y: ");
            y = l.nextInt();
            l.nextLine();
            if (x < 0) {
                if (y < 0) {
                    System.out.println("Position: Sud-Ouest");
                } else if (y > 0) {
                    System.out.println("Position: Nord-Ouest");
                } else {
                    System.out.println("Position: Ouest");
                }
            } else if (x > 0) {
                if (y < 0) {
                    System.out.println("Position: Sud-Est");
                } else if (y > 0) {
                    System.out.println("Position: Nord-Est");
                } else {
                    System.out.println("Position: Est");
                }
            } else {
                if (y < 0) {
                    System.out.println("Position: Sud");
                } else if (y > 0) {
                    System.out.println("Position: Nord");
                } else {
                    System.out.println("Position: Centre");
                }
            }
            System.out.print("\nVoulez-vous recommencer ?(o/n)");
            again = l.next().toLowerCase();
            l.nextLine();
        } while(again.equals("n"));
    }
}
