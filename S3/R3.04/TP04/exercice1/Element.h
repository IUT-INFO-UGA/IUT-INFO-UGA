#ifndef ELEMENT_H
#define ELEMENT_H
#include <string>
#include <vector>

#include "Usager.h"

class Element {
private:
    const Usager* m_Propriétaire;
    std::string m_Nom;
protected:
    const std::string& Element::maxDate(std::string date1, std::string date2) const;
    std::vector<std::string> customSplit(std::string str, char separator) const;
public:
    Element(const Usager* proprietaure, const std::string nom);
    virtual ~Element() {};
    const std::string& getNom() const;
    void setNom(const std::string& nom);
    const Usager* getPropriétaire() const;
    void setPropriétaire(const Usager* proprietaure);
    virtual int getTaille() const = 0;
    virtual const std::string& getDateModification() const = 0;
    virtual void setDateModification(const std::string & date);
    virtual void afficher();
    virtual void ajouter(Element* element);

};

#endif /* ELEMENT_H */

