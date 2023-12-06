import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CompareRech {
	public static void main(String[] args) {
		//dont work
		ArrayList<Integer> array = new ArrayList<>(Arrays.asList(-45, -45, -10, 9, 10, 20, 30, 75, 90));
		System.out.println(array);
		System.out.println(array.size());
		System.out.println("tappe un nombre");
		Scanner in = new Scanner(System.in);
		int saisie  = in.nextInt();
		System.out.println("avec rechSeqIt_O");
		PaireResCompteur<Integer> result = Utilitaire.rechSeqIt_O(array, saisie);
		System.out.println("nb "+result.getCompteur()+", result"+result.getRes());
		System.out.println("avec rechDichoIt_O");
		result = Utilitaire.rechDichoIt_O(array, saisie);
		System.out.println("nb "+result.getCompteur()+", result"+result.getRes());
	}
}
