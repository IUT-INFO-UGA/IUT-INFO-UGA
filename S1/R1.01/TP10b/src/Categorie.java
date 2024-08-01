public class Categorie implements Comparable<Categorie> {
	private final String nomCat;
	private final ListeTrieeC<Instrument> lInstruments;
	public Categorie(String nomCat, ListeTrieeC<Instrument> lInstruments) {
		this.nomCat = nomCat;
		this.lInstruments = lInstruments;
	}

	public String getNomCat() {
		return nomCat;
	}

	public ListeTrieeC<Instrument> getlInstruments() {
		return lInstruments;
	}
	public void afficheCat() {
		System.out.print(this.nomCat + " (" + this.lInstruments.getLongueur()+") : ");
		lInstruments.afficheGD();
	}

	public boolean exixstInsDispo() {
		// { lInstruments non vide } =>
		// { résultat = vai si au moins un instrument de lInstruments peut être prêté }
		Cellule<Instrument> cell = lInstruments.getTete();
		while (cell!= null && cell.getInfo().getNbDispo()<0){
			cell = cell.getCelluleSuivante();
		}
		return cell==null;
	}

	@Override
	public int compareTo(Categorie inst){
		return nomCat.compareTo(inst.nomCat);
	}
}
