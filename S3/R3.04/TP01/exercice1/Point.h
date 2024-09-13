// Les 2 directives ci-cessous permettent d'éviter les problèmes d'inclusions multiples d'une même classe
#ifndef POINT_H
#define POINT_H

// On inclut les librairies utilisées dans le fichier
#include <iostream>
#include <string>
// Attention : pas de clause "using namespace" dans un fichier ".h" !

class Point {

    std::string nom;
    int x;
    int y;
public:
    Point(const std::string& nom, int x, int y);
    Point();
    ~Point();
    std::string getNom() const;
    int getX() const;
    int getY() const;
    void setNom(const std::string& nom);
    void setX(int x);
    void setY(int y);
    void saisir(std::istream & entre);
    void afficher(std::ostream & ost) const;

};

#endif /* POINT_H */

