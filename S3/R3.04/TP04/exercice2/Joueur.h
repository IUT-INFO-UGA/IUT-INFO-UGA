////////////////////////////////////////////////////////////////////////////////
// NE MODIFIEZ PAS CE FICHIER
////////////////////////////////////////////////////////////////////////////////

#ifndef JOUEUR_H
#define JOUEUR_H
#include <string>

class Joueur {
public:
    Joueur(const std::string & intitule) : m_pseudo(intitule) {}
    const std::string & getPseudo() const { return m_pseudo; }
private:
    std::string m_pseudo;
};

#endif /* JOUEUR_H */