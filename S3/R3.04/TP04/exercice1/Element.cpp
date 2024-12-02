#include "Element.h"

#include <vector>

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

/**
 * 
 * @param date1 format AAAA-MM-JJ"
 * @param date2 format AAAA-MM-JJ"
 * @return max date betwen Date1 and Date2 if date1 == date2 date2 is retruned
 */
const std::string& Element::maxDate(std::string date1, std::string date2) const
{
    std::vector<std::string> date1vector = customSplit(date1, '-');
    std::vector<std::string> date2vector = customSplit(date2, '-');
    //years
    if(atoi(date1vector[0].c_str()) >= atoi(date2vector[0].c_str()))
        return date1vector[0];
    else if(atoi(date1vector[1].c_str()) >= atoi(date2vector[1].c_str()))
        return date1vector[1];
    else if (atoi(date1vector[2].c_str()) >= atoi(date2vector[2].c_str()))
        return date1vector[2];
}

std::vector<std::string> Element::customSplit(std::string str, char separator)const  {
    std::vector < std::string > strings;
    int startIndex = 0, endIndex = 0;
    for (int i = 0; i <= str.size(); i++) {

        // If we reached the end of the word or the end of the input.
        if (str[i] == separator || i == str.size()) {
            endIndex = i;
            std::string temp;
            temp.append(str, startIndex, endIndex - startIndex);
            strings.push_back(temp);
            startIndex = endIndex + 1;
        }
    }
    return strings;
}