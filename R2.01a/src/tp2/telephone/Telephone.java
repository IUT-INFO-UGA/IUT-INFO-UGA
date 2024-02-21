package tp2.telephone;

import java.util.ArrayList;

public class Telephone {
	private final String libelle;
	private final Processeur processeur;
	private final Ecran ecran;
	private final ArrayList<Memoire> ram = new ArrayList<>();
	private final Memoire stockage;

	public Telephone(String libelle, Processeur processeur, Ecran ecran, Memoire memoire, Memoire ram) {
		this.libelle = libelle;
		this.processeur = processeur;
		this.ecran = ecran;
		this.stockage = memoire;
		this.ram.add(ram);
	}

	public void addRam(Memoire ram) {
		this.ram.add(ram);
	}

	@Override
	public String toString() {
		int totalRam = 0;
		String ramString = "";
		for (Memoire memoire : ram) {
			ramString += memoire + " ";
			totalRam += memoire.getNombreGiga();
		}
		return libelle + " : " + processeur + " " + ecran + " " + stockage + " ram: " + totalRam + "[" + ramString
				+ "]";
	}
}
