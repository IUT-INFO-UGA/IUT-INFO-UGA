#include <iostream>
#include "Billet.h"
using namespace std;

Billet::Billet(Trajet* trajet, Tarif* tarif)
{
    this->trajet = trajet;
    this->tarif = tarif;
}

float Billet::getPrix() const
{
    return  tarif->getPrixAuKm()*trajet->getDistance();
}

Tarif& Billet::getTarif() const
{
    return *tarif;
}

Trajet& Billet::getTrajet() const
{
    return *trajet;
}


