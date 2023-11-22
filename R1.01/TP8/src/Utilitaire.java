import java.util.ArrayList;

public class Utilitaire {
	public static Pays plusGrandPaysIter(ArrayList<Pays> vPays) {
		// { vPays non vide } =>
		// { résultat = élément de vPays ayant la plus grande superficie }
		Pays plusGrand = vPays.get(0);

		for (Pays pays : vPays) {
			if (plusGrand.getSuperficie() < pays.getSuperficie())
				plusGrand = pays;
		}

		return plusGrand;
	}

	public static Pays plusGrandPaysPDR(ArrayList<Pays> vPays) {
		return maxPaysDPRWorker(vPays, 0, vPays.size() - 1);
		// { vPays non vide } =>
		// { résultat = élément de vPays ayant la plus grande superficie }
	}

	private static Pays maxPaysDPRWorker(ArrayList<Pays> vPays, int inf, int sup) {
		// { vPays non vide, 0<=inf<=sup<vPays.size() } =>
		// { résultat = élément de plus grande superficie dans vPays[inf..sup] }
		int milieu = (inf + sup) / 2;

		if (inf == milieu) {
			return vPays.get(inf);
		}

		Pays maxGauche = maxPaysDPRWorker(vPays, inf, milieu);

		Pays maxDroite = maxPaysDPRWorker(vPays, milieu + 1, sup);

		return (maxGauche.getSuperficie() > maxDroite.getSuperficie()) ? maxGauche : maxDroite;
	}

	public static int indMinPopIter(ArrayList<Pays> vPays) {
		// { vPays non vide } =>
		// { résultat = indice dans vPays de l'élément de population la plus faible }
		int indMinPop = 0;
		int minPop = vPays.get(0).getPopulation();

		for (int i = 1; i < vPays.size(); i++) {
			if (minPop > vPays.get(i).getPopulation()) {
				indMinPop = i;
				minPop = vPays.get(i).getPopulation();
			}
		}

		return indMinPop;
	}

	public static int indMinPopDPR(ArrayList<Pays> vPays) {
		// { vPays non vide } =>
		// { résultat = indice dans vPays de l'élément de population la plus faible }
		return indMinPopDPRWorker(vPays, 0, vPays.size() - 1);
	}

	private static int indMinPopDPRWorker(ArrayList<Pays> vPays, int inf, int sup) {
		// { vPays non vide, 0<=inf<=sup<vPays.size() } =>
		// { résultat = indice dans vPay[inf..sup] de l'élément de population
		// la plus faible }
		if (sup == inf) {
			return sup;
		}

		int milieu = (inf + sup) / 2;

		int gauche = indMinPopDPRWorker(vPays, inf, milieu);

		int droite = indMinPopDPRWorker(vPays, milieu + 1, sup);

		return (vPays.get(gauche).getPopulation() < vPays.get(droite).getPopulation()) ? gauche : droite;
	}

	public static ArrayList<Pays> triBulleContNom(ArrayList<Pays> vPays) {
		// { } => { résultat = vecteur contenant les éléments de vPays,
		// triés selon l'ORDRE(continent, nom) }
		// ALGORITHME : tri à bulles amélioré
		ArrayList<Pays> lesPays;
		lesPays = vPays;

		int i = 0;
		while (i < lesPays.size() - 1) {
			int j = lesPays.size() - 1;
			while (j > i) {
				if (lesPays.get(j).compareTo(lesPays.get(j - 1)) < 0) {
					final Pays temp = lesPays.get(j);
					lesPays.set(j, lesPays.get(j - 1));
					lesPays.set(j - 1, temp);
				}
				j--;
			}
			i++;
		}
		return lesPays;
	}

	public static boolean verifTriContNom(ArrayList<Pays> vPays) {
		// { } => { résultat = vrai si vPays trié selon l'ORDRE(continent, nom) }
		boolean status = true;
		int i = 0;

		while (i < vPays.size() - 2 && status) {
			if (vPays.get(i).compareTo(vPays.get(i + 1)) > 0) {
				status = false;
			}
			i++;
		}

		return status;
	}

	public static int indDichoIter(ArrayList<Pays> vPays, String contP, String nomP) {
		// { vPays trié selon l'ORDRE(continent, nom) } =>
		// { résultat = * indice dans vPays du pays de continent contP et de nom nomP,
		// si trouvé
		// * -1 si non trouvé }
		int gauche = 0;
		int droite = vPays.size() - 1;

		while (gauche <= droite) {
			final int milieu = (gauche + droite) / 2;
			Pays paysMilieu = vPays.get(milieu);

			int comparaisonContinent = contP.compareTo(paysMilieu.getContinent());
			int comparaisonNom = nomP.compareTo(paysMilieu.getNom());

			if (comparaisonContinent == 0 && comparaisonNom == 0) {
				return milieu;
			}

			if (comparaisonContinent < 0 || (comparaisonContinent == 0 && comparaisonNom < 0)) {
				droite = milieu - 1;
			} else {
				gauche = milieu + 1;
			}
		}
		return -1;
	}

	public static int indDichoRec(ArrayList<Pays> vPays, String contP, String nomP) {
		// { vPays trié selon l'ORDRE(continent, nom) } =>
		// { résultat = * indice dans vPays du pays de continent contP et de nom nomP,
		// si trouvé
		// * -1 si non trouvé }
		return indDichoWorker(vPays, contP, nomP, 0, vPays.size() - 1);
	}

	private static int indDichoWorker(ArrayList<Pays> vPays, String contP, String nomP, int gauche,	int droite) {
		// { vPays trié selon l'ORDRE(continent,nom), 0<=inf<=sup<vPays.size() } =>
		// { résultat = * indice dans vPays[inf..sup] du pays de continent contP et de
		// nom nomP, si trouvé
		// * -1 si non trouvé }
		if (gauche > droite) {
			return -1;
		}

		int milieu = (gauche + droite) / 2;
		Pays paysMilieu = vPays.get(milieu);

		int comparaisonContinent = contP.compareTo(paysMilieu.getContinent());
		int comparaisonNom = nomP.compareTo(paysMilieu.getNom());

		if (comparaisonContinent == 0 && comparaisonNom == 0) {
			return milieu;
		}

		if (comparaisonContinent < 0 || (comparaisonContinent == 0 && comparaisonNom < 0)) {
			return indDichoWorker(vPays, contP, nomP, gauche, milieu - 1);
		}

		return indDichoWorker(vPays, contP, nomP, milieu + 1, droite);
	}

	public static int nbPaysDeContInfNbHabIter(ArrayList<Pays> vPays, String unCont, int popMax) {
		// { vPays trié selon l'ORDRE(continent, nom), popMax > 0 } =>
		// { résultat = nombre d'éléments de vPays de continent unCont
		// et de population < popMax }
		int count = 0;

		for (Pays pays : vPays) {
			if (pays.getContinent().equals(unCont) && pays.getPopulation() < popMax) {
				count++;
			}
		}

		return count;
	}

	public static int nbPaysDeContInfNbHabRec(ArrayList<Pays> vPays, String unCont, int popMax) {
		// { vPays trié selon l'ORDRE(continent, nom), popMax > 0 } =>
		// { résultat = nombre d'éléments de vPays de continent unCont
		// et de population < popMax }
		return nbPaysDeContInfNbHabWorker(vPays, unCont, popMax, 0);
	}

	private static int nbPaysDeContInfNbHabWorker(ArrayList<Pays> vPays, String unCont, int popMax, int ind) {
		// { vPays[ind..vPays.size()-1] trié selon l'ORDRE(continent, nom),
		// 0<=ind<vPays.size(), popMax > 0 } =>
		// { résultat = nombre d'éléments de vPays[ind..vPays.size()-1]
		// de continent unCont et de population < popMax }
		if (ind >= vPays.size()) {
			return 0;
		}

		Pays paysCourant = vPays.get(ind);
		int count = 0;

		if (paysCourant.getContinent().equals(unCont) && paysCourant.getPopulation() < popMax) {
			count = 1;
		}

		return count + nbPaysDeContInfNbHabWorker(vPays, unCont, popMax, ind + 1);
	}

	public static void triFusion(ArrayList<Pays> vPays, int inf, int sup) {
		// { vectE[inf..sup] non vide, 0<=inf<=sup<vectE.size() }
		// => { vectE[inf..sup] trié }
		if (inf < sup) {
			int m = (inf + sup) / 2;
			triFusion(vPays, inf, m);
			triFusion(vPays, m + 1, sup);
			fusionTabG_TabD(vPays, inf, m, sup);
		}
	}

	private static void fusionTabG_TabD(ArrayList<Pays> vPays, int inf, int m, int sup) {
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
		ArrayList<Pays> temp = new ArrayList<>();

		int i = inf;
		int j = m + 1;

		while (i <= m && j <= sup) {
			if (vPays.get(i).getSuperficie() <= vPays.get(j).getSuperficie()) {
				temp.add(vPays.get(i));
				i++;
			} else {
				temp.add(vPays.get(j));
				j++;
			}
		}

		while (i <= m) {
			temp.add(vPays.get(i));
			i++;
		}

		while (j <= sup) {
			temp.add(vPays.get(j));
			j++;
		}

		int k = 0;
		for (i = inf; i <= sup; i++) {
			vPays.set(i, temp.get(k));
			k++;
		}
	}
}
