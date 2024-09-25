#ifndef PROMOTION_H
#define PROMOTION_H

#include <iostream>
#include <iomanip>
#include <string>

#include "ObjetContraint.h"

class Promotion {
public:
    Promotion(const std::string &unLibelle, float unTaux);
    const std::string &getLibelle() const;
    void setLibelle(const std::string &libelle);
    float calculePrixReduit(float prix) const;
    // sortie
    friend std::ostream &operator<<(std::ostream &sortie, const Promotion &promotion);

private:
    std::string m_libelle;
    ObjetContraint<float> m_tauxReduction;
    static const float TAUXMIN;
    static const float TAUXMAX;
};

#endif