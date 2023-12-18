public class Instrument implements Comparable<Instrument> {
	private String nomInstrument;
	private int nbDispo;

	public Instrument(String nomInstrument, int nbDispo){
		this.nomInstrument = nomInstrument;
		this.nbDispo = nbDispo;
	}

	public int getNbDispo() {
		return nbDispo;
	}

	public String getNomInstrument() {
		return nomInstrument;
	}

	public void renduExemplaires(int nbEx) {
		// { } => { nbDispo a été mis à jour }
		this.nbDispo += nbEx;
	}

	public void retraitExemplaires(int nbEx) throws ExceptionDefautDispo {
		// { } => { nbDispo a été mis à jour si et seulement si sa valeur était
		// supérieure à nbEx, sinon, l'exception ExceptionDefautDispo
		// est levée }
		if(nbEx>nbDispo) throw new ExceptionDefautDispo();
		nbDispo-=nbEx;
	}

	@Override
	public String toString(){
		return '('+nomInstrument+", "+nbDispo+')';
	}

	@Override
	public int compareTo(Instrument inst){
		return nomInstrument.compareTo(inst.nomInstrument);
	}
}
