/* 
 * File:   Mondial.h
 * Author: hb
 *
 * Created on 22 novembre 2018, 16:05
 */

#ifndef MONDIAL_H
#define MONDIAL_H

#include "tinyxml2.h"
#include "PrecondVioleeExcep.h"
#include <string>
#include <vector>
#include <map>

using namespace tinyxml2; // dans l'espace de nom de la bibliothèque
using namespace std;

class Mondial {
public:
    Mondial(const char* filename);

    int getNbAirports() const;
    
    int getNbDeserts() const;
    
    int getNbElemCat(string categoryName);

    void printCountriesCode() const;
    
    string getCountryCodeFromName(string countryName) const throw (PrecondVioleeExcep);

    int getCountryPopulationFromName(string countryName) const;

    void printCountryBorders(string countryName) const;

    void printCountriesWithProvincesCrossedByRiver(string riverName) const;

    void printAllCountriesCrossedByRiver(string riverName) const;
    
    void printCountriesAndProvincesCrossedByRiver(string riverName) const;
    
    void printCityInformation(string cityName) const;
    
    void printIslandsInformations() const;


    void Print();

    virtual ~Mondial();

private:
    // Un XMLDocument permet d'accéder à toutes les fonctionnalités de la bibliothèque
    // Il peut être sauvegardé, chargé, et affiché à l'écran.
    // Tous les noeuds sont connectés et alloués à un document.
    // Si le document est supprimé, tous ses noeuds sont aussi supprimés.
    XMLDocument imageMondial;
    // XMLElement est une classe container.
    // Un element possède une valeur, un nom et peut contenir d'autres éléments, du texte, des commentaires, des inconnus
    // Un élément peut contenir un nombre arbitraire d'attributs    
    // racineMondial est un élément de la classe <mondial> qui permet de parcourir les entrées familles d'éléments pays, fleuves, ...
    XMLElement* racineMondial;                   
    
    map<string, string> decod_category = {
        {"pays", "countriescategory"},
        {"continent", "continentscategory"},
        {"organisation", "organizationscategory"},
        {"mer", "seascategory"},
        {"fleuve", "riverscategory"},
        {"lac", "lakescategory"},
        {"île", "islandscategory"},
        {"montagne", "mountainscategory"},
        {"désert", "desertscategory"},
        {"aéroport", "airportscategory"},
    };

    XMLElement* getCountryXmlelementFromNameRec(string countryName) const; 
    
    XMLElement* getCountryXmlelementFromNameRecWorker(XMLElement* currentCountryElement, string countryName) const;
  
    XMLElement* getCountryXmlelementFromNameIter(string countryName) const;
    
    XMLElement* getCountryXmlelementFromCode(string countryCode) const;

    XMLElement* getRiverXmlelementFromNameIter(string riverName) const;

    // Procédures de découpage des chaînes en mots

    template<typename Out>
    void split(string& s, char delim, Out result) const;


    /**
     * Méthode à utiliser pour découper les mots d'une chaîne dans un vecteur
     * Utile pour la gestion des attributs à valeurs multiples
     * @param s chaîne à découper
     * @param delim délimiteur des mots de la chaîne à découper
     * @return vecteur contenant les mots de la chaîne découpée
     */
    vector<std::string> split(string& s, char delim) const;

};

#endif /* MONDIAL_H */

