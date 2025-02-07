
#include <iostream>
#include "CellInt.h"
#include "ListeInt.h"

using namespace std;

ListeInt listeVide() {
    ListeInt maListe;
    return maListe;
}

ListeInt listeAvec0EntiersPairs() {
    ListeInt maListe;
    maListe.insereTete(23);
    maListe.insereTete(21);
    maListe.insereTete(5);
    maListe.insereTete(15);
    maListe.insereTete(13);
    maListe.insereTete(7);
    maListe.insereTete(49);
    return maListe;
}

ListeInt listeAvec1EntiersPairs() {
    ListeInt maListe;
    maListe.insereTete(23);
    maListe.insereTete(21);
    maListe.insereTete(5);
    maListe.insereTete(12);
    maListe.insereTete(13);
    maListe.insereTete(7);
    maListe.insereTete(57);
    return maListe;
}

ListeInt listeAvec3EntiersPairs() {
    ListeInt maListe;
    maListe.insereTete(23);
    maListe.insereTete(21);
    maListe.insereTete(6);
    maListe.insereTete(12);
    maListe.insereTete(13);
    maListe.insereTete(7);
    maListe.insereTete(2);
    return maListe;
}

ListeInt listeAlternee1() {
    ListeInt maListe;
    maListe.insereTete(2);
    return maListe;
}

ListeInt listeAlternee2() {
    ListeInt maListe;
    maListe.insereTete(23);
    return maListe;
}

ListeInt listeAlternee3() {
    ListeInt maListe;
    maListe.insereTete(2);
    maListe.insereTete(21);
    maListe.insereTete(6);
    maListe.insereTete(15);
    maListe.insereTete(12);
    maListe.insereTete(7);
    maListe.insereTete(6);
    return maListe;
}

ListeInt listeAlternee4() {
    ListeInt maListe;
    maListe.insereTete(66);
    maListe.insereTete(63);
    maListe.insereTete(12);
    maListe.insereTete(33);
    maListe.insereTete(18);
    maListe.insereTete(9);
    return maListe;
}

ListeInt listeNonAlternee1() {
    ListeInt maListe;
    maListe.insereTete(21);
    maListe.insereTete(33);
    return maListe;
}

ListeInt listeNonAlternee2() {
    ListeInt maListe;
    maListe.insereTete(21);
    maListe.insereTete(6);
    maListe.insereTete(15);
    maListe.insereTete(12);
    maListe.insereTete(8);
    maListe.insereTete(57);
    return maListe;
}

void testNombreEntiersPairs() {
    cout << "\n***********************************************************" << endl;
    cout << "**                                                       **" << endl;
    cout << "**              NOMBRE D'ENTIERS PAIRS                   **" << endl;
    cout << "**                                                       **" << endl;
    cout << "***********************************************************\n" << endl;
    ListeInt laListeVide = listeVide();
    ListeInt laListeAvec0EntiersPairs = listeAvec0EntiersPairs();
    ListeInt laListeAvec1EntiersPairs = listeAvec1EntiersPairs();
    ListeInt laListeAvec3EntiersPairs = listeAvec3EntiersPairs();

    cout << "la liste => vide contient : " << laListeVide.nbPairsRec() << " entiers pairs (devrait être 0)" << endl;
    cout << "\nla liste => ";
    laListeAvec0EntiersPairs.afficheGD();
    cout << " contient : " << laListeAvec0EntiersPairs.nbPairsRec() << " entiers pairs (devrait être 0)" << endl;
    cout << "\nla liste => ";
    laListeAvec1EntiersPairs.afficheGD();
    cout << " contient : " << laListeAvec1EntiersPairs.nbPairsRec() << " entiers pairs (devrait être 1)" << endl;
    cout << "\nla liste => ";
    laListeAvec3EntiersPairs.afficheGD();
    cout << " contient : " << laListeAvec3EntiersPairs.nbPairsRec() << " entiers pairs (devrait être 3)" << endl;
}

void testEstAlternee() {
    cout << "\n***********************************************************" << endl;
    cout << "**                                                       **" << endl;
    cout << "**             UNE LISTE EST-ELLE ALTERNÉE               **" << endl;
    cout << "**                                                       **" << endl;
    cout << "***********************************************************\n" << endl;
    ListeInt laListeVide = listeVide();
    ListeInt laListeAlternee1 = listeAlternee1();
    ListeInt laListeAlternee2 = listeAlternee2();
    ListeInt laListeAlternee3 = listeAlternee3();
    ListeInt laListeAlternee4 = listeAlternee4();
    ListeInt laListeNonAlternee1 = listeNonAlternee1();
    ListeInt laListeNonAlternee2 = listeNonAlternee2();

    cout << "la liste => vide est-elle alternée ? : " << laListeVide.estAlterneeRec() << " (devrait être 1 [true])" << endl;
    cout << "\nla liste => ";
    laListeAlternee1.afficheGD();
    cout << " est-elle alternée ? : " << laListeAlternee1.estAlterneeRec() << " (devrait être 1 [true])" << endl;
    cout << "\nla liste => ";
    laListeAlternee2.afficheGD();
    cout << " est-elle alternée ? : " << laListeAlternee2.estAlterneeRec() << " (devrait être 1 [true])" << endl;
    cout << "\nla liste => ";
    laListeAlternee3.afficheGD();
    cout << " est-elle alternée ? : " << laListeAlternee3.estAlterneeRec() << " (devrait être 1 [true])" << endl;
    cout << "\nla liste => ";
    laListeAlternee4.afficheGD();
    cout << " est-elle alternée ? : " << laListeAlternee4.estAlterneeRec() << " (devrait être 1 [true])" << endl;
    cout << "\nla liste => ";
    laListeNonAlternee1.afficheGD();
    cout << " est-elle alternée ? : " << laListeNonAlternee1.estAlterneeRec() << " (devrait être 0 [false])" << endl;
    cout << "\nla liste => ";
    laListeNonAlternee2.afficheGD();
    cout << " est-elle alternée ? : " << laListeNonAlternee2.estAlterneeRec() << " (devrait être 0 [false])" << endl;
}



int main() {
    testNombreEntiersPairs();
    testEstAlternee();

    return 0;
}

// Trace Attendue
/*
 ***********************************************************
**                                                       **
**              NOMBRE D'ENTIERS PAIRS                   **
**                                                       **
***********************************************************

la liste => vide contient : 0 entiers pairs (devrait être 0)

la liste => 49 -> 7 -> 13 -> 15 -> 5 -> 21 -> 23 contient : 0 entiers pairs (devrait être 0)

la liste => 57 -> 7 -> 13 -> 12 -> 5 -> 21 -> 23 contient : 1 entiers pairs (devrait être 1)

la liste => 2 -> 7 -> 13 -> 12 -> 6 -> 21 -> 23 contient : 3 entiers pairs (devrait être 3)

***********************************************************
**                                                       **
**             UNE LISTE EST-ELLE ALTERNÉE               **
**                                                       **
***********************************************************

la liste => vide est-elle alternée ? : 1 (devrait être 1 [true])

la liste => 2 est-elle alternée ? : 1 (devrait être 1 [true])

la liste => 23 est-elle alternée ? : 1 (devrait être 1 [true])

la liste => 6 -> 7 -> 12 -> 15 -> 6 -> 21 -> 2 est-elle alternée ? : 1 (devrait être 1 [true])

la liste => 9 -> 18 -> 33 -> 12 -> 63 -> 66 est-elle alternée ? : 1 (devrait être 1 [true])

la liste => 33 -> 21 est-elle alternée ? : 0 (devrait être 0 [false])

la liste => 57 -> 8 -> 12 -> 15 -> 6 -> 21 est-elle alternée ? : 0 (devrait être 0 [false])

 */