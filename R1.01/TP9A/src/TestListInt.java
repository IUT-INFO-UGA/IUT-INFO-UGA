import java.util.Scanner;

public class TestListInt {
	public static void main(String[] args) {
		final Scanner in = new Scanner(System.in);
		final ListeChainee<Integer> listInt =  new ListeChainee<>();
		for (int i = 0; i < 15; i++) {
			listInt.insereTete((int)(Math.random() * 10));
		}
		System.out.println(listInt.getLongueur());
		listInt.afficheGaucheDroiteRec();
		System.out.println(Utilitaire.sumIter(listInt));
		System.out.println(Utilitaire.sumRec(listInt));

		final int unInt = Utilitaire.getInt_IME(in);
		System.out.println(Utilitaire.existIntRec(listInt, unInt));
		System.out.println(Utilitaire.posFirstSup(listInt, unInt));

		System.out.println(Utilitaire.bigger(listInt));
		final int deuxint = Utilitaire.getIntMinMax_IME(in, 0, listInt.getLongueur());
		final ListeChainee<Integer> sub = Utilitaire.subList(listInt, deuxint);
		System.out.println(Utilitaire.nbMult2(sub));

	}
}
