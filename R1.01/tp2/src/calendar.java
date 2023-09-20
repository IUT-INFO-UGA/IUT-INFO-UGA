import java.util.Scanner;

public class calendar {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("which year ?");
        int yearsDate = in.nextInt();
        in.nextLine();
        if(yearsDate%100 == 0)
            if((yearsDate/100)%4 == 0)
                System.out.println("this year is end of " + (yearsDate/100 + 1) +" century and she is leap year (366 days)");
            else
                System.out.println("this year is just one end of " + (yearsDate/100 + 1) + " century (365 days)");
        else
            if(yearsDate%4 == 0)
                System.out.println("this year is just a leap year year (366 days)");
            else
                System.out.println("this tear is normal(365 days)");
    }
}
