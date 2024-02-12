package TP1;

import java.util.Scanner;

public class TestString {
	public static void main(String[] args) {
		final Scanner entree = new Scanner(System.in);
		System.out.println("Donner une chaîne de caractères maChaine :");
		final String maChaine = entree.nextLine();
		System.out.println("Nombre de caractères de la chaîne de caractères maChaine : " + maChaine.length());
		System.out.println("La chaîne de caractères maChaine en majuscule : " + maChaine.toUpperCase());
		System.out.println("Donner une deuxieme chaîne de caractères deuxiemeChaine : ");
		final String deuxiemeChaine = entree.nextLine();
		System.out.println(deuxiemeChaine.equalsIgnoreCase(maChaine)
				? "Les deux chaînes sont identiques - sans tenir compte de la casse."
				: "lex deux chaine ne sont pas egal");
		System.out
				.println(maChaine.equals(maChaine.toLowerCase()) ? "La chaîne de caractères maChaine est en minuscule."
						: "La chaîne de caractères maChaine n'est pas en minuscule");
		System.out.println("La chaîne de caractères maChaine en majuscule sans les 'blancs' en début et fin de chaîne :"
				+ maChaine.trim().toUpperCase());
		final StringBuilder sb = new StringBuilder(maChaine);
		sb.reverse();
		System.out.println(maChaine.contentEquals(sb) ? "La chaîne de caractères maChaine est un palindrome."
				: "La chaîne de caractères maChaine n'est pas un palindrome.");
		entree.close();
	}
}
