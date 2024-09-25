#include "Promotion.h"
#include <iostream>
#include <string>
using namespace std;

const float Promotion::TAUXMIN = 0.01;
const float Promotion::TAUXMAX = 0.99;

Promotion::Promotion(const string &unLibelle, float unTaux)
        : m_libelle(unLibelle), m_tauxReduction(unTaux, TAUXMIN, TAUXMAX) {
}

const string &Promotion::getLibelle() const {
    return this->m_libelle;
}

void Promotion::setLibelle(const string &libelle) {
    this->m_libelle = libelle;
}

float Promotion::calculePrixReduit(float prix) const {
    return (1.0 - m_tauxReduction) * prix;
}

std::ostream &operator<<(std::ostream &sortie, const Promotion &promotion) {
    return sortie << "Promotion " << promotion.getLibelle() << " (-" << promotion.m_tauxReduction * 100.0f << " %) ";
}
