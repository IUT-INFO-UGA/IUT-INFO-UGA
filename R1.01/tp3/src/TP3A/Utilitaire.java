package TP3A;

import java.util.Scanner;

public class Utilitaire {
	public static float saisieFloatPos() {
		// { } => { résultat = un réel (float) strictement positif }
		Scanner in = new Scanner(System.in);
		float value;
		do {
			System.out.print("Entrer un float positif ou nul: ");
			value = in.nextFloat();
			in.nextLine();
		} while (value <= 0f);
		return value;
	}

	public static float saisieFloatPosMinMax(float min, float max) {
		// { 0 < min < max } =>
		// { résultat = un réel saisi par l'utilisateur, appartenant à ]min, max[ }
		Scanner in = new Scanner(System.in);
		float value;
		do {
			System.out.println("donné un nombre entre " + min + " et " + max);
			value = in.nextFloat();
			in.nextLine();
		} while (value <= min || value >= max);

		return value;
	}

	public static Cercle saisirCercle() {
		// { } => { résultat = un nouvel objet de type Cercle dont le rayon
		// est saisi par l'utilisateur }
		System.out.println("quelle est le rayon du cercle ?");
		return new Cercle(saisieFloatPos());
	}

	public static float troisiemeCoteTriangle(float cote1, float cote2) {
		// { cote1 et cote2 > 0 } =>
		// { le résultat est un float strictement positif, tel qu'un triangle dont
		// les côtés seraient cote1, cote2 et le float saisi puisse être construit }
		// INDICATION : INÉGALITÉ TRIANGULAIRE
		System.out.print("donné nombre entre " + (cote2 - cote1) + " et " + (cote2 + cote1) + " : ");
		return saisieFloatPosMinMax(cote2 - cote1, cote2 + cote1);
	}


	public static Triangle saisirTriangle() {
		// { } => { résultat = un nouvel objet de type triangle
		// dont les côtés sont saisis par l'utilisateur }
		System.out.println("donné nombre positif pour coté 1");
		final float cote1 = saisieFloatPos();
		System.out.println("donné nombre positif pour coté 2");
		final float cote2 = saisieFloatPos();
		System.out.println("donné le troisiemme coté");
		return new Triangle(cote1, cote2, troisiemeCoteTriangle(cote1, cote2));
	}
}
