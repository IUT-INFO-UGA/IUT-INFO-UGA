import java.util.ArrayList;
import java.util.Scanner;

public class Utilitaire {
	public static int saisirIntMinMax(int min, int max) {
		// { min <= max } => { résultat = entier compris entre min et max }
		final Scanner in = new Scanner(System.in);
		int value;

		do{
			System.out.println("enter un entier entre "+min+" et "+max);
			value = in.nextInt();
			in.nextLine();
		}while(value>max || value<min);
		return value;
	}

	public static int rechPremIndSeq(ArrayList<Polar> vPolar, int an, String aut) {
		// { vPolar trié dans l'ordre (annee, auteur) } =>
		// { * s'il y a dans vPolar au moins un élément d'année an et d'auteur aut,
		// résultat = indice du premier de ces éléments
		// * sinon, résultat = -1 }
		// LA RECHERCHE EST SÉQUENTIELLE !!
		int i;

		i = 0;
		Polar polarTest = new Polar(an, aut,"test");
		while (i< vPolar.size() && vPolar.get(i).compareTo(polarTest)<0){
			i++;
		}
		if(vPolar.size() == i || vPolar.get(i).compareTo(polarTest)>0)
			return -1;
		else
			return i;
	}
}
