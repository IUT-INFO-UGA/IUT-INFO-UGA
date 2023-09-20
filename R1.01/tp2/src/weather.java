import java.util.Scanner;

public class weather {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("what is the weather ? is it raining? (true or false)");
        boolean rain = in.nextBoolean();
        in.nextLine();
        System.out.print("do you have a umbrella? (true or false)");
        boolean umbrella = in.nextBoolean();
        in.nextLine();
        System.out.print("do you have a tongs? (true or false)");
        boolean tongs = in.nextBoolean();
        in.nextLine();
        System.out.print("do you have a hat? (true or false)");
        boolean hat = in.nextBoolean();
        in.nextLine();

        if(rain)
            if(umbrella && !tongs && !hat)
                System.out.println("good equipment");
            else
                System.out.println("bad equipment");
        else
            if(tongs && hat && !umbrella)
                System.out.println("good equipment");
            else
                System.out.println("bad equipment");
    }
}
