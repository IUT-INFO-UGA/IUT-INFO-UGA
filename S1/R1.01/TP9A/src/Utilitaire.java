import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilitaire {
	public static int getInt_IME(Scanner lecteur) {
		// { } => {résultat = un entier saisi par l'utilisateur }
		// L'EXCEPTION InputMismatchException EST GÉRÉE
		int val;
		try {
			System.out.println("donne un int");
			val = lecteur.nextInt();
			lecteur.nextLine();
			return val;
		} catch (InputMismatchException e) {
			lecteur.nextLine();
			System.out.println("non: " + e);
			return getInt_IME(lecteur);
		}
	}

	public static int getIntMinMax_IME(Scanner lecteur, int min, int max) {
		// { min <= max } =>
		// { résultat = un entier compris entre min et max, saisi par l'utilisateur }
		// L'EXCEPTION inputMismatchException EST GÉRÉE
		int val;
		try {
			System.out.println("donne un int entre: " + min + " et " + max);
			val = lecteur.nextInt();
			lecteur.nextLine();
			if (val > max || val < min) {
				System.out.println("non");
				return getIntMinMax_IME(lecteur, min, max);
			}
			return val;
		} catch (InputMismatchException e) {
			lecteur.nextLine();
			System.out.println("non: " + e);
			return getIntMinMax_IME(lecteur, min, max);
		}
	}

	public static int getInt_NFE(Scanner lecteur) {
		// { } => {résultat = un entier saisi par l'utilisateur }
		// L'EXCEPTION NumberFormatException EST GÉRÉE
		int val;
		try {
			System.out.println("donne un int");
			val = lecteur.nextInt();
			lecteur.nextLine();
			return val;
		} catch (NumberFormatException e) {
			lecteur.nextLine();
			System.out.println("non: " + e);
			return getInt_IME(lecteur);
		}
	}

	public static float getFloat_NFE(Scanner lecteur) {
		// { } => {résultat = un entier saisi par l'utilisateur }
		// L'EXCEPTION NumberFormatException EST GÉRÉE
		float val;
		try {
			System.out.println("donne un float");
			val = lecteur.nextFloat();
			lecteur.nextLine();
			return val;
		} catch (NumberFormatException e) {
			lecteur.nextLine();
			System.out.println("non: " + e);
			return getFloat_NFE(lecteur);
		}
	}

	public static int sumIter(ListeChainee<Integer> listInt) {
		// { listInt non vide } =>
		// { résultat = somme des entiers portés par les cellules de listInt }
		int tot = 0;
		Cellule<Integer> mCell;
		mCell = listInt.getTete();
		tot += mCell.getInfo();
		do {
			mCell = mCell.getCelluleSuivante();
			tot += mCell.getInfo();

		} while (mCell.getCelluleSuivante() != null);
		return tot;
	}

	public static int sumRec(ListeChainee<Integer> listInt) {
		// { listInt non vide } =>
		// { résultat = somme des entiers portés par les cellules de listInt }
		return sumRec_wk(listInt.getTete());
	}
	private static int sumRec_wk(Cellule<Integer> cellCour) {
		// { } =>
		// { résultat = somme des entiers portés par les cellules d'une sous-liste
		// de tête cellCour }
		if (cellCour.getCelluleSuivante() == null) {
			return cellCour.getInfo();
		} else {
			return cellCour.getInfo()+sumRec_wk(cellCour.getCelluleSuivante());
		}
	}

	public static boolean existIntIt(ListeChainee<Integer> listInt, int unInt) {
		// { } =>
		// { résultat = vrai si au moins une cellule de listInt porte l'info unInt }
		Cellule<Integer> mCell;
		mCell = listInt.getTete();
		while (mCell.getInfo() != unInt || mCell.getCelluleSuivante() == null){
			mCell = mCell.getCelluleSuivante();
		}
		return mCell.getCelluleSuivante() != null;
	}

	public static boolean existIntRec(ListeChainee<Integer> listInt, int unInt) {
		// { } =>
		// { résultat = vrai si au moins une cellule de listInt porte l'info unInt }
		return existIntRec_wk(listInt.getTete(), unInt);
	}

	private static boolean existIntRec_wk(Cellule<Integer> cellCour, int unInt) {
		// { } => { résultat = vrai si au moins une cellule d'une sous-liste de tête
		// cellCour porte l'info unInt }
		if(cellCour.getInfo()==unInt) return true;
		if (cellCour.getCelluleSuivante() == null) return false;
		return existIntRec_wk(cellCour.getCelluleSuivante(), unInt);
	}

	public static int posFirstSup(ListeChainee<Integer> listInt, int unInt) {
		// { } => {résultat = rang de la première cellule de listInt portant
		// un entier supérieur à unInt, 0 si non trouvée }
		int rang = 0;
		Cellule<Integer> mCell;
		mCell = listInt.getTete();
		while (mCell.getInfo() <= unInt || mCell.getCelluleSuivante() == null){
			mCell = mCell.getCelluleSuivante();
			rang++;
		}
		if(mCell.getCelluleSuivante() == null) return 0;
		return rang;
	}

	public static int bigger(ListeChainee<Integer> listInt) {
		// { listInt non vide } =>
		// { résultat = plus grand entier porté par une cellule de listInt }
		Cellule<Integer> mCell;
		mCell = listInt.getTete();
		int bigger = mCell.getInfo();
		while (mCell.getCelluleSuivante()!=null){
			mCell = mCell.getCelluleSuivante();
			if(bigger<mCell.getInfo()) bigger = mCell.getInfo();
		}
		return bigger;
	}

	public static ListeChainee<Integer> subList(ListeChainee<Integer> listInt,
												int position) {
		// { * listInt non vide,
		// * position compris entre 1 et le nombre de cellules de listInt } =>
		// { résultat = une liste d'entiers contenant les cellules de listInt
		// à partir de position }
		int currPos = 0;
		Cellule<Integer> mCell = listInt.getTete();
		while (currPos!=position && mCell.getCelluleSuivante()!=null){
			mCell = mCell.getCelluleSuivante();
			currPos++;
		}
		ListeChainee<Integer> newList = new ListeChainee<>();
		while (mCell.getCelluleSuivante()!=null){
			newList.insereTete(mCell.getInfo());
			mCell = mCell.getCelluleSuivante();
		}
		return newList;
	}

	public static int nbMult2(ListeChainee<Integer> listeInt) {
		// { } =>
		// { résultat = nombre d'entiers pairs portés par les cellules de listeInt }
		return nbMult2_wk(listeInt.getTete());
	}

	private static int nbMult2_wk(Cellule<Integer> cellCour) {
		// { } =>
		// { résultat = nombre d'entiers pairs portés par les cellules d'une sous-liste
		// de tête cellCour }
		if(cellCour.getCelluleSuivante()==null)
			return cellCour.getInfo()%2 == 0 ? 1 : 0;
		if(cellCour.getInfo()%2 == 0)
			return nbMult2_wk(cellCour.getCelluleSuivante())+1;
		else
			return nbMult2_wk(cellCour.getCelluleSuivante());
	}
}