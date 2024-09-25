#include "Groupe.h"
#include "Personne.h"
#include <string>
#include <iostream>

using namespace std;

// A COMPLETER
// Implémenter les méthodes nécessaires pour la forme canonique de COPLIEN

Groupe::Groupe(const std::string &intitule)
        : m_intitule(intitule) {
}

Groupe::Groupe(const Groupe &groupe)
{
    this->Copy(groupe);
}

Groupe &Groupe::operator=(const Groupe &groupe)
{
    this->clear();
    this->Copy(groupe);
    return *this;
}

void Groupe::Copy(const Groupe & other)
{
    this->m_intitule = other.m_intitule;
    for (int i = 0; i < other.m_effectif.size(); ++i)
    {
        this->addPersonne(other.m_effectif[i]->getNom());
    }
}

void Groupe::clear()
{
    for (size_t i = 0; i < this->m_effectif.size(); i++)
    {
        delete this->m_effectif[i];
    }
    this->m_effectif.clear();
}

Groupe::~Groupe()
{
    this->clear();
}

///////////////////////////////////////////////////
void Groupe::setIntitule(const std::string &intitule) {
    this->m_intitule = intitule;
}

///////////////////////////////////////////////////
void Groupe::addPersonne(const std::string &nom) {
    this->m_effectif.push_back(new Personne(nom));
}

///////////////////////////////////////////////////
void Groupe::setNomPersonne(unsigned int i,
                            const std::string nom) {
    if (i < this->m_effectif.size())
        this->m_effectif[i]->setNom(nom);
}

///////////////////////////////////////////////////
void Groupe::affiche() const {
    cout << "Groupe " << this->m_intitule << " = { ";
    for (Personne *personne: this->m_effectif)
        cout << personne->getNom() << " ";
    cout << "}" << endl;
}
