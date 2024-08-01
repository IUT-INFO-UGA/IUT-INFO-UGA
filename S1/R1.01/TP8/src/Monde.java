import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.Scanner;

public class Monde {
	public static void main(String[] args) {
		final Scanner in = new Scanner(System.in);
		final ArrayList<Pays> leMonde = InitMonde.creerMonde();

		final Pays plusGrandPaysIter = Utilitaire.plusGrandPaysIter(leMonde);
		final Pays plusGrandPaysPDR = Utilitaire.plusGrandPaysPDR(leMonde);
		System.out.println(plusGrandPaysIter);
		System.out.println(plusGrandPaysPDR);

		final int indMinPopIter = Utilitaire.indMinPopIter(leMonde);
		final int indMinPopDPR = Utilitaire.indMinPopDPR(leMonde);
		final Pays minGrandPaysIter = leMonde.get(indMinPopIter);
		final Pays minGrandPaysPDR = leMonde.get(indMinPopDPR);
		System.out.println(indMinPopIter + " " + minGrandPaysIter);
		System.out.println(indMinPopDPR + " " + minGrandPaysPDR);

		final ArrayList<Pays> leMondeTrie = Utilitaire.triBulleContNom(leMonde);
		System.out.println(Utilitaire.verifTriContNom(leMondeTrie));

		System.out.println("donner unCont");
		final String unCont = in.nextLine();
		System.out.println("donner unNomP");
		final String unNomP = in.nextLine();
		final int indDichoIter = Utilitaire.indDichoIter(leMondeTrie, unCont, unNomP);
		if (indDichoIter < 0)
			System.out.println("non trouver");
		else
			System.out.println(indDichoIter + " " + leMondeTrie.get(indDichoIter));
		final int indDichoRec = Utilitaire.indDichoRec(leMondeTrie, unCont, unNomP);
		if (indDichoRec < 0)
			System.out.println("non trouver");
		else
			System.out.println(indDichoRec + " " + leMondeTrie.get(indDichoRec));

		System.out.println(Utilitaire.nbPaysDeContInfNbHabIter(leMondeTrie, unCont, 100_000));
		System.out.println(Utilitaire.nbPaysDeContInfNbHabRec(leMondeTrie, unCont, 100_000));

		Utilitaire.triFusion(leMonde, 0, leMonde.size()-1);
		System.out.println(leMonde);
	}
}