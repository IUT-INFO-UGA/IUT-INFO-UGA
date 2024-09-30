#ifndef BILLET_H
#define BILLET_H

#include <iostream>
#include <iomanip>

#include "Trajet.h"
#include "Tarif.h"

class Billet {
private:
    Trajet* trajet;
    Tarif* tarif;
    public:
    Billet(Trajet* trajet, Tarif* tarif);
    Trajet &getTrajet() const;
    Tarif &getTarif() const;
    float getPrix() const;
};
#endif