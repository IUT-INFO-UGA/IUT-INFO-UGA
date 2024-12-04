/* 
 * File:   Mondial.cpp
 * Author: hb
 * 
 * Created on 22 novembre 2018, 16:05
 */

#include "Mondial.h"


#include <iostream>     // pour cout
#include <iomanip>      // pour setw()
#include <sstream>
#include <iterator>
#include <cstdlib>

Mondial::Mondial(const char* filename)
{
    // Chargement du fichier XML en mémoire
    imageMondial.LoadFile(filename);
    // Initialisation de l'attribut racineMondial avec la racine (élément <mondial>)
    racineMondial = imageMondial.FirstChildElement();
}

void Mondial::Print()
{
    imageMondial.Print();
}

/*
 * FOURNIE
 */
int Mondial::getNbAirports() const
{
    // initialisation du nombre d’aéroports
    int nb = 0;
    // accéder à <airportscategory>, c’est un fils de l'élément <racineMondial>
    XMLElement* airportsCategory = racineMondial->FirstChildElement("airportscategory");
    // parcours complet des fils de <airportscategory> en les comptants
    // 1) accéder au premier fils <airport> de <airportscategory>
    XMLElement* currentAirport = airportsCategory->FirstChildElement();
    // 2) parcourir tous les <airport> qui sont des frères
    while (currentAirport != nullptr)
    {
        // un aéroport supplémentaire
        nb = nb + 1;
        // avancer au frère <airport> suivant de currentAirport
        currentAirport = currentAirport->NextSiblingElement();
    }
    // currentAirport n’a plus de frère {currentAirport == nullptr}, c’est le dernier
    return nb;
}

/*
 * FOURNIE
 */
void Mondial::printCountriesCode() const
{
    int rank = 1; // rang du pays
    string carcodeValue; // valeur de l'attribut "car_cod" du pays courant
    // accéder à <countriescategory>, c’est un fils de l'élément <racineMondial>)
    XMLElement* countriesCategory = racineMondial->FirstChildElement("countriescategory");
    // parcours complet des fils de <countriescategory> en affichant le rang et le code
    // 1) accéder au premier fils <country> de <countriescategory>
    XMLElement* currentCountry = countriesCategory->FirstChildElement();
    // 2) parcourir tous les <country> qui sont des frères
    while (currentCountry != nullptr)
    {
        // traiter le pays courant
        //      1) récupérer la valeur de l’attribut "car_code"
        carcodeValue = currentCountry->Attribute("car_code");
        //      2) faire l’affichage
        cout << setw(5) << rank << " : " << carcodeValue << endl;
        // avancer au frère <country> suivant de currentCountry
        currentCountry = currentCountry->NextSiblingElement();
        // mettre à jour le rang
        rank = rank + 1;
    }
    // currentCountry n’a pas de frère {currentCountry == nullptr}, c’est fini
}


/*
 * COMPLETER
 */
int Mondial::getNbDeserts() const
{
    if (!racineMondial)
    {
        throw PrecondVioleeExcep("La racine XML est nulle.");
    }
    // initialisation du nombre d’aéroports
    int nb = 0;
    // accéder à <desertscategory>, c’est un fils de l'élément <racineMondial>
    XMLElement* desertsCategory = racineMondial->FirstChildElement("desertscategory");
    // parcours complet des fils de <desertscategory> en les comptants
    // 1) accéder au premier fils <desert> de <desertscategory>
    if (desertsCategory == nullptr)
    {
        return nb;
    }
    XMLElement* currentDesert = desertsCategory->FirstChildElement();
    // 2) parcourir tous les <desert> qui sont des frères
    while (currentDesert != nullptr)
    {
        // un aéroport supplémentaire
        nb = nb + 1;
        // avancer au frère <desert> suivant de currentDesert
        currentDesert = currentDesert->NextSiblingElement("desert");
    }
    // currentDesert n’a plus de frère {currentDesert == nullptr}, c’est le dernier
    return nb;
}

/*
 * COMPLETER
 */
int Mondial::getNbElemCat(const string categoryName)
{
    if (!racineMondial)
    {
        throw PrecondVioleeExcep("La racine XML est nulle.");
    }
    int nb = 0;
    // accéder à <categoryName>, c’est un fils de l'élément <racineMondial>
    XMLElement* category = racineMondial->FirstChildElement((decod_category[categoryName]).c_str());
    // parcours complet des fils de <categoryName> en les comptants
    // 1) accéder au premier fils <category> de <categoryName>
    if (category == nullptr)
    {
        return nb;
    }
    XMLElement* currentCategory = category->FirstChildElement();
    // 2) parcourir tous les <category> qui sont des frères
    while (currentCategory != nullptr)
    {
        // une categorie supplémentaire
        nb = nb + 1;
        // avancer au frère <category> suivant de currentDesert
        currentCategory = currentCategory->NextSiblingElement();
    }
    // il n’a plus de frère {currentCategory == nullptr}, c’est le dernier
    return nb;
}

/*
 * A COMPLETER
 */
XMLElement* Mondial::getCountryXmlelementFromNameRec(string countryName) const
{
    return getCountryXmlelementFromNameRecWorker(racineMondial->FirstChildElement("countriescategory")->FirstChildElement("country"), countryName);
}

/*
 * A COMPLETER
 */
XMLElement* Mondial::getCountryXmlelementFromNameRecWorker(XMLElement* currentCountryElement, string countryName) const
{
    if (!currentCountryElement) return nullptr;
    else if (countryName==currentCountryElement->FirstChildElement("name")->GetText()) return currentCountryElement;
    else return getCountryXmlelementFromNameRecWorker(currentCountryElement->NextSiblingElement("country"), countryName);
}

/*
 * A COMPLETER
 */
string Mondial::getCountryCodeFromName(string countryName) const throw (PrecondVioleeExcep)
{
   XMLElement* currentCountry = getCountryXmlelementFromNameRec(countryName);
   if (currentCountry) return currentCountry->Attribute("car_code");
    else throw PrecondVioleeExcep("pays non trouvé");
}


/*
 * A COMPLETER
 */
/**
 * élément <country> d'un pays identifié par son nom countryName
 * @param countryName
 * @return pointeur sur l'élément <country> dont la valeur du fils <name> est égal à countryName, nullprt sinon
 */
XMLElement* Mondial::getCountryXmlelementFromNameIter(string countryName) const
{
    XMLElement* country = racineMondial->FirstChildElement("countriescategory")->FirstChildElement("country");
    while (country != nullptr && country->FirstChildElement("name")->GetText() != countryName)
    {
        country = country->NextSiblingElement("country");
    }
    return country;
}

/**
 *
 * @param countryName name of contry
 * @return population of most recent mesur of population.
 */
int Mondial::getCountryPopulationFromName(string countryName) const {
    XMLElement* country = getCountryXmlelementFromNameIter(countryName);
    //if contry dont exist
    if(!country) return -1;

    int lastYear = 0;
    int population = -1;
    XMLElement* pop = country->FirstChildElement("population");
    // toute population jusqu'a la fin
    while (pop!= nullptr)
    {
        //year of current test
        const int currYears = atoi(pop->Attribute("year"));
        if ( currYears > lastYear)
        {
            lastYear = currYears;
            population = atoi(pop->GetText());
        }
        pop = pop->NextSiblingElement("population");
    }
    return population;
}

/*
 * A COMPLETER
 */
XMLElement* Mondial::getCountryXmlelementFromCode(string countryCode) const {
    XMLElement* country = racineMondial->FirstChildElement("countriescategory")->FirstChildElement("country");
    while (country != nullptr && country->Attribute("car_code") != countryCode)
    {
        country = country->NextSiblingElement("country");
    }
    return country;
}

/*
 * A COMPLETER
 */
void Mondial::printCountryBorders(string countryName) const
{
    XMLElement* country = getCountryXmlelementFromNameIter(countryName);
    cout << "Le pays : " << countryName;
    if(country == nullptr)
    {
        cout<< " n'a pas été trouvé"<<endl;
        return;
    }

    XMLElement* border = country->FirstChildElement("border");
    //pour chaque bordure
    bool hasBorder = false;
    while (border != nullptr)
    {
        hasBorder = true;
        const XMLElement* borderContry = getCountryXmlelementFromCode(border->Attribute("country"));
        cout << " est frontalier avec : " << borderContry->FirstChildElement("name")->GetText() << endl;
        border = border->NextSiblingElement("border");
    }
    if(!hasBorder)
    {
        cout << ", n'a pas de pays frontalier !"<< endl;
    }
}


/**
 * @param riverName The name of the river to search for.
 * @return XMLElement* Pointer to the XML element of the river with the specified name.
 *         Returns nullptr if no river with the given name is found.
 */
XMLElement* Mondial::getRiverXmlelementFromNameIter(string riverName) const
{
    XMLElement* river = racineMondial->FirstChildElement("riverscategory")->FirstChildElement("river");
    while (river != nullptr && river->FirstChildElement("name")->GetText() != riverName)
    {
        river = river->NextSiblingElement("river");
    }
    return river;
}


void Mondial::printAllCountriesCrossedByRiver(string riverName) const
{
    XMLElement* river = getRiverXmlelementFromNameIter(riverName);
    if (river == nullptr)
    {
        cout << riverName<< "ne traverse pas de pays" << endl;
        return;
    }
    cout << riverName << " traverse : " << endl;

    vector<string> contrysCode= split(river->Attribute("country"), ' ');
    for (size_t i = 0; i < contrysCode.size(); i++)
    {
        cout << getCountryXmlelementFromCode(contrysCode[i])->FirstChildElement("name")->GetText() << endl;
    }

    cout << "il a la longeur de " << river->FirstChildElement("length")->GetText() <<endl;
}

/*
 * A COMPLETER
 */
void Mondial::printCountriesWithProvincesCrossedByRiver(string riverName) const
{

}

/*
 * A COMPLETER
 */
void Mondial::printCountriesAndProvincesCrossedByRiver(string riverName) const
{
    /*
     * A COMPLETER
     */
}

/*
 * A COMPLETER
 */
void Mondial::printCityInformation(string cityName) const
{
    /*
     * A COMPLETER
     */
}

/**
 * Exemple de question additionnelle pour l'exercice 9 afficher toutes les informations disponibles
 * dans Mondial concernant toutes les îles.
 * On peut commencer par une île en particulier à partir de son nom
 */
void Mondial::printIslandsInformations() const
{
    /*
     * A COMPLETER
     */
}

/*
 * Méthodes de service fournies
 */

template <typename Out>
void Mondial::split(string& s, char delim, Out result) const
{
    stringstream ss(s);
    string item;
    while (getline(ss, item, delim))
    {
        *(result++) = item;
    }
}

/**
 * Méthode à utiliser pour découper les mots d'une chaîne dans un vecteur
 * Utile pour la gestion des attributs à valeurs multiples
 * @param s chaîne à découper
 * @param delim délimiteur des mots de la chaîne à découper
 * @return vecteur contenant les mots de la chaîne découpée
 */
vector<std::string> Mondial::split(const string& s, char delim) const
{
    vector<std::string> elems;
    string sLocal = s;
    split(sLocal, delim, back_inserter(elems));
    return elems;
}

Mondial::~Mondial()
{
}
