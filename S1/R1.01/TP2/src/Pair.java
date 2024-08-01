import java.util.Scanner;

public class Pair {
    public static void main(String[] args) {
        Scanner l = new Scanner(System.in);
        System.out.print("Entrez un nombre: ");
        int value = l.nextInt();
        l.nextLine();
        int Final = 0;

        for (int i = 0; i <= value; i++) {
            if (i % 2 == 0) {
                Final += i;
            }
        }
        System.out.println("La somme des entiers pairs est de " + Final);
    }
}
