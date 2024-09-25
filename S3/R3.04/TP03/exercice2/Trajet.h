#ifndef TRAJET_H
#define TRAJET_H

#include <iostream>
#include <iomanip>
#include <string>

#include "ObjetContraint.h"

class Trajet {
public:
    Trajet(const std::string & villeDep, const std::string & villeArr, int dist);
    const std::string & getVilleDepart() const;
    void setVilleDepart(const std::string & villeDep);
    const std::string & getVilleArrivee() const;
    void setVilleArrivee(const std::string & villeArri);
    int getDistance() const;
    // sortie
    friend std::ostream & operator<<(std::ostream & sortie, const Trajet & trajet);
private:
    std::string m_villeDepart;
    std::string m_villeArrivee;
    ObjetContraint<int> m_distance;
    // Constantes de classe
    static const int DISTANCEMIN;
    static const int DISTANCEMAX;
};

#endif