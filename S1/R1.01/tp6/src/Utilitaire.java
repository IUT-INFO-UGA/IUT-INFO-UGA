import java.util.ArrayList;
import java.util.Scanner;

public class Utilitaire {
	public static int indContinent(ArrayList<String> vCont, String cont) {
		// { vCont trié } =>
		// { résultat = * -1 si cont est déjà dans vCont
		// * indice où il faudrait insérer cont dans VCont
		// pour conserver le tri de ce vecteur, sinon }
		int i = 0;
		while (i<vCont.size() && vCont.get(i).compareTo(cont)<0)
			i++;
		if(i<vCont.size() && vCont.get(i).compareTo(cont)==0)
			return -1;
		return i;
	}

	public static boolean existString(ArrayList<String> vString, String uneString) {
		// { vString trié } =>
		// { résultat = vrai si uneString appartient à vString }
		return indContinent(vString, uneString)==-1;
	}

	public static String saisieCont(ArrayList<String> vCont) {
		final Scanner in = new Scanner(System.in);
		// { vCont trié, non vide } =>
		// { résultat = valeur d'un élément de vCont saisie par l'utilisateur }
		// LA SAISIE DOIT ÊTRE CONTRÔLÉE
		String text;
		do{
			System.out.print("entrer un nom de continent: ");
			text = in.nextLine();
		}while(!existString(vCont, text));
		return text;
	}
	public static ArrayList<Pays> paysDeCont(ArrayList<Pays> vPays, String cont) {
		// { cont est le continent d'au moins un pays de vPays } =>
		// { résultat = vecteur contenant les pays de vPays
		// dont le continent est cont }
		ArrayList<Pays> contryList = new ArrayList<Pays>();
		for (int i = 0; i < vPays.size(); i++) {
			Pays contry = vPays.get(i);
			if(contry.getContinent().equals(cont))
				contryList.add(contry);
		}
		return contryList;
	}

	public static int rechPaysT(ArrayList<Pays> vPays, String nomP) {
		// { vPays trié sur le nom } =>
		// { résultat = indice dans vPays du pays de nom nomP s'il existe,
		// vPays.size() si pas de pays de nom nomP dans vPays }
		int i = 0;
		while (i<vPays.size() && !vPays.get(i).getNom().equals(nomP))
			i++;
		if(i == vPays.size()-1&&!vPays.get(i).getNom().equals(nomP))
			return vPays.size();
		else return i;
	}

	public static void paysMoinsPeuples(ArrayList<Pays> vMonde) {
		// { vMonde non vide } =>
		// { les caractéristiques du ou des pays le(s) moins peuplé(s)
		// dans vMonde ont été affichées }
		int popMin = vMonde.get(0).getPopulation();
		ArrayList<Pays> min= new ArrayList<Pays>();
		min.add(vMonde.get(0));
		for (int i = 1; i < vMonde.size(); i++) {
			if(popMin > vMonde.get(i).getPopulation()){
				min.clear();
				min.add(vMonde.get(i));
				popMin = vMonde.get(i).getPopulation();
			}else if(popMin==vMonde.get(i).getPopulation()){
				min.add(vMonde.get(i));
			}
		}
		System.out.println(min);
	}

	public static void contExtremes(ArrayList<Pays> vMonde, ArrayList<String> vCont) {
		// { vMonde non vide } =>
		// { * Affichage du nom et du nombre de pays du (ou des) continent(s)
		// comptant le plus de pays
		// * Affichage du nom et du nombre de pays du (ou des) continent(s)
		// comptant le moins de pays }
		paysMoinsPeuples(vMonde);

		ArrayList<ArrayList<Pays>> minCont = new ArrayList<ArrayList<Pays>>();
		minCont.add(paysDeCont(vMonde, vCont.get(0)));
		for (int i = 0; i < vCont.size(); i++) {
			ArrayList<Pays> listPays = paysDeCont(vMonde, vCont.get(i));
			if(minCont.get(0).size()>listPays.size()){
				minCont.clear();
				minCont.add(listPays);
			}
		}
		System.out.println("contient avec le moins de pays("+minCont.get(0).size()+"): ");
		System.out.println(minCont);

		ArrayList<ArrayList<Pays>> maxcont = new ArrayList<ArrayList<Pays>>();
		maxcont.add(paysDeCont(vMonde, vCont.get(0)));
		for (int i = 0; i < vCont.size(); i++) {
			ArrayList<Pays> listPays = paysDeCont(vMonde, vCont.get(i));
			if(maxcont.get(0).size()>listPays.size()){
				maxcont.clear();
				maxcont.add(listPays);
			}
		}

		System.out.println("contient avec le plus de pays("+maxcont.get(0).size()+"): ");
		System.out.println(minCont);
	}
}
