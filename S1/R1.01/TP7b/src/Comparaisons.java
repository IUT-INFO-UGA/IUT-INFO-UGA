import java.util.ArrayList;
import java.util.Scanner;

public class Comparaisons {
	public static void main(String[] args) {
		final Scanner in = new Scanner(System.in);

		ArrayList<Polar> mesPolars = CreationBib.lesPolars();
		final int compTrisSelect = Utilitaire.triSelect(mesPolars);
		System.out.println("comaraison dans triselect: " + compTrisSelect);
		mesPolars = CreationBib.lesPolars();
		final int compTrisInsert = Utilitaire.triInsertion(mesPolars);
		System.out.println("comaraison dans triInsertion: " + compTrisInsert);

		System.out.println("entrer année: ");
		final int years = in.nextInt();
		in.nextLine();
		System.out.println("entrer un auteur: ");
		final String aut = in.nextLine();
		System.out.println("index 1: "+ Utilitaire.rechSeqT(mesPolars, aut, years));
		System.out.println("index 2: "+ Utilitaire.rechDicho(mesPolars, aut, years));
	}
}
