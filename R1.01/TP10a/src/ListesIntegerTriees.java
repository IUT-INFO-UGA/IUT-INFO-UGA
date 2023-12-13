import java.util.ArrayList;
import java.util.Arrays;

public class ListesIntegerTriees {
	public static void main(String[] args) {
		ArrayList<Integer> vIntTest = new ArrayList(Arrays.asList(31, 1, 46, 35, 5, 32,
				14, 49, 19, 28, 2, 30, 32, 12, 20));
		ListeTrieeD<Integer> listIntD = new ListeTrieeD<>();

		for (Integer integer : vIntTest) {
			listIntD.insereTrie(integer);
		}

		listIntD.afficheGD();
		ArrayList<Integer> vIntRandom1 = new ArrayList<>();

		ArrayList<Integer> vIntRandom2 = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			vIntRandom1.add((int) (Math.random() * 40));
		}
		for (int i = 0; i < 15; i++) {
			vIntRandom2.add((int) (Math.random() * 40));
		}

		ListeTrieeC<Integer> ListIntC1 = new ListeTrieeC<>(), ListIntC2 = new ListeTrieeC<>();
		for (Integer integer : vIntRandom1) {
			ListIntC1.insereTrie(integer);
		}
		for (Integer integer : vIntRandom2) {
			ListIntC2.insereTrie(integer);
		}
		ListIntC1.afficheGD();
		ListIntC2.afficheGD();

		ListeTrieeC<Integer> listIntC1_sdb = Utilitaire.lCsansDoublons(ListIntC1);
		ListeTrieeC<Integer> listIntC2_sdb = Utilitaire.lCsansDoublons(ListIntC2);

		listIntC1_sdb.afficheGD();
		listIntC2_sdb.afficheGD();

		ListeTrieeC<Integer> union = Utilitaire.union(listIntC1_sdb, listIntC2_sdb);
		union.afficheGD();


	}

}
