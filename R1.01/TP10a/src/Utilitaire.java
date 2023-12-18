import java.util.Objects;

public class Utilitaire {
	public static ListeTrieeC<Integer> lCsansDoublons(ListeTrieeC<Integer> lC) {
		// { lC non vide, avec potentiellement des doublons } =>
		// { résultat = nouvelle liste triée croissante dont les cellules portent
		// les mêmes entiers que lC, mais sans doublons }
		final ListeTrieeC<Integer> sDouble = new ListeTrieeC<>();

		Cellule<Integer> cell = lC.getTete();

		int info;

		while(cell != null){
			info = cell.getInfo();
			sDouble.insereTrie(info);
			cell = cell.getCelluleSuivante();
			while (cell!=null && cell.getInfo()==info){
				cell = cell.getCelluleSuivante();
			}
		}

		return sDouble;
	}
	public static boolean estDansListeC(ListeTrieeC<Integer> lC, int unEnt) {
		// { lC non vide, sans doublons } =>
		// { résultat = vrai s'il existe une cellule de lC portant l'entier unEnt,
		// faux sinon }
		if (lC.getLongueur() == 0) return false;
		return estDansListeC_wk(lC.getTete(), unEnt);
	}

	private static boolean estDansListeC_wk(Cellule<Integer> cellCour, int unEnt) {
		// { lC1_sdb et lC2_sdb non vides, sans doublons } =>
		// { résultat = liste triée croissante, contenant, sans doublons,
		// les entiers portés par les cellules de lC1_sdb et
		// les entiers portés par les cellules de lC2_sdb }
		if (cellCour.getInfo() == unEnt) {
			return true;
		}
		if (cellCour.getCelluleSuivante() == null || cellCour.getInfo() > unEnt) {
			return false;
		}
		return estDansListeC_wk(cellCour.getCelluleSuivante(), unEnt);
	}

	public static ListeTrieeC<Integer> union(ListeTrieeC<Integer> lC1_sdb, ListeTrieeC<Integer> lC2_sdb) {
		// { lC1_sdb et lC2_sdb non vides, sans doublons } =>
		// { résultat = liste triée croissante, contenant, sans doublons,
		// les entiers portés par les cellules de lC1_sdb qui sont
		// égaux à ceux portés par les cellules de lC2_sdb }
		final ListeTrieeC<Integer> list = lC1_sdb;

		Cellule<Integer> cell = lC2_sdb.getTete();
		while (cell!=null){
			if(!estDansListeC(list, cell.getInfo())){
				list.insereTrie(cell.getInfo());
			}
			cell=cell.getCelluleSuivante();
		}
		return list;
	}

	public static ListeTrieeC<Integer> intersect(ListeTrieeC<Integer> lC1_sdb, ListeTrieeC<Integer> lC2_sdb) {
		// { lC1_sdb et lC2_sdb non vides, sans doublons } =>
		// { résultat = liste triée croissante, contenant, sans doublons,
		// les entiers portés par les cellules de lC1_sdb qui sont
		// égaux à ceux portés par les cellules de lC2_sdb }
		final ListeTrieeC<Integer> list = new ListeTrieeC<>();
		Cellule<Integer> cell = lC1_sdb.getTete();
		while (cell!=null){
			if(estDansListeC(lC2_sdb, cell.getInfo())){
				list.insereTrie(cell.getInfo());
			}
			cell = cell.getCelluleSuivante();
		}
		return list;
	}
}
