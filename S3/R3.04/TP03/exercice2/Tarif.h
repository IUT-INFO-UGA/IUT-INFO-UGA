#ifndef TARIF_H
#define TARIF_H

#include <iostream>
#include <iomanip>
#include <string>

#include "ObjetContraint.h"

class Tarif {
public:
    Tarif(const std::string & unLibelle, float unPrixKilo);
    const std::string & getLibelle() const;
    void setLibelle(const std::string & libelle);
    float getPrixAuKm() const;
    // sortie
    friend std::ostream & operator<<(std::ostream & sortie, const Tarif & tarif);
private:
    std::string m_libelle;
    ObjetContraint<float> m_prixAuKm;
    static const float PRIXMIN;
    static const float PRIXMAX;
};

#endif