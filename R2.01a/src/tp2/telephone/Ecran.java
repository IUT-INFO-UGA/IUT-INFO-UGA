package tp2.telephone;

public class Ecran {
	final private String type;
	final private int taille;

	public Ecran(String type, int taille) {
		this.type = type;
		this.taille = taille;
	}

	public String getType() {
		return type;
	}

	public int getTaille() {
		return taille;
	}

	@Override
	public String toString() {
		return type + " (" + taille + " pouces)";
	}
}
