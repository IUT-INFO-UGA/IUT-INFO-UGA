import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Utilitaire {
	public static ListeChainee<PaysDeCont> countries(ArrayList<Pays> mondeT, String cont) {
		// { mondeT non vide, trié selon l'ORDRE (continent, nom) } =>
		// { résultat = liste chainée des pays du continent cont, TRIÉE par nom }
		ListeChainee<PaysDeCont> result = new ListeChainee<>();
		int i = 0;
		int resI = 1;
		while (mondeT.size() > i && !Objects.equals(mondeT.get(i).getContinent(), cont)){
			i++;
		}
		while (mondeT.size() > i && mondeT.get(i).getContinent().equals(cont)){
			result.insereAtPosit(resI, new PaysDeCont( mondeT.get(i).getNom(),  mondeT.get(i).getPopulation(),  mondeT.get(i).getSuperficie()));
			i++;
			resI++;
		}
		return result;
	}

	public static void affichePaysDeCont(ListeChainee<PaysDeCont> listePdeC) {
		// { listePdeC non vide } =>
		// { l'information portée par chaque celle de listePdeC a été affichée
		// ligne à ligne, précédée par sa position dans listePdeC }
		if (listePdeC == null || listePdeC.estVide()) {
			System.out.println("List is empty.");
			return;
		}

		affichePaysDeCont_wk(1, listePdeC.getTete());
	}

	private static void affichePaysDeCont_wk(int pos, Cellule<PaysDeCont> cellCour) {
		if (cellCour != null) {
			System.out.println(pos + " - " + cellCour.getInfo());
			affichePaysDeCont_wk(pos + 1, cellCour.getCelluleSuivante());
		}
	}

	public static int indString(Scanner lecteur, ArrayList<String> vString) {
		// { vString non vide, trié par ordre strictement croissant } =>
		// { résultat = indice dans vString, d'une chaîne saisie par l'utilisateur }
		// La saisie a été répétée tant que la chaîne saisie n'est pas dans vString

		int index = -1;
		boolean isValidInput = false;

		while (!isValidInput) {
			System.out.println("Enter a string: ");
			String userInput = lecteur.nextLine();

			index = vString.indexOf(userInput);

			if (index != -1) {
				isValidInput = true;
			} else {
				System.out.println("Invalid input, try again...");
			}
		}

		return index;
	}

	public static void contExtremes(ArrayList<String> vCont, ArrayList<ListeChainee<PaysDeCont>> vListesPdeC) {
		// { * vCont, trié et non vide : vecteur des continents du monde
		// * vListesPdeC, non vide : vecteur des listes de pays de ces continents
		// dans l'ordre des continents de vCont } =>
		// { le nom et le nombre de pays du continent qui a le plus de pays est affiché,
		// ainsi que le nom et le nombre de pays du continent qui a le moins de pays }

		if (vCont == null || vCont.isEmpty() || vListesPdeC == null || vListesPdeC.isEmpty()) {
			System.out.println("Input lists are empty or null.");
			return;
		}

		int maxIndex = 0;
		int minIndex = 0;
		int maxCount = vListesPdeC.get(0).getLongueur();
		int minCount = vListesPdeC.get(0).getLongueur();

		for (int i = 0; i < vListesPdeC.size(); i++) {
			int currentCount = vListesPdeC.get(i).getLongueur();

			if (currentCount > maxCount) {
				maxCount = currentCount;
				maxIndex = i;
			}

			if (currentCount < minCount) {
				minCount = currentCount;
				minIndex = i;
			}
		}

		System.out.println("Continent comptant le plus de pays : " + vCont.get(maxIndex) + " (" + maxCount + " pays)");
		System.out.println("Continent comptant le moins de pays : " + vCont.get(minIndex) + " (" + minCount + " pays)");
	}

	public static ListeChainee<String> listeNomsPdeC(String unCont, ListeChainee<PaysDeCont> listePDeC) {
		// { * unCont est le nom d'un continent
		// * listePdeC contient les pays de unCont, triés par nom } =>
		// { résultat = liste triée dont chaque élément est une chaîne construite par
		// concaténation de unCont entre parenthèses, aux noms des pays
		// EXEMPLE : "Andorre (Europe)" }

		ListeChainee<String> result = new ListeChainee<>();

		if (listePDeC == null || listePDeC.estVide()) {
			System.out.println("Input list is empty or null.");
			return result;  // or throw an exception, handle accordingly
		}

		Cellule<PaysDeCont> currentCell = listePDeC.getTete();

		while (currentCell != null) {
			PaysDeCont pays = currentCell.getInfo();
			String concatenatedString = pays.getNom() + " (" + unCont + ")";
			result.insereTete(concatenatedString);
			currentCell = currentCell.getCelluleSuivante();
		}

		return result;
	}

	public static int posInsert(ListeChainee<String> uneListe, String uneChaine) {
		// { uneListe triée, éventuellement vide } =>
		// { résultat = rang que devrait occuper uneChaine lors de son insertion dans
		// uneListe, pour que le tri soit respecté }

		int position = 0;
		Cellule<String> currentCell = uneListe.getTete();

		// Traverse the list to find the correct position for insertion
		while (currentCell != null && uneChaine.compareTo(currentCell.getInfo()) > 0) {
			position++;
			currentCell = currentCell.getCelluleSuivante();
		}

		return position;
	}

	public static ListeChainee<String> listeNomsPaysDuMonde(ArrayList<String> vCont, ArrayList<ListeChainee<PaysDeCont>> vListesPdeC) {
		// { * vCont, trié et non vide : vecteur des continents du monde
		// * vListesPdeC, non vide : vecteur des listes de pays de ces continents } =>
		// { résultat = liste triée dont chaque élément est le nom d'un pays du
		// monde, concaténé au nom de son continent entre parenthèses }

		ListeChainee<String> resultList = new ListeChainee<>();

		for (int i = 0; i < vListesPdeC.size(); i++) {
			Cellule<PaysDeCont> current = vListesPdeC.get(i).getTete();
			while (current.getCelluleSuivante() != null){
				resultList.insereTete(current.getInfo().getNom()+'('+vCont.get(i)+')');
				current = current.getCelluleSuivante();
			}
		}

		return resultList;
	}
}
