public class Date implements Comparable<Date> {
	// 3 attributs de type int : jour, mois, annee
	private int jour;
	private int mois;
	private int annee;

	// constructeur - `À CODER
	public Date(int jour, int mois, int annee) {
		this.jour = jour;
		this.mois = mois;
		this.annee = annee;
	}

	// getters - `À CODER
	public int getAnnee() {
		return annee;
	}

	public int getJour() {
		return jour;
	}

	public int getMois() {
		return mois;
	}

	@Override
	public int compareTo(Date o) {
		// Ordre choronologique
		// REMPLACER L'INSTRUCTION CI-DESSOUS PAR LE CODE ADÉQUAT
		if (annee > o.annee)
			return 1;
		else if (annee < o.annee)
			return -1;
		else if (mois > o.mois)
			return 1;
		else if (mois < o.mois)
			return -1;
		else if (jour > o.jour)
			return 1;
		else if (jour < o.jour)
			return -1;
		else
			return 0;
	}

	public String toString() {
		// affichage sous la forme jour/mois/annee
		// REMPLACER L'INSTRUCTION CI-DESSOUS PAR LE CODE ADÉQUAT
		return jour + "/" + mois + "/" + annee;
	}

}
