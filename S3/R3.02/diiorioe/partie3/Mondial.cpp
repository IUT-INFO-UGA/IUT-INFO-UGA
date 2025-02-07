
#include "Mondial.h"
#include <iostream>     // pour cout
#include <iomanip>      // pour setw()
#include <limits>       // pour numeric_limits<unsigned int>::max
#include <sstream>
#include <iterator>
using namespace std;

/*
 **********************************************************************************
 * PARTIE 3 - A COMPLETER
 **********************************************************************************
 */


XMLElement* Mondial::getIslandXmlelementFromName(const string& islandName) const {
    XMLElement* island = racineMondial->FirstChildElement("islandscategory")->FirstChildElement("island");
    while (island != nullptr && island->FirstChildElement("name")->GetText() != islandName && island->Attribute("sea")!=nullptr)
    {
        island = island->NextSiblingElement("island");
    }
    return island;
}


string Mondial::getIslandCodeFromName(const string& islandName) const { // throw (PrecondVioleeExcep) 
    XMLElement* island = racineMondial->FirstChildElement("islandscategory")->FirstChildElement("island");
    while (island != nullptr && island->FirstChildElement("name")->GetText() != islandName && island->Attribute("sea")!=nullptr)
    {
        island = island->NextSiblingElement("island");
    }
    if(island == nullptr)
        throw PrecondVioleeExcep("island not found");
    return island->Attribute("id");
}

void Mondial::printInfoIslandFromName(const string& islandName) const {
    XMLElement* island = getIslandXmlelementFromName(islandName);
    if(island == nullptr)
    {
        cout << "L'île "<< islandName << " n'existe pas !" << endl;
        return;
    }
    else
    {
        XMLElement* area        = island->FirstChildElement("area");
        XMLElement* Latitude    = island->FirstChildElement("latitude");
        XMLElement* Longitude   = island->FirstChildElement("longitude");
        XMLElement* elevation   = island->FirstChildElement("elevation");
        XMLElement* archipel    = island->FirstChildElement("islands");
        string text = "Informations sur l'île :"+islandName+"\n";
        if(archipel)
        {
            text += " - archipel: ";
            text += archipel->GetText();
            text += "\n";
        }
        if(area)
        {
            text += " - latitude: ";
            text += area->GetText();
            text += "\n";
        }
        if(Latitude)
        {
            text += " - longitude: ";
            text += Latitude->GetText();
            text += "\n";
        }
        if(Longitude)
        {
            text += " - elevation: ";
            text += Longitude->GetText();
            text += "\n";
        }
        if(elevation)
        {
            text += " - Élévation: ";
            text += elevation->GetText();
            text += "\n";
        }

        cout << text << endl;
    }

}

void Mondial::printIslandsInSameArchipelago(const string& islandName) const {
    // on ne peut pas utiliser la fonction car Hokkaido doit aparaitre mais n'est pas entouré de mer ou d'ocean
    XMLElement* island = racineMondial->FirstChildElement("islandscategory")->FirstChildElement("island");
    while (island != nullptr && island->FirstChildElement("name")->GetText() != islandName)
    {
        island = island->NextSiblingElement("island");
    }
    if(island == nullptr)
    {
        cout << "L'île "<< islandName << " n'existe pas !" << endl;
        return;
    }
    XMLElement* archipel = island->FirstChildElement("islands");
    if(archipel == nullptr)
    {
        cout << "L'île "<< islandName << " ne fait pas partie d'un archipel !" << endl;
        return;
    }

    cout << "L'île "<< islandName << " fait partie de l'archipel: "<<archipel->GetText() << endl;
    XMLElement* otherIsland = racineMondial->FirstChildElement("islandscategory")->FirstChildElement("island");
    //on parcours toutes les iles
    cout <<"Les îles qui font partie de cet archipel sont : "<<endl;
    while (otherIsland != nullptr)
    {
        XMLElement* Marchipel = otherIsland->FirstChildElement("islands");
        //on check les attendus
        if(Marchipel!=nullptr && (archipel->GetText() == Marchipel->GetText()))
        {
            cout << " - " << otherIsland->FirstChildElement("name")->GetText() << endl;
        }
        otherIsland = otherIsland->NextSiblingElement("island");
    }
}

void Mondial::printIslandBorderedExculivelyByOneSea(const string& seaCode) const {
    XMLElement* island = racineMondial->FirstChildElement("islandscategory")->FirstChildElement("island");
    cout << "Îles bordées uniquement par la mer "<<seaCode<<endl;
    bool find = false;
    while (island != nullptr)
    {
        if(island->Attribute("sea")!=nullptr && island->Attribute("sea")== seaCode)
        {
            find = true;
            cout << island->FirstChildElement("name")->GetText() << endl;
        }
        island = island->NextSiblingElement("island");
    }
    if(find == false)
        cout << "  - Cette mer ne borde de manière excusive aucune île !"<<endl;
}

void Mondial::printIslandBorderedExclusivelyOrNotByOneSea(const string& seaCode) const {
    XMLElement* island = racineMondial->FirstChildElement("islandscategory")->FirstChildElement("island");
    cout << "Îles bordées par la mer "<<seaCode<<" et au moins une autre :"<<endl;
    bool find = false;
    while (island != nullptr)
    {
        //on conveti en string
        const char* sea = island->Attribute("sea");
        string text = sea==nullptr ? "": sea;
        //on cherche dans la string et on verifie qu'il y a pas une corespndance parfaite
        if(sea!=nullptr && text.find(seaCode)!=string::npos && text != seaCode)
        {
            find = true;
            cout <<"– L'île "<< island->FirstChildElement("name")->GetText() <<" est bordée par " << text << endl;
        }
        island = island->NextSiblingElement("island");
    }
    if(find == false)
        cout << "  - Cette mer ne borde de manière excusive aucune île !"<<endl;
}

/*
 **********************************************************************************
 * NE PAS MODIFIER CE QUI SUIT
 **********************************************************************************
 */

Mondial::Mondial(const char* filename) {
    // Chargement du fichier XML en mémoire
    imageMondial.LoadFile(filename);
    // Initialisation de l'attribut racineMondial avec la racine (élément <mondial>)
    racineMondial = imageMondial.FirstChildElement();
}

void Mondial::Print() {
    imageMondial.Print();
}

template<typename Out>
void Mondial::split(string& s, char delim, Out result) const {
    stringstream ss(s);
    string item;
    while (getline(ss, item, delim)) {
        *(result++) = item;
    }
}

vector<std::string> Mondial::split(const string & s, char delim) const {
    vector<std::string> elems;
    string s2;
    split(s2, delim, back_inserter(elems));
    return elems;
}

Mondial::~Mondial() {
}
