// Dans le fichier d'implémentation d'une classe, on doit inclure le fichier de spécification de cette classe
#include "Point.h"
using namespace std;
// Et on inclura aussi les librairies utilisées ici

// A COMPLETER - Implémenter les méthodes de la classe Point

Point::²Point(const std::string &nom = "P", const int x = 0, const int y= 0)
{
    this->nom = nom;
    this->x = x;
    this->y = y;
    cout << "Point "<< nom << "created at x:" << x <<" y:"<< y<< endl;
}

Point::Point()
{
    this->nom = "P";
    this->x = 0;
    this->y = 0;
}

Point::~Point()
{
    cout << "Point destroyed" << endl;
}

std::string Point::getNom() const
{
    return nom;
}

int Point::getX() const
{
    return x;
}

int Point::getY() const
{
    return y;
}

void Point::setX(const int x)
{
    this->x = x;
}

void Point::setY(const int y)
{
    this->y = y;
}

void Point::setNom(const std::string& nom)
{
    this->nom = nom;
}

void Point::afficher(std::ostream & ost) const
{
    ost << "Point name: " << this->nom << " placment: x:"<< x << " y: " << y;
}

void Point::saisir(std::istream& entre)
{
    entre >> this->nom >> this->x >> this->y;
}
