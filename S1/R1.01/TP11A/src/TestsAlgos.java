import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class TestsAlgos {
	public static void main(String[] args) {
		/*
		 * -----------------------------------------------------------------------------
		 * ---------
		 * TEST DES ALGORITHMES DÉVELOPPÉS DANS LA CLASSE Algos
		 * À NE PAS MODIFIER !!!
		 * -----------------------------------------------------------------------------
		 * ----------
		 */
		Scanner lecteur = new Scanner(System.in);
		int unEnt, res;
		String uneChaine;
		Jeton unJeton;

		// Structures de données de type Integer
		ArrayList<Integer> vInt = new ArrayList<>();
		while (vInt.size() < 10) {
			vInt.add((int) (Math.random() * 21));
		}
		ArrayList<Integer> vIntVide = new ArrayList<>();
		ListeTrieeC<Integer> lIntC = new ListeTrieeC<>();
		for (int i = 0; i < vInt.size(); i++) {
			lIntC.insereTrie(vInt.get(i));
		}
		ArrayList<Integer> vIntTrie = new ArrayList<>();
		Cellule<Integer> cellCour = lIntC.getTete();
		while (cellCour != null) {
			vIntTrie.add(cellCour.getInfo());
			cellCour = cellCour.getCelluleSuivante();
		}
		// Structure de données de type String
		ArrayList<String> vString = new ArrayList<>(
				Arrays.asList("lundi", "mardi", "mercredi", "jeudi", "samedi", "dimanche"));
		ListeTrieeC<String> lStringC = new ListeTrieeC<>();
		for (int i = 0; i < vString.size(); i++) {
			lStringC.insereTrie(vString.get(i));
		}

		// Structures de données de type Jeton
		ArrayList<Jeton> lesJetons = CreeVectJetons.lesJetons();
		Collections.shuffle(lesJetons);
		ArrayList<Jeton> vJetons = new ArrayList<>();
		for (int i = 0; i < 15; i++) {
			vJetons.add(lesJetons.get(i));
		}
		/*----------------------------------------------------------------------------------------
		    ALGOS SAISIES CONTRÔLÉES
		---------------------------------------------------------------------------------------*/

		// Saisie d'un entier compris dans un intervalle, sans gestion d'exception
		// unEnt = Algos.saisieEntMinMax(lecteur, 3, 15);
		// System.out.println("Entier saisi : " + unEnt);
		// System.out.println();

		// Saisie contrôlée d'un entier supérieur à un entier donné
		// avec gestion de l'exception InputMismatchException
		// unEnt = Algos.saisieEntSup(lecteur, 100);
		// System.out.println("Entier saisi : " + unEnt);
		// System.out.println();

		// Saisie contrôlée d'une chaîne dans un vecteur de chaînes non vide
		// uneChaine = Algos.saisieChaineDeV(lecteur, vString);
		// System.out.println("Chaîne saisie : " + uneChaine);
		// System.out.println();

		/*---------------------------------------------------------------------------------------
		    ALGOS MAXIMUM / MINIMUM / MOYENNE - DANS UN VECTEUR
		  ---------------------------------------------------------------------------------------*/

		// Plus grand entier d'un vecteur d'entiers non vide
		// System.out.println("Maximum de " + vInt + " = " + Algos.maximum(vInt));
		// System.out.println();

		// Moyenne des valeurs d'un vecteur d'entiers quelconque
		// try {
		// System.out.print("Moyenne de " + vIntVide + " : ");
		// System.out.println(Algos.moyenne(vIntVide));
		// } catch (ExceptionMoyImpossible e) {
		// System.out.println(e.getMessage());
		// }
		// try {
		// System.out.print("Moyenne de " + vInt + " : ");
		// System.out.println(Algos.moyenne(vInt));
		// } catch (ExceptionMoyImpossible e) {
		// System.out.println(e.getMessage());
		// }
		// System.out.println();

		// Plus petite chaine selon l'ordre lexicographique dans un vecteur de chaines
		// non vide
		// uneChaine = Algos.minOrdreLG(vString);
		// System.out.println(vString);
		// System.out.println("Plus petite chaine de " + vString + " dans l'ordre
		// lexicographique : " + uneChaine);
		// System.out.println();

		/*---------------------------------------------------------------------------------------
		   ALGOS NOMBRE DE / SOMME DE
		   DANS UN VECTEUR OU UNE LISTE CHAÎNÉE
		 ---------------------------------------------------------------------------------------*/

		// Somme des éléments d'un vecteur d'entiers non vide - forme récursive
		// System.out.println("Somme de " + vInt + " = " + Algos.somme(vInt));
		// System.out.println();

		// Nombre d'entiers égaux à entier donné dans une liste croissante d''entiers
		// - forme récursive
		// System.out.print("Liste étudiée : ");

		// lIntC.afficheGD();
		// System.out.println("Nombres d'entiers égaux à 6 dans la liste : " +
		// Algos.nbEntDeVal(lIntC, 6));
		// System.out.println();

		// Nombre de jetons de valeur supérieure à 3 dans un vecteur de Jeton non vide
		// System.out.println("Vecteur de jetons : " + vJetons);
		// System.out.println("Nombre de jetons de valeur supérieure à 3 dans le
		// vecteur: " + Algos.nbJetonsSup3(vJetons));
		// System.out.println();

		/*---------------------------------------------------------------------------------------
		   ALGOS RECHERCHES DANS UN VECTEUR OU UNE LISTE CHAÎNÉE
		 ---------------------------------------------------------------------------------------*/
		// Existence d'un entier donné dans un vecteur d'entiers quelconque
		// (recherche séquentielle) – 2 formes

		// FORME ITÉRATIVE
		// unEnt = -4;
		// System.out.println("Recherche séquentielle itérative de " + unEnt + " dans le
		// vecteur " + vInt);
		// System.out.println((Algos.existValSeq_it(vInt, unEnt))
		// ? unEnt + " est dans le vecteur !"
		// : unEnt + " n'est pas dans le vecteur");
		// unEnt = 13;
		// System.out.println();

		// System.out.println("Recherche séquentielle itérative de " + unEnt + " dans le
		// vecteur " + vInt);
		// System.out.println((Algos.existValSeq_it(vInt, unEnt))
		// ? unEnt + " est dans le vecteur !"
		// : unEnt + " n'est pas dans le vecteur");
		// System.out.println();

		// FORME RÉCURSIVE
		// unEnt = -4;
		// System.out.println("Recherche séquentielle récursive de " + unEnt + " dans le
		// vecteur " + vInt);
		// System.out.println((Algos.existValSeq_rec(vInt, unEnt))
		// ? unEnt + " est dans le vecteur !"
		// : unEnt + " n'est pas dans le vecteur");
		// unEnt = 13;
		// System.out.println();

		// System.out.println("Recherche séquentielle récursive de " + unEnt + " dans le
		// vecteur " + vInt);
		// System.out.println((Algos.existValSeq_rec(vInt, unEnt))
		// ? unEnt + " est dans le vecteur !"
		// : unEnt + " n'est pas dans le vecteur");
		// System.out.println();

		// Indice de la première occurrence d'un entier donné dans un vecteur trié
		// d'entiers
		// (recherche dichotomique)
		// unEnt = -4;
		// System.out.println("Recherche dichotomique de l'indice de la 1ère occurrence
		// de " + unEnt + " dans le vecteur "
		// + vIntTrie);
		// res = Algos.rechIndDicho(vIntTrie, unEnt);
		// System.out.println((res != -1)
		// ? "1ère occurrence de " + unEnt + "trouvée à l'indice " + res
		// : unEnt + " n'est pas dans le vecteur");
		// unEnt = 13;
		// System.out.println();
		// System.out.println("Recherche dichotomique de l'indice de la 1ère occurrence
		// de " + unEnt + " dans le vecteur "
		// + vIntTrie);
		// res = Algos.rechIndDicho(vIntTrie, unEnt);
		// System.out.println((res != -1)
		// ? "1ère occurrence de " + unEnt + "trouvée à l'indice " + res
		// : unEnt + " n'est pas dans le vecteur");
		// unEnt = 15;
		// System.out.println();

		// System.out.println("Recherche dichotomique de l'indice de la 1ère
		// occurrencede " + unEnt + " dans le vecteur " + vIntVide);
		// res = Algos.rechIndDicho(vIntVide, unEnt);
		// System.out.println((res != -1)
		// ? "1ère occurrence de " + unEnt + "trouvée à l'indice " + res
		// : unEnt + " n'est pas dans le vecteur");
		// unEnt = 100;
		// System.out.println();
		//
		// System.out.println("Recherche dichotomique de l'indice de la 1ère occurrence
		// de " + unEnt + " dans le vecteur " + vIntTrie);
		// res = Algos.rechIndDicho(vIntTrie, unEnt);
		// System.out.println((res != -1)
		// ? "1ère occurrence de " + unEnt + "trouvée à l'indice " + res
		// : unEnt + " n'est pas dans le vecteur");
		// System.out.println();

		// Position de la première occurrence d'une chaîne donnée dans une
		// liste de chaînes triée croissante (recherche séquentielle !!!)
		// System.out.print("Liste étudiée : ");
		// lStringC.afficheGD();
		// uneChaine = "jeudi";
		// System.out.println("Position de la 1ère occurrence de " + uneChaine + " dans
		// la liste...");
		// res = Algos.rechPos(lStringC, uneChaine);
		// System.out.println((res != 0)
		// ? "1ère occurrence de " + uneChaine + " trouvée à l'indice " + res
		// : uneChaine + " n'est pas dans la liste");
		// System.out.println();

		// uneChaine = "monday";
		// System.out.println("Position de la 1ère occurrence de " + uneChaine + " dans
		// la liste...");
		// res = Algos.rechPos(lStringC, uneChaine);
		// System.out.println((res != 0)
		// ? "1ère occurrence de " + uneChaine + " trouvée à l'indice " + res
		// : uneChaine + " n'est pas dans la liste");
		// System.out.println();

		/*---------------------------------------------------------------------------------------
		    ALGOS TRIS ET VÉRIFICATION DU TRI
		 ---------------------------------------------------------------------------------------*/

		// Tri à bulles amélioré d'un vecteur d'entiers
		// ArrayList<Integer> vInt30 = new ArrayList<>();
		// while (vInt30.size() <= 30) {
		// vInt30.add((int) (Math.random() * 61));
		// }
		// System.out.println("Vecteur d'entiers à trier : ");
		// System.out.println(vInt30);
		// System.out.println("Vecteur après tri : ");
		// Algos.triBulle(vInt30);
		// System.out.println(vInt30);
		// System.out.println();

		// // Vecteur résultant du tri par insertion d'un vecteur de jetons
		// System.out.println("Vecteur de jetons : ");
		// System.out.println(vJetons);
		// System.out.println("Nouveau vecteur de jetons, résultant du tri ce de
		// vecteur: ");
		// ArrayList<Jeton> vJetonsTrie = Algos.vJetonTrie(vJetons);
		// System.out.println(vJetonsTrie);
		// System.out.println();

		// // Vérification du tri d'un vecteur non vide de type Jeton
		// if (Algos.veriftri(vJetonsTrie)) {
		// System.out.println("Le nouveau vecteur de jetons est bien trié !");
		// } else {
		// System.out.println("Echec du tri... (nouveau vecteur de jetons non trié)");
		// }

		/*---------------------------------------------------------------------------------------
		    TESTS COMPLÉTION CLASSE Date
		 ---------------------------------------------------------------------------------------*/
		Date d1 = new Date(18, 12, 2023);
		Date d2 = new Date(19, 12, 2022);
		Date d3 = new Date(18, 01, 2024);
		Date d4 = new Date(1, 01, 2025);
		Date d5 = new Date(15, 12, 2023);

		System.out.println(d1 + "comparée à " + d2 + " --> " + d1.compareTo(d2));
		System.out.println(" Résultat attendu : 1");
		System.out.println();

		System.out.println(d1 + "comparée à " + d3 + " --> " + d1.compareTo(d3));
		System.out.println(" Résultat attendu : -1");
		System.out.println();

		System.out.println(d1 + "comparée à " + d4 + " --> " + d1.compareTo(d4));
		System.out.println(" Résultat attendu : -1");
		System.out.println();

		System.out.println(d1 + "comparée à " + d5 + " --> " + d1.compareTo(d5));
		System.out.println(" Résultat attendu : 1");
		System.out.println();

		System.out.println(d1 + "comparée à " + d1 + " --> " + d1.compareTo(d1));
		System.out.println(" Résultat attendu : 0");
		System.out.println();
	}

}
