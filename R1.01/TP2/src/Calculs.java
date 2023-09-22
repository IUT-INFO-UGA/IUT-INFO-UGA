import java.util.Scanner;

public class Calculs {
    private static final Scanner l = new Scanner(System.in);
    private static int saisieEntPosOuNul() {
        int value;
        do {
            System.out.print("Entrez un entier positif ou nul :");
            value = l.nextInt();
            l.nextLine();
        } while (value < 0);
        return value;
    }

    private static int saisieEntMinMax(int min, int max) {
        int value;
        do {
            System.out.print("Entrez un entier compris entre " + min + " et " + max + " :");
            value = l.nextInt();
            l.nextLine();
        } while (value < min || value > max);
        return value;
    }

    private static int factorielle(int n) {
        int value = 1;
        for (int i = 1; i <= n; i++) {
            value *= i;
        }
        return value;
    }

    private static int combinaison(int n, int p) {
        return (factorielle(n)/(factorielle(p)*factorielle(n-p)));
    }

    private static int arrangment(int n, int p) {
        return (factorielle(n)/factorielle(n-p));
    }

    private static void trianglePascal(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(combinaison(i, j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int entierPos = saisieEntPosOuNul();
        int entiermm = saisieEntMinMax(0, 10);

        System.out.println("------------------------");
        System.out.println("Factorielle de " + entierPos + " = " + factorielle(entierPos));
        System.out.println("------------------------");
        System.out.println("Nombre de sous-ensembles de " + entiermm + " éléments parmi " + entierPos + " éléments: " + combinaison(entierPos, entiermm));
        System.out.println("------------------------");
        System.out.println("Nombre de n-uplets ordonnés de " + entiermm + " éléments parmi " + entierPos + " éléments: " + arrangment(entierPos, entiermm));
        System.out.println();

        int x = 5;

        System.out.println("------------------------");
        System.out.println("Lignes 0 à " + x + " du triangle de Pascal");
        System.out.println("------------------------");
        trianglePascal(x);

    }
}
