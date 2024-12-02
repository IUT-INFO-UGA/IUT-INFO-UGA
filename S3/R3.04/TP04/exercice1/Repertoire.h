#ifndef REPERTOIRE_H
#define REPERTOIRE_H
#include <string>
#include <vector>

#include "Element.h"
#include "Usager.h"

class Repertoire: public Element{

private:
    std::string name;
    Usager* m_usager;
    std::vector<Element*> m_elements;
public:
    Repertoire(std::string name, Usager &usager);
    ~Repertoire() {};
    int getTaille() const override;
    void ajouter(Element* element) override;
    const std::string& getDateModification() const override;

};

#endif /* REPERTOIRE_H */

