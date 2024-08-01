package TP3A;

public class Cercle {
	final double PI = 3.14;
	float rayon;  // longueur du rayon
    public Cercle(float rayon) {
		this.rayon = rayon;
    }
    public float getRayon() {return this.rayon;}
    public float getPerimetre() {
        // { } => { Résultat = périmètre de ce Cercle }
		return (float) (2*PI*this.rayon);
    }
    public float getSurface() {
        // { } => { Résultat = surface de ce Cercle }
		return (float) (Math.pow(this.rayon, 2)*PI);
    }
    @Override
    public String toString() {
        return "Rayon : "+ rayon + " | Périmètre : " + getPerimetre() + " | Surface : " + getSurface();
    }
}
