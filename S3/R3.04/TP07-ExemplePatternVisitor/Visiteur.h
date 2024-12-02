#ifndef VISITEUR_H
#define VISITEUR_H
#include "Composite.h"

// Créer une classe abstraite Visiteur avec une méthode visite() pour chaque type d'élément du composite

class Visiteur {
public:
    virtual void visite(const Fichier &e) const = 0;
    virtual void visite(const Repertoire &e) const = 0;
};

// Créer une classe dérivée de Visiteur pour chaque opération à réaliser sur les éléments du composite

class Operation1 : public Visiteur {
    void visite(const Fichier &e) const override;
    void visite(const Repertoire &e) const override;
};

class Operation2 : public Visiteur {
    void visite(const Fichier &e) const override;
    void visite(const Repertoire &e) const override;
};

#endif /* VISITEUR_H */