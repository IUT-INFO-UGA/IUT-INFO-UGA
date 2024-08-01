import java.util.ArrayList;
import java.util.Scanner;

public class Monde {
	public static void main(String[] args) {
		final Scanner in = new Scanner(System.in);
		ArrayList<Pays> leMonde = InitMonde.creerMonde();
		ArrayList<String> lesContinents = new ArrayList<String>();
		for (int i = 0; i < leMonde.size(); i++) {
			final int ind = Utilitaire.indContinent(lesContinents, leMonde.get(i).getContinent());
			if(ind != -1){
				lesContinents.add(ind, leMonde.get(i).getContinent());
			}
		}
		System.out.println(lesContinents);
		Utilitaire.contExtremes(leMonde, lesContinents);
		/*
		final String unCont = Utilitaire.saisieCont(lesContinents);
		ArrayList<Pays> vPaysDeCont = Utilitaire.paysDeCont(leMonde, unCont);
		System.out.println("premier "+ vPaysDeCont.get(0).getNom());
		System.out.println("dermier "+ vPaysDeCont.get(vPaysDeCont.size()-1).getNom());
		System.out.println("taile "+ vPaysDeCont.size());

		System.out.print("entrer un nom de pays: ");
		final String text = in.nextLine();
		final int indexPays = Utilitaire.rechPaysT(vPaysDeCont, text);
		if(indexPays==vPaysDeCont.size())
			System.out.println("une erreur s'est produite");
		else
			System.out.println(vPaysDeCont.get(indexPays));
	*/
	}

}
