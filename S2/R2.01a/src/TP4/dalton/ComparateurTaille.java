package TP4.dalton;

import java.util.Comparator;

public class ComparateurTaille implements Comparator<Dalton> {
	@Override
	public int compare(Dalton d1, Dalton d2) {
		if (d1.getHeight() == d2.getHeight()) {
			return 0;
		}
		if (d1.getHeight() == Taille.PETIT) {
			return -1;
		}
		if (d1.getHeight() == Taille.MOYEN) {
			if (d2.getHeight() == Taille.PETIT) {
				return 1;
			}
			return -1;
		}
		if (d1.getHeight() == Taille.GRAND) {
			return 1;
		}
		return 0;
	}
}
