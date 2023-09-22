import java.util.Scanner;

public class Calendrier {
    public static void main(String[] args) {
        int uneAnnee;
        Scanner l = new Scanner(System.in);
        System.out.print("Entrez une année: ");
        uneAnnee = l.nextInt();
        l.nextLine();
        if (uneAnnee % 100 == 0) {
            if (uneAnnee % 4 == 0) {
                System.out.println("L'année bissextile " + uneAnnee + ", composée de 366 jours, a terminé le siècle " + uneAnnee / 100);
            } else {
                System.out.println("L'année " + uneAnnee + ", composée de 365 jours, a terminé le siècle " + uneAnnee / 100);
            }
        } else {
            if (uneAnnee % 4 == 0) {
                System.out.println("L'année bissextile " + uneAnnee + ", composée de 366 jours, n'a pas terminé de siècle.");
            } else {
                System.out.println("L'année " + uneAnnee + ", composée de 365 jours, n'a pas terminé de siècle.");
            }
        }
    }
}
