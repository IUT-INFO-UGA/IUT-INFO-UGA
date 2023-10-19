import java.util.ArrayList;
import java.util.Scanner;

public class VecteursDeString {
	public static void main(String[] args) {
		final Scanner in = new Scanner(System.in);
		ArrayList<String> couleursFR = new ArrayList<String>();
		couleursFR.add("rouge");
		couleursFR.add("orange");
		couleursFR.add("jaune");
		couleursFR.add("vert");
		couleursFR.add("bleu");
		couleursFR.add("indigo");
		couleursFR.add("violet");
		ArrayList<String> couleursAN = new ArrayList<String>();
		couleursAN.add("red");
		couleursAN.add("orange");
		couleursAN.add("yellow");
		couleursAN.add("green");
		couleursAN.add("blue");
		couleursAN.add("indigo");
		couleursAN.add("purple");
		System.out.println(couleursFR);
		System.out.println(couleursAN);
		System.out.println(nbChEgales(couleursFR, couleursAN));
		char continu;
		do{
			System.out.println("nom fr couleur:");
			System.out.println(equiv(in.nextLine(), couleursFR, couleursAN));
			System.out.println("continuer y|N");
			 continu = in.next().charAt(0);
			 in.nextLine();
		} while (continu == 'y');
	}
	private static int nbChEgales(ArrayList<String> v1, ArrayList<String> v2) {
		// { v1 non vide, sans doublons, de même taille que v2 } =>
		// { résultat = nombre d'éléments de v1 dont la valeur est égale
		// à celle de l'élément de même indice dans v2 }
		int occ = 0;
		for (int i = 0; i < v1.size(); i++) {
			if(v1.get(i).equals(v2.get(i))) occ++;
		}
		return occ;
	}


	public static String equiv(String uneChaine, ArrayList<String> v1,
							   ArrayList<String> v2) {
		// { v1 non vide, sans doublons, de même taille que v2 } =>
		// { résultat = * chaîne du vecteur v2, ayant le même indice que
		// uneChaine dans v1 si uneChaine est un élément de v1,
		// * chaîne vide sinon }
		final int index = v1.indexOf(uneChaine);
		if(index == -1) return "";
		return v2.get(index);
	}
}
