import java.util.Scanner;
import java.util.Stack;

public class Moy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        float sum = 0;
        System.out.print("how many result have you?");
        final float numberResult = in.nextFloat();
        in.nextLine();
        for (int i = 0; i < numberResult; i++) {
            System.out.print("what is your "+i+" result? ");
            sum +=  in.nextFloat();
            in.nextLine();
        }

        System.out.println("your avrange is of "+(sum/numberResult));
    }
}
