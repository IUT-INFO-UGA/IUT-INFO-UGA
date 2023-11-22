import java.util.ArrayList;

public class TestTriFusion {
    public static void triFusion(ArrayList<Integer> vInt, int inf, int sup) {
        // { vectE[inf..sup] non vide, 0<=inf<=sup<vectE.size() }
        // => { vectE[inf..sup] trié }
        if (inf < sup) {
            int m = (inf + sup) / 2;
            triFusion(vInt, inf, m);
            triFusion(vInt, m + 1, sup);
            fusionTabG_TabD(vInt, inf, m, sup);
        }
    }

    private static void fusionTabG_TabD(ArrayList<Integer> vInt, int inf, int m, int sup) {
        // { inf<=sup, m=(inf+sup)/2, vectE[inf..m] trié, vectE[m+1..sup] trié }
        // => { vectE[inf..sup] trié }
        //
        // 1 - Déclarer une variable vTemp de type ArrayList<E>
        //
        // 2 - Ajouter dans temp les éléments de vectE[inf..m] et de vectE[m+1..sup]
        // de façon à ce que vTemp soit trié
        // MÉTHODE :
        // | Jusqu'à ce qu'un des deux sous-vecteurs ait été entièrement ajouté à vTemp :
        // | (a) Comparer le 1er élément de vectE[inf..m] pas encore ajouté à vTemp
        // | au 1er élément de vectE[m+1..sup] pas encore ajouté à vTemp
        // | (b) Ajouter à vTemp le plus petit de ces deux éléments
        // |
        // | Dès que tous les éléments d'un des sous-vecteurs ont été ajoutés à vTemp :
        // | Ajouter à vTemp les éléments restant dans l'autre sous-vecteur
        //
        // 3 - Copier élément par élément, les éléments de vTemp dans vectE[inf..sup]
        ArrayList<Integer> temp = new ArrayList<>();

        int i = inf;
        int j = m + 1;

        while (i <= m && j <= sup) {
            if (vInt.get(i) <= vInt.get(j)) {
                temp.add(vInt.get(i));
                i++;
            } else {
                temp.add(vInt.get(j));
                j++;
            }
        }

        while (i <= m) {
            temp.add(vInt.get(i));
            i++;
        }

        while (j <= sup) {
            temp.add(vInt.get(j));
            j++;
        }

        int k = 0;
        for (i = inf; i <= sup; i++) {
            vInt.set(i, temp.get(k));
            k++;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>();

        ints.add(5);
        ints.add(26);
        ints.add(2);
        ints.add(14);
        ints.add(19);
        ints.add(15);
        ints.add(6);
        ints.add(35);
        ints.add(12);
        ints.add(18);
        ints.add(15);
        ints.add(6);

        System.out.println(ints);
        triFusion(ints, 0, 11);
        System.out.println(ints);
    }
}
