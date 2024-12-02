#include "Salarie.h"
#include "SalarieException.h"
#include <cctype>
#include <map>
#include <limits>
#include <string>
#include <iostream>
#include <iomanip>
using namespace std;

// Constantes de classe
const float        Salarie::SMIC          = 1257.0f;
const float        Salarie::COEFF_SMIC    = 500.0f;
const std::string  Salarie::NOM_DEF       = "Martin";
const std::string  Salarie::NUMERO_SS_DEF = "1234567890123";
const std::map<float, float> Salarie::TRANCHES_IMPOT {
    {  6000.0f, 0.000f},
    { 12000.0f, 0.055f},
    { 26600.0f, 0.140f},
    { 71400.0f, 0.300f},
    {151200.0f, 0.410f},
    {std::numeric_limits<float>::max(), 0.50f} 
};

Salarie::Salarie(const std::string & nom, const std::string & numeroSS, float salaireMensuel)
: m_salaireMensuel(SMIC, SMIC, SMIC*COEFF_SMIC) {
    // Il faut utiliser les setters pour vérifier les contraintes lors de la construction
    setNom(nom);
    setNumeroSS(numeroSS);
    setSalaireMensuel(salaireMensuel);
}

const std::string & Salarie::getNom() const {
    static string nomEnMajuscule;
    // nomEnMajuscule doit etre static pour pouvoir le renvoyer en résultat qui est de type "const string &"
    // On ne pourrait pas renvoyer une référence à une variable locale "automatique"
    //   puisque ces variables automatiques sont supprimées à la fin de la méthode
    // On aurait aussi pu spécifier la méthode ainsi : std::string Salarie::getNom() const
    //   et dans ce cas nomEnMajuscule n'aurait pas eu besoin d'être static
    nomEnMajuscule = "";
    for (int i = 1; i < this->m_nom.size(); i++) //WARN\\ ca doit etre 0
        nomEnMajuscule += (char)toupper(this->m_nom[i]);
    return nomEnMajuscule;
}

void Salarie::setNom(const std::string & nom) {
    bool erreur = false;
    for (int i = 0; !erreur && i < nom.size(); i++) {
        erreur = (!isalpha(nom[i]) && nom[i] != '-');
    }
    if (erreur || nom.empty() || nom[0]=='-' || nom[nom.size()-1]=='-')
        throw NomIncorrectException();
    this->m_nom = nom;
}

const std::string & Salarie::getNumeroSS() const {
    return this->m_numeroSS;
}

void Salarie::setNumeroSS(const std::string & numeroSS) {
    bool erreur = false;
    for (int i = 0; !erreur && i < numeroSS.size(); i++)
        erreur = !isdigit(numeroSS[i]);
    if (numeroSS.size() != 13 || erreur || numeroSS[0] < '1' | numeroSS[0] >= '2') throw NumeroIncorrectException();
    this->m_numeroSS = numeroSS;
}

float Salarie::getSalaireMensuel() const {
    return this->m_salaireMensuel;
}

void Salarie::setSalaireMensuel(float salaireMensuel) {
    // ObjetContraint lève une exception de type domain_error
    // il faut attraper cette exception pour lever à la place
    // une exception de type SalaireIncorrectException
    try {
        this->m_salaireMensuel.setVal(salaireMensuel);
    } catch (domain_error & exception) {
        throw NumeroIncorrectException();
    }
}

float Salarie::getImpot() const {
    float revenuImposable = getSalaireMensuel()*12.0f;
    float impot;
    bool trancheTrouvee = false;
    // On parcourt la "map" (triée sur les clés... c'est une map !)
    // pour chercher la tranche d'imposition correspondant au revenu imposable
    for (auto it = TRANCHES_IMPOT.begin(); 
            it != TRANCHES_IMPOT.end() && !trancheTrouvee; it++) {
        // it est un itérateur qui pointe sur un élément de la map
        // un élément de map est une "paire" qui est une structure comportant deux champs : 
        //  - first : la clé, ici le seuil de revenu pour une tranche
        //  - second : la valeur associée, ici le taux d'imposition de la tranche
        if (revenuImposable <= it->first) {
            trancheTrouvee = true;
            impot = revenuImposable * it->second;
        }
    }
    return impot;
}

void Salarie::saisir() {
    // On utilise ici les "setters" en gérant les exceptions qu'ils lèvent
    //  pour recommencer les saisies tant que les valeurs sont incorrectes
    bool erreurSaisie;
    // Saisie du nom
    do {
        try {
            cout << "Nom : ";
            string nom;
            getline(cin, nom); // cin >> nom : ne lit que le 1er mot
            this->setNom(nom);
            erreurSaisie = false;
        } catch (NomIncorrectException & exception) {
            cout << "Nom incorrect, recommencez..." << endl;
            erreurSaisie = true;
        }
    } while (erreurSaisie);
    // Saisie du Numéro SS
    do {
        try {
            cout << "Numéro SS : ";
            string numeroSS;
            getline(cin, numeroSS);
            this->setNumeroSS(numeroSS);
            erreurSaisie = false;
        } catch (NumeroIncorrectException & exception) {
            cout << "Numéro SS incorrect, recommencez..." << endl;
            erreurSaisie = true;
        }
    } while (erreurSaisie);
    // Saisie du salaire
    do {
        try {
            cout << "Salaire Mensuel : ";
            float salaire;
            cin >> salaire; cin.ignore(256,'\n');
            this->setSalaireMensuel(salaire);
            erreurSaisie = false;
        } catch (SalaireIncorrectException & exception) {
            cout << "Salaire Mensuel incorrect, recommencez..." << endl;
            erreurSaisie = true;
        }
    } while (erreurSaisie);
}

void Salarie::afficher() const {
    cout << "            Nom : " << this->getNom() << endl
         << "      Numéro SS : " << this->getNumeroSS() << endl
         << fixed << setprecision(2) // pour écrire les nombres avec 2 chiffres après la virgule
         << "Salaire Mensuel : " << setw(10) << this->getSalaireMensuel() << " €" << endl
         << "   Impôt Annuel : " << setw(10) << this->getImpot() << " €" << endl;
}