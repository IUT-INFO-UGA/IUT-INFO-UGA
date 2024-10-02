#include "Repertoire.h"

Repertoire::Repertoire(std::string name, Usager usager): Element(&usager, name), name(name), m_usager(&usager)
{
}

int Repertoire::getTaille() const
{
    return 4;
}

void Repertoire::ajouter(Element* element)
{

}

