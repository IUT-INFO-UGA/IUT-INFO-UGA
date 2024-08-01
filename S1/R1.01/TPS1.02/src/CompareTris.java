import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CompareTris {
	public static void main(String[] args) {
		ArrayList<Integer> vInt, vIntBase;
		int nbComp;
		System.out.println("cas 1");
		vIntBase = new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9, 12, 14, 17, 18));

		vInt = new ArrayList<>(vIntBase);

		System.out.println("tri bulle");
		System.out.println(vInt);
		System.out.println("is sort "+ Utilitaire.isSortAsc(vInt));
		System.out.println("nb op "+ Utilitaire.triBulle_O(vInt));

		vInt = new ArrayList<>(vIntBase);

		System.out.println("tris insertion");
		System.out.println(vInt);
		System.out.println("is sort "+ Utilitaire.isSortAsc(vInt));
		System.out.println("nb op "+ Utilitaire.triInsert_O(vInt));

		vInt = new ArrayList<>(vIntBase);

		System.out.println("tris select");
		System.out.println(vInt);
		System.out.println("is sort "+ Utilitaire.isSortAsc(vInt));
		System.out.println("nb op "+ Utilitaire.triSelect_O(vInt));





		System.out.println("\n\n\ncas 1");
		vIntBase = new ArrayList<>(Arrays.asList(12, 7, 9, 14, 5, 17, 6, 8, 18));

		vInt = new ArrayList<>(vIntBase);

		System.out.println("tri bulle");
		System.out.println(vInt);
		System.out.println("is sort "+ Utilitaire.isSortAsc(vInt));
		System.out.println("nb op "+ Utilitaire.triBulle_O(vInt));

		vInt = new ArrayList<>(vIntBase);

		System.out.println("tris insertion");
		System.out.println(vInt);
		System.out.println("is sort "+ Utilitaire.isSortAsc(vInt));
		System.out.println("nb op "+ Utilitaire.triInsert_O(vInt));

		vInt = new ArrayList<>(vIntBase);

		System.out.println("tris select");
		System.out.println(vInt);
		System.out.println("is sort "+ Utilitaire.isSortAsc(vInt));
		System.out.println("nb op "+ Utilitaire.triSelect_O(vInt));



		System.out.println("\n\n\ncas 2");
		vIntBase = new ArrayList<>(Arrays.asList(18, 17, 14, 12, 9, 8, 7, 6, 5));

		vInt = new ArrayList<>(vIntBase);

		System.out.println("tri bulle");
		System.out.println(vInt);
		System.out.println("is sort "+ Utilitaire.isSortAsc(vInt));
		System.out.println("nb op "+ Utilitaire.triBulle_O(vInt));

		vInt = new ArrayList<>(vIntBase);

		System.out.println("tris insertion");
		System.out.println(vInt);
		System.out.println("is sort "+ Utilitaire.isSortAsc(vInt));
		System.out.println("nb op "+ Utilitaire.triInsert_O(vInt));

		vInt = new ArrayList<>(vIntBase);

		System.out.println("tris select");
		System.out.println(vInt);
		System.out.println("is sort "+ Utilitaire.isSortAsc(vInt));
		System.out.println("nb op "+ Utilitaire.triSelect_O(vInt));





		System.out.println("\n\n\npartie 2");
		System.out.println("\n\n\ncas 4");
		vIntBase = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 6, 7, 8, 9));
		System.out.println("tri bulle");
		System.out.println(vIntBase);
		System.out.println("is sort "+ Utilitaire.isSortAsc(vIntBase));
		System.out.println("nb op "+ Utilitaire.triBulle_O(vIntBase));
		System.out.println("\n\n\ncas 5");
		vIntBase = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 9, 9, 9, 9, 9));
		System.out.println("tri bulle");
		System.out.println(vIntBase);
		System.out.println("is sort "+ Utilitaire.isSortAsc(vIntBase));
		System.out.println("nb op "+ Utilitaire.triBulle_O(vIntBase));
		System.out.println("\n\n\ncas 6");
		vIntBase = new ArrayList<>(Arrays.asList(18, 17, 16, 15, 0, 0, 0, 0, 0));
		System.out.println("tri bulle");
		System.out.println(vIntBase);
		System.out.println("is sort "+ Utilitaire.isSortAsc(vIntBase));
		System.out.println("nb op "+ Utilitaire.triBulle_O(vIntBase));
		System.out.println("\n\n\ncas 7");
		vIntBase = new ArrayList<>(Arrays.asList(18, 17, 16, 15, 0, 0, 0, 0, 0));
		System.out.println("tri bulle");
		System.out.println(vIntBase);
		System.out.println("is sort "+ Utilitaire.isSortAsc(vIntBase));
		System.out.println("nb op "+ Utilitaire.triBulle_O(vIntBase));
		System.out.println("\n\n\ncas 8");
		vIntBase = new ArrayList<>(Arrays.asList(18, 18, 18, 18, 18, 4, 3, 0, -2));
		System.out.println("tri bulle");
		System.out.println(vIntBase);
		System.out.println("is sort "+ Utilitaire.isSortAsc(vIntBase));
		System.out.println("nb op "+ Utilitaire.triBulle_O(vIntBase));



		System.out.println("\n\n\npartie 3");
		System.out.println("\n\n\ncas 9");
		vIntBase = Utilitaire.genVectSansDoublons(10);
		System.out.println("tri select");
		System.out.println(vIntBase);
		System.out.println("is sort "+ Utilitaire.isSortAsc(vIntBase));
		System.out.println("nb op "+ Utilitaire.triSelect_O(vIntBase));
		System.out.println("\n\n\ncas 10");
		vIntBase = Utilitaire.genVectSansDoublons(40);
		System.out.println("tri select");
		System.out.println(vIntBase);
		System.out.println("is sort "+ Utilitaire.isSortAsc(vIntBase));
		System.out.println("nb op "+ Utilitaire.triSelect_O(vIntBase));
		System.out.println("\n\n\ncas 11");
		vIntBase = Utilitaire.genVectSansDoublons(160);
		System.out.println("tri select");
		System.out.println(vIntBase);
		System.out.println("is sort "+ Utilitaire.isSortAsc(vIntBase));
		System.out.println("nb op "+ Utilitaire.triSelect_O(vIntBase));
	}
}
