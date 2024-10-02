////////////////////////////////////////////////////////////////////////////////
// NE MODIFIEZ PAS CE FICHIER
////////////////////////////////////////////////////////////////////////////////

#ifndef THEME_H
#define THEME_H
#include <string>

class Theme {
public:
    Theme(const std::string & intitule) : m_intitule(intitule) {}
    const std::string & getIntitule() const { return m_intitule; }
private:
    std::string m_intitule;
};

#endif /* THEME_H */
