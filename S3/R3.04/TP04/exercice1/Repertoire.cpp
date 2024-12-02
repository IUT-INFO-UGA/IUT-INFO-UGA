#include "Repertoire.h"

Repertoire::Repertoire(std::string name, Usager& usager): Element(&usager, name), name(name), m_usager(&usager)
{
}

int Repertoire::getTaille() const
{
    return 4;
}

void Repertoire::ajouter(Element* element)
{
    m_elements.push_back(element);
}

const std::string& Repertoire::getDateModification() const
{
    if(this->m_elements.empty())
        return std::string("1970-01-01");
    if(this->m_elements.size() == 1)
        return m_elements.front()->getDateModification();
    std::string max = m_elements.front()->getDateModification();
    for (auto m_element : this->m_elements)
    {
        max  = maxDate(max, m_element->getDateModification());
    }
    return max;
}

