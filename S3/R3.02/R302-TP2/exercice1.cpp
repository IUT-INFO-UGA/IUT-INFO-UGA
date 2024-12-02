
#include "ArbreNoeudsBinairesRecherche.h"
#include <iostream>

using namespace std;

void check(bool succes) {
    if (succes)
        cout << " Opération réussie." << endl;
    else
        cout << " Opération impossible." << endl;
} // end check

// arbre binaire de recherche dégénéré à droite

ArbreNoeudBinaireRecherche<int>* buildArbreDegenereDroit() {
    ArbreNoeudBinaireRecherche<int>* ptrArbre = new ArbreNoeudBinaireRecherche<int>();
    ptrArbre->insere(10);
    ptrArbre->insere(20);
    ptrArbre->insere(30);
    ptrArbre->insere(40);
    ptrArbre->insere(50);
    return ptrArbre;
}

// arbre binaire de recherche dégénéré à gauche

ArbreNoeudBinaireRecherche<int>* buildArbreDegenereGauche() {
    ArbreNoeudBinaireRecherche<int>* ptrArbre = new ArbreNoeudBinaireRecherche<int>();
    ptrArbre->insere(50);
    ptrArbre->insere(40);
    ptrArbre->insere(30);
    ptrArbre->insere(20);
    ptrArbre->insere(10);
    return ptrArbre;
}

// un arbre binaire de recherche

ArbreNoeudBinaireRecherche<int>* buildArbre2() {
    ArbreNoeudBinaireRecherche<int>* ptrArbre = new ArbreNoeudBinaireRecherche<int>();
    ptrArbre->insere(15);
    ptrArbre->insere(12);
    ptrArbre->insere(24);
    ptrArbre->insere(23);
    ptrArbre->insere(35);
    ptrArbre->insere(40);
    ptrArbre->insere(14);
    ptrArbre->insere(80);
    ptrArbre->insere(20);
    return ptrArbre;
}

// un arbre binaire de recherche équilibré

ArbreNoeudBinaireRecherche<int>* buildArbre3() {
    ArbreNoeudBinaireRecherche<int>* ptrArbre = new ArbreNoeudBinaireRecherche<int>();
    ptrArbre->insere(40);
    ptrArbre->insere(20);
    ptrArbre->insere(10);
    ptrArbre->insere(30);
    ptrArbre->insere(60);
    ptrArbre->insere(50);
    ptrArbre->insere(70);
    ptrArbre->insere(80);
    return ptrArbre;
}

void testInsertAffiche() {
    cout << endl << "***********************************" << endl;
    cout << "*                                 *" << endl;
    cout << "*  test des méthodes d'affichage  *" << endl;
    cout << "*                                 *" << endl;
    cout << "***********************************" << endl << endl;
    ArbreNoeudBinaireRecherche<int>* ptrArbre1 = buildArbreDegenereDroit();
    cout << "Arbre1 -> un arbre binaire de recherche dégénéré : " << endl;
    ptrArbre1->printPretty(2, 0, cout);
    cout << endl << " Arbre1 en parcours préfixé doit être 10 20 30 40 50" << endl << "  ";
    ptrArbre1->affichePrefixe();

    cout << " Arbre1 en parcours infixé doit être 10 20 30 40 50" << endl << "  ";
    ptrArbre1->afficheInfixe();

    cout << " Arbre1 en parcours postfixé doit être 50 40 30 20 10" << endl << "  ";
    ptrArbre1->affichePostfixe();

    ArbreNoeudBinaireRecherche<int>* ptrArbre2 = buildArbre2();
    cout << "Arbre2 -> un arbre binaire de recherche : " << endl;
    ptrArbre2->printPretty(2, 0, cout);
    cout << endl << " Arbre2 en parcours préfixé doit être 15 12 14 24 23 35 40 80" << endl << "  ";
    ptrArbre2->affichePrefixe();

    cout << " Arbre2 en parcours infixé doit être 12 14 15 23 24 35 40 80" << endl << "  ";
    ptrArbre2->afficheInfixe();

    cout << " Arbre2 en parcours postfixé doit être 14 12 23 40 35 24 15" << endl << "  ";
    ptrArbre2->affichePostfixe();
}

void testHauteur() {
    cout << endl << "***********************************" << endl;
    cout << "*                                 *" << endl;
    cout << "*        test getHauteur()        *" << endl;
    cout << "*                                 *" << endl;
    cout << "***********************************" << endl << endl;
    ArbreNoeudBinaireRecherche<int>* ptrArbre1 = buildArbreDegenereDroit();
    cout << "Arbre1 -> un arbre binaire de recherche dégénéré : " << endl;
    ptrArbre1->printPretty(2, 0, cout);
    cout << endl << " Hauteur de Arbre1 : " << ptrArbre1->getHauteur() << " ; doit être 5." << endl;

    ArbreNoeudBinaireRecherche<int>* ptrArbre2 = buildArbre2();
    cout << "Arbre2 -> un arbre binaire de recherche : " << endl;
    ptrArbre2->printPretty(2, 0, cout);
    cout << endl << " Hauteur de Arbre2 : " << ptrArbre2->getHauteur() << " ; doit être 5." << endl;
}

void testGetNombreNoeuds() {
    cout << endl << "***********************************" << endl;
    cout << "*                                 *" << endl;
    cout << "*    test getNombreDeNoeuds()     *" << endl;
    cout << "*                                 *" << endl;
    cout << "***********************************" << endl << endl;
    ArbreNoeudBinaireRecherche<int>* ptrArbre1 = buildArbreDegenereDroit();
    cout << "Arbre1 -> un arbre binaire de recherche dégénéré :" << endl;
    ptrArbre1->printPretty(2, 0, cout);
    cout << endl << " Nombre de noeuds de Arbre1 : " << ptrArbre1->getNombreDeNoeuds() << " ; doit être 5." << endl;

    ArbreNoeudBinaireRecherche<int>* ptrArbre2 = buildArbre2();
    cout << "Arbre2 -> un arbre binaire de recherche :" << endl;
    ptrArbre2->printPretty(2, 0, cout);
    cout << endl << " Nombre de noeuds de Arbre2 : " << ptrArbre2->getNombreDeNoeuds() << " ; doit être 9." << endl;
}

void testEstInfoPresente() {
    cout << endl << "***********************************" << endl;
    cout << "*                                 *" << endl;
    cout << "*     test estInfoPresente()      *" << endl;
    cout << "*                                 *" << endl;
    cout << "***********************************" << endl << endl;
    ArbreNoeudBinaireRecherche<int>* ptrArbre3 = buildArbre3();
    cout << "Arbre3 -> un arbre binaire de recherche équilibré :" << endl;
    ptrArbre3->printPretty(2, 0, cout);

    cout << endl << "5 est-il présent ? : " << ptrArbre3->estInfoPresente(5) << " ; devrait être false" << endl;
    cout << "10 est-il présent ? : " << ptrArbre3->estInfoPresente(10) << " ; devrait être true" << endl;
    cout << "15 est-il présent ? : " << ptrArbre3->estInfoPresente(15) << " ; devrait être false" << endl;
    cout << "45 est-il présent ? " << ptrArbre3->estInfoPresente(45) << " ; devrait être false" << endl;
    cout << "50 est-il présent ? " << ptrArbre3->estInfoPresente(50) << " ; devrait être true" << endl;
    cout << "55 est-il présent ? " << ptrArbre3->estInfoPresente(55) << " ; devrait être false" << endl;
    cout << "60 est-il présent ? " << ptrArbre3->estInfoPresente(60) << " ; devrait être true" << endl;
    cout << "65 est-il présent ? " << ptrArbre3->estInfoPresente(65) << " ; devrait être false" << endl;
    cout << "80 est-il présent ? " << ptrArbre3->estInfoPresente(80) << " ; devrait être true" << endl;
    cout << "85 est-il présent ? " << ptrArbre3->estInfoPresente(85) << " ; devrait être false" << endl;
}

void testGetMax() {
    cout << endl << "***********************************" << endl;
    cout << "*                                 *" << endl;
    cout << "*         test getMax()           *" << endl;
    cout << "*                                 *" << endl;
    cout << "***********************************" << endl << endl;
    ArbreNoeudBinaireRecherche<int>* ptrArbre1 = buildArbreDegenereDroit();
    cout << "Arbre1 -> un arbre binaire de recherche dégénéré à droite :" << endl;
    ptrArbre1->printPretty(2, 0, cout);
    cout << endl << " La valeur la plus grande est : " << ptrArbre1->getMax() << " ; devrait rendre 50" << endl << endl;

    ArbreNoeudBinaireRecherche<int>* ptrArbre2 = buildArbreDegenereGauche();
    cout << "Arbre2 -> un arbre binaire de recherche dégénéré à gauche :" << endl;
    ptrArbre2->printPretty(2, 0, cout);
    cout << endl << " La valeur la plus grande est : " << ptrArbre2->getMax() << " ; devrait rendre 50" << endl << endl;

    cout << "Arbre3 un arbre vide : " << endl;
    ArbreNoeudBinaireRecherche<int> ptrArbre3;
    ptrArbre3.printPretty(2, 0, cout);
    cout << endl << "La valeur la plus grande d'un arbre vide est : ";
    try {
        cout << ptrArbre3.getMax() << endl;
    } catch (PrecondViolatedExcep e) {
        cout << endl << "  !!! CA C'EST MAL PASSEE, VOICI POURQUOI ---> " << endl;
        cout << e.what() << endl;
        cout << "  !!! ENFIN ON A QUAND MEME RECUPERER LE COUP !" << endl;
    }
}

int main() {

    testInsertAffiche();
    testHauteur();
    testGetNombreNoeuds();
    testEstInfoPresente();
    testGetMax();
    // testGetMax();   // A DECOMMENTER LORSQUE L'INSERTION MARCHE

    return 0;
} // end main


/*
***********************************
*                                 *
*  test des méthodes d'affichage  *
*                                 *
***********************************

Arbre1 -> un arbre binaire de recherche dégénéré :

                                             10______________________
                                                                     \
                                                                     20__________
                                                                                 \
                                                                                 30____
                                                                                       \
                                                                                       40_
                                                                                          \
                                                                                          50

 Arbre1 en parcours préfixé doit être 10 20 30 40 50
  En parcours préfixé, l'ABO contient : 10 20 30 40 50
 Arbre1 en parcours infixé doit être 10 20 30 40 50
  En parcours infixé, l'ABO contient : 10 20 30 40 50
 Arbre1 en parcours postfixé doit être 50 40 30 20 10
  En parcours postfixé, l'ABO contient : 50 40 30 20 10
Arbre2 -> un arbre binaire de recherche :

                       ______________________15______________________
                      /                                              \
                     12__________                          __________24__________
                                 \                        /                      \
                                 14                  ____23                      35____
                                                    /                                  \
                                                   20                                  40_
                                                                                          \
                                                                                          80

 Arbre2 en parcours préfixé doit être 15 12 14 24 23 35 40 80
  En parcours préfixé, l'ABO contient : 15 12 14 24 23 20 35 40 80
 Arbre2 en parcours infixé doit être 12 14 15 23 24 35 40 80
  En parcours infixé, l'ABO contient : 12 14 15 20 23 24 35 40 80
 Arbre2 en parcours postfixé doit être 14 12 23 40 35 24 15
  En parcours postfixé, l'ABO contient : 14 12 20 23 80 40 35 24 15

***********************************
*                                 *
*        test getHauteur()        *
*                                 *
***********************************

Arbre1 -> un arbre binaire de recherche dégénéré :

                                             10______________________
                                                                     \
                                                                     20__________
                                                                                 \
                                                                                 30____
                                                                                       \
                                                                                       40_
                                                                                          \
                                                                                          50

 Hauteur de Arbre1 : 5 ; doit être 5.
Arbre2 -> un arbre binaire de recherche :

                       ______________________15______________________
                      /                                              \
                     12__________                          __________24__________
                                 \                        /                      \
                                 14                  ____23                      35____
                                                    /                                  \
                                                   20                                  40_
                                                                                          \
                                                                                          80

 Hauteur de Arbre2 : 5 ; doit être 5.

***********************************
*                                 *
*    test getNombreDeNoeuds()     *
*                                 *
***********************************

Arbre1 -> un arbre binaire de recherche dégénéré :

                                             10______________________
                                                                     \
                                                                     20__________
                                                                                 \
                                                                                 30____
                                                                                       \
                                                                                       40_
                                                                                          \
                                                                                          50

 Nombre de noeuds de Arbre1 : 5 ; doit être 5.
Arbre2 -> un arbre binaire de recherche :

                       ______________________15______________________
                      /                                              \
                     12__________                          __________24__________
                                 \                        /                      \
                                 14                  ____23                      35____
                                                    /                                  \
                                                   20                                  40_
                                                                                          \
                                                                                          80

 Nombre de noeuds de Arbre2 : 9 ; doit être 9.

***********************************
*                                 *
*     test estInfoPresente()      *
*                                 *
***********************************

Arbre3 -> un arbre binaire de recherche équilibré :

           __________40__________
          /                      \
     ____20____              ____60____
    /          \            /          \
   10          30          50          70_
                                          \
                                          80

5 est-il présent ? : 0 ; devrait être false
10 est-il présent ? : 1 ; devrait être true
15 est-il présent ? : 0 ; devrait être false
45 est-il présent ? 0 ; devrait être false
50 est-il présent ? 1 ; devrait être true
55 est-il présent ? 0 ; devrait être false
60 est-il présent ? 1 ; devrait être true
65 est-il présent ? 0 ; devrait être false
80 est-il présent ? 1 ; devrait être true
85 est-il présent ? 0 ; devrait être false

***********************************
*                                 *
*         test getMax()           *
*                                 *
***********************************

Arbre1 -> un arbre binaire de recherche dégénéré à droite :

                                             10______________________
                                                                     \
                                                                     20__________
                                                                                 \
                                                                                 30____
                                                                                       \
                                                                                       40_
                                                                                          \
                                                                                          50

 La valeur la plus grande est : 50 ; devrait rendre 50

Arbre2 -> un arbre binaire de recherche dégénéré à gauche :

                       ______________________50
                      /
           __________40
          /
     ____30
    /
  _20
 /
10

 La valeur la plus grande est : 50 ; devrait rendre 50

Arbre3 un arbre vide :



La valeur la plus grande d'un arbre vide est :
  !!! CA C'EST MAL PASSEE, VOICI POURQUOI --->
Precondition Violated Exception: Pas de maximum sur un arbre vide !
  !!! ENFIN ON A QUAND MEME RECUPERER LE COUP !

Process finished with exit code 0
 */