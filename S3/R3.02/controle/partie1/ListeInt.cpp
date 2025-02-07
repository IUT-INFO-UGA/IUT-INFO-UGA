#include "ListeInt.h"
#include <iostream>
#include <string>
using namespace std;

/*
 **********************************************************************************
 * PARTIE 1 - A COMPLETER
 **********************************************************************************
 */

int ListeInt::nbPairsRec() const {
    /*
     * EXERCICE 1 : METHODE FOURNIE, NE PAS MODIFIER
     */
    return nbPairsRecWorker(ptrTete);
}

int ListeInt::nbPairsRecWorker(const CellInt *ptrCetteListe) const {
    if(ptrCetteListe == nullptr)
        return 0;
    else if(ptrCetteListe->getInfo()%2==0)
        return nbPairsRecWorker(ptrCetteListe->getSuivante())+1;
    else
        return nbPairsRecWorker(ptrCetteListe->getSuivante());
}


bool ListeInt::estAlterneeRec() const {
    /*
     * EXERCICE 2 A COMPLETER
     */
    if(ptrTete == nullptr || ptrTete->getInfo()==NULL)
        return true;
    if(ptrTete->getInfo()%2==0)
        return estAlterneeRecWorker(ptrTete->getSuivante(), "impaire");
    else
        return estAlterneeRecWorker(ptrTete->getSuivante(), "paire");
}

bool ListeInt::estAlterneeRecWorker(const CellInt *ptrCellCour, const string attendu) const {
    /*
     * EXERCICE 2 A COMPLETER
     */
    if(ptrCellCour==nullptr)
        return true;
    else if(attendu=="impaire")
    {
        if(ptrCellCour->getInfo()%2==0)
            return false;
        else
            return estAlterneeRecWorker(ptrCellCour->getSuivante(), "paire");
    }
    else
    {
        if(ptrCellCour->getInfo()%2!=0)
            return false;
        else
            return estAlterneeRecWorker(ptrCellCour->getSuivante(), "impaire");
    }
}

/*
 **********************************************************************************
 * NE PAS MODIFIER CE QUI SUIT
 **********************************************************************************
 */

ListeInt::ListeInt() : ptrTete(nullptr) {
}

ListeInt::ListeInt(const ListeInt &orig) {
    // construction de la copie
    // pointeur sur uneListeChainee pour la parcourir sans la détruire (const)
    CellInt *ptrListeOriginale = orig.ptrTete;

    if (ptrListeOriginale == nullptr) {
        // La liste uneListeChainee est vide donc cette liste est vide !
        ptrTete = nullptr;
    } else {
        // La liste uneListeChainee n'est pas vide !

        // Copie de la première cellule
        ptrTete = new CellInt(); //création de la nouvelle liste avec le constructeur par défaut
        ptrTete->setInfo(ptrListeOriginale->getInfo()); //màj de info

        // Ou en une seule instruction avec le constructeur qui prend une information
        // ptrTete = new Cellule<TypeInfo>(ptrListeOriginale->getInfo());

        // Copie des cellules suivantes
        CellInt *ptrNouvelleListe = ptrTete; // pointeur sur la dernière cellule de la nouvelle liste
        ptrListeOriginale = ptrListeOriginale->getSuivante(); // avancer sur la liste originale
        // tant que la liste originale n'est pas vide
        while (ptrListeOriginale != nullptr) {
            // obtenir l'information portée par la première cellule
            int infoSuivante = ptrListeOriginale->getInfo();
            // créer une nouvelle cellule contenant l'infoSuivante
            CellInt *newCellulePtr = new CellInt(infoSuivante);
            // mettre à jour le suivant de la dernière cellule de la nouvelle liste
            ptrNouvelleListe->setSuivante(newCellulePtr);
            // mettre à jour le pointeur sur la dernière cellule de le nouvelle liste     
            ptrNouvelleListe = ptrNouvelleListe->getSuivante();
            // avancer dans la liste originale
            ptrListeOriginale = ptrListeOriginale->getSuivante();
        } // end while

        ptrNouvelleListe->setSuivante(nullptr); // arrêter cette liste (la denière cellule n'a pas de successeur)
    } // end if
}

ListeInt::~ListeInt() {
}

//Présent uniquement pour fabriquer une liste dans le test

void ListeInt::insereTete(int nouvelleInfo) {
    // appel de l'insertion en tête dans la liste ptrTete
    insereTeteWorker(ptrTete, nouvelleInfo);
}

void ListeInt::insereTeteWorker(CellInt *&ptrTete, int nouvelleInfo) {
    // création d'une cellule contenant la nouvelleInfo
    CellInt *ptrNouvelleCellule = new CellInt(nouvelleInfo);

    // la cellule suivante de cette cellule est la tête actuelle
    ptrNouvelleCellule->setSuivante(ptrTete);

    // la nouvelle cellule de tête est la cellule contenant nouvelleInfo
    // MODIFICATION du paramètre résultat
    ptrTete = ptrNouvelleCellule;
}

void ListeInt::afficheGD() {
    // affichage du premier seul puis -> suivante (dans le worker)
    if (ptrTete != nullptr) {
        cout << ptrTete->getInfo();
        afficheGDWorker(ptrTete->getSuivante());
    }
}

void ListeInt::afficheGDWorker(CellInt *ptrListe) {
    if (ptrListe) {
        cout << " -> " << ptrListe->getInfo();
        afficheGDWorker(ptrListe->getSuivante());
    }
    // sinon rien à faire, donc on en fait rien !!! 
}
