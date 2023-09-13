import java.util.Scanner;
public class Jeu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("BONJOUR");
        System.out.println();
        System.out.print("Doner votre nom : ");
        final String name = in.nextLine();
        System.out.print("Donner votre année de naissance : ");
        final int birthYears = in.nextInt();
        in.nextLine();
        System.out.print("Donner votre pointure : ");

    }
}
