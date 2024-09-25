#include <iostream>

using namespace std;

#include "Groupe.h"
#include "Personne.h"

int main(int argc, char **argv) {
    // Au début, pas de Groupes ni de Personnes
    cout << "-------- Aucun Groupe créé --------" << endl;
    Personne::afficheNbInstances();

    // On crée le groupe A et on en y ajoute 3 Personnes : Emmanuel, Brigitte, Edouard
    Groupe *groupeA = new Groupe("A");
    groupeA->addPersonne("Emmanuel");
    groupeA->addPersonne("Brigitte");
    groupeA->addPersonne("Edouard");
    // On affiche les groupes et le nombre de Personnes
    cout << "-------- Groupe A créé --------" << endl;
    groupeA->affiche();
    Personne::afficheNbInstances();

    // On crée le groupe B à partir du groupe A
    Groupe *groupeB = new Groupe(*groupeA); // constructeur de recopie !
    groupeB->setIntitule("B");
    // on change le nom de la 2ème personne de Brigitte en Line
    groupeB->setNomPersonne(1, "Line");
    // On affiche les groupes et le nombre de Personnes
    cout << "-------- Groupe B créé --------" << endl;
    groupeA->affiche();
    groupeB->affiche();
    Personne::afficheNbInstances();

    // On crée le groupe C à partir du groupe B
    Groupe *groupeC = new Groupe("");
    *groupeC = *groupeB; // operator =
    // on change le nom de la 3ème personne de Edouard en Francois
    groupeC->setIntitule("C");
    groupeC->setNomPersonne(2, "Francois");
    // On affiche les groupes et le nombre de Personnes
    cout << "-------- Groupe C créé --------" << endl;
    groupeA->affiche();
    groupeB->affiche();
    groupeC->affiche();
    Personne::afficheNbInstances();

    // On supprime tous les groupes
    delete groupeA;
    cout << "groupe A detruit"<<endl;
    Personne::getNbInstances();
    delete groupeB;
    delete groupeC;
    // On affiche le nombre de Personnes
    cout << "-------- Groupes supprimés --------" << endl;
    Personne::afficheNbInstances();

    return 0;
}
