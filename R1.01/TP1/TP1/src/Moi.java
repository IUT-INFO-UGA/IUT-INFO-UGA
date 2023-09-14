import java.util.Scanner;
public class Moi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("what is your identity? ");
        final String identity = in.nextLine();
        System.out.print("what is your age? ");
        final int age = in.nextInt();
        in.nextLine();
        System.out.print("what is your group? ");
        final char group = in.next().charAt(0);
        in.nextLine();
        System.out.print("what is your sub group? ");
        final String subGroup = in.nextLine();

        System.out.println("-----------------------------------------------------------------");
        System.out.println("                      INFORMATION ABOUT YOU                      ");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Identity: "+identity);
        System.out.println("Age: "+age);
        System.out.println("Group: "+group);
        System.out.println("Sub group: "+subGroup);
        System.out.println("-----------------------------------------------------------------");
    }
}
