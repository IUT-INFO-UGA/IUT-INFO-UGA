
#include "NoeudBinaireInt.h"
#include "ArbreBinaireInt.h"
#include "prettyPrint.h"
#include <iostream>
#include <time.h>
#include <stdlib.h>

using namespace std;

void testeNoeudBinaire() {
    cout << endl << "DÉBUT testeNoeudBinaire()" << endl << endl;
    NoeudBinaireInt racine(7);
    NoeudBinaireInt filsDroit(5);
    NoeudBinaireInt filsGauche(8);

    racine.setPtrFilsGauche(&filsGauche);
    racine.setPtrFilsDroit(&filsDroit);
    cout << "La racine porte l'information : " << racine.getInfo() << " ; devrait être 7" << endl;
    cout << "Le fils gauche porte l'information : " << racine.getPtrFilsGauche()->getInfo() << " ; devrait être 8" << endl;
    cout << "La fils droit porte l'information : " << racine.getPtrFilsDroit()->getInfo() << " ; devrait être 5" << endl;

    cout << endl << "FIN testeNoeudBinaire()" << endl;
}

void testeConstructionRandom() {
    cout << endl << "DÉBUT testeConstructionV2()" << endl << endl;
    ArbreBinaireInt monArbre(27);
    monArbre.insereRandom(10);
    monArbre.insereRandom(33);
    monArbre.insereRandom(8);
    monArbre.insereRandom(6);
    monArbre.insereRandom(9);
    monArbre.insereRandom(17);
    monArbre.insereRandom(14);
    monArbre.insereRandom(15);
    monArbre.insereRandom(14);
    monArbre.insereRandom(12);
    monArbre.insereRandom(23);
    monArbre.insereRandom(24);
    monArbre.insereRandom(25);
    monArbre.insereRandom(20);
    monArbre.insereRandom(21);
    monArbre.insereRandom(30);
    monArbre.insereRandom(38);
    monArbre.afficheInfixe();
    cout << endl << "FIN testeConstructionRandom()" << endl;
}

/**
 * 
 * @return arbre binaire vide
 */
ArbreBinaireInt arbreBinaireVide() {
    ArbreBinaireInt arbreVide;
    return arbreVide;
}

/**
 * 
 * @return arbre binaire feuille
 */
ArbreBinaireInt arbreBinaireFeuille() {
    ArbreBinaireInt arbreFeuille(15);
    return arbreFeuille;
}

/**
 * 
 * @return arbre binaire feuille
 */
ArbreBinaireInt arbreBinaireFeuille(int val) {
    ArbreBinaireInt arbreFeuille(val);
    return arbreFeuille;
}

/**
 * 
 * @return arbre binaire au hasard
 */
ArbreBinaireInt arbreBinaireQcQ() {
    ArbreBinaireInt monArbre(27);
    monArbre.insereRandom(10);
    monArbre.insereRandom(33);
    monArbre.insereRandom(8);
    monArbre.insereRandom(6);
    monArbre.insereRandom(9);
    monArbre.insereRandom(17);
    monArbre.insereRandom(14);
    monArbre.insereRandom(15);
    monArbre.insereRandom(14);
    monArbre.insereRandom(12);
    monArbre.insereRandom(23);
    monArbre.insereRandom(24);
    monArbre.insereRandom(25);
    monArbre.insereRandom(20);
    monArbre.insereRandom(21);
    monArbre.insereRandom(30);
    monArbre.insereRandom(38);
    return monArbre;
}

/**
 * 
 * @return arbre binaire produit (contruction avec inserePath()
 */
ArbreBinaireInt arbreBinaireSomme() {
    ArbreBinaireInt monArbre;
    monArbre.inserePath(46, "");
    monArbre.inserePath(18, "0");
    monArbre.inserePath(28, "1");
    monArbre.inserePath(6, "00");
    monArbre.inserePath(12, "01");
    monArbre.inserePath(5, "10");
    monArbre.inserePath(23, "11");
    monArbre.inserePath(6, "000");
    monArbre.inserePath(3, "100");
    monArbre.inserePath(2, "101");
    return monArbre;
}

/**
 * 
 * @return arbre binaire non produit (contruction avec inserePath()
 */
ArbreBinaireInt arbreBinaireNonSomme1() {
    ArbreBinaireInt monArbre;
    monArbre.inserePath(33, "");
    monArbre.inserePath(13, "0");
    monArbre.inserePath(12, "1");
    monArbre.inserePath(6, "00");
    monArbre.inserePath(7, "01");
    monArbre.inserePath(12, "10");
    return monArbre;
}

/**
 * 
 * @return arbre binaire non produit (contruction avec inserePath()
 */
ArbreBinaireInt arbreBinaireNonSomme2() {
    ArbreBinaireInt monArbre;
    monArbre.inserePath(27, "");
    monArbre.inserePath(15, "0");
    monArbre.inserePath(12, "1");
    monArbre.inserePath(6, "00");
    monArbre.inserePath(7, "01");
    monArbre.inserePath(12, "10");
    return monArbre;
}

/**
 * 
 * @return arbre binaire non produit (contruction avec inserePath()
 */
ArbreBinaireInt arbreBinaireNonSomme3() {
    ArbreBinaireInt monArbre;
    monArbre.inserePath(55, "");
    monArbre.inserePath(15, "0");
    monArbre.inserePath(12, "1");
    monArbre.inserePath(6, "00");
    monArbre.inserePath(7, "01");
    monArbre.inserePath(12, "10");
    return monArbre;
}

/**
 *
 * @return arbre binaire non produit (contruction avec inserePath()
 */
ArbreBinaireInt arbreBinaireNonSomme4() {
    ArbreBinaireInt monArbre;
    monArbre.inserePath(55, "");
    monArbre.inserePath(15, "0");
    monArbre.inserePath(12, "1");
    monArbre.inserePath(6, "00");
    monArbre.inserePath(7, "01");
    monArbre.inserePath(12, "10");
    monArbre.inserePath(12, "11");
    return monArbre;
}

/**
 *
 * @return arbre binaire non produit (contruction avec inserePath()
 */
ArbreBinaireInt arbreBinaireNonSomme5() {
    ArbreBinaireInt monArbre;
    monArbre.inserePath(55, "");
    monArbre.inserePath(15, "0");
    monArbre.inserePath(12, "1");
    monArbre.inserePath(12, "10");
    monArbre.inserePath(12, "11");
    return monArbre;
}

void testProfondeurMinimale() {
    cout << "\n*******************************************" << endl;
    cout << "**                                       **" << endl;
    cout << "**      TEST profondeurMinimale()        **" << endl;
    cout << "**                                       **" << endl;
    cout << "*******************************************\n" << endl;
    ArbreBinaireInt arbreVide = arbreBinaireVide();
    ArbreBinaireInt abFeuille = arbreBinaireFeuille(3);
    ArbreBinaireInt ab1 = arbreBinaireNonSomme2();
    ArbreBinaireInt ab2 = arbreBinaireNonSomme4();
    ArbreBinaireInt ab3 = arbreBinaireNonSomme5();

    cout << "profondeur minimale d'un arbre vide -> " << arbreVide.profondeurMinimale() << "; devrait être 0" << endl << endl;

    cout << "Pour une arbre feuille : " << endl;
    prettyPrint::printPretty(abFeuille, 2, 0, cout);
    cout << "\n    sa profondeur minimale est ->" << abFeuille.profondeurMinimale() << " ; devrait être 1" << endl << endl;
    
    cout << "Pour l'arbre 1 : " << endl;
    prettyPrint::printPretty(ab1, 2, 0, cout);
    cout << "\n    sa profondeur minimale est -> " << ab1.profondeurMinimale() << " ; devrait être 3" << endl << endl;

    cout << "Pour l'arbre 2 : " << endl;
    prettyPrint::printPretty(ab2, 2, 0, cout);
    cout << "\n    sa profondeur minimale est -> " << ab2.profondeurMinimale() << " ; devrait être 3" << endl << endl;

    cout << "Pour l'arbre 3 : " << endl;
    prettyPrint::printPretty(ab3, 2, 0, cout);
    cout << "\n    sa profondeur minimale est -> " << ab3.profondeurMinimale() << " ; devrait être 2" << endl << endl;
}

void testeValeurArbre() {
    cout << "\n***********************************************************" << endl;
    cout << "**                                                       **" << endl;
    cout << "**                 TEST valeurArbre()                    **" << endl;
    cout << "**                                                       **" << endl;
    cout << "***********************************************************\n" << endl;
    ArbreBinaireInt arbreVide = arbreBinaireVide();
    ArbreBinaireInt abProduitFeuille = arbreBinaireFeuille();
    ArbreBinaireInt abSomme = arbreBinaireSomme();
    ArbreBinaireInt abNonSomme1 = arbreBinaireNonSomme1();
    ArbreBinaireInt abNomSomme2 = arbreBinaireNonSomme2();

    cout << "La valeur d'un arbre vide est : " << arbreVide.valeurArbre() << " ; devrait être 0" << endl << endl;
    
    cout << "La valeur de l'arbre : " << endl;
    prettyPrint::printPretty(abProduitFeuille, 2, 0, cout);
    cout << "\n    est : " << abProduitFeuille.valeurArbre() << " ; devrait être 15" << endl << endl;
    
    cout << "La valeur de l'arbre : " << endl;
    prettyPrint::printPretty(abSomme, 2, 0, cout);
    cout << "\n    est : " << abSomme.valeurArbre() << " ; devrait être 46" << endl << endl;
    
    cout << "La valeur de l'arbre : " << endl;
    prettyPrint::printPretty(abNonSomme1, 2, 0, cout);
    cout << "\n    est : " << abNonSomme1.valeurArbre() << " ; devrait être 33" << endl << endl;
    
    cout << "La valeur de l'arbre : " << endl;
    prettyPrint::printPretty(abNomSomme2, 2, 0, cout);
    cout << "\n    est : " << abNomSomme2.valeurArbre() << " ; devrait être 27" << endl;
}


void testeEstArbreBinaireSomme() {
    cout << "\n***********************************************************" << endl;
    cout << "**                                                       **" << endl;
    cout << "**                TEST estUnAbreSomme()                  **" << endl;
    cout << "**                                                       **" << endl;
    cout << "***********************************************************\n" << endl;
    ArbreBinaireInt arbreVide = arbreBinaireVide();
    ArbreBinaireInt abSommeFeuille = arbreBinaireFeuille();
    ArbreBinaireInt abSomme = arbreBinaireSomme();
    ArbreBinaireInt abNonSomme1 = arbreBinaireNonSomme1();
    ArbreBinaireInt abNomSomme2 = arbreBinaireNonSomme2();
    
    cout << "L'arbre vide est-il un arbre de somme : " << arbreVide.estUnArbreSomme() << " ; devrait être 1 (true)" << endl << endl;
    
    cout << "L'arbre : " << endl;
    prettyPrint::printPretty(abSommeFeuille, 2, 0, cout);
    cout << "\n    est-il un arbre de somme : " << abSommeFeuille.estUnArbreSomme() << " ; devrait être 1 (true)" << endl << endl;
    
    cout << "L'arbre : " << endl;
    prettyPrint::printPretty(abSomme, 2, 0, cout);
    cout << "\n    est-il un arbre de somme : " << abSomme.estUnArbreSomme() << " ; devrait être 1 (true)" << endl << endl;
    
    cout << "L'arbre : " << endl;
    prettyPrint::printPretty(abNonSomme1, 2, 0, cout);
    cout << "\n    est-il un arbre de somme : " << abNonSomme1.estUnArbreSomme() << " ; devrait être 0 (false) ; problème au nœud 33" << endl << endl;
    
    cout << "L'arbre : " << endl;
    prettyPrint::printPretty(abNomSomme2, 2, 0, cout);
    cout << "\n    est-il un arbre de somme : " << abNomSomme2.estUnArbreSomme() << " ; devrait être 0 (false) ; problème au nœud 15" << endl << endl;

}

void testeinsereArbreSomme() {
    cout << "\n***********************************************************" << endl;
    cout << "**                                                       **" << endl;
    cout << "**            TEST testeinsereArbreSomme()               **" << endl;
    cout << "**                                                       **" << endl;
    cout << "***********************************************************\n" << endl;
    
    ArbreBinaireInt unArbre = arbreBinaireVide();
    cout << "affichage d'un arbre vide : ";
    unArbre.afficheInfixe();
    cout << endl;
    
    unArbre.insereArbreSomme(5);
    cout << "affichage pretty de l'arbre après insertion de 5 : ";
    prettyPrint::printPretty(unArbre, 2, 0, cout);
    cout << endl;
    
    unArbre.insereArbreSomme(6);
    cout << "affichage pretty de l'arbre après insertion de 6 : ";
    prettyPrint::printPretty(unArbre, 2, 0, cout);
    cout << endl;
    
    unArbre.insereArbreSomme(7);
    cout << "affichage pretty de l'arbre après insertion de 7 : ";
    prettyPrint::printPretty(unArbre, 2, 0, cout);
    cout << endl;
    
    unArbre.insereArbreSomme(8);
    cout << "affichage pretty de l'arbre après insertion de 8 : ";
    prettyPrint::printPretty(unArbre, 2, 0, cout);
    cout << endl;
    
    unArbre.insereArbreSomme(4);
    cout << "affichage pretty de l'arbre après insertion de 4 : ";
    prettyPrint::printPretty(unArbre, 2, 0, cout);
    cout << endl;
    
}

/*
 * 
 */
int main() {
    srand(time(NULL));
    testProfondeurMinimale();
    testeValeurArbre();
    testeEstArbreBinaireSomme();
    testeinsereArbreSomme();
    
    return 0;
}

// Trace attendue
/*
*******************************************
**                                       **
**      TEST profondeurMinimale()        **
**                                       **
*******************************************

profondeur minimale d'un arbre vide -> 0; devrait être 0

Pour une arbre feuille :

 3

    sa profondeur minimale est ->0 ; devrait être 1

Pour l'arbre 1 :

     ____27____
    /          \
  _15_        _12
 /    \      /
 6     7    12

    sa profondeur minimale est -> 3 ; devrait être 3

Pour l'arbre 2 :

     ____55____
    /          \
  _15_        _12_
 /    \      /    \
 6     7    12    12

    sa profondeur minimale est -> 3 ; devrait être 3

Pour l'arbre 3 :

     ____55____
    /          \
   15         _12_
             /    \
            12    12

    sa profondeur minimale est -> 2 ; devrait être 2


***********************************************************
**                                                       **
**                 TEST valeurArbre()                    **
**                                                       **
***********************************************************

La valeur d'un arbre vide est : 0 ; devrait être 0

La valeur de l'arbre :

15

    est : 15 ; devrait être 15

La valeur de l'arbre :

           __________46__________
          /                      \
     ____18____              ____28____
    /          \            /          \
  __6          12         __5_         23
 /                       /    \
 6                       3     2

    est : 46 ; devrait être 46

La valeur de l'arbre :

     ____33____
    /          \
  _13_        _12
 /    \      /
 6     7    12

    est : 33 ; devrait être 33

La valeur de l'arbre :

     ____27____
    /          \
  _15_        _12
 /    \      /
 6     7    12

    est : 27 ; devrait être 27

***********************************************************
**                                                       **
**                TEST estUnAbreSomme()                  **
**                                                       **
***********************************************************

L'arbre vide est-il un arbre de somme : 0 ; devrait être 1 (true)

L'arbre :

15

    est-il un arbre de somme : 1 ; devrait être 1 (true)

L'arbre :

           __________46__________
          /                      \
     ____18____              ____28____
    /          \            /          \
  __6          12         __5_         23
 /                       /    \
 6                       3     2

    est-il un arbre de somme : 1 ; devrait être 1 (true)

L'arbre :

     ____33____
    /          \
  _13_        _12
 /    \      /
 6     7    12

    est-il un arbre de somme : 0 ; devrait être 0 (false) ; problème au nœud 33

L'arbre :

     ____27____
    /          \
  _15_        _12
 /    \      /
 6     7    12

    est-il un arbre de somme : 0 ; devrait être 0 (false) ; problème au nœud 15

***********************************************************
**                                                       **
**           TEST testeinsereArbreSomme()              **
**                                                       **
***********************************************************

affichage d'un arbre vide : 

affichage pretty de l'arbre après insertion de 5 : 
 5

affichage pretty de l'arbre après insertion de 6 : 
  __6 
 /     
 6      

affichage pretty de l'arbre après insertion de 7 : 
  _13_
 /    \
 6     7

affichage pretty de l'arbre après insertion de 8 : 
     ____15____
    /          \
  __8           7 
 /                 
 8                  

affichage pretty de l'arbre après insertion de 4 : 
           __________11__________
          /                      \
     _____4                       7    
    /                                   
  __4                                     
 /                                         
 4                        
 */