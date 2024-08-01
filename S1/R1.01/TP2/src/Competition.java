import java.util.Scanner;

public class Competition {
    private static float getTemps(int number, Scanner l) {
        float TEMPS_MAX = 20f;
        float value;
        do {
            System.out.print("Temps estimé par le juge N°" + number + ": ");
            value = l.nextFloat();
            l.nextLine();
        } while (value > TEMPS_MAX);
        return value;
    }

    public static void main(String[] args) {
        float temps = 0f;
        int nbJuges;
        float min = 20;
        float max = 0;
        Scanner l = new Scanner(System.in);
        System.out.print("Nombre de juges: ");
        nbJuges = l.nextInt();
        l.nextLine();
        for (int i = 0; i < nbJuges; i++) {
            float val = getTemps(i, l);
            if (val > max) max = val;
            if (val < min) min = val;
            temps += val;
        }
        temps /= nbJuges;
        System.out.println("La moyenne est de " + temps);
        System.out.println("Le max est de " + max);
        System.out.println("Le min est de " + min);
    }
}
