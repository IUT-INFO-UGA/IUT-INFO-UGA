#ifndef FICHIER_H
#define FICHIER_H
#include "Element.h"
#include "Usager.h"

class Fichier: public Element {

private:
    const std::string m_nom;
    const int m_size;
    std::string m_date;
    public:
    Fichier(const char* nom, int size, const char* date, const Usager& proprietaire);
    int getTaille() const;
    const std::string& getDateModification() const;

};

#endif /* FICHIER_H */

