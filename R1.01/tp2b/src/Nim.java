import java.util.Scanner;

public class Nim {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nbPart = 0;
        final int MAXTAKING = 3;
        System.out.println("------------------------------------------------");
        System.out.println("how many players? (up of 2) ");
        final int nbPlayers = upOfMin(2);
        System.out.println("------------------------------------------------");
        System.out.println("how many matches? (up of "+ 3*nbPlayers + ") ");
        int nbMatches = upOfMin(3*nbPlayers);
        System.out.println("------------------------------------------------");
        System.out.println();
        System.out.println("********************************");
        System.out.println("number of player: "+ nbPlayers);
        System.out.println("number of matches: "+ nbMatches);
        System.out.println("********************************");
        while (nbMatches>0){
            for (int i = 0; i < nbPlayers && nbMatches > 0; i++) {
                System.out.println("player " + i + "how many matches take you");
                nbMatches-= takeMatches(nbMatches, MAXTAKING);
                nbPart++;
                if(nbMatches <= 0)
                    System.out.println("victory of player "+i+" after "+ nbPart + " part !!!");
                else
                    System.out.println(nbMatches + " matches left");
            }
        }
    }

    /**
     * Returns value enter min amd max. min must be up of 0
     *
     * @param rest number of matches.
     * @param max max value of user input /!\ must be > rest.
     * @return value up of matches but lower of max
     */
    private static int takeMatches(int rest, int max){
        int value;
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("enter number between" + 1 + " and " + Math.min(rest, max) + ": ");
            value = in.nextInt();
            in.nextLine();
            System.out.println(value);
        }while (value > Math.min(rest, 3) | value < 1);
        return (value);
    }

    /**
     * Returns an in up of min. min must be up of 0
     *
     * @param min min of user input /!\ must be > 0.
     * @return int up of {min}
     */
    private static int upOfMin(final int min) {
        int value = -1;
        final Scanner in = new Scanner(System.in);
        while (value < min) {
            System.out.println("enter number up of " + min + ": ");
            value = in.nextInt();
            in.nextLine();
        }
        return (value);
    }
}
