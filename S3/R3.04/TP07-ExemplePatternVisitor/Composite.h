#ifndef COMPOSITE_H
#define COMPOSITE_H
#include <string>

// Annoncer la classe Visiteur (ne pas inclure Visiteur.h qui inclut Composite.h)
class Visiteur; 

// Ajouter la méthode accepte(Visiteur&) à la classe de base du Composite

class Element {
public:
    virtual void accepte(const Visiteur &v) const = 0;
    // ... autres méthodes du composite
};

// Redéfinir la méthode accepte(Visiteur&) à chaque classe dérivée du Composite

class Fichier : public Element {
public:
    void accepte(const Visiteur & v) const override;
    std::string nomFichier() const;
    // ... autres méthodes du composite
};

class Repertoire : public Element {
public:
    void accepte(const Visiteur & v) const override;
    std::string nomRepertoire() const;
    // ... autres méthodes du composite
};

#endif /* COMPOSITE_H */

