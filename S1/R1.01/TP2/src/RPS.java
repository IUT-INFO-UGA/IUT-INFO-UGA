import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class RPS {
    private static String getEquivalent(int value) {
        if (value == 0) {
            return "Rock";
        } else if (value == 1) {
            return "Paper";
        } else {
            return "Scissors";
        }
    }
    private static int pc() {
        final int number = ThreadLocalRandom.current().nextInt(0, 3);
        System.out.println("The PC plays " + getEquivalent(number) + "!");
        return number;
    }
    private static void printBoard() {
        System.out.println("==============");
        System.out.println("Rock: 0");
        System.out.println("Paper: 1");
        System.out.println("Scissors: 2");
        System.out.println("==============");
    }

    private static int hasUserWon(int user, int PC) {
        if (user == PC) {
            return -1;
        }
        if (user == 0) {
            if (PC == 1) {
                return 0;
            } else {
                return 1;
            }
        } else if (user == 1) {
            if (PC == 2) {
                return 0;
            } else {
                return 1;
            }
        } else {
            if (PC == 0) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static void main(String[] args) {
        final Scanner l = new Scanner(System.in);
        printBoard();
        System.out.print(": ");
        final int value = l.nextInt();
        System.out.println("You played " + getEquivalent(value));
        final int userwon = hasUserWon(value, pc());
        if(userwon == 1) {
            System.out.println("You win !");
        } else if (userwon == 0) {
            System.out.println("You lose !");
        } else {
            System.out.println("Equality !");
        }
    }
}
