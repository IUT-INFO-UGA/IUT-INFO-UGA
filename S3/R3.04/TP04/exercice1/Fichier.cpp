#include "Fichier.h"

Fichier::Fichier(const char* nom, int size, const char* date, const Usager& proprietaire): Element(&proprietaire, nom), m_size(size), m_nom(nom), m_date(date) {}

int Fichier::getTaille()const
{
    return m_size;
}

const std::string& Fichier::getDateModification() const
{
    return m_date;
}

