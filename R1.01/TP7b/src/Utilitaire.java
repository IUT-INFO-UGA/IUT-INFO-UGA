import java.util.ArrayList;

public class Utilitaire {
	public static boolean verifTri(ArrayList<Polar> vPolar) {
		// { } =>
		// { résultat = vrai si vPolar est trié par titre strictement croissant }
		int i = 1;
		while ((i < vPolar.size()) && (vPolar.get(i - 1).getTitre().compareTo(vPolar.get(i).getTitre())<=0)){
			i++;
		}
		return i == vPolar.size();
	}
	public static void printbibTitre(ArrayList<Polar> bib){
		for (Polar polar : bib) System.out.println(polar.getTitre());
	}

	public static int triSelect(ArrayList<Polar> vPolar) {
		// { } => { * vPolar est trié selon l'ORDRE(auteur, annee)
		// en utilisant la méthode DU TRI PAR SÉLECTION
		// * résultat = nombre de comparaisons effectuées
		// entre deux éléments de vPolar }
		int i = 0;
		int comp = 0;
		while (i < vPolar.size()){
			int iMin = i;
			int j = i+1;
			while (j< vPolar.size()){
				if(vPolar.get(j).compareTo(vPolar.get(iMin)) < 0) iMin = j;
				j++;
				comp++;
			}
			if(iMin!=i){
				final Polar temp = vPolar.get(i);
				vPolar.set(i,vPolar.get(iMin));
				vPolar.set(iMin, temp);
			}
			//System.out.println("iteration "+ i + 1 + " : "+ vPolar.get(i));
			i++;
		}
		return comp;
	}

	public static void triBulle(ArrayList<Polar> vPolar) {
		// { } => { vPolar est trié selon l'ORDRE(auteur, annee)
		// en utilisant la méthode DU TRI À BULLES AMÉLIORÉ }
		int i = 0;
		int j;

		while ((i < vPolar.size()-1)){
			j = vPolar.size()-1;
			while(j>i){
				if (vPolar.get(j).compareTo(vPolar.get(j-1))<0){
					final Polar temp = vPolar.get(j);
					vPolar.set(j, vPolar.get(j-1));
					vPolar.set(j-1, temp);
				}
				j--;
			}
			System.out.println("iteration "+ i + 1 + " : "+ vPolar.get(i));
			i++;
		}
	}

	public static int triInsertion(ArrayList<Polar> vPolar) {
		// { } => { * vPolar est trié selon l'ORDRE(auteur, annee)
		// en utilisant la méthode DU TRI PAR INSERTION
		// * résultat = nombre de comparaisons effectuées
		// entre deux éléments de vPolar }
		int j;
		int comp = 0;
		Polar valeurAPlacer;
		int i = 1;
		while(i< vPolar.size()) {
			j = i;
			valeurAPlacer = vPolar.get(i);
			while (j > 0 && vPolar.get(j - 1).compareTo(valeurAPlacer) > 0) {
				comp++;
				vPolar.set(j, vPolar.get(j - 1));
				j--;
			}
			vPolar.set(j, valeurAPlacer);
			//System.out.println("iteration "+ i + 1 + " : "+ vPolar.get(i));
			i++;
		}
		return comp;
	}

	public static int rechSeqT(ArrayList<Polar> vPolar, String aut, int an) {
		// { vPolar trié selon l'ORDRE(auteur, annee) }
		// => { * résultat = indice du premier élément de vPolar
		// écrit par aut, l'année an, si trouvé
		// * résultat = -1, si aucun roman écrit par aut, l'année an }
		// LA RECHERCHE EST SÉQUENTIELLE
		int i = 0;
		final Polar autComp = new Polar(an, aut,"comp");
		while (i < vPolar.size() && vPolar.get(i).compareTo(autComp)!=0){
			i++;
		}
		if (i == vPolar.size()) return -1;
		else return i;
	}

	public static int rechDicho(ArrayList<Polar> vPolar, String aut, int an) {
		// { vPolar trié selon l'ORDRE(auteur, annee) }
		// => { * résultat = indice du premier élément de vPolar
		// écrit par aut, l'année an, si trouvé
		// * résultat = -1, si aucun roman écrit par aut, l'année an }
		// LA RECHERCHE EST DICHOTOMIQUE
		final Polar autComp = new Polar(an, aut,"comp");
		int max = vPolar.size()-1;
		int min = 0;
		while( min <= max ){
			final int mid = (min + max)/2;
			if ( vPolar.get(mid).compareTo(autComp) < 0 ){
				min = mid + 1;
			}else if ( vPolar.get(mid).compareTo(autComp) == 0 ){
				return mid -1;
			}else{
				max = mid;
			}
		}
		return -1;
	}
}
