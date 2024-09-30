#ifndef BILLETREDUIT_H
#define BILLETREDUIT_H

#include "Billet.h"
#include "Promotion.h"

class BilletReduit : public Billet {
private:
    const Promotion &promotion;
    public:
    BilletReduit(Trajet& un_trajet, Tarif& un_tarif, const Promotion& promotion);
    float getPrix() const;
    Promotion getPromotion() const;
};
#endif