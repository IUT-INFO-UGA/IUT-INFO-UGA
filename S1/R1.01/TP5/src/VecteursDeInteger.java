import java.util.ArrayList;
import java.util.Scanner;

public class VecteursDeInteger {
	public static int saisieEntPos() {
		final Scanner in = new Scanner(System.in);
		// { } => { résultat = un entier >0, saisi par l'utilisateur }
		int saisie = -1;
		while (saisie<0){
			System.out.println("donnée un entier");
			saisie = in.nextInt();
			in.nextLine();
		}
		return saisie;
	}

	public static ArrayList<Integer> lesDiviseurs(int unEnt) {
		// { unEnt >0 } => {résultat = vecteur contenant les diviseurs de unEnt
		// y compris 1 et unEnt }
		ArrayList<Integer> div = new ArrayList<Integer>();
		for (int i = unEnt; i >0; i--) {
			if(unEnt%i==0)
				div.add(i);
		}
		return div;
	}

	private static int sommeDe(ArrayList<Integer> unVectEntPos) {
		// { unVectEntPos non vide, tous ses éléments sont > 0 } =>
		// { résultat = somme des éléments de unVectEntPos }
		int sum = 0;
		for (int i = 0; i < unVectEntPos.size(); i++) {
			sum+=unVectEntPos.get(i);
		}
		return sum;
	}

	private static boolean estPremier(int unEnt) {
		// { unEnt >0 } => { résultat = vrai si unEnt est PREMIER }
		return lesDiviseurs(unEnt).size() <= 2;
	}

	private static boolean estParfait (int unEnt) {
		// {unEnt >0 } => { résultat = vrai si unEnt est PARFAIT }
		return (unEnt == sommeDe(lesDiviseurs(unEnt))/2);
	}

	private static boolean estSublime(int unEnt) {
		//{ unEnt >0 } => { résultat = vrai si unEnt est SUBLIME
		return estParfait(lesDiviseurs(unEnt).size())&&estParfait(lesDiviseurs(unEnt).size());
	}

	private static String qualiteDe(int unEnt) {
		// { unEnt >0 } =>
		// { résultat = "PREMIER", "PARFAIT", "SUBLIME" ou "QUELCONQUE"
		// selon les propriétés de unEnt }
		if(estPremier(unEnt)) return "PREMIER";
		else if(estParfait(unEnt)) return "PARFAIT";
		else if (estSublime(unEnt)) return "SUBLIME";
		else return "QUELCONQUE";
	}


	public static void main(String[] args) {
		final int unEnt = saisieEntPos();
		final ArrayList<Integer> lesdiv = lesDiviseurs(unEnt);
		System.out.println("les diviseur: "+lesdiv);
		System.out.println("nb div "+ lesdiv.size());
		System.out.println("somme div "+ sommeDe(lesdiv));
		System.out.println("qualité: "+ qualiteDe(unEnt));
		if(!qualiteDe(unEnt).equals("PREMIER")){
			for (int i = 1; i < lesdiv.size()-1; i++) {
				System.out.println("qualité de "+lesdiv.get(i)+" "+ qualiteDe(lesdiv.get(i)));
			}
		}
	}
}
