import java.util.ArrayList;

public class PolarsEtTris {
	public static void main(String[] args) {
		//partie 1
		ArrayList<Polar> lesPolars = CreationBib.lesPolars();
		Utilitaire.printbibTitre(lesPolars);

		final boolean sort = Utilitaire.verifTri(lesPolars);
		if(sort){
			System.out.println("vecteur trié");
		}else{
			System.out.println("vecteur non trié");
		}

		//partie 2
		Polar pol1 = new Polar(2000, "AUTEUR1", "Une oeuvre");
		Polar pol2 = new Polar(2000, "AUTEUR2", "Mon oeuvre");
		Polar pol3 = new Polar(1998, "AUTEUR1", "Oeuvre sans nom");
		System.out.print("pol1 : "); System.out.println(pol1);
		System.out.print("pol2 : "); System.out.println(pol2);
		System.out.print("pol3 : "); System.out.println(pol3);
		System.out.println("* pol1 comparé à pol2 : " + pol1.compareTo(pol2));
		System.out.println("* pol1 comparé à pol1 : " + pol1.compareTo(pol1));
		System.out.println("* pol1 comparé à pol3 : " + pol1.compareTo(pol3));

		//partie 3
		System.out.println("le tableau va etre trié par ordre auteur, annee");
		Utilitaire.triSelect(lesPolars);

		//partie 4
		lesPolars = CreationBib.lesPolars();
		System.out.println("le tableau va etre trié par ordre auteur, annee");
		Utilitaire.triBulle(lesPolars);

		//partie 5
		lesPolars = CreationBib.lesPolars();
		System.out.println("le tableau va etre trié par ordre auteur, annee");
		Utilitaire.triInsertion(lesPolars);
	}
}
