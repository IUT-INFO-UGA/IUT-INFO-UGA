
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

ArbreNoeudBinaireRecherche<int>* buildArbre21() {
    ArbreNoeudBinaireRecherche<int>* ptrArbre = new ArbreNoeudBinaireRecherche<int>();
    ptrArbre->insere(24);
    ptrArbre->insere(23);
    ptrArbre->insere(35);
    ptrArbre->insere(40);
    ptrArbre->insere(80);
    ptrArbre->insere(20);
    return ptrArbre;
}

ArbreNoeudBinaireRecherche<int>* buildArbre22() {
    ArbreNoeudBinaireRecherche<int>* ptrArbre = new ArbreNoeudBinaireRecherche<int>();
    ptrArbre->insere(12);
    ptrArbre->insere(14);
    return ptrArbre;
}

ArbreNoeudBinaireRecherche<int>* buildArbre23() {
    ArbreNoeudBinaireRecherche<int>* ptrArbre = new ArbreNoeudBinaireRecherche<int>();
    ptrArbre->insere(12);
    ptrArbre->insere(14);
    ptrArbre->insere(10);
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

// un arbre binaire de recherche pour ancêtre commun le plus bas

ArbreNoeudBinaireRecherche<int>* buildArbreACPB() {
    ArbreNoeudBinaireRecherche<int>* ptrArbre = new ArbreNoeudBinaireRecherche<int>();
    ptrArbre->insere(20);
    ptrArbre->insere(8);
    ptrArbre->insere(4);
    ptrArbre->insere(12);
    ptrArbre->insere(10);
    ptrArbre->insere(14);
    ptrArbre->insere(22);
    return ptrArbre;
}

// arbres pour le pliage

ArbreNoeudBinaireRecherche<int>* buildArbrePliable1() {
    ArbreNoeudBinaireRecherche<int>* ptrArbre = new ArbreNoeudBinaireRecherche<int>();
    ptrArbre->insere(4);
    ptrArbre->insere(2);
    ptrArbre->insere(6);
    ptrArbre->insere(1);
    ptrArbre->insere(3);
    ptrArbre->insere(5);
    ptrArbre->insere(7);
    return ptrArbre;
}

ArbreNoeudBinaireRecherche<int>* buildArbrePliable2() {
    ArbreNoeudBinaireRecherche<int>* ptrArbre = new ArbreNoeudBinaireRecherche<int>();
    ptrArbre->insere(4);
    ptrArbre->insere(2);
    ptrArbre->insere(6);
    ptrArbre->insere(1);
    ptrArbre->insere(7);
    return ptrArbre;
}

ArbreNoeudBinaireRecherche<int>* buildArbreNonPliable1() {
    ArbreNoeudBinaireRecherche<int>* ptrArbre = new ArbreNoeudBinaireRecherche<int>();
    ptrArbre->insere(4);
    ptrArbre->insere(2);
    ptrArbre->insere(6);
    ptrArbre->insere(1);
    ptrArbre->insere(3);
    ptrArbre->insere(7);
    return ptrArbre;
}

ArbreNoeudBinaireRecherche<int>* buildArbreNonPliable2() {
    ArbreNoeudBinaireRecherche<int>* ptrArbre = new ArbreNoeudBinaireRecherche<int>();
    ptrArbre->insere(4);
    ptrArbre->insere(2);
    ptrArbre->insere(6);
    ptrArbre->insere(1);
    ptrArbre->insere(5);
    return ptrArbre;
}

void testeAncetreCommunLePlusBas() {
    cout << endl << "**********************************************" << endl;
    cout << "*                                            *" << endl;
    cout << "*     test getAncetreCommunLePlusBas()       *" << endl;
    cout << "*                                            *" << endl;
    cout << "**********************************************" << endl << endl;
    ArbreNoeudBinaireRecherche<int>* ptrArbre1 = buildArbreACPB();
    cout << "Arbre1 -> un arbre binaire de recherche :" << endl;
    ptrArbre1->printPretty(2, 0, cout);
    cout << endl << " Ancêtre commun le plus bas -> " << endl;
    cout << " - de 10 et 14 : " << ptrArbre1->getAncetreCommunLePlusBas(10, 14) << "  (devrait être 12)" << endl;
    cout << " - de 4 et 14 : " << ptrArbre1->getAncetreCommunLePlusBas(4, 14) << "  (devrait être 8)" << endl;
    cout << " - de 8 et 14 : " << ptrArbre1->getAncetreCommunLePlusBas(8, 14) << "  (devrait être 8)" << endl;
    cout << " - de 4 et 22 : " << ptrArbre1->getAncetreCommunLePlusBas(4, 22) << "  (devrait être 20)" << endl;
}

void testeSousArbre() {
    cout << endl << "*********************************" << endl;
    cout << "*                               *" << endl;
    cout << "*     test aPourSousArbre()     *" << endl;
    cout << "*                               *" << endl;
    cout << "*********************************" << endl << endl;
    ArbreNoeudBinaireRecherche<int>* ptrArbre1 = buildArbre2();
    ArbreNoeudBinaireRecherche<int>* ptrArbreVide = new ArbreNoeudBinaireRecherche<int>();
    cout << "Arbre1 -> un arbre binaire de recherche :" << endl;
    ptrArbre1->printPretty(2, 0, cout);
    cout << "l'arbre vide est-il un sous-arbre de Arbre1 ? : " << ptrArbre1->aPourSousArbre(*ptrArbreVide) << " (devrait être true)" << endl;
    cout << "Arbre1 est-il un sous-arbre de l'arbre vide ? : " << ptrArbreVide->aPourSousArbre(*ptrArbre1) << " (devrait être false)" << endl;
    cout << endl << endl;
    ArbreNoeudBinaireRecherche<int>* ptrArbre11 = buildArbre21();
    cout << "Arbre1 -> un arbre binaire de recherche :" << endl;
    ptrArbre1->printPretty(2, 0, cout);
    cout << "Arbre11 -> un arbre binaire de recherche :" << endl;
    ptrArbre11->printPretty(2, 0, cout);
    cout << "Arbre11 est-il un sous-arbre de Arbre1 ? : " << ptrArbre1->aPourSousArbre(*ptrArbre11) << " (devrait répondre true)" << endl;
    cout << "Arbre1 est-il un sous-arbre de Arbre11 ? : " << ptrArbre11->aPourSousArbre(*ptrArbre1) << " (devrait répondre false)" << endl;
    cout << endl << endl;
    ArbreNoeudBinaireRecherche<int>* ptrArbre12 = buildArbre22();
    cout << "Arbre1 -> un arbre binaire de recherche :" << endl;
    ptrArbre1->printPretty(2, 0, cout);
    cout << "Arbre12 -> un arbre binaire de recherche :" << endl;
    ptrArbre12->printPretty(2, 0, cout);
    cout << "Arbre12 est-il un sous-arbre de Arbre1 ? : " << ptrArbre1->aPourSousArbre(*ptrArbre12) << " (devrait répondre true)" << endl;
    cout << "Arbre1 est-il un sous-arbre de Arbre12 ? : " << ptrArbre12->aPourSousArbre(*ptrArbre1) << " (devrait répondre false)" << endl;
    cout << endl << endl;
    ArbreNoeudBinaireRecherche<int>* ptrArbre13 = buildArbre23();
    cout << "Arbre1 -> un arbre binaire de recherche :" << endl;
    ptrArbre1->printPretty(2, 0, cout);
    cout << "Arbre13 -> un arbre binaire de recherche :" << endl;
    ptrArbre13->printPretty(2, 0, cout);
    cout << "Arbre13 est-il un sous-arbre de Arbre1 ? : " << ptrArbre1->aPourSousArbre(*ptrArbre13) << " (devrait répondre true)" << endl;
    cout << "Arbre1 est-il un sous-arbre de Arbre13 ? : " << ptrArbre13->aPourSousArbre(*ptrArbre1) << " (devrait répondre false)" << endl;
    cout << endl << endl;
}

void testAMemeGeometrieQue() {
    cout << endl << "***********************************" << endl;
    cout << "*                                 *" << endl;
    cout << "*    test aMemeGeometrieQue()     *" << endl;
    cout << "*                                 *" << endl;
    cout << "***********************************" << endl << endl;
    bool succes;
    ArbreNoeudBinaireRecherche<int>* ptrArbreVide = new ArbreNoeudBinaireRecherche<int>();
    cout << "Un arbre binaire de recherche vide :" << endl;
    ptrArbreVide->printPretty(2, 0, cout);
    cout << "a-t-il la même géométrie qu'un autre arbre vide :" << endl;
    ptrArbreVide->printPretty(2, 0, cout);
    cout << "--> Réponse = " << ptrArbreVide->aMemeGeometrieQue(*ptrArbreVide) << " ; doit être true !" << endl << endl;

    ArbreNoeudBinaireRecherche<int>* ptrArbre1 = buildArbre2();
    cout << endl << "Un arbre binaire de recherche vide :" << endl;
    ptrArbreVide->printPretty(2, 0, cout);
    cout << "a-t-il la même géométrie qu'un arbre non vide :" << endl;
    ptrArbre1->printPretty(2, 0, cout);
    cout << endl << "--> Réponse = " << ptrArbreVide->aMemeGeometrieQue(*ptrArbre1) << " ; doit être false !" << endl;

    cout << endl << "Un arbre binaire non vide :" << endl;
    ptrArbre1->printPretty(2, 0, cout);
    cout << endl << "a-t-il la même géométrie qu'un arbre vide :" << endl;
    ptrArbreVide->printPretty(2, 0, cout);
    cout << "--> Réponse = " << ptrArbre1->aMemeGeometrieQue(*ptrArbreVide) << " ; doit être false !" << endl;

    cout << endl << "Un arbre binaire non vide :" << endl;
    ptrArbre1->printPretty(2, 0, cout);
    cout << endl << "a-t-il la même géométrie que lui-même :" << endl;
    ptrArbre1->printPretty(2, 0, cout);
    cout << endl << "--> Réponse = " << ptrArbre1->aMemeGeometrieQue(*ptrArbre1) << " ; doit être false !" << endl;

    ArbreNoeudBinaireRecherche<int>* ptrArbre2 = buildArbre3();
    cout << endl << "Un arbre binaire non vide :" << endl;
    ptrArbre1->printPretty(2, 0, cout);
    cout << endl << "a-t-il la même géométrie qu'un arbre binaire non vide qui n'a pas la même géométrie :" << endl;
    ptrArbre2->printPretty(2, 0, cout);
    cout << endl << "--> Réponse = " << ptrArbre1->aMemeGeometrieQue(*ptrArbre2) << " ; doit être false !" << endl;
}

void testEstPliable() {
    cout << endl << "***********************************" << endl;
    cout << "*                                 *" << endl;
    cout << "*       test estPliable()         *" << endl;
    cout << "*                                 *" << endl;
    cout << "***********************************" << endl;
    ArbreNoeudBinaireRecherche<int>* ptrArbreVide = new ArbreNoeudBinaireRecherche<int>();
    ArbreNoeudBinaireRecherche<int>* ptrArbrePliable1 = buildArbrePliable1();
    ArbreNoeudBinaireRecherche<int>* ptrArbrePliable2 = buildArbrePliable2();
    ArbreNoeudBinaireRecherche<int>* ptrArbreNonPliable1 = buildArbreNonPliable1();
    ArbreNoeudBinaireRecherche<int>* ptrArbreNonPliable2 = buildArbreNonPliable2();

    cout << "l'arbre vide est-il pliable ? : " << ptrArbreVide->estPliable() << " (doit être true)" << endl;
    cout << endl << "l'arbre : " << endl;
    ptrArbrePliable1->printPretty(2, 0, cout);
    cout << endl << " est-il pliable ? : " << ptrArbrePliable1->estPliable() << " (doit être true)" << endl;
    cout << endl << "l'arbre : " << endl;
    ptrArbrePliable2->printPretty(2, 0, cout);
    cout << endl << " est-il pliable ? : " << ptrArbrePliable2->estPliable() << " (doit être true)" << endl;
    cout << endl << "l'arbre : " << endl;
    ptrArbreNonPliable1->printPretty(2, 0, cout);
    cout << endl << " est-il pliable ? : " << ptrArbreNonPliable1->estPliable() << " (doit être false)" << endl;
    cout << endl << "l'arbre : " << endl;
    ptrArbreNonPliable2->printPretty(2, 0, cout);
    cout << endl << " est-il pliable ? : " << ptrArbreNonPliable2->estPliable() << " (doit être false)" << endl;


}

void testSuppression() {
    cout << endl << "***********************************" << endl;
    cout << "*                                 *" << endl;
    cout << "*        test supprime()          *" << endl;
    cout << "*                                 *" << endl;
    cout << "***********************************" << endl << endl;
    ArbreNoeudBinaireRecherche<int>* ptrArbre1 = buildArbreDegenereDroit();
    cout << "Arbre1 -> un arbre binaire de recherche dégénéré :" << endl;
    ptrArbre1->printPretty(2, 0, cout);
    cout << endl << " Hauteur de Arbre1 : " << ptrArbre1->getHauteur() << " ; doit être 5." << endl;
    cout << " Nombre de noeuds de Arbre1 : " << ptrArbre1->getNombreDeNoeuds() << " ; doit être 5." << endl;

    cout << endl << " Suppression de la feuille 50 : ";
    bool succes = ptrArbre1->supprime(50);
    check(succes);
    cout << " Arbre1 est maintenant : ";
    ptrArbre1->printPretty(2, 0, cout);
    cout << endl << " Hauteur de Arbre1 : " << ptrArbre1->getHauteur() << " ; doit être 4." << endl;
    cout << " Nombre de noeuds de Arbre1 : " << ptrArbre1->getNombreDeNoeuds() << " ; doit être 4." << endl;

    cout << endl << " Essai de suppression de 50 (il n'est plus là) : ";
    succes = ptrArbre1->supprime(50);
    check(succes);
    cout << " Arbre1 est maintenant : ";
    ptrArbre1->printPretty(2, 0, cout);
    cout << endl << " Hauteur de Arbre1 : " << ptrArbre1->getHauteur() << " ; doit être 4." << endl;
    cout << " Nombre de noeuds de Arbre1 : " << ptrArbre1->getNombreDeNoeuds() << " ; doit être 4." << endl;

    cout << endl << " Suppression du noeud 20 qui a seulement un fils droit : ";
    succes = ptrArbre1->supprime(20);
    check(succes);
    cout << " Arbre1 est maintenant : ";
    ptrArbre1->printPretty(2, 0, cout);
    cout << endl << " Hauteur de Arbre1 : " << ptrArbre1->getHauteur() << " ; doit être 3." << endl;
    cout << " Nombre de noeuds de Arbre1 : " << ptrArbre1->getNombreDeNoeuds() << " ; doit être 3." << endl;

    cout << endl << " Suppression de la racine 10 (a un sous-arbre droit) : ";
    succes = ptrArbre1->supprime(10);
    check(succes);
    cout << " Arbre1 est maintenant : ";
    ptrArbre1->printPretty(2, 0, cout);
    cout << endl << " Hauteur de Arbre1 : " << ptrArbre1->getHauteur() << " ; doit être 2." << endl;
    cout << " Nombre de noeuds de Arbre1 : " << ptrArbre1->getNombreDeNoeuds() << " ; doit être 2." << endl;

    //===========================
    ArbreNoeudBinaireRecherche<int>* ptrArbre2 = buildArbre2();
    cout << endl << "Arbre2 -> un arbre binaire de recherche équilibré :" << endl;
    ptrArbre2->printPretty(2, 0, cout);
    cout << endl << " Hauteur de Arbre2 : " << ptrArbre2->getHauteur() << " ; doit être 5." << endl;
    cout << " Nombre de noeuds de Arbre2 : " << ptrArbre2->getNombreDeNoeuds() << " ; doit être 9." << endl;

    cout << endl << " Suppression du noeud 40 qui a seulement un fils droit : ";
    succes = ptrArbre2->supprime(40);
    check(succes);
    cout << " Arbre2 est maintenant : ";
    ptrArbre2->printPretty(2, 0, cout);
    cout << endl << " Hauteur de Arbre2 : " << ptrArbre2->getHauteur() << " ; doit être 4." << endl;
    cout << " Nombre de noeuds de Arbre2 : " << ptrArbre2->getNombreDeNoeuds() << " ; doit être 8." << endl;

    cout << endl << " Suppression du noeud 23 qui a seulement un fils gauche : ";
    succes = ptrArbre2->supprime(23);
    check(succes);
    cout << " Arbre2 est maintenant : ";
    ptrArbre2->printPretty(2, 0, cout);
    cout << endl << " Hauteur de Arbre2 : " << ptrArbre2->getHauteur() << " ; doit être 4." << endl;
    cout << " Nombre de noeuds de Arbre2 : " << ptrArbre2->getNombreDeNoeuds() << " ; doit être 5." << endl;

    cout << endl << " Suppression du noeud 24 qui a deux sous-arbres (gauche et droit) -> 35 doit remonter à sa place : ";
    succes = ptrArbre2->supprime(24);
    check(succes);
    cout << " Arbre2 est maintenant : ";
    ptrArbre2->printPretty(2, 0, cout);
    cout << endl << " Hauteur de Arbre2 : " << ptrArbre2->getHauteur() << " ; doit être 3." << endl;
    cout << " Nombre de noeuds de Arbre2 : " << ptrArbre2->getNombreDeNoeuds() << " ; doit être 6." << endl;

    cout << endl << " Suppression de la feuille 14 : ";
    succes = ptrArbre2->supprime(14);
    check(succes);
    cout << " Arbre2 est maintenant : ";
    ptrArbre2->printPretty(2, 0, cout);
    cout << endl << " Arbre2 hauteur : " << ptrArbre2->getHauteur() << " ; doit être 3." << endl;
    cout << " Arbre2 nombre de noeuds : " << ptrArbre2->getNombreDeNoeuds() << " ; doit être 5." << endl;

    cout << endl << " Suppression de la racine 15 qui a deux sous-arbre (gauche et droit) -> 20 doit remonter : ";
    succes = ptrArbre2->supprime(15);
    check(succes);
    cout << " Arbre2 est maintenant : ";
    ptrArbre2->printPretty(2, 0, cout);
    cout << endl << " Hauteur Arbre2 : " << ptrArbre2->getHauteur() << " ; doit être 3." << endl;
    cout << " Nombre de noeuds Arbre2 : " << ptrArbre2->getNombreDeNoeuds() << " ; doit être 4." << endl;
}

void testOperateurAffectationSurcharge() {
    cout << endl << "****************************************" << endl;
    cout << "*                                      *" << endl;
    cout << "* test surcharge opérateur affectation *" << endl;
    cout << "*                                      *" << endl;
    cout << "****************************************" << endl << endl;
    cout << "DÉBUT testeOperateurAffectationSurcharge() " << endl << endl;
    ArbreNoeudBinaireRecherche<int>* ptrArbre1 = buildArbre3();
    cout << "Arbre1 avant copie -> un arbre binaire de recherche équilibré : " << endl;
    ptrArbre1->printPretty(2, 0, cout);

    cout << endl << "Test de l'opérateur d'affectation surchargé (Arbre2 = Arbre1): " << endl;
    cout << " -> Copie de Arbre1 dans Arbre3, on a : " << endl;
    ArbreNoeudBinaireRecherche<int> arbre2 = *ptrArbre1;
    ArbreNoeudBinaireRecherche<int>* ptrArbre2 = &arbre2;

    cout << "Arbre2 copie de arbre1 " << endl;
    ptrArbre2->printPretty(2, 0, cout);

    cout << endl << "Transformation de Arbre2 en supprimant 40" << endl << endl;
    ptrArbre2->supprime(40);
    cout << "Arbre2 modifié : " << endl;
    ptrArbre2->printPretty(2, 0, cout);

    cout << endl << "Arbre1 n'a pas dû être modifié : " << endl;
    ptrArbre1->printPretty(2, 0, cout);
}

int main() {

    testAMemeGeometrieQue();
    testeAncetreCommunLePlusBas();
    testeSousArbre();
    //testEstPliable();

    /*
     * teste des opérations fournies
     */
    //testSuppression();
    //testOperateurAffectationSurcharge();

    return 0;
} // end main


/*
***********************************
*                                 *
*    test aMemeGeometrieQue()     *
*                                 *
***********************************

Un arbre binaire de recherche vide :


a-t-il la même géométrie qu'un autre arbre vide :


--> Réponse = 1 ; doit être true !


Un arbre binaire de recherche vide :


a-t-il la même géométrie qu'un arbre non vide :

                       ______________________15______________________
                      /                                              \
                     12__________                          __________24__________
                                 \                        /                      \
                                 14                  ____23                      35____
                                                    /                                  \
                                                   20                                  40_
                                                                                          \
                                                                                          80

--> Réponse = 0 ; doit être false !

Un arbre binaire non vide :

                       ______________________15______________________
                      /                                              \
                     12__________                          __________24__________
                                 \                        /                      \
                                 14                  ____23                      35____
                                                    /                                  \
                                                   20                                  40_
                                                                                          \
                                                                                          80

a-t-il la même géométrie qu'un arbre vide :


--> Réponse = 0 ; doit être false !

Un arbre binaire non vide :

                       ______________________15______________________
                      /                                              \
                     12__________                          __________24__________
                                 \                        /                      \
                                 14                  ____23                      35____
                                                    /                                  \
                                                   20                                  40_
                                                                                          \
                                                                                          80

a-t-il la même géométrie que lui-même :

                       ______________________15______________________
                      /                                              \
                     12__________                          __________24__________
                                 \                        /                      \
                                 14                  ____23                      35____
                                                    /                                  \
                                                   20                                  40_
                                                                                          \
                                                                                          80

--> Réponse = 1 ; doit être false !

Un arbre binaire non vide :

                       ______________________15______________________
                      /                                              \
                     12__________                          __________24__________
                                 \                        /                      \
                                 14                  ____23                      35____
                                                    /                                  \
                                                   20                                  40_
                                                                                          \
                                                                                          80

a-t-il la même géométrie qu'un arbre binaire non vide qui n'a pas la même géométrie :

           __________40__________
          /                      \
     ____20____              ____60____
    /          \            /          \
   10          30          50          70_
                                          \
                                          80

--> Réponse = 0 ; doit être false !

**********************************************
*                                            *
*     test getAncetreCommunLePlusBas()       *
*                                            *
**********************************************

Arbre1 -> un arbre binaire de recherche :

           __________20__________
          /                      \
     _____8____                  22
    /          \
    4         _12_
             /    \
            10    14

 Ancêtre commun le plus bas ->
 - de 10 et 14 : 12  (devrait être 12)
 - de 4 et 14 : 8  (devrait être 8)
 - de 8 et 14 : 8  (devrait être 8)
 - de 4 et 22 : 20  (devrait être 20)

*********************************
*                               *
*     test aPourSousArbre()     *
*                               *
*********************************

Arbre1 -> un arbre binaire de recherche :

                       ______________________15______________________
                      /                                              \
                     12__________                          __________24__________
                                 \                        /                      \
                                 14                  ____23                      35____
                                                    /                                  \
                                                   20                                  40_
                                                                                          \
                                                                                          80
l'arbre vide est-il un sous-arbre de Arbre1 ? : 1 (devrait être true)
Arbre1 est-il un sous-arbre de l'arbre vide ? : 0 (devrait être false)


Arbre1 -> un arbre binaire de recherche :

                       ______________________15______________________
                      /                                              \
                     12__________                          __________24__________
                                 \                        /                      \
                                 14                  ____23                      35____
                                                    /                                  \
                                                   20                                  40_
                                                                                          \
                                                                                          80
Arbre11 -> un arbre binaire de recherche :

           __________24__________
          /                      \
     ____23                      35____
    /                                  \
   20                                  40_
                                          \
                                          80
Arbre11 est-il un sous-arbre de Arbre1 ? : 1 (devrait répondre true)
Arbre1 est-il un sous-arbre de Arbre11 ? : 0 (devrait répondre false)


Arbre1 -> un arbre binaire de recherche :

                       ______________________15______________________
                      /                                              \
                     12__________                          __________24__________
                                 \                        /                      \
                                 14                  ____23                      35____
                                                    /                                  \
                                                   20                                  40_
                                                                                          \
                                                                                          80
Arbre12 -> un arbre binaire de recherche :

   12_
      \
      14
Arbre12 est-il un sous-arbre de Arbre1 ? : 1 (devrait répondre true)
Arbre1 est-il un sous-arbre de Arbre12 ? : 0 (devrait répondre false)


Arbre1 -> un arbre binaire de recherche :

                       ______________________15______________________
                      /                                              \
                     12__________                          __________24__________
                                 \                        /                      \
                                 14                  ____23                      35____
                                                    /                                  \
                                                   20                                  40_
                                                                                          \
                                                                                          80
Arbre13 -> un arbre binaire de recherche :

  _12_
 /    \
10    14
Arbre13 est-il un sous-arbre de Arbre1 ? : 0 (devrait répondre true)
Arbre1 est-il un sous-arbre de Arbre13 ? : 0 (devrait répondre false)



***********************************
*                                 *
*       test estPliable()         *
*                                 *
***********************************
l'arbre vide est-il pliable ? : 1 (doit être true)

l'arbre :

     _____4____
    /          \
  __2_        __6_
 /    \      /    \
 1     3     5     7

 est-il pliable ? : 1 (doit être true)

l'arbre :

     _____4____
    /          \
  __2           6_
 /                \
 1                 7

 est-il pliable ? : 1 (doit être true)

l'arbre :

     _____4____
    /          \
  __2_          6_
 /    \           \
 1     3           7

 est-il pliable ? : 0 (doit être false)

l'arbre :

     _____4____
    /          \
  __2         __6
 /           /
 1           5

 est-il pliable ? : 0 (doit être false)

***********************************
*                                 *
*        test supprime()          *
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
 Nombre de noeuds de Arbre1 : 5 ; doit être 5.

 Suppression de la feuille 50 :  Opération réussie.
 Arbre1 est maintenant :
                     10__________
                                 \
                                 20____
                                       \
                                       30_
                                          \
                                          40

 Hauteur de Arbre1 : 4 ; doit être 4.
 Nombre de noeuds de Arbre1 : 4 ; doit être 4.

 Essai de suppression de 50 (il n'est plus là) :  Opération impossible.
 Arbre1 est maintenant :
                     10__________
                                 \
                                 20____
                                       \
                                       30_
                                          \
                                          40

 Hauteur de Arbre1 : 4 ; doit être 4.
 Nombre de noeuds de Arbre1 : 4 ; doit être 4.

 Suppression du noeud 20 qui a seulement un fils droit :  Opération réussie.
 Arbre1 est maintenant :
         10____
               \
               30_
                  \
                  40

 Hauteur de Arbre1 : 3 ; doit être 3.
 Nombre de noeuds de Arbre1 : 3 ; doit être 3.

 Suppression de la racine 10 (a un sous-arbre droit) :  Opération réussie.
 Arbre1 est maintenant :
   30_
      \
      40

 Hauteur de Arbre1 : 2 ; doit être 2.
 Nombre de noeuds de Arbre1 : 2 ; doit être 2.

Arbre2 -> un arbre binaire de recherche équilibré :

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
 Nombre de noeuds de Arbre2 : 9 ; doit être 9.

 Suppression du noeud 40 qui a seulement un fils droit :  Opération réussie.
 Arbre2 est maintenant :
           __________15__________
          /                      \
         12____              ____24____
               \            /          \
               14         _23          35_
                         /                \
                        20                80

 Hauteur de Arbre2 : 4 ; doit être 4.
 Nombre de noeuds de Arbre2 : 8 ; doit être 8.

 Suppression du noeud 23 qui a seulement un fils gauche :  Opération réussie.
 Arbre2 est maintenant :
           __________15__________
          /                      \
         12____              ____24____
               \            /          \
               14          20          35_
                                          \
                                          80

 Hauteur de Arbre2 : 4 ; doit être 4.
 Nombre de noeuds de Arbre2 : 7 ; doit être 5.

 Suppression du noeud 24 qui a deux sous-arbres (gauche et droit) -> 35 doit remonter à sa place :  Opération réussie.
 Arbre2 est maintenant :
     ____15____
    /          \
   12_        _35_
      \      /    \
      14    20    80

 Hauteur de Arbre2 : 3 ; doit être 3.
 Nombre de noeuds de Arbre2 : 6 ; doit être 6.

 Suppression de la feuille 14 :  Opération réussie.
 Arbre2 est maintenant :
     ____15____
    /          \
   12         _35_
             /    \
            20    80

 Arbre2 hauteur : 3 ; doit être 3.
 Arbre2 nombre de noeuds : 5 ; doit être 5.

 Suppression de la racine 15 qui a deux sous-arbre (gauche et droit) -> 20 doit remonter :  Opération réussie.
 Arbre2 est maintenant :
     ____20____
    /          \
   12          35_
                  \
                  80

 Hauteur Arbre2 : 3 ; doit être 3.
 Nombre de noeuds Arbre2 : 4 ; doit être 4.

****************************************
*                                      *
* test surcharge opérateur affectation *
*                                      *
****************************************

DÉBUT testeOperateurAffectationSurcharge()

Arbre1 avant copie -> un arbre binaire de recherche équilibré :

           __________40__________
          /                      \
     ____20____              ____60____
    /          \            /          \
   10          30          50          70_
                                          \
                                          80

Test de l'opérateur d'affectation surchargé (Arbre2 = Arbre1):
 -> Copie de Arbre1 dans Arbre3, on a :
Arbre2 copie de arbre1

           __________40__________
          /                      \
     ____20____              ____60____
    /          \            /          \
   10          30          50          70_
                                          \
                                          80

Transformation de Arbre2 en supprimant 40

Arbre2 modifié :

           __________50__________
          /                      \
     ____20____                  60____
    /          \                       \
   10          30                      70_
                                          \
                                          80

Arbre1 n'a pas dû être modifié :

           __________40__________
          /                      \
     ____20____              ____60____
    /          \            /          \
   10          30          50          70_
                                          \
                                          80

Process finished with exit code 0
 */