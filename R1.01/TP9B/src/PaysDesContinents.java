import jdk.jshell.execution.Util;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PaysDesContinents {
	public static void main(String[] args) {
		final Scanner in = new Scanner(System.in);
		// Declarations and initializations
		ArrayList<Pays> mondeT = new ArrayList<>(InitMondeT.creerMondeT());
		ArrayList<String> vContinents = new ArrayList<>(Arrays.asList("Afrique", "Amériques", "Antarctique", "Asie", "Europe", "Océanie"));

		ListeChainee<PaysDeCont> listeAfrique = Utilitaire.countries(mondeT, "Afrique");
		ListeChainee<PaysDeCont> listeAmeriques = Utilitaire.countries(mondeT, "Amériques");
		ListeChainee<PaysDeCont> listeAntarctique = Utilitaire.countries(mondeT, "Antarctique");
		ListeChainee<PaysDeCont> listeAsie = Utilitaire.countries(mondeT, "Asie");
		ListeChainee<PaysDeCont> listeEurope = Utilitaire.countries(mondeT, "Europe");
		ListeChainee<PaysDeCont> listeOceanie = Utilitaire.countries(mondeT, "Océanie");

		// Display the number of elements in each continent's list
		System.out.println("* Afrique : " + listeAfrique.getLongueur() + " pays");
		System.out.println("* Amériques : " + listeAmeriques.getLongueur() + " pays");
		System.out.println("* Antarctique : " + listeAntarctique.getLongueur() + " pays");
		System.out.println("* Asie : " + listeAsie.getLongueur() + " pays");
		System.out.println("* Europe : " + listeEurope.getLongueur() + " pays");
		System.out.println("* Océanie : " + listeOceanie.getLongueur() + " pays");

		ArrayList<ListeChainee<PaysDeCont>> vListesPdeC = new ArrayList<>(Arrays.asList(listeAfrique,listeAmeriques, listeAntarctique, listeAsie,listeEurope, listeOceanie));
		int conti = Utilitaire.indString(in, vContinents);
		Utilitaire.affichePaysDeCont(vListesPdeC.get(conti));

		Utilitaire.contExtremes(vContinents, vListesPdeC);


		ListeChainee<String> truc = Utilitaire.listeNomsPaysDuMonde(vContinents, vListesPdeC);
		Cellule<String> current = truc.getTete();
		for (int i = 0; i < 10; i++) {
			System.out.println(current.getInfo());
			current = current.getCelluleSuivante();
		}

	}
}