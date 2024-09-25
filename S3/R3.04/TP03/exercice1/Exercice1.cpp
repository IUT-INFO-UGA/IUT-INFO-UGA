#include "AttributsVisage.h"
#include "Visage.h"
#include <iostream>
using namespace std;

const Ethnie BDF("Belle de Fontenay"); // Allocation statique d'une ethnie de patate à chair ferme

int main(int argc, char** argv) {
    Visage misterPatate(7, BDF); // Nez de 7cm, variété "Belle de Fontenay"
    misterPatate.setChapeau(Chapeau(100)); // Chapeau de 100 grammes
    misterPatate.addBijou(Bijou(10)); // Bijou 10€
    misterPatate.addBijou(Bijou(20)); // Bijou 20€
    misterPatate.addBijou(Bijou(100)); // Bijou 100€
    misterPatate.addBouton(1); // Bouton 1cm
    misterPatate.addBouton(2); // Bouton 2cm
    cout << "misterPatate original : " << endl
            << "======================= " << endl;
    cout << misterPatate << endl;
    // Test du constructeur par Recopie
    Visage misterPatateRecopie = Visage(misterPatate); // Const. Visage par recopie
    misterPatateRecopie.setMoustache(10);
    cout << "misterPatate original (doit être inchangé) : " << endl
            << "============================================ " << endl;
    cout << misterPatate << endl;
    cout << "misterPatateRecopie (doit avoir une moustache de 10) : " << endl
            << "==================================================== " << endl;
    cout << misterPatateRecopie << endl;
    // Test de l'opérateur égal
    Visage misterPatateEgal(7, BDF);
    misterPatateEgal=misterPatate; // operateur egal de Visage
    misterPatateEgal.setMoustache(12);
    cout << "misterPatate original (doit être inchangé) : " << endl
            << "============================================ " << endl;
    cout << misterPatate << endl;
    cout << "misterPatateEgal (doit avoir une moustache de 12) : " << endl
            << "==================================================== " << endl;
    cout << misterPatateEgal << endl;
    return 0;
}

// Résultat Attendu :
//misterPatate original :
//=======================
//Attributs du Visage :
//- Ethnie de type Belle de Fontenay
//- Nez mesurant 7 cm
//- pas de moustache
//- Chapeau pesant 100 gramme(s)
//- Un bouton mesurant 1 cm
//- Un bouton mesurant 2 cm
//- Un bijou coutant 10 €
//- Un bijou coutant 20 €
//- Un bijou coutant 100 €
//
//misterPatate original (doit être inchangé) :
//============================================
//Attributs du Visage :
//- Ethnie de type Belle de Fontenay
//- Nez mesurant 7 cm
//- pas de moustache
//- Chapeau pesant 100 gramme(s)
//- Un bouton mesurant 1 cm
//- Un bouton mesurant 2 cm
//- Un bijou coutant 10 €
//- Un bijou coutant 20 €
//- Un bijou coutant 100 €
//
//misterPatateRecopie (doit avoir une moustache de 10) :
//====================================================
//Attributs du Visage :
//- Ethnie de type Belle de Fontenay
//- Nez mesurant 7 cm
//- Moustache mesurant 10 cm
//- Chapeau pesant 100 gramme(s)
//- Un bouton mesurant 1 cm
//- Un bouton mesurant 2 cm
//- Un bijou coutant 10 €
//- Un bijou coutant 20 €
//- Un bijou coutant 100 €
//
//misterPatate original (doit être inchangé) :
//============================================
//Attributs du Visage :
//- Ethnie de type Belle de Fontenay
//- Nez mesurant 7 cm
//- pas de moustache
//- Chapeau pesant 100 gramme(s)
//- Un bouton mesurant 1 cm
//- Un bouton mesurant 2 cm
//- Un bijou coutant 10 €
//- Un bijou coutant 20 €
//- Un bijou coutant 100 €
//
//misterPatateEgal (doit avoir une moustache de 12) :
//====================================================
//Attributs du Visage :
//- Ethnie de type Belle de Fontenay
//- Nez mesurant 7 cm
//- Moustache mesurant 12 cm
//- Chapeau pesant 100 gramme(s)
//- Un bouton mesurant 1 cm
//- Un bouton mesurant 2 cm
//- Un bijou coutant 10 €
//- Un bijou coutant 20 €
//- Un bijou coutant 100 €