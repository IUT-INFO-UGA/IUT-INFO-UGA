package tp2.telephone;

public class Memoire {
	final private String type;
	final private int nombreGiga;

	Memoire(String type, int nombreGiga) {
		this.type = type;
		this.nombreGiga = nombreGiga;
	}

	public String getType() {
		return type;
	}

	public int getNombreGiga() {
		return nombreGiga;
	}

	@Override
	public String toString() {
		return type + " (" + nombreGiga + "Go)";
	}
}
