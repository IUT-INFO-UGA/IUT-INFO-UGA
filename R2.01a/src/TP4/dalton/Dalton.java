package TP4.dalton;

public class Dalton implements Comparable<Dalton> {
	final String name;
	final Taille height;

	public Dalton(String name, Taille height) {
		this.name = name;
		this.height = height;
	}

	@Override
	public int compareTo(Dalton d) {
		int compare = ComparateurTaille.compareToHeight(this.height, d.height);
		if (compare == 0) {
			compare = ComparateurNom.compareToName(this.name, d.name);
		}
		return compare;
	}
}
