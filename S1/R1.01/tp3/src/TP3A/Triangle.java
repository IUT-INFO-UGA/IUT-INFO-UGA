package TP3A;

public class Triangle {
	// un triangle est défini par la longueur de chacun de ses côtés
	// Attributs
	float cote1; // longueur d'un côté
	float cote2; // longueur d'un autre côté
	float cote3; // longueur du troisième côté

	public Triangle(float cote1, float cote2, float cote3) {
		this.cote1 = cote1;
		this.cote2 = cote2;
		this.cote3 = cote3;

	}

	public float getCote1() {return this.cote1;}

	public float getCote2() {return this.cote2;}

	public float getCote3() {return this.cote3;}

	public float getPerimetre() {
		// { } => { résultat = périmètre de ce Triangle }
		return cote1 + cote2 + cote3;
	}

	public float getSurface() {
		// { } => { résultat = surface de ce Triangle }
		final float p = (this.cote1 + this.cote2 + this.cote3) / 2;
		return (float) Math.sqrt(p * (p - this.cote1) * (p - this.cote2) * (p - this.cote3));
	}

	public String getNature() {
		// { } => { résultat = nature de ce Triangle
		//           * rectangle si la somme des carrés de 2 côtés est égale au
		//             carré du 3ème côté
		//           * rectangle et isocèle s'il est rectangle et a deux côtés égaux
		//           * équilatéral si ses 3 côtés sont égaux
		//           * isocèle si 2 (et seulement 2) de ses côtés sont égaux
		//           * quelconque s'il n'est ni équilatéral, ni isocèle, ni rectangle }
		// NOTE : dans un plan, un triangle équilatéral ne peut pas être rectangle
		if (Math.pow(this.cote1, 2) + Math.pow(this.cote2, 2) == Math.pow(this.cote3, 2)) {
			if (cote1 == cote2 || cote2 == cote3 || cote3 == cote1) {
				return ("rectangle et isocèle");
			} else {
				return ("rectangle");
			}
		} else {
			int nbEqual = 0;
			if (cote1 == cote2) nbEqual++;
			if (cote2 == cote3) nbEqual++;
			if (cote3 == cote1) nbEqual++;
			if (nbEqual == 2) {
				return "isocèle";
			} else {
				return "quelconque";
			}

		}
	}

	public String toString() {
		return "Cotés : (" + cote1 + ", " + cote2 + ", " + cote3 + ") | Périmètre : " + getPerimetre() + " | Surface : " + getSurface() + " | Nature : " + getNature();
	}
}
