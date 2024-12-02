//  HB librement inspiré de
//  Data Abstraction & Problem Solving with C++: Walls and Mirrors
//  HB librement inspiré de
//  Data Abstraction & Problem Solving with C++: Walls and Mirrors
//  Frank M. Carrano and Tim Henry.
//  2013 – Pearson Education

/** TAD liste: Implémentation sous forme de liste chaînée.
    @file ListeChainee.h */

#ifndef _LISTE_CHAINEE
#define _LISTE_CHAINEE

#include <cassert>
#include <cstdlib>

#include "Shared/ListeInterface.h"
#include "Shared/Cellule.h"
#include "Shared/PrecondVioleeExcep.h"
#include "PileCellules.h"

using namespace std;

template<class TypeInfo>
class ListeChainee : public ListeInterface<TypeInfo> {
private:
    Cellule<TypeInfo> *ptrTete; // pointeur sur la première Cellule de la liste;
    int nbCellules; // nombre de cellules

    //------------------------------------------------------------
    // Section de méthodes utilitaires worker récursives :
    // Méthodes "helper" récursive pour les méthodes publiques.
    //------------------------------------------------------------

    void videRecWorker(Cellule<TypeInfo> *ptrCetteListe);

    bool estInfoPresentRecWorker(Cellule<TypeInfo>* ptrCetteListe, TypeInfo& infoCible) const;

    void insereAtPositRecWorker(Cellule<TypeInfo>*& ptrCetteListe, int nouvellePosition, const TypeInfo& nouvelleInfo);

    void supprimeAtPositRecWorker(Cellule<TypeInfo>*& ptrCetteListe, int position);

    TypeInfo getInfoAtPositRecWorker(const Cellule<TypeInfo>* ptrCetteListe, const int position) const;


    //------------------------------------------------------------
    // Section des méthodes "atomiques"
    //------------------------------------------------------------
    void insereTeteWorker(Cellule<TypeInfo> *&ptrCetteListe, const TypeInfo &nouvelleInfo);

    void supprimeTeteWorker(Cellule<TypeInfo> *&ptrCetteListe);

    //------------------------------------------------------------
    // Section des méthodes de parcours
    //------------------------------------------------------------
    void afficheGDWorker(const Cellule<TypeInfo>* ptrListe) const;

    void afficheDGWorker(const Cellule<TypeInfo>* ptrListe) const;

public:
    ListeChainee();

    ListeChainee(const ListeChainee<TypeInfo>& uneListeChainee);

    virtual ~ListeChainee();

    bool estVide() const;

    int getLongueur() const;

    void insereTete(const TypeInfo &nouvelleInfo);

    void supprimeTete();

    bool insereAtPositIter(const int nouvellePosition, const TypeInfo& nouvelleInfo);

    bool insereAtPositRec(const int nouvellePosition, const TypeInfo& nouvelleInfo);

    bool supprimeAtPositIter(const int position);

    bool supprimeAtPositRec(const int position);

    void videIter();

    void videRec();

    bool estInfoPresentRec(TypeInfo& infoCible) const;

    /* @throw PrecondVioleeExcep si position < 1 or
                               position > getLongueur(). */
    TypeInfo getInfoAtPositRec(const int position) const throw(PrecondVioleeExcep);

    // Affichage récursif de la liste ; parcours de gauche à droite
    void afficheGDRec();

    // Affichage récursif de la liste ; parcours de droite à gauche
    void afficheDGRec();

    // Affichage itératif de la liste ; parcours de gauche à droite
    void afficheGDIter() const;

    // Affichage itératif de la liste ; parcours de gauche à droite
    /*
     * POUR LA DERNIERE PARTIE DU TP
     */
    void afficheDGIter() const;

}; // end ListeChainee

/****************************************************************************
      CONSTRUCTEURS
 ****************************************************************************/

// Constructeur par défaut : fabrique une liste videRec de longueur 0
template<class TypeInfo>
ListeChainee<TypeInfo>::ListeChainee() : ptrTete(nullptr), nbCellules(0) {
    // appel des constructeurs de ptrTete et de nbCellules
    // rien à faire dans le corps
} // end constructeur par défaut

// Constructeur par copie : fabrique une nouvelle liste par copie de la liste passée en paramètre
template<class TypeInfo>
ListeChainee<TypeInfo>::ListeChainee(const ListeChainee<TypeInfo> &uneListeChainee) : nbCellules(uneListeChainee.nbCellules) {
    // le nombre de Cellules de cette liste est égal au nombre de Cellules le la liste copiée nbCellules(uneListeChainee.nbCellules)

    // construction de la copie
    // pointeur sur uneListeChainee pour la parcourir sans la détruire (const)
    Cellule<TypeInfo> *ptrListeOriginale = uneListeChainee.ptrTete;

    if (ptrListeOriginale == nullptr) {
        // La liste uneListeChainee est vide donc cette liste est videRec !
        ptrTete = nullptr;
    } else {
        // La liste uneListeChainee n'est pas videRec !

        // Copie de la première cellule
        ptrTete = new Cellule<TypeInfo>(); //création de la nouvelle liste avec le constructeur par défaut
        ptrTete->setInfo(ptrListeOriginale->getInfo()); //màj de info

        // Ou en une seule instruction avec le constructeur qui prend une information
        // ptrTete = new Cellule<TypeInfo>(ptrListeOriginale->getInfo());

        // Copie des cellules suivantes
        Cellule<TypeInfo> *ptrNouvelleListe = ptrTete; // pointeur sur la dernière cellule de la nouvelle liste
        ptrListeOriginale = ptrListeOriginale->getSuivante(); // avancer sur la liste originale
        // tant que la liste originale n'est pas videRec
        while (ptrListeOriginale != nullptr) {
            // obtenir l'information portée par la première cellule
            TypeInfo infoSuivante = ptrListeOriginale->getInfo();
            // créer une nouvelle cellule contenant l'infoSuivante
            Cellule<TypeInfo> *newCellulePtr = new Cellule<TypeInfo>(infoSuivante);
            // mettre à jour le suivant de la dernière cellule de la nouvelle liste
            ptrNouvelleListe->setSuivante(newCellulePtr);
            // mettre à jour le pointeur sur la dernière cellule de le nouvelle liste
            ptrNouvelleListe = ptrNouvelleListe->getSuivante();
            // avancer dans la liste originale
            ptrListeOriginale = ptrListeOriginale->getSuivante();
        } // end while

        ptrNouvelleListe->setSuivante(nullptr); // arrêter cette liste (la denière cellule n'a pas de successeur)
    } // end if
} // end constructeur par copie

/****************************************************************************
      DESTRUCTEUR
 ****************************************************************************/

/**
 * Destructeur non opérationnel tantque la suppression n'est pas implantée (videIter())
 * @tparam TypeInfo
 */
template<class TypeInfo>
ListeChainee<TypeInfo>::~ListeChainee() {
    // appel de la méthode de nettoyage
    //videIter();
} // end destructeur

/****************************************************************************
      METHODES UTILITAIRES PUBLIQUES
 ****************************************************************************/

template<class TypeInfo>
bool ListeChainee<TypeInfo>::estVide() const {
    // je suis videRec si je ne contiens aucune cellule
    return nbCellules == 0;
} // end estVide

template<class TypeInfo>
int ListeChainee<TypeInfo>::getLongueur() const {
    return nbCellules;
} // end getLongueur

template<class TypeInfo>
void ListeChainee<TypeInfo>::insereTete(const TypeInfo &nouvelleInfo) {
    // appel de l'insertion en tête dans la liste ptrTete
    insereTeteWorker(ptrTete, nouvelleInfo);
} // end insereTete

template<class TypeInfo>
void ListeChainee<TypeInfo>::supprimeTete() {
    // appel de l'insertion en tête dans la liste ptrTete
    supprimeTeteWorker(ptrTete);
} // end supprimeTete


template<class TypeInfo>
bool ListeChainee<TypeInfo>::insereAtPositIter(const int nouvellePosition, const TypeInfo &nouvelleInfo) {
    if(nouvellePosition >= 1 && nouvellePosition <= nbCellules+1)
    {
    Cellule<TypeInfo>** pplist = &ptrTete;
    int position = 1;
    while (position < nouvellePosition)
    {
        *pplist = pplist->getRefSuivante();
    }
    Cellule<TypeInfo> cel = new Cellule<TypeInfo>(nouvelleInfo, *pplist);
    *pplist = *cel;
    nbCellules++;
    return true;
    }

} // end inserePositIter

template<class TypeInfo>
bool ListeChainee<TypeInfo>::supprimeAtPositRec(int position) {
    // si insertion possible appeller insereAtPositRecProcWorker() qui met à jour cette liste
    bool insertionPossible = (position >= 1) && (position <= nbCellules + 1);
    if (insertionPossible) {
        // mise à jour de cette liste (ptrTete)
        supprimeAtPositRecWorker(ptrTete, position);
    } // end if

    return insertionPossible;
} // end insereAtPositRec

template<class TypeInfo>
bool ListeChainee<TypeInfo>::insereAtPositRec(int nouvellePosition, const TypeInfo &nouvelleInfo) {
    // si insertion possible appeller insereAtPositRecWorker() qui met à jour cette liste
    bool insertionPossible = (nouvellePosition >= 1) && (nouvellePosition <= nbCellules + 1);
    if (insertionPossible) {
        // mise à jour de cette liste (ptrTete)
        insereAtPositRecWorker(ptrTete, nouvellePosition, nouvelleInfo);
    } // end if

    return insertionPossible;
} // end insereAtPositRec

template<class TypeInfo>
bool ListeChainee<TypeInfo>::estInfoPresentRec(TypeInfo &infoCible) const {
    return estInfoPresentRecWorker(ptrTete, infoCible);
}

template<class TypeInfo>
TypeInfo ListeChainee<TypeInfo>::getInfoAtPositRec(const int position) const throw(class PrecondVioleeExcep) {
    // si insertion possible appeller getAtPositRecWorker() qui retourne la valeur à position
    bool accesPossible = (position >= 1) && (position <= nbCellules + 1);
    if (accesPossible) {
        // mise à jour de cette liste (ptrTete)
        return getInfoAtPositRecWorker(ptrTete, position);
    } else {
        string message = "setInfo() appellée pour une position invalide.";
        throw (PrecondVioleeExcep(message));
    }
}


// VERSION SANS CONTRÔLE AVANT : tous les contrôles sont inclus dans l'algorithme
template<class TypeInfo>
bool ListeChainee<TypeInfo>::supprimeAtPositIter(int position) {
    Cellule<TypeInfo> **ppliste = &this.ptrTete;
    int pcour = 1;
    while (pcour < pcour-1)
    {
        ppliste = &((*ppliste)->getRefSuivante());
        pcour++;
    }
    suprimeAtPositIterWorker(*ppliste);
} // end supprimeAtPositIter

// Utilisation du Worker récusif

template<class TypeInfo>
void ListeChainee<TypeInfo>::videRec() {
    videRecWorker(ptrTete);
    ptrTete = nullptr;
} // end videRec

// Version itérative supprimant en première position

template<class TypeInfo>
void ListeChainee<TypeInfo>::videIter() {
    while (!estVide())
        supprimeAtPositIter(1);
} // end videRec


/****************************************************************************
     METHODES PRIVEES RECURSIVES
 ****************************************************************************/

template<class TypeInfo>
void ListeChainee<TypeInfo>::videRecWorker(Cellule<TypeInfo> *ptrCetteListe) {
    // > ptrCetteListe == nullptr => rien {la liste est videRec} *
    // > ptrCetteListe != nullptr => supprimeTete(ptrCetteListe); nbcellules--; videRecWorker(ptrCetteListe);

    if (ptrCetteListe != nullptr) {
        // supprimer en tête
        supprimeTeteWorker(ptrCetteListe);
        nbCellules--;
        // vider la liste qui reste
        videRecWorker(ptrCetteListe);
    } // end if
} // end videRec

// Rappel
// @pre  position est le rang de la cellule sur laquelle on veut pointer;
//       position >= 1 and position <= itemCount.
// On est donc certain d'atteindre la position
template<class TypeInfo>
TypeInfo ListeChainee<TypeInfo>::getInfoAtPositRecWorker(const Cellule<TypeInfo>* ptrCetteListe, const int position) const {
    if (position == 1) {
        return ptrCetteListe->getInfo();
    } else {
        return getInfoAtPositRecWorker(ptrCetteListe->getSuivante(), position-1);
    }
}

template<class TypeInfo>
bool ListeChainee<TypeInfo>::estInfoPresentRecWorker(Cellule<TypeInfo> *ptrCetteListe, TypeInfo &infoCible) const {
    if(ptrCetteListe == nullptr)
        return false;
    else if(ptrCetteListe->getInfo() == infoCible)
        return true;
    else
        return estInfoPresentRecWorker(ptrCetteListe->getSuivante(), infoCible);
    // supprimer à partir d'ici après complétion
    return false;
}

// Rappel
// @pre  position est le rang de la cellule sur laquelle on veut pointer;
//       position >= 1 and position <= itemCount.
// On est donc certain de trouver pas besoin de considérer une liste videRec !
//
// Noter que le premier paramètre est une référence sur un pointeur

template<class TypeInfo>
void ListeChainee<TypeInfo>::insereAtPositRecWorker(Cellule<TypeInfo>*& ptrCetteListe, int nouvellePosition,
                                                        const TypeInfo& nouvelleInfo) {
    // > nouvellePosition = 1  =>
    //              insertête(ptrCetteListe, nouvelleInfo);
    // > nouvellePosition != 1 =>
    //              insereAtPositRecFuncWorker(ptrCetteListe->getRefSuivante(), nouvellePosition - 1, nouvelleInfo);

    if (nouvellePosition == 1) {
        //insertête
        insereTeteWorker(ptrCetteListe, nouvelleInfo);
    } else {
        insereAtPositRecWorker(ptrCetteListe->getRefSuivante(), nouvellePosition - 1, nouvelleInfo);
    }
} // end insereAtPositRecProcWorker

// Rappel
// @pre  position est le rang de la cellule que l'on veut supprimer;
//       position >= 1 and position <= itemCount.
// On est donc certain de trouver pas besoin de considérer une liste videRec !
//
// Noter que le premier paramètre est une référence sur un pointeur qui n'est pas const donc un paramètre résultat
template<class TypeInfo>
void ListeChainee<TypeInfo>::supprimeAtPositRecWorker(Cellule<TypeInfo>*& ptrCetteListe, int position) {
    if(position == 1)
    {
        supprimeTeteWorker(ptrCetteListe);
    }else
    {
        supprimeAtPositRecWorker(ptrCetteListe->getRefSuivante(), position-1);
    }
} // end supprimeAtPositRecProcWorker

/****************************************************************************
     METHODES PRIVEES ATOMIQUES
 ****************************************************************************/

template<class TypeInfo>
void ListeChainee<TypeInfo>::insereTeteWorker(Cellule<TypeInfo> *&ptrCetteListe, const TypeInfo &nouvelleInfo) {
    // création d'une cellule contenant la nouvelleInfo
    Cellule<TypeInfo> *ptrNouvelleCellule = new Cellule<TypeInfo>(nouvelleInfo);

    // la cellule suivante de cette cellule est la tête actuelle
    ptrNouvelleCellule->setSuivante(ptrCetteListe);

    // la nouvelle cellule de tête est la cellule contenant nouvelleInfo
    // MODIFICATION du paramètre résultat
    ptrCetteListe = ptrNouvelleCellule;

    nbCellules++; //une nouvelle cellule
} // end insereTeteWorker

template<class TypeInfo>
void ListeChainee<TypeInfo>::supprimeTeteWorker(Cellule<TypeInfo> *&ptrCetteListe) {
    //  pointeur temporaire sur la première cellule
    Cellule<TypeInfo> *ptrCelluleASupprimer = ptrCetteListe;
    // si la liste n'est pas videRec
    if (ptrCetteListe) {
        // la cellule suivante de la première cellule devient la nouvelle première cellule
        // MODIFICATION du paramètre résultat
        ptrCetteListe = ptrCetteListe->getSuivante();
        // rendre au tas la cellule à supprimer
        ptrCelluleASupprimer->setSuivante(nullptr);
        delete ptrCelluleASupprimer;
        ptrCelluleASupprimer = nullptr;
        nbCellules--; // une cellule en moins
    }
    // si la liste est déjà videRec, ne rien faire
} // end supprimeTeteWorker

/****************************************************************************
     METHODES PRIVEES D'AFFICHAGE
 ****************************************************************************/
template<class TypeInfo>
void ListeChainee<TypeInfo>::afficheGDWorker(const Cellule<TypeInfo> *ptrListe) const {
    if (ptrListe) {
        cout << ptrListe->getInfo() << " ";
        afficheGDWorker(ptrListe->getSuivante());
    }
    // sinon rien à faire, donc on en fait rien !!!
}

template<class TypeInfo>
void ListeChainee<TypeInfo>::afficheDGWorker(const Cellule<TypeInfo> *ptrListe) const {
    if (ptrListe) {
        afficheDGWorker(ptrListe->getSuivante());
        cout << ptrListe->getInfo() << " ";
    }
    // sinon rien à faire, donc on ne fait rien !!
}



/****************************************************************************
     METHODES PUBLIQUES D'AFFICHAGE qui font appel à un Worker
 ****************************************************************************/

template<class TypeInfo>
void ListeChainee<TypeInfo>::afficheGDRec() {
    cout << "En parcours récursif de gauche à droite, la liste contient -> ";
    afficheGDWorker(ptrTete);
    cout << endl;
}

template<class TypeInfo>
void ListeChainee<TypeInfo>::afficheDGRec() {
    cout << "En parcours récursif de droite à gauche, la liste contient -> ";
    afficheDGWorker(ptrTete);
    cout << endl;
}

template<class TypeInfo>
void ListeChainee<TypeInfo>::afficheGDIter() const {
    cout << "En parcours itératif de gauche à droite, la liste contient -> ";
    Cellule<TypeInfo> *ptrCellCour = ptrTete;
    while (ptrCellCour) {
        cout << ptrCellCour->getInfo() << " ";
        ptrCellCour = ptrCellCour->getSuivante();
    }
    cout << endl;
}

/*
 * POUR LA DERNIERE PARTIE DU TP
 */
template<class TypeInfo>
void ListeChainee<TypeInfo>::afficheDGIter() const {
    cout << "En parcours itératif de droite à gauche, la liste contient -> ";
    /*
     * A COMPLETER
     */
    cout << endl;
}

//  Fin implementation de la classe ListeChainee.


#endif 
