import java.util.Scanner;
public class Jeu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int calc;
        System.out.println("BONJOUR");
        System.out.println();
        System.out.print("Doner votre nom : ");
        final String name = in.nextLine();
        System.out.print("Donner votre année de naissance : ");
        final int birthYears = in.nextInt();
        in.nextLine();
        System.out.print("Donner votre pointure : ");
        final int shoeSize = in.nextInt();
        in.nextLine();
        calc = 5* shoeSize;
        System.out.println("On multiplie votre pointure par 5 : "+calc);
        calc+=50;
        System.out.println("0n ajoute 50 : "+calc);
        calc*=20;
        System.out.println("On multiplie par 20 :" + calc);
        calc+=1023;
        System.out.println("0n ajoute 1023 : "+calc);
        System.out.println("On soustrait votre année de naissance :");
        calc -= birthYears;
        System.out.println("----------------");
        System.out.println("RESULTAT = "+ calc);
        System.out.println("----------------");
        System.out.println("Les 2 premiers chiffres sont : "+calc/100);
        System.out.println("> C'est votre pointure !!!");
        System.out.println("Les 2 derniers chiffres sont : "+calc%100);
        System.out.println("> C'est l'âge que vous atteignez cette année !!!\n\nAU REVOIR "+name+" !");
    }
}
