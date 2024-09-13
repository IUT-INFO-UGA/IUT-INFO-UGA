#include <cstdlib>
#include <iostream>
#include <string>
#include "Point.h"
using namespace std;

int main(int argc, char** argv) {

    // à compléter
    auto* point = new Point();
    cout << "give name x y" << endl;
    point->saisir(cin);
    point->afficher(cout);
    return 0;
    
}

void testClassePoint(const string& name, const int x, const int y)
{
    auto* p = new Point(name, x, y);
    //work perfectly
    if(p->getNom()!= name)
        cout<<"error in name"<<endl;
    if(p->getX() != x)
        cout<<"error in x"<<endl;
    if(p->getY() != y)
        cout<<"error in y"<<endl;
    p->setNom("truc");
    p->setX(1);
    p->setY(2);
    if(p->getNom()!= "truc")
        cout<<"error in name"<<endl;
    if(p->getX() != 1)
        cout<<"error in x"<<endl;
    if(p->getY() != 2)
        cout<<"error in y"<<endl;
}