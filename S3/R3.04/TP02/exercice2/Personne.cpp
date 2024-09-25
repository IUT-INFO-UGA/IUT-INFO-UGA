#include <string>
#include <iostream>
#include "Personne.h"
using namespace std;

unsigned int Personne::nbInstances = 0;

Personne::Personne(string nom)
: m_nom(nom) {
    nbInstances++; // Un objet Personne a été instancié
}

const std::string & Personne::getNom() const {
    return this->m_nom;
}

void Personne::setNom(const std::string & nom) {
    this->m_nom = nom;
}

Personne::~Personne() {
    nbInstances--; // Un objet Personne va être libéré
}

void Personne::afficheNbInstances() {
    cout << "Nombre Total de Personnes : " << nbInstances << endl;
}

unsigned int Personne::getNbInstances() {
    return nbInstances;
}