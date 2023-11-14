import java.util.ArrayList;
import java.util.Scanner;

public class Polars_Main {
	public static void main(String[] args) {
		ArrayList<Polar> lesPolars = InitBibPolars.lesPolars();
		System.out.println(lesPolars);

		final int anMin = lesPolars.get(0).getAnnee();
		final int anMax = lesPolars.get(lesPolars.size()-1).getAnnee();
		final int anTest = Utilitaire.saisirIntMinMax(anMin, anMax);

		System.out.println("entrer un nom d'auteur");
		final Scanner in = new Scanner(System.in);
		final String auteurTest = in.nextLine();

		final int iPolar = Utilitaire.rechPremIndSeq(lesPolars, anTest, auteurTest);
		System.out.println(iPolar!=-1?lesPolars.get(iPolar):"polar non trouvé");
	}
}
