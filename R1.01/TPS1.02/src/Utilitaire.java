import javax.swing.*;
import java.util.ArrayList;
import java.util.Map;

public class Utilitaire {
	public static int triBulle_O (ArrayList<Integer> vInt) {
		// { vInt quelconque } =>
		// { * vInt a été trié par la méthode du TRI A BULLES AMELIORE
		// * résultat = nombre de comparaisons entre deux éléments de vInt }
		int i = 0, comp = 0, j;
		int temp;
		boolean permute = true;
		while (permute) {
			permute = false;
			j = vInt.size() - 1;
			while (j > i) {
				if (vInt.get(j) < vInt.get(j - 1)) {
					temp = vInt.get(j);
					vInt.set(j, vInt.get(j - 1));
					vInt.set(j - 1, temp);
					permute = true;
				}
				comp++;
				j--;
			}
			i++;
		}
		// System.out.println(vInt);
		return comp;
	}

	public static int triInsert_O(ArrayList<Integer> vInt) {
		// { vInt quelconque } =>
		// { * vInt a été trié par la méthode du TRI PAR INSERTION
		// * résultat = nombre de comparaisons entre deux éléments de vInt }
		int j;
		int comp = 0;
		int valeurAPlacer;
		int i = 1;
		while(i< vInt.size()) {
			j = i;
			valeurAPlacer = vInt.get(i);
			while (j > 0 && vInt.get(j - 1).compareTo(valeurAPlacer) > 0) {
				comp++;
				vInt.set(j, vInt.get(j - 1));
				j--;
			}
			if(j>0)
				comp++;
			vInt.set(j, valeurAPlacer);
			i++;
		}
		return comp;
	}

	public static int triSelect_O (ArrayList<Integer> vInt) {
		// { vInt quelconque } =>
		// { * vInt a été trié par la méthode du TRI PAR SELECTION
		// * résultat = nombre de comparaisons entre deux éléments de vInt }
		int i = 0;
		int comp = 0;
		while (i < vInt.size()) {
			int iMin = i;
			int j = i + 1;
			while (j < vInt.size()) {
				if (vInt.get(j).compareTo(vInt.get(iMin)) < 0) iMin = j;
				j++;
				comp++;
			}
			if (iMin != i) {
				final int temp = vInt.get(i);
				vInt.set(i, vInt.get(iMin));
				vInt.set(iMin, temp);
			}
			i++;
		}
		return comp;
	}

	public static boolean isSortAsc(ArrayList<Integer> vInt){
		int i = 1;
		while (i<vInt.size()&&vInt.get(i-1)<=vInt.get(i)){
			i++;
		}
		return i == vInt.size();
	}

	public static ArrayList<Integer> genVectSansDoublons(int n) {
		// { } =>
		// { résultat = vecteur de n entiers, sans doublons, dont les valeurs
		// sont choisies aléatoirement dans [0..2*n] }
		final ArrayList<Integer> arr =  new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			int val;
			do {
				 val= (int) (Math.random() * (2 * n));
			} while (arr.indexOf(val)!=-1);
			arr.add(val);
		}
		return arr;
	}

	public static PaireResCompteur<Integer> rechSeqIt_O(ArrayList<Integer> vInt,
														int unInt) {
		// { vInt non vide, trié } =>
		// { résultat = variable de type PaireResCompteur avec :
		// res = * indice de la 1ère occurrence de unInt dans vInt
		// * -1 si non trouvé
		// compteur = nombre de comparaisons entre unInt
		// et un élément de vInt }
		int i = 0;
		int comp = 0;
		while (i<vInt.size() && vInt.get(i)!=unInt){
			i++;
			comp++;
		}
		if(i==vInt.size()-1){
			i=-1;
		}
		return new PaireResCompteur<>(i, comp);
	}

	public static PaireResCompteur<Integer> rechDichoIt_O(ArrayList<Integer> vInt,
														  int unInt) {
		// { vInt non vide, trié } =>
		// { résultat = variable de type PaireResCompteur avec :
		// res = * indice de la 1ère occurrence de unInt dans vInt
		// * -1 si non trouvé
		// compteur = nombre de comparaisons effectuées entre unInt
		// et un élément de vInt }
		int max = vInt.size()-1;
		int min = 0;
		while (min<=max){
			final int mid = (min + max)/2;
			if(vInt.get(mid)>unInt) { min = mid + 1;}
			if(vInt.get(mid)<unInt) { max = mid - 1;}
		}
	}
}
