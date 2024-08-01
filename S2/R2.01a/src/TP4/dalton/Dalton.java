package TP4.dalton;

public class Dalton implements Comparable<Dalton> {
	final String name;
	final Taille height;

	public Dalton(String name, Taille height) {
		this.name = name;
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public Taille getHeight() {
		return height;
	}

	@Override
	public String toString() {
		return name + " (" + height + ")";
	}

	@Override
	public int compareTo(Dalton d) {
		final int compare = this.name.compareTo(d.name);
		if (compare == 0) {
			return this.height.compareTo(d.height);
		}
		return compare;
	}
}
