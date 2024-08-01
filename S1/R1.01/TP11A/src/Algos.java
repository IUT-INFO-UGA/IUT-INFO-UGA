import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Algos {
	public static int saisieEntMinMax(Scanner lecteur, int min, int max) {
		// { } => { résultat = un entier de l'intervalle [min..max] saisi par
		// l'utilisateur }
		int userIn;
		do {
			System.out.println("donné un nombre entre " + min + " et " + max);
			userIn = lecteur.nextInt();
			lecteur.nextLine();
		} while (userIn < min || userIn > max);
		return userIn;
	}

	public static int saisieEntSup(Scanner lecteur, int val) {
		// { } => { résultat = un entier supérieur à val, saisi par l'utilisateur }
		// L'exception InputMismatchException qui sera déclenchée si l'utilisateur
		// saisit autre chose qu'un entier est gérée
		System.out.println("donné un nombre superieur a " + val);
		final int userIn = lecteur.nextInt();
		if (userIn < val) {
			throw new InputMismatchException("bad input");
		}
		return userIn;
	}

	public static String saisieChaineDeV(Scanner lecteur, ArrayList<String> vString) {
		// { vString non vide }
		// => { résultat = un élément de vString, saisi par l'utilisateur }

		String userIn;
		do {
			System.out.println("donne un mot dans " + vString);
			userIn = lecteur.nextLine();
		} while (!vString.contains(userIn));
		return vString.get(vString.indexOf(userIn));
	}

	public static int maximum(ArrayList<Integer> vInt) {
		// { vInt non vide } => { résultat = plus grand entier dans vInt }
		int max = vInt.get(0);
		for (Integer integer : vInt) {
			if (integer > max) {
				max = integer;
			}
		}
		return max;
	}

	public static float moyenne(ArrayList<Integer> vInt) throws ExceptionMoyImpossible {
		// { } =>
		// { * si vInt est vide, l'exception ExceptionMoyImpossible est levée
		// avec un message expliquant le problème
		// * sinon, la moyenne des éléments de vInt est retournée }
		if (vInt.isEmpty()) {
			throw new ExceptionMoyImpossible("aucun element");
		}
		float tot = 0;
		for (Integer integer : vInt) {
			tot += integer;
		}
		return tot / vInt.size() - 1;
	}

	public static String minOrdreLG(ArrayList<String> vString) {
		// { vString non vide } =>
		// { résultat = plus petite chaîne de vString selon l'ordre lexicographique }
		String min = vString.get(0);
		for (String s : vString) {
			if (min.compareTo(s) > 0) {
				min = s;
			}
		}
		return min;
	}

	public static int somme(ArrayList<Integer> vInt) {
		// { vInt non vide } => { résultat = somme des éléments de vInt }
		return somme_wk(vInt, 0);
	}

	private static int somme_wk(ArrayList<Integer> vInt, int dep) {
		if (dep == vInt.size() - 1) {
			return vInt.get(dep);
		}
		return vInt.get(dep) + somme_wk(vInt, dep + 1);
	}

	public static int nbEntDeVal(ListeTrieeC<Integer> lIntC, int val) {
		// { } => { résultat = nombre d'entiers supérieurs à unEnt dans lIntC }
		return nbEntDeVal_wk(lIntC.getTete(), val);
	}

	private static int nbEntDeVal_wk(Cellule<Integer> cellCour, int unEnt) {
		int ofset = 0;
		if (cellCour.getInfo() == unEnt) {
			ofset = 1;
		}
		if (cellCour.getCelluleSuivante() == null || cellCour.getInfo() > unEnt) {
			return ofset;
		} else {
			return ofset + nbEntDeVal_wk(cellCour.getCelluleSuivante(), unEnt);
		}
	}

	public static int nbJetonsSup3(ArrayList<Jeton> vJetons) {
		// { vJetons non vide } =>
		// { résultat = nombre d'éléments de vJetons dont la valeur est supérieure à 3 }
		int nb = 0;
		for (int i = 0; i < vJetons.size(); i++) {
			if (vJetons.get(i).getValeur() > 3) {
				nb++;
			}
		}
		return nb;
	}

	public static boolean existValSeq_it(ArrayList<Integer> vInt, int val) {
		// { } => { résultat = vrai si val est un élément de vInt }
		return vInt.indexOf(val) == -1 ? false : true;
	}

	public static boolean existValSeq_rec(ArrayList<Integer> vInt, int val) {
		// { } => { résultat = vrai si val est un élément de vInt }
		return existValSeq_rec_wk(vInt, val, 0);
	}

	private static boolean existValSeq_rec_wk(ArrayList<Integer> vInt, int val, int indice) {
		// { 0 <= indice < vInt.size() } =>
		// { résultat = vrai si val est un élément de vInt[indice..vInt.size()-1] }
		if (vInt.size() == indice)
			return false;

		else if (vInt.get(indice) == val)
			return true;
		else
			return existValSeq_rec_wk(vInt, val, indice + 1);
	}

	public static int rechIndDicho(ArrayList<Integer> vInt, int val) {
		// { vInt trié } =>
		// { résultat = indice de la 1ère occurrence de val dans vInt si trouvé, -1
		// sinon }
		if (vInt.isEmpty() || vInt.get(vInt.size() - 1) < val) {
			return -1;
		}
		int gauche = 0;
		int droite = vInt.size() - 1;

		while (droite > gauche) {
			int centre = (gauche + droite) / 2;
			if (vInt.get(centre) >= val)
				droite = centre;
			else if (vInt.get(centre) < val)
				gauche = centre + 1;
		}
		if (vInt.get(gauche) == val)
			return gauche;
		else
			return -1;
	}

	public static int rechPos(ListeTrieeC<String> lString, String uneChaine) {
		// { } =>
		// { résultat = position de la 1ère occurrence de uneChaine dans lString,
		// 0 si non trouvée }
		Cellule<String> cellcour = lString.getTete();
		int i = 1;
		while (!cellcour.getInfo().equals(uneChaine) && cellcour.getCelluleSuivante() != null) {
			cellcour = cellcour.getCelluleSuivante();
			i++;
		}
		return cellcour.getInfo().equals(uneChaine) ? i : 0;
	}

	public static void triBulle(ArrayList<Integer> vInt) {
		// { } => { vInt a été trié par la méthode du tri à bulles amélioré }
		int i = 0, j;
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
				j--;
			}
			i++;
		}
	}

	public static ArrayList<Jeton> vJetonTrie(ArrayList<Jeton> vJetons) {
		// { vJetons non vide } =>
		// { résultat = vecteur de Jeton trié dont les éléments sont ceux de vJetons }
		// Méthode utilisée pour le tri : tri par insertion
		// { } => { vPolar est trié selon l'ORDRE(auteur, annee)
		// en utilisant la méthode DU TRI PAR INSERTION }
		int j;
		Jeton valeurAPlacer;
		int i = 1;
		while (i < vJetons.size()) {
			j = i;
			valeurAPlacer = vJetons.get(i);
			while (j > 0 && vJetons.get(j - 1).compareTo(valeurAPlacer) > 0) {
				vJetons.set(j, vJetons.get(j - 1));
				j--;
			}
			vJetons.set(j, valeurAPlacer);
			i++;
		}
		return vJetons;
	}

	public static boolean veriftri(ArrayList<Jeton> vJeton) {
		// { vJeton non vide }=> {
		// { résultat = vrai si vJeton trié selon l'ordre naturel de la classe Jeton,
		// faux sinon }
		int i = 1;
		while ((i < vJeton.size()) && (vJeton.get(i - 1).compareTo(vJeton.get(i)) <= 0)) {
			i++;
		}
		return i == vJeton.size();
	}
}
