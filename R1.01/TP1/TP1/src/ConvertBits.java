import java.util.Scanner;

public class ConvertBits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final float EURO_TO_USD = 1.07f;
        final float EURO_TO_CHF = 0.96f;
        final float EURO_TO_GBP = 0.86f;

        System.out.print("Please enter price in Euro : ");
        float priceEuro = in.nextFloat();
        in.nextLine();
        System.out.print("Please select devise convert to 1: American dolars, 2: Swiss franc, 3: pound sterling");
        int select = in.nextInt();
        if(select == 1)
            System.out.println(priceEuro + "€ = " + priceEuro*EURO_TO_USD+"$");
        else if (select == 2)
            System.out.println(priceEuro + "€ = " + priceEuro*EURO_TO_CHF+"CHF");
        else if (select == 3)
            System.out.println(priceEuro + "€ = " + priceEuro*EURO_TO_GBP+"£");
        else
            System.out.println("bad choose");
    }
}
