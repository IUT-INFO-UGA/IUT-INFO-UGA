#include "Trajet.h"
#include <iostream>
#include <string>
using namespace std;

const int Trajet::DISTANCEMIN = 1;
const int Trajet::DISTANCEMAX = 2000;

Trajet::Trajet(const string &villeDep, const string &villeArr, int dist)
        : m_villeDepart(villeDep), m_villeArrivee(villeArr), m_distance(dist, DISTANCEMIN, DISTANCEMAX) {
}

const string &Trajet::getVilleDepart() const {
    return this->m_villeDepart;
}

void Trajet::setVilleDepart(const string &villeDep) {
    this->m_villeDepart = villeDep;
}

const string &Trajet::getVilleArrivee() const {
    return this->m_villeArrivee;
}

void Trajet::setVilleArrivee(const string &villeArr) {
    this->m_villeArrivee = villeArr;
}

int Trajet::getDistance() const {
    return m_distance.getVal();
}

std::ostream &operator<<(std::ostream &sortie, const Trajet &trajet) {
    return cout << trajet.getVilleDepart() << " -> " << trajet.getVilleArrivee() << " (" << trajet.getDistance()
                << " km)";
}
