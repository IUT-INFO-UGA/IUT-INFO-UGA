package TP4.dalton;

import java.util.Comparator;

public class ComparateurNom implements Comparator<Dalton> {
	@Override
	public int compare(Dalton d1, Dalton d2) {
		return d1.getName().compareTo(d2.getName());
	}
}
