#include <iostream>
#include "BilletReduit.h"
using namespace std;

BilletReduit::BilletReduit(Trajet& un_trajet, Tarif& un_tarif, const Promotion& promotion):
    Billet(&un_trajet, &un_tarif), promotion(promotion)
{
}

float BilletReduit::getPrix() const
{
    return (promotion.calculePrixReduit(Billet::getPrix()));
}

Promotion BilletReduit::getPromotion() const
{
    return promotion;
}