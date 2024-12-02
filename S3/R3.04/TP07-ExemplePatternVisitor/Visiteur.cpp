#include "Visiteur.h"
#include <iostream>
using namespace std;

// On code ici le comportement de chaque opération pour chaque type d'élément 

void Operation1::visite(const Fichier &e) const { // Operation 1 sur un Fichier
    cout << "Opération 1 réalisée sur " << e.nomFichier() << endl;
}

void Operation1::visite(const Repertoire &e) const { // Operation 1 sur un Répertoire
    cout << "Opération 1 réalisée sur " << e.nomRepertoire() << endl;
}

void Operation2::visite(const Fichier &e) const { // Operation 2 sur un Fichier
    cout << "Opération 2 réalisée sur " << e.nomFichier() << endl;
}

void Operation2::visite(const Repertoire &e) const { // Operation 2 sur un Répertoire
    cout << "Opération 2 réalisée sur " << e.nomRepertoire() << endl;
}