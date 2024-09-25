#ifndef POINT_H
#define POINT_H

#include <iostream>
#include <string>

class Point {
public:
    Point(const std::string & nom = NOM_DEF, int x = X_DEF, int y = Y_DEF);
    ~Point();
    const std::string & getNom() const;
    int getX() const;
    int getY() const;
    void setNom(const std::string & nom);
    void setX(int x);
    void setY(int y);
    void saisir(std::istream & entree = std::cin);
    void afficher(std::ostream & sortie = std::cout) const;

    // A CCOMPLETER : Rajouter l'opérateur < pour le TP02 exercice 3

private: // membres privés
    // attributs d'instance
    std::string m_nom;
    int m_x;
    int m_y;
    // constantes de classe
    static const std::string NOM_DEF;
    static const int X_DEF;
    static const int Y_DEF;
};

#endif /* POINT_H */

