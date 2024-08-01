import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GuessTheNumber {
    private static int ask(Scanner l) {
        System.out.print("Guess the number: ");
        int value = l.nextInt();
        l.nextLine();
        return value;
    }
    public static void main(String[] args) {
        Scanner l = new Scanner(System.in);
        int number = ThreadLocalRandom.current().nextInt(0, 100 + 1);
        for (int i = 0; i < 5; i++) {
            int asked = ask(l);
            if (asked < number) {
                System.out.println("Higher !");
            } else if (asked > number) {
                System.out.println("Lower !");
            } else {
                System.out.println("You win !");
                return;
            }
        }
        System.out.println("You lose...");
    }
}
