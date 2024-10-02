#ifndef ELEMENT_H
#define ELEMENT_H
#include <string>

#include "Usager.h"

class Element {
private:
    Usager* m_Propriétaire;
    std::string m_Nom;
public:
    Element(Usager* proprietaure, const std::string nom);
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

