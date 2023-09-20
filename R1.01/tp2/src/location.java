import java.util.Scanner;

public class location {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("enter x location (int)");
        int x = in.nextInt();
        in.nextLine();
        System.out.print("enter y location (int)");
        int y = in.nextInt();
        in.nextLine();
        if (y > 0)
            if (x == 0)
                System.out.println("North");
            else if(x > 0)
                System.out.println("North-est");
            else
                System.out.println("North_west");
        else if(y < 0)
            if(x == 0)
                System.out.println("Sud");
            else if(x > 0)
                System.out.println("Sud-est");
            else
                System.out.println("Sud-west");
        else
            if(x > 0)
                System.out.println("Est");
            else if (x < 0)
                System.out.println("West");
            else
                System.out.println("center");
    }
}