
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
    
    void Print();

    virtual ~Mondial();
    
    /**
     * MÉTHODES PUBLIQUES À ÉCRIRE
     */
    
    /**
     * Code d'une île étant donné son nom
     * @param islandName : nom de l'île
     * @return code de islandName, exception sinon
     */
    string getIslandCodeFromName(const string& islandName) const; // throw (PrecondVioleeExcep)
    
    /**
     * Affichage des informations relatives à islandName
     * @param islandName
     */
    void printInfoIslandFromName(const string& islandName) const;
    
    /**
     * Affichage des îles faisant partie du même archipel que islandName, ou message pertinent
     * @param islandName
     */
    void printIslandsInSameArchipelago(const string& islandName) const;
    
    /**
     * Affichage des îles bordées uniquement par seaCode
     * @param seaCode
     * @pre seaCode existe dans Mondial
     */
    void printIslandBorderedExculivelyByOneSea(const string& seaCode) const;
    
    /**
     * Affichage des îles bordées partiellmenent par seaCode et affichage des mers ou océans à l'entour
     * @param countryCode
     * @pre seaCode existe dans Mondial
     */
    void printIslandBorderedExclusivelyOrNotByOneSea(const string& seaCode) const;

private:
    // Un XMLDOcument permet d'accéder à toutes les fonctionnalités de la bibliothèque
    // Il peut être sauveagrdé, chargé, et affiché à l'écran.
    // Tous les noeuds sont connectés et aloués à un document.
    // Si le document est supprimé, tous ses noeuds sont aussi supprimés.
    XMLDocument imageMondial;
    // XMLElement est une classe container.
    // Un element possède une valeur, un nom et peut contenir d'autres éléments, du texte, des commentaires, des inconnus
    // Un élément peut contenir un nombre arbitraire d'attributs    
    // racineMondial est un élément de la classe <mondial> qui permet de parcourir les entrées familles d'éléments pays, fleuves, ...
    XMLElement* racineMondial;
    
    // Procédures de découpage des chaînes en mots

    template<typename Out>
    void split(string& s, char delim, Out result) const;

    vector<std::string> split(const string& s, char delim) const;
    
    /**
     * MÉTHODES PRIVEES À ÉCRIRE
     */
    
    /**
     * XMLElement <island> correspondant à islandName
     * @param islandName 
     * @return 
     */
    XMLElement* getIslandXmlelementFromName(const string& islandName) const;

};

#endif /* MONDIAL_H */

