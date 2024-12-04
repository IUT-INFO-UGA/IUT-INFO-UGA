/* 
 * File:   newmain.cpp
 * Author: hb
 *
 * Created on 22 novembre 2018, 16:20
 */

#include <iostream>

#include "Mondial.h"

using namespace std;

void testGetNbAirports(Mondial& theMondial) {
    cout << endl << "****************************************" << endl;
    cout << "*                                      *" << endl;
    cout << "*          Nombre d'aéroports          *" << endl;
    cout << "*                                      *" << endl;
    cout << "****************************************" << endl << endl;
    cout << "La base de données comporte : " << theMondial.getNbAirports() << " aéroports (devrait être 1318)" << endl;
}

void testPrintCodesPays(Mondial& theMondial) {
    cout << endl << "****************************************" << endl;
    cout << "*                                      *" << endl;
    cout << "*     Affichage des codes de pays      *" << endl;
    cout << "*                                      *" << endl;
    cout << "****************************************" << endl << endl;
    theMondial.printCountriesCode();
    cout << endl;
}

void testGetNbDeserts(Mondial& theMondial) {
    cout << endl << "****************************************" << endl;
    cout << "*                                      *" << endl;
    cout << "*          Nombre de déserts           *" << endl;
    cout << "*                                      *" << endl;
    cout << "****************************************" << endl << endl;
    cout << "La base de données comporte : " << theMondial.getNbDeserts() << " déserts (devrait être 63)" << endl;
}

void testgetNbElemCat(Mondial& theMondial) {
    cout << endl << "****************************************" << endl;
    cout << "*                                      *" << endl;
    cout << "*          Nombre d'éléments           *" << endl;
    cout << "*                                      *" << endl;
    cout << "****************************************" << endl << endl;
    cout << "La base de données comporte : " << theMondial.getNbElemCat("pays") << " pays (devrait être 244)" << endl;
    cout << "La base de données comporte : " << theMondial.getNbElemCat("continent") << " continents (devrait être 5)" << endl;
    cout << "La base de données comporte : " << theMondial.getNbElemCat("organisation") << " organisations (devrait être 168)" << endl;
    cout << "La base de données comporte : " << theMondial.getNbElemCat("mer") << " mers (devrait être 49)" << endl;
    cout << "La base de données comporte : " << theMondial.getNbElemCat("fleuve") << " fleuves (devrait être 421)" << endl;
    cout << "La base de données comporte : " << theMondial.getNbElemCat("lac") << " lacs (devrait être 187)" << endl;
    cout << "La base de données comporte : " << theMondial.getNbElemCat("île") << " île, (devrait être 350)" << endl;
    cout << "La base de données comporte : " << theMondial.getNbElemCat("montagne") << " montagne, (devrait être 570)" << endl;
    cout << "La base de données comporte : " << theMondial.getNbElemCat("désert") << " déserts (devrait être 63)" << endl;
    cout << "La base de données comporte : " << theMondial.getNbElemCat("aéroport") << " aéroports (devrait être 1318)" << endl;
}

void testGetCountryCodeFromName(Mondial& theMondial) {
    cout << endl << "****************************************" << endl;
    cout << "*                                      *" << endl;
    cout << "*           Code d'un pays             *" << endl;
    cout << "*                                      *" << endl;
    cout << "****************************************" << endl << endl;
    try {
        string countryName = "United States";
        string theCountryCode = theMondial.getCountryCodeFromName(countryName);
        cout << "Le pays : " << countryName << " existe et son code est :  " << theCountryCode << endl;
    } catch (PrecondVioleeExcep& e) {
        cout << endl << "  !!! CA C'EST MAL PASSEE, VOICI POURQUOI ---> " << endl;
        cout << e.what() << endl;
        cout << "  !!! ENFIN ON A QUAND MEME RECUPERER LE COUP !" << endl;
    }
    try {
        string countryName = "Test";
        string theCountryCode = theMondial.getCountryCodeFromName(countryName);
        cout << "Le pays : " << countryName << " existe et son code est :  " << theCountryCode << endl;
    } catch (PrecondVioleeExcep& e) {
        cout << endl << "  !!! CA C'EST MAL PASSEE, VOICI POURQUOI ---> " << endl;
        cout << e.what() << endl;
        cout << "  !!! ENFIN ON A QUAND MEME RECUPERER LE COUP !" << endl;
    }
    cout << endl;
}

void testGetCountryPopulationFromName(Mondial& theMondial) {
    cout << endl << "********************************************" << endl;
    cout << "*                                          *" << endl;
    cout << "* Dernière population renseignée d'un pays *" << endl;
    cout << "*                                          *" << endl;
    cout << "********************************************" << endl << endl;
    string countryName = "United States";
    int thePopulation = theMondial.getCountryPopulationFromName(countryName);
    if (thePopulation == -1) {
        cout << "Le pays : " << countryName << ", n'existe pas" << endl;
    } else {
        cout << "Pour le pays : " << countryName << " la denière population renseignée est "
                << thePopulation << endl;
    }
    cout << endl;
    
    countryName = "Test";
    thePopulation = theMondial.getCountryPopulationFromName(countryName);
    if (thePopulation == -1) {
        cout << "Le pays : " << countryName << ", n'existe pas" << endl;
    } else {
        cout << "Pour le pays : " << countryName << " la denière population renseignée est "
                << thePopulation << endl;
    }
    cout << endl;
}

void testPrintCountryBorders(Mondial& theMondial) {
    cout << endl << "********************************************" << endl;
    cout << "*                                          *" << endl;
    cout << "*     Pays frontaliers d'un pays donné     *" << endl;
    cout << "*                                          *" << endl;
    cout << "********************************************" << endl << endl;
    string countryName = "United States";
    theMondial.printCountryBorders(countryName);
    cout << endl;
    countryName = "France";
    theMondial.printCountryBorders(countryName);
    cout << endl;
    countryName = "Japan";
    theMondial.printCountryBorders(countryName);
    cout << endl;
    countryName = "Test";
    theMondial.printCountryBorders(countryName);
    cout << endl;
}

void testPrintAllCountriesCrossedByRiver(Mondial& theMondial) {
    cout << endl << "**********************************************" << endl;
    cout << "*                                            *" << endl;
    cout << "*   Tous les pays traversés par un fleuve    *" << endl;
    cout << "*                                            *" << endl;
    cout << "**********************************************" << endl << endl;
    string riverName = "Rhein";
    theMondial.printAllCountriesCrossedByRiver(riverName);
    cout << endl;
    riverName = "Seine";
    theMondial.printAllCountriesCrossedByRiver(riverName);
    cout << endl;
}

void testPrintCountriesWithProvincesCrossedByRiver(Mondial& theMondial) {
    cout << endl << "********************************************************" << endl;
    cout << "*                                                      *" << endl;
    cout << "* Tous les pays avec provinces traversés par un fleuve *" << endl;
    cout << "*                                                      *" << endl;
    cout << "********************************************************" << endl << endl;
    string riverName = "Rhein";
    theMondial.printCountriesWithProvincesCrossedByRiver(riverName);
    cout << endl;
    riverName = "Seine";
    theMondial.printCountriesWithProvincesCrossedByRiver(riverName);
    cout << endl;
    riverName = "Test";
    theMondial.printCountriesWithProvincesCrossedByRiver(riverName);
    cout << endl;
}

void testPrintCountriesAndProvincesCrossedByRiver(Mondial& theMondial) {
    cout << endl << "*************************************************************" << endl;
    cout << "*                                                           *" << endl;
    cout << "* Tous les pays avec les provinces traversées par un fleuve *" << endl;
    cout << "*                                                           *" << endl;
    cout << "*************************************************************" << endl << endl;
    string riverName = "Rhein";
    theMondial.printCountriesAndProvincesCrossedByRiver(riverName);
    cout << endl;
    riverName = "Seine";
    theMondial.printCountriesAndProvincesCrossedByRiver(riverName);
    cout << endl;
    riverName = "Test";
    theMondial.printCountriesAndProvincesCrossedByRiver(riverName);
    cout << endl;
}

void testPrintCityInformation(Mondial& theMondial) {
    cout << endl << "******************************" << endl;
    cout << "*                            *" << endl;
    cout << "* Informations sur une ville *" << endl;
    cout << "*                            *" << endl;
    cout << "******************************" << endl << endl;
    string cityName = "Vaduz";
    theMondial.printCityInformation(cityName);
    cout << endl;
    cityName = "Paris";
    theMondial.printCityInformation(cityName);
    cout << endl;
    cityName = "Test";
    theMondial.printCityInformation(cityName);
    cout << endl;
}

int main() {

    /*
     * ATTENTION
     * METTRE VOTRE CHEMIN D'ACCÈS À JOUR !!
     */

    // version HB
    //Mondial theMondial("/Users/hb/Documents/ Enseignement/R3.02/TP_Sols/R302-TP3-Correction-compile/mondial_HB.xml");

    // pour les étudiants
    Mondial theMondial("/users/info/pub/s3/R302/mondial_HB.xml");

    // autre, mettre votre chemin d'accès au fichier XML
    // Mondial theMondial("/MON_CHEMIN_D_ACCES/mondial_HB.xml");

    //theMondial.Print();

    testGetNbAirports(theMondial);
    testPrintCodesPays(theMondial);
    testGetNbDeserts(theMondial);
    testgetNbElemCat(theMondial);
    testGetCountryCodeFromName(theMondial);
    testGetCountryPopulationFromName(theMondial);
    testPrintCountryBorders(theMondial);
    testPrintAllCountriesCrossedByRiver(theMondial);
    testPrintCountriesWithProvincesCrossedByRiver(theMondial);
//    testPrintCountriesAndProvincesCrossedByRiver(theMondial);
//    testPrintCityInformation(theMondial);

    //theMondial.printIslandsInformations();
    
    return 0;
}


/* TRACE ATTENDUE */
/*
****************************************
*                                      *
*          Nombre d'aéroports          *
*                                      *
****************************************

La base de données comporte : 1318 aéroports (devrait être 1318)

****************************************
*                                      *
*     Affichage des codes de pays      *
*                                      *
****************************************

    1 : AL
   ...
  244 : SY


****************************************
*                                      *
*          Nombre de déserts           *
*                                      *
****************************************

La base de données comporte : 63 déserts (devrait être 63)

****************************************
*                                      *
*          Nombre d'éléments           *
*                                      *
****************************************

La base de données comporte : 244 pays (devrait être 244)
La base de données comporte : 5 continents (devrait être 5)
La base de données comporte : 168 organisations (devrait être 168)
La base de données comporte : 49 mers (devrait être 49)
La base de données comporte : 421 fleuves (devrait être 421)
La base de données comporte : 187 lacs (devrait être 187)
La base de données comporte : 350 île, (devrait être 350)
La base de données comporte : 570 montagne, (devrait être 570)
La base de données comporte : 63 déserts (devrait être 63)
La base de données comporte : 1318 aéroports (devrait être 1318)

****************************************
*                                      *
*           Code d'un pays             *
*                                      *
****************************************

Le pays : United States existe et son code est :  USA

  !!! CA C'EST MAL PASSEE, VOICI POURQUOI ---> 
Exception pour précondition violée : Dans getCountryCodeFromName, le pays Test n'existe pas !
  !!! ENFIN ON A QUAND MEME RECUPERER LE COUP !


********************************************
*                                          *
* Dernière population renseignée d'un pays *
*                                          *
********************************************

Pour le pays : United States la denière population renseignée est 318857056

Le pays : Test, n'existe pas


********************************************
*                                          *
*     Pays frontaliers d'un pays donné     *
*                                          *
********************************************

Le pays : United States
 est frontalier avec : Mexico, la longueur de sa frontière avec celui-ci est : 3326
 est frontalier avec : Canada, la longueur de sa frontière avec celui-ci est : 8893

Le pays : France
 est frontalier avec : Andorra, la longueur de sa frontière avec celui-ci est : 60
 est frontalier avec : Spain, la longueur de sa frontière avec celui-ci est : 623
 est frontalier avec : Germany, la longueur de sa frontière avec celui-ci est : 451
 est frontalier avec : Italy, la longueur de sa frontière avec celui-ci est : 488
 est frontalier avec : Switzerland, la longueur de sa frontière avec celui-ci est : 573
 est frontalier avec : Belgium, la longueur de sa frontière avec celui-ci est : 620
 est frontalier avec : Luxembourg, la longueur de sa frontière avec celui-ci est : 73
 est frontalier avec : Monaco, la longueur de sa frontière avec celui-ci est : 4.4

Le pays : Japan, n'a pas de pays frontalier !

Le pays : Test, n'existe pas !


**********************************************
*                                            *
*   Tous les pays traversés par un fleuve    *
*                                            *
**********************************************

Le fleuve : Rhein
 traverse les pays suivants : Germany, Switzerland, Liechtenstein, Austria, France, Netherlands ; il a la longueur suivante : 1324

Le fleuve : Seine
 traverse les pays suivants : France ; il a la longueur suivante : 776


********************************************************
*                                                      *
* Tous les pays avec provinces traversés par un fleuve *
*                                                      *
********************************************************

Le fleuve : Rhein
 traverse les pays suivants : Germany, France, Austria, Switzerland, Netherlands ; il a la longueur suivante : 1324

Le fleuve : Seine
 traverse les pays suivants : France ; il a la longueur suivante : 776

Le fleuve : Test, n'existe pas !


*************************************************************
*                                                           *
* Tous les pays avec les provinces traversées par un fleuve *
*                                                           *
*************************************************************

Le fleuve Rhein de longueur 1324 traverse les pays suivants : 
  - Germany, où il traverse les divisions administratives suivantes : 
      * Baden-Württemberg
      * Hessen
      * Nordrhein-Westfalen
      * Rheinland-Pfalz
  - Switzerland, où il traverse les divisions administratives suivantes : 
      * Aargau
      * Basel-Landschaft
      * Basel-Stadt
      * Graubünden
      * Sankt Gallen
      * Schaffhausen
      * Thurgau
      * Zürich
  - Liechtenstein
  - Austria, où il traverse les divisions administratives suivantes : 
      * Vorarlberg
  - France, où il traverse les divisions administratives suivantes : 
      * Alsace
  - Netherlands, où il traverse les divisions administratives suivantes : 
      * Gelderland
      * Zuid-Holland
      * Noord-Brabant

Le fleuve Seine de longueur 776 traverse les pays suivants : 
  - France, où il traverse les divisions administratives suivantes : 
      * Bourgogne
      * Haute-Normandie
      * Île-de-France
      * Champagne-Ardenne

Le fleuve : Test, n'existe pas !


******************************
*                            *
* Informations sur une ville *
*                            *
******************************

La ville Vaduz
 - se trouve dans le pays : Liechtenstein
 - sa latitude est : 47.14
 - sa longitude est : 9.52
 - son altitude est : 455
 - sa population est : 5241

La ville Paris
 - se trouve dans le pays : France
 - dans la division adminstrative : Île-de-France
 - sa latitude est : 48.86
 - sa longitude est : 2.35
 - son altitude est : 28
 - sa population est : 2249975

La ville Test, n'existe pas !
 */

