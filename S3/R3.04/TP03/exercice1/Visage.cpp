#include "Visage.h"
#include <iostream>
using namespace std;

// A COMPLETER : IMPLEMENTER LES METHODES DE LA CLASSE VISAGE (ET L'OPERATEUR <<)

Visage::Visage(int longueurNez, const Ethnie &uneEthnie): m_ethnie(&uneEthnie), m_nez(longueurNez)
{
    m_moustache == NULL;
}

void Visage::setMoustache(int largeur) {
    m_moustache = new Moustache(largeur);
}

void Visage::addBouton(int diametre) {
    this->m_boutons.emplace_back(diametre);
}

void Visage::setChapeau(const Chapeau &unChapeau) {
    m_chapeau = new Chapeau(unChapeau);
}

void Visage::addBijou(const Bijou &unBijou) {
    m_bijou.push_back(&unBijou);
}

const Visage &Visage::operator=(const Visage &unVisage)
{
    if(this!= &unVisage)
    {
        this->m_bijou = unVisage.m_bijou;
        this->m_chapeau = unVisage.m_chapeau;
        this->m_moustache = unVisage.m_moustache;
        this->m_boutons = unVisage.m_boutons;
        this->m_nez = unVisage.m_nez;
        this->m_ethnie = unVisage.m_ethnie;
    }
    return *this;
}
Visage::Visage(const Visage &unVisage): m_nez(unVisage.m_nez)
{
    this->m_bijou = unVisage.m_bijou;
    this->m_chapeau = unVisage.m_chapeau;
    this->m_moustache = unVisage.m_moustache;
    this->m_boutons = unVisage.m_boutons;
    this->m_ethnie = unVisage.m_ethnie;
}

Visage::~Visage() {
    delete m_moustache;
}

std::ostream &operator<<(std::ostream &sortie, const Visage &visage) {
    sortie <<"Attributs du Visage :"  << endl;
    sortie << visage.m_nez << endl;
    sortie  << *visage.m_ethnie << endl;
    sortie  << *visage.m_chapeau << endl;
    if(visage.m_moustache != nullptr)
        sortie << *visage.m_moustache << endl;
    else
        sortie << "pas de moustache" << endl;
    for (size_t i = 0; i < visage.m_boutons.size(); i++)
    {
        sortie << visage.m_boutons[i] << endl;
    }
    for (size_t i = 0; i < visage.m_bijou.size(); i++)
    {
        sortie << *visage.m_bijou[i] << endl;
    }
    
}