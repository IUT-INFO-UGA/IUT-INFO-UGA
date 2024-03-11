package TP4.dalton;

public class ComparateurTaille {
	public static int compareToHeight(Taille t1, Taille t2) {
		if (t1 == t2) {
			return 0;
		}
		if (t1 == Taille.PETIT) {
			return -1;
		}
		if (t1 == Taille.MOYEN) {
			if (t2 == Taille.PETIT) {
				return 1;
			}
			return -1;
		}
		if (t1 == Taille.GRAND) {
			return 1;
		}
		return 0;
	}
}
