package TP3A;

public class Rectangle {
	// un rectangle est défini par la longueur de ses côtés
	// quelle que soit sa position dans le plan

	// Attributs
	private final float cote1;
	private final float cote2;

	public Rectangle(float cote1, float cote2) {
		this.cote1 = cote1;
		this.cote2 = cote2;
	}

	public float getCote1() {return this.cote1;}

	public float getCote2() {return this.cote2;}

	public float getPerimetre() {
		// { } => { résultat = périmètre de ce Rectangle }
		return ((this.cote1 + this.cote2) * 2);
	}


	// 3 - surface - À DÉCOMMENTER ET COMPLÉTER

	public float getSurface() {
		// { } => { résultat = surface de ce Rectangle }
		return (this.cote1 * this.cote2);
	}

	public Cercle cercleInscrit() {
		// { } => { résultat = le Cercle inscrit dans ceRectangle }
		return new Cercle(cote1 / 2);
	}

	public Cercle cercleCirconscrit() {
		// { } => { résultat = le Cercle circonscrit à ceRectangle }
		return new Cercle((float) ((Math.sqrt(Math.pow(cote1, 2) + Math.pow(cote2, 2))) / 2));
	}

	// Pour l'affichage des cotés, du périmètre et de la surface de ce Rectangle

	@Override
	public String toString() {
		return "Cotés : (" + cote1 + ", " + cote2 + ") | Périmètre : " + getPerimetre() + " | Surface : " + getSurface();
	}

}