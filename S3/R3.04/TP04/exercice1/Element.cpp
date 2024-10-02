#include "Element.h"

Element::Element(const Usager* proprietaure, const std::string nom): m_Propriétaire(proprietaure), m_Nom(nom){}

void Element::setNom(const std::string& nom)
{
    this->m_Nom = nom;
}

const std::string& Element::getNom() const
{
    return m_Nom;
}

const Usager* Element::getPropriétaire() const
{
    return m_Propriétaire;
}

void Element::setPropriétaire(const Usager* propriétaire)
{
    this->m_Propriétaire = propriétaire;
}