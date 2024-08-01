import java.util.Scanner;
public class Permutation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a, b, c, d, e;

        System.out.print("enter a: ");
        a = in.nextInt();
        in.nextLine();

        System.out.println("enter b");
        b = in.nextInt();
        in.nextLine();

        System.out.println("enter c");
        c = in.nextInt();
        in.nextLine();

        System.out.println("enter d");
        d = in.nextInt();
        in.nextLine();

        System.out.println("enter e");
        e = in.nextInt();
        in.nextLine();

        int temp = a;
        a = b;
        b = c;
        c = d;
        d = e;
        e = temp;

        System.out.println("new value: a: " + a + " b: " + b + " c: " + c + " d: " + d + " e: " + e);
    }
}
