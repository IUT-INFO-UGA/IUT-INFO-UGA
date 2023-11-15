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

	public static void triSelect(ArrayList<Polar> vPolar) {
		// { } => { vPolar a été trié selon l'ORDRE(auteur, annee)
		// en utilisant la méthode DU TRI PAR SÉLECTION }
		int i = 0;
		while (i < vPolar.size()){
			int iMin = i;
			int j = i+1;
			while (j< vPolar.size()){
				if(vPolar.get(j).compareTo(vPolar.get(iMin)) < 0) iMin = j;
				j++;
			}
			if(iMin!=i){
				final Polar temp = vPolar.get(i);
				vPolar.set(i,vPolar.get(iMin));
				vPolar.set(iMin, temp);
			}
			System.out.println("iteration "+ i + 1 + " : "+ vPolar.get(i));
			i++;
		}
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

	public static void triInsertion(ArrayList<Polar> vPolar) {
		// { } => { vPolar est trié selon l'ORDRE(auteur, annee)
		// en utilisant la méthode DU TRI PAR INSERTION }
		int j;
		Polar valeurAPlacer;
		int i = 1;
		while (i < vPolar.size()){
			j = i;
			valeurAPlacer  = vPolar.get(i);
			while (j > 0 && vPolar.get(j-1).compareTo(valeurAPlacer) > 0){
				vPolar.set(j, vPolar.get(j-1));
				j--;
			}
			System.out.println("iteration "+ i + 1 + " : "+ vPolar.get(i));
			i++;
		}
	}
}
