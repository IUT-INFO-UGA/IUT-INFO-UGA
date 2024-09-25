#include "Tarif.h"
#include <iostream>
#include <string>
using namespace std;

const float Tarif::PRIXMIN = 0.01;
const float Tarif::PRIXMAX = 10.0;

Tarif::Tarif(const string &unLibelle, float unPrixKilo)
        : m_libelle(unLibelle), m_prixAuKm(unPrixKilo, PRIXMIN, PRIXMAX) {
}

const string &Tarif::getLibelle() const {
    return this->m_libelle;
}

void Tarif::setLibelle(const string &libelle) {
    this->m_libelle = libelle;
}

float Tarif::getPrixAuKm() const {
    return m_prixAuKm.getVal();
}

std::ostream &operator<<(std::ostream &sortie, const Tarif &tarif) {
    return sortie << tarif.getLibelle() << " (" << tarif.getPrixAuKm() << " €/km) ";
}
