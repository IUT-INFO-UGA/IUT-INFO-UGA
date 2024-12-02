#include <iostream>
#include <string>
#include "../PileCellules.h"

using namespace std;

/**
 * Une procédure modèle qui affiche une pile de n'importe quel type d'éléments
 * ATTENTION il faut que les éléments puissent s'afficher sur cout
 *            -> la classe T doit avoir pour ami l'opérateur de flux <<
 * 
 * @param unePile
 */
template<typename T>
void affichePile(PileCellules<T>& unePile) {
    // dupliquer la pile pour faire un parcours destructif (depile) sur celle-ci
    PileCellules<T>* pileTemporaire = new PileCellules<T>(unePile);
    cout << "En partant du sommet pile contient -> ";
    while (!pileTemporaire->estVide()) {
        cout << pileTemporaire->consulteSommet() << " ";
        pileTemporaire->depile();
    }
    cout << endl;
} // end afficheListe

void testEmpile() {
    PileCellules<string> maPile;
    cout << "DEBUT testEmpile()" << endl << endl;
    cout << "  Liste videRec ? : " << maPile.estVide() << " devrait répondre vrai (1) !" << endl << endl;
    try {
        cout << "  empile zéro --> ";
        maPile.empile("zero");
        affichePile(maPile);
        cout << "   - le sommet contient : " << maPile.consulteSommet() << endl;
        cout << "  empile un --> ";
        maPile.empile("un");
        affichePile(maPile);
        cout << "   - le sommet contient : " << maPile.consulteSommet() << endl;
        cout << "  empile deux --> ";
        maPile.empile("deux");
        affichePile(maPile);
        cout << "   - le sommet contient : " << maPile.consulteSommet() << endl;
        cout << "  empile trois --> ";
        maPile.empile("trois");
        affichePile(maPile);
        cout << "   - le sommet contient : " << maPile.consulteSommet() << endl;
        cout << "  empile quatre --> ";
        maPile.empile("quatre");
        affichePile(maPile);
        cout << "   - le sommet contient : " << maPile.consulteSommet() << endl;
        cout << "  empile cinq --> ";
        maPile.empile("cinq");
        affichePile(maPile);
        cout << "   - le sommet contient : " << maPile.consulteSommet() << endl;
        cout << "  Liste vide ? : " << maPile.estVide() << " devrait répondre faux (0) !" << endl;
    } catch (PrecondVioleeExcep& e) {
        cout << "  !!! CA C'EST MAL PASSEE, VOICI POURQUOI ---> " << endl;
        cout << e.what() << endl;
        cout << "  !!! ENFIN ON A QUAND MEME RECUPERER LE COUP !" << endl;
    }
    cout << endl << "FIN testEmpile()" << endl << endl;
}

void testDepile() {
    cout << "DEBUT testDepile()" << endl << endl;
    PileCellules<string> maPile;
    cout << "  Remplissage de la liste --> ";
    maPile.empile("zero");
    maPile.empile("un");
    maPile.empile("deux");
    maPile.empile("trois");
    maPile.empile("quatre");
    maPile.empile("cinq");
    affichePile(maPile);
    try {
        cout << endl << "  3 consulteSommet() et depile()" << endl;
        cout << "   ma pile actuelle --> ";
        affichePile(maPile);
        cout << "  sommet actuel : " << maPile.consulteSommet() << endl;
        maPile.depile();
        cout << "   ma pile actuelle --> ";
        affichePile(maPile);
        cout << "  sommet actuel : " << maPile.consulteSommet() << endl;
        maPile.depile();
        cout << "   ma pile actuelle --> ";
        affichePile(maPile);
        cout << "  sommet actuel : " << maPile.consulteSommet() << endl;
        maPile.depile();
        cout << "   ma pile actuelle --> ";
        affichePile(maPile);
        cout << "  sommet actuel : " << maPile.consulteSommet() << endl;
    } catch (PrecondVioleeExcep& e) {
        cout << "  !!! CA C'EST MAL PASSEE, VOICI POURQUOI ---> " << endl;
        cout << e.what() << endl;
        cout << "  !!! ENFIN ON A QUAND MEME RECUPERER LE COUP !" << endl;
    }

    cout << endl << "FIN testDepile()" << endl << endl;
}

void testBorneDepile() {
    cout << "DEBUT testBorneDepile()" << endl << endl;
    PileCellules<string> maPile;
    cout << "  Remplissage de la liste --> ";
    maPile.empile("zero");
    maPile.empile("un");
    maPile.empile("deux");
    maPile.empile("trois");
    maPile.empile("quatre");
    maPile.empile("cinq");
    cout << "  ma pile actuelle -> ";
    affichePile(maPile);
    try {
        // itération infinie de depile() ; dans la vraie vie il faut bien sûr éviter de faire cela
        while (true) {
            maPile.depile();
            cout << "  ma pile actuelle -> ";
            affichePile(maPile);
        }
    } catch (PrecondVioleeExcep& e) {
        cout << "  !!! CA C'EST MAL PASSEE, VOICI POURQUOI ---> " << endl;
        cout << e.what() << endl;
        cout << "  !!! ENFIN ON A QUAND MEME RECUPERER LE COUP !" << endl;
    }
    cout << "  Liste videRec ? : " << maPile.estVide() << " devrait répondre vrai (1) !" << endl << endl;
    cout << "  tentative de consulation du sommet sur une liste videRec" << endl << endl;
    try {
        // tentative 
        maPile.consulteSommet();
    } catch (PrecondVioleeExcep& e) {
        cout << "  !!! CA C'EST MAL PASSEE, VOICI POURQUOI ---> " << endl;
        cout << e.what() << endl;
        cout << "  !!! ENFIN ON A QUAND MEME RECUPERER LE COUP !" << endl;
    }

    cout << endl << "FIN testBorneDepile()" << endl << endl;
}

void testEmpileSansFin() {
    // itération infinie d'appels à empile())
    cout << "DEBUT testBorneDepile()" << endl << endl;

    PileCellules<int> maPile;

    cout << "  ma pile acuelle -> ";
    affichePile(maPile);
    // itération infinie de depile() ; dans la vraie vie il faut bien sûr éviter dde faire cela
    unsigned long long int i = 0;
    while (true) {
        cout << i << endl;
        maPile.empile(i);
        i++;
    }
    cout << endl << "FIN testBorneDepile()" << endl << endl;
}

int main() {
    //testEmpile();
    //testDepile();
    //testBorneDepile();
    // à utiliser une fois !!
    //testEmpileSansFin();
    return 0;
} // end main

/*
 DEBUT testEmpile()

  Liste videRec ? : 1 devrait répondre vrai (1) !

  empile zéro --> En partant du sommet pile contient -> zero
   - le sommet contient : zero
  empile un --> En partant du sommet pile contient -> un zero
   - le sommet contient : un
  empile deux --> En partant du sommet pile contient -> deux un zero
   - le sommet contient : deux
  empile trois --> En partant du sommet pile contient -> trois deux un zero
   - le sommet contient : trois
  empile quatre --> En partant du sommet pile contient -> quatre trois deux un zero
   - le sommet contient : quatre
  empile cinq --> En partant du sommet pile contient -> cinq quatre trois deux un zero
   - le sommet contient : cinq
  Liste videRec ? : 0 devrait répondre faux (0) !

FIN testEmpile()

DEBUT testDepile()

  Remplissage de la liste --> En partant du sommet pile contient -> cinq quatre trois deux un zero

  3 consulteSommet() et depile()
   ma pile actuelle --> En partant du sommet pile contient -> cinq quatre trois deux un zero
  sommet actuel : cinq
   ma pile actuelle --> En partant du sommet pile contient -> quatre trois deux un zero
  sommet actuel : quatre
   ma pile actuelle --> En partant du sommet pile contient -> trois deux un zero
  sommet actuel : trois
   ma pile actuelle --> En partant du sommet pile contient -> deux un zero
  sommet actuel : deux

FIN testDepile()

DEBUT testBorneDepile()

  Remplissage de la liste -->   ma pile actuelle -> En partant du sommet pile contient -> cinq quatre trois deux un zero
  ma pile actuelle -> En partant du sommet pile contient -> quatre trois deux un zero
  ma pile actuelle -> En partant du sommet pile contient -> trois deux un zero
  ma pile actuelle -> En partant du sommet pile contient -> deux un zero
  ma pile actuelle -> En partant du sommet pile contient -> un zero
  ma pile actuelle -> En partant du sommet pile contient -> zero
  ma pile actuelle -> En partant du sommet pile contient ->
  !!! CA C'EST MAL PASSEE, VOICI POURQUOI --->
Exception pour précondition violée : méthode depile() appelée sur une pile videRec !
  !!! ENFIN ON A QUAND MEME RECUPERER LE COUP !
  Liste videRec ? : 1 devrait répondre vrai (1) !

  tentative de consulation du sommet sur une liste videRec

  !!! CA C'EST MAL PASSEE, VOICI POURQUOI ---> 
Exception pour précondition violée : méthode consulteSommet() appelée sur une pile videRec !
  !!! ENFIN ON A QUAND MEME RECUPERER LE COUP !

FIN testBorneDepile()

 */