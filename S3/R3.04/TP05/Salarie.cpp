#include "Salarie.h"
#include <iostream>
#include <limits>
#include <algorithm>
#include <cctype>
#include "SalarieException.h"

const float Salarie::SMIC = 1257.0f;
const float Salarie::COEFF_SMIC = 500.0f;
const std::string Salarie::NOM_DEF = "Martin";
const std::string Salarie::NUMERO_SS_DEF = "1234567890123";
const std::map<float, float> Salarie::TRANCHES_IMPOT = {
    {6000.0f, 0.000f},
    {12000.0f, 0.055f},
    {26600.0f, 0.140f},
    {71400.0f, 0.300f},
    {151200.0f, 0.410f},
    {std::numeric_limits<float>::max(), 0.500f}
};

// Constructeur par défaut
Salarie::Salarie() {
    this->saisir(std::cin);
}

// Constructeur avec paramètres
Salarie::Salarie(std::string nom, std::string numeroSS, float salaire) {
    this->setNom(nom);
    this->setNumeroSS(numeroSS);
    this->setSalaireMensuel(salaire);
}

// Destructeur
Salarie::~Salarie() {
    delete m_salaireMensuel;
}

// Getters
float Salarie::getSalaireMensuel() const {
    return *this->m_salaireMensuel;
}

std::string Salarie::getNom() const {
    std::string nomMaj = this->m_nom;
    std::transform(nomMaj.begin(), nomMaj.end(), nomMaj.begin(), ::toupper);  // Nom en majuscules
    return nomMaj;
}

std::string Salarie::getNumeroSS() const {
    return this->m_numeroSS;
}

// Setters
void Salarie::setNom(std::string nom) {
    if (nom.empty() || !std::all_of(nom.begin(), nom.end(), ::isalpha)) {
        throw NomIncorrectException();
    }
    this->m_nom = nom;
}

void Salarie::setNumeroSS(std::string numeroSS) {
    if (numeroSS.length() != 13 || !std::all_of(numeroSS.begin(), numeroSS.end(), ::isdigit)) {
        throw NumeroIncorrectException();
    }
    this->m_numeroSS = numeroSS;
}

void Salarie::setSalaireMensuel(float salaire) {
    if (salaire < 1257 || salaire > 628500) {
        throw SalaireIncorrectException();
    }
    this->m_salaireMensuel = new ObjetContraint<float>(salaire, 1257, 628500);
}

// Calcul de l'impôt annuel
float Salarie::getImpot()
{
    if(m_salaireMensuel->getVal()<6'000)
        return 0;
    if (m_salaireMensuel->getVal()<12'000)
        return m_salaireMensuel->getVal()*0.055;
    if(m_salaireMensuel->getVal()<26'600)
        return m_salaireMensuel->getVal()*0.14;
    if(m_salaireMensuel->getVal()<71'400)
        return m_salaireMensuel->getVal()*0.30;
    if(m_salaireMensuel->getVal()<151'200)
        return m_salaireMensuel->getVal()*0.41;
    if(m_salaireMensuel->getVal()>=151'200)
        return m_salaireMensuel->getVal()*0.50;
}

// Méthode pour saisir les données
void Salarie::saisir(std::istream& entree) {
    // 1. Saisie du nom
    std::cout << "Entrez le nom du salarié: ";
    std::getline(entree, this->m_nom);

    // Vérification du nom
    while (this->m_nom.empty() || !std::all_of(this->m_nom.begin(), this->m_nom.end(), ::isalpha)) {
        std::cout << "Nom incorrect, recommencez..." << std::endl;
        std::cout << "Nom : ";
        std::getline(entree, this->m_nom);
    }

    // 2. Saisie du numéro de sécurité sociale
    std::cout << "Numéro SS : ";
    std::getline(entree, this->m_numeroSS);

    // Vérification du numéro de sécurité sociale
    while (this->m_numeroSS.length() != 13 || !std::all_of(this->m_numeroSS.begin(), this->m_numeroSS.end(), ::isdigit)) {
        std::cout << "Numéro SS incorrect, recommencez..." << std::endl;
        std::cout << "Numéro SS : ";
        std::getline(entree, this->m_numeroSS);
    }

    // 3. Saisie du salaire mensuel
    float salaire;
    std::cout << "Salaire Mensuel : ";
    entree >> salaire;

    // Vérification du salaire
    while (salaire < 1257 || salaire > 628500) {
        std::cout << "Salaire Mensuel incorrect, recommencez..." << std::endl;
        std::cout << "Salaire Mensuel : ";
        entree >> salaire;
    }

    // Création de l'objet contraint pour le salaire
    this->m_salaireMensuel = new ObjetContraint<float>(salaire, 1257, 628500);

    // Consommer le caractère de fin de ligne laissé par `>>` après la saisie du salaire
    entree.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
}

// Méthode pour afficher les informations
void Salarie::afficher(std::ostream& sortie) {
    sortie << "Informations Salarié(e) ------------------------------------" << std::endl;
    sortie << "Nom : " << this->getNom() << std::endl;
    sortie << "Numéro SS : " << this->getNumeroSS() << std::endl;
    sortie << "Salaire Mensuel : " << this->getSalaireMensuel() << " €" << std::endl;
    sortie << "Impôt Annuel : " <<this->getImpot() << " €" << std::endl;
}
