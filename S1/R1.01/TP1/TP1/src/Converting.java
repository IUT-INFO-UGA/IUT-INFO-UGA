import java.util.Scanner;
public class Converting {
    public static void main(String[] args) {
        float dollars, euros;
        final float change = 0.89f;
        Scanner in = new Scanner(System.in);

        System.out.print("ero to dollars select 1, dollars to euro select other number");
        final int type = in.nextInt();
        in.nextLine();
        if (type == 1) {
            System.out.print("combier d'euro a tu ??? ");
            euros = in.nextFloat();
            in.nextLine();
            dollars = euros / change;
            System.out.printf("tu a "+dollars+" $");
        } else {
            System.out.print("how many dollars are you ??? ");
            dollars = in.nextFloat();
            in.nextLine();
            euros = dollars * change;
            System.out.printf("you are "+euros+" € ");
        }
    }
}
