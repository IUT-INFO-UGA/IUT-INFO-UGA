//  HB librement inspiré de
//  Data Abstraction & Problem Solving with C++: Walls and Mirrors
//  Frank M. Carrano and Tim Henry.
//  2013 – Pearson Education

/** implantation des arbres binaires de recherche avec des noeuds chaînés
 @file ArbreNoeudsBinaireRecherche.h */

#ifndef ARBRE_NOEUDS_BINAIRES_RECHERCHE
#define ARBRE_NOEUDS_BINAIRES_RECHERCHE

#include "ArbreBinaireInterface.h"
#include "NoeudBinaire.h"
#include "ExceptionPrecontionViolee.h"

#include <fstream>
#include <iostream>
#include <deque>
#include <iomanip>
#include <sstream>
#include <string>
#include <math.h>


template<class TypeInfo>
class ArbreNoeudBinaireRecherche : public ArbreBinaireInterface<TypeInfo> {
private:
    NoeudBinaire<TypeInfo>* ptrRacine;

    //------------------------------------------------------------
    // Méthodes utilitaires privées :
    // Worker (qui fait le travail) d'une méthode publique.
    //------------------------------------------------------------

    // Calcul récursif de la hauteur de cet ABR.
    int getHauteurRecWorker(NoeudBinaire<TypeInfo>* ptrRac) const;
    
    // Calcul récursif du nombre de noeuds de cet ABR.
    int getNombreDeNoeudsRecWorker(NoeudBinaire<TypeInfo>* ptrRac) const;
    
    TypeInfo getAncetreCommunLePlusBasRecWorker(const NoeudBinaire<TypeInfo>* ptrRac, const TypeInfo val1, const TypeInfo val2) const;

    // Suppression récursive de tous le noeuds de cet ABR.
    void videWorker(NoeudBinaire<TypeInfo>* ptrRac);

    // recherche récursive de la place où insérer ptrNouveauNoeud dans
    // ptrRac qui est un ABR et insertion à cette place.
    // on obtient un ABR
    void insertRecWorker(NoeudBinaire<TypeInfo>*& ptrRac, const TypeInfo& nouvelleInfo);

    // supprime l'information infoCible de ptrRac qui est ABR.
    // on obtient un ABR
    // suppressionPossible est vrai si la suppression a eu lieu
    // supprime l'information infoCible de ptrRac qui est ABR.
    // on obtient un ABR
    // suppressionPossible est vrai si la suppression a eu lieu
    NoeudBinaire<TypeInfo>* supprimeInfo(NoeudBinaire<TypeInfo>* ptrRac,
            const TypeInfo infoCible,
            bool& suppressionPossible);

    // supprime un noeud (ptrNoeud) de cet ABR.
    // on obtient un ABR
    NoeudBinaire<TypeInfo>* supprimeNoeud(NoeudBinaire<TypeInfo>* ptrNoeud);

    // Supprime le noeud le plus à gauche dans la sous arbre gauche de ptrRac.
    // donne la valeur de successeurLePlusProche (à droite) à ce noeud.
    // retourne un pointeur sur le sous arbre modifié
    NoeudBinaire<TypeInfo>* supprimeNoeudLePlusAGauche(NoeudBinaire<TypeInfo>* ptrRac, TypeInfo& successeurLePlusProche);
    
    // retourne un pointeur sur le noeuds l'ABR ptrABR qui contient infoCible,
    // nullptr si infoCible non trouvée.
    bool estInfoPresenteRecWorker(NoeudBinaire<TypeInfo>* ptrABR, const TypeInfo& infoCible) const;

    // copie l'ABR de rachine ptrABR et retourne un pointeur sur la copie.
    NoeudBinaire<TypeInfo>* copieArbre(const NoeudBinaire<TypeInfo>* ptrABR) const;
    
    // workers pour l'affichage récursif
    void affichePrefixeWorker(const NoeudBinaire<TypeInfo>* ptrRac) const;
    void afficheInfixeWorker(const NoeudBinaire<TypeInfo>* ptrRac) const;
    void affichePostfixeWorker(const NoeudBinaire<TypeInfo>* ptrRac) const;
    
    bool aMemeGeometrieQueRecWorker(const NoeudBinaire<TypeInfo>* monPtrRac, const NoeudBinaire<TypeInfo>* sonPtrRac) const;
    bool estEgalARecWorker(const NoeudBinaire<TypeInfo>* monPtrRac, const NoeudBinaire<TypeInfo>* sonPtrRac) const;

    bool aPourSousArbreRecWorker(const NoeudBinaire<TypeInfo>* ptrRacCetArbre, const NoeudBinaire<TypeInfo>* ptrRacUnArbre) const;

    TypeInfo getMaxRecWorker(const NoeudBinaire<TypeInfo>* ptrRac) const;

    // workers pour printPretty (l'implantation est fournie)
    int maxHeight(NoeudBinaire<TypeInfo>* p);
    
    string my2String(TypeInfo val);
    
    void printBranches(int branchLen, int nodeSpaceLen, int startLen, int nodesInThisLevel, const deque<NoeudBinaire<TypeInfo>*>& nodesQueue, ostream& out);
    
    void printNodes(int branchLen, int nodeSpaceLen, int startLen, int nodesInThisLevel, const deque<NoeudBinaire<TypeInfo>*>& nodesQueue, ostream& out);
    
    void printLeaves(int indentSpace, int level, int nodesInThisLevel, const deque<NoeudBinaire<TypeInfo>*>& nodesQueue, ostream& out);


public:
    //------------------------------------------------------------
    // Constructeurs et destructeurs
    //------------------------------------------------------------
    ArbreNoeudBinaireRecherche();
    ArbreNoeudBinaireRecherche(const TypeInfo& infoRacine);
    ArbreNoeudBinaireRecherche(const ArbreNoeudBinaireRecherche<TypeInfo>& arbreOriginal);
    virtual ~ArbreNoeudBinaireRecherche();

    //------------------------------------------------------------
    // Méthodes publiques
    //------------------------------------------------------------
    bool estVide() const;
    int getHauteur() const;
    int getNombreDeNoeuds() const;
    TypeInfo getInfoRacine() const;
    void insere(const TypeInfo& nouvelleInfo);
    bool supprime(const TypeInfo& uneInfo);
    void vide();
    bool estInfoPresente(const TypeInfo& uneInfo) const;
    TypeInfo getAncetreCommunLePlusBas(const TypeInfo val1, const TypeInfo val2) const;
    
    //------------------------------------------------------------
    // Méthodes publiques RECURSIVES pédagogiques
    //------------------------------------------------------------

    /**
     *
     * @param unArbre
     * @return true si unArbre est un sous-arbre de cet Arbre
     */
    bool aPourSousArbre(const ArbreNoeudBinaireRecherche<TypeInfo>& unArbre) const;
    bool estPliable() const;
    bool estPliableRecWorker(const NoeudBinaire<TypeInfo>* monPtrRac, const NoeudBinaire<TypeInfo>* sonPtrRac) const;
    /**
     * cet arbre a-t-il la même géométrie que l'autreArbre
     * @param autreArbre
     * @return  true les cet arbre et autreArbre ont la même géométrie ; false sinon
     */
    bool aMemeGeometrieQue(const ArbreNoeudBinaireRecherche<TypeInfo>& autreArbre) const;
    
    /**
     * retourne une exception si l'arbre est vide
     * @return  la plus grand information contenue dans cet arbre
     */
    TypeInfo getMax() const;

    //------------------------------------------------------------
    // Méthodes publiques d'affichage
    //------------------------------------------------------------
    void affichePrefixe() const;
    void affichePostfixe() const;
    void afficheInfixe() const;


    //------------------------------------------------------------
    // Opérateur surchargé
    //------------------------------------------------------------
    // On surchagre ici l'opérateur d'affectation nouvelArbre = arbreExistant;
    // nouvelArbre est une copie de arbreExistant
    ArbreNoeudBinaireRecherche<TypeInfo>& operator=(const ArbreNoeudBinaireRecherche<TypeInfo>& rightHandSide);
    
    
    //------------------------------------------------------------
    // Méthode publique d'affichage vertical (fournie)
    //------------------------------------------------------------
    void printPretty(int level, int indentSpace, ostream& out);


}; // end ArbreBinaireRecherche

//////////////////////////////////////////////////////////////
//
//      METHODES UTILITAIRES PRIVEES
//
//////////////////////////////////////////////////////////////
#include <algorithm>
template<class TypeInfo>
int ArbreNoeudBinaireRecherche<TypeInfo>::getHauteurRecWorker(NoeudBinaire<TypeInfo>* ptrRac) const {
    if(ptrRac==nullptr)
        return 0;
    else
        return 1 + std::max(getHauteurRecWorker(ptrRac->getPtrFilsDroit()), getHauteurRecWorker(ptrRac->getPtrFilsDroit()));
} // end getHauteurRecWorker

template<class TypeInfo>
int ArbreNoeudBinaireRecherche<TypeInfo>::getNombreDeNoeudsRecWorker(NoeudBinaire<TypeInfo>* ptrRac) const {
    // on applique directement la définition récursive
    // > ptrRac == null -> return 0 ; l'arbre vide ne contient aucun noeud
    // > ptrRac != null -> return 1 + getNombreDeNoeudsWorker(sous-arbre gauche) + getNombreDeNoeudsRecWorker(sous-arbre droit));
    if (ptrRac == nullptr) {
        return 0;
    } else {
        return 1 + getNombreDeNoeudsRecWorker(ptrRac->getPtrFilsGauche())
               + getNombreDeNoeudsRecWorker(ptrRac->getPtrFilsDroit());
    }
} // end getNombreDeNoeudsRecWorker

template<class TypeInfo>
void ArbreNoeudBinaireRecherche<TypeInfo>::videWorker(NoeudBinaire<TypeInfo>* ptrRac) {
    // on applique directement la définition récursive
    // Note, il faut faire un parcours postfixé !!!!!
    // > ptrRac == null -> rien à faire !
    // > ptrRac != null -> vider(sous-arbre gauche); vider(sous-arbre droit); libérer(ptrRac)
    if (ptrRac != nullptr) {
        videWorker(ptrRac->getPtrFilsGauche());
        videWorker(ptrRac->getPtrFilsDroit());
        delete ptrRac;
    } // end if
} // end videWorker

template<class TypeInfo>
NoeudBinaire<TypeInfo>* ArbreNoeudBinaireRecherche<TypeInfo>::copieArbre(const NoeudBinaire<TypeInfo>* ptrABR) const {
    // initialiser la copie avec un arbre vide
    NoeudBinaire<TypeInfo>* ptrCopieABR = nullptr;

    // copier les noeuds de ptrABR dans la copie en faisant un parcours
    // récursif préfixé (racine, gauche, droite) de ptrABR
    if (ptrABR != nullptr) {
        // Copy node
        ptrCopieABR = new NoeudBinaire<TypeInfo>(ptrABR->getInfo(), nullptr, nullptr);
        ptrCopieABR->setPtrFilsGauche(copieArbre(ptrABR->getPtrFilsGauche()));
        ptrCopieABR->setPtrFilsDroit(copieArbre(ptrABR->getPtrFilsDroit()));
    } // end if
    // rendre la copie
    return ptrCopieABR;
} // end copieArbre

template<class TypeInfo>
void ArbreNoeudBinaireRecherche<TypeInfo>::insertRecWorker(NoeudBinaire<TypeInfo>*& ptrRac, const TypeInfo& nouvelleInfo) {
    if(ptrRac==nullptr)
    {
        ptrRac = new NoeudBinaire<TypeInfo>(nouvelleInfo);
    }
    else if(ptrRac!=nullptr && nouvelleInfo>ptrRac->getInfo())
        insertRecWorker(ptrRac->getRefPtrFilsDroit(), nouvelleInfo);
    else
        insertRecWorker(ptrRac->getRefPtrFilsGauche(), nouvelleInfo);

} // end insertRecWorker

template<class TypeInfo>
TypeInfo ArbreNoeudBinaireRecherche<TypeInfo>::getAncetreCommunLePlusBasRecWorker(const NoeudBinaire<TypeInfo>* ptrRac,
                                                                                  const TypeInfo val1, const TypeInfo val2) const {

    if(val1<=ptrRac->getInfo() && val2>ptrRac->getInfo()){
        return ptrRac->getInfo();
    }
    if (val1 <= ptrRac->getInfo() && val2 < ptrRac->getInfo() ) {
        return getAncetreCommunLePlusBasRecWorker(ptrRac->getPtrFilsGauche(), val1, val2);
    }
    if (val1 > ptrRac->getInfo()  && val2 > ptrRac->getInfo() ) {
        return getAncetreCommunLePlusBasRecWorker(ptrRac->getPtrFilsDroit(), val1, val2);
    }

}

/**
 *
 * @param val1 est dans l'arbre
 * @param val2 est dans l'arbre
 * @pre val1 <= val2
 * @return l'ancêtre commun le plus bas
 */
template<class TypeInfo>
TypeInfo ArbreNoeudBinaireRecherche<TypeInfo>::getAncetreCommunLePlusBas(const TypeInfo val1, const TypeInfo val2) const {
    return getAncetreCommunLePlusBasRecWorker(ptrRacine, val1, val2);
}

template<class TypeInfo>
NoeudBinaire<TypeInfo>* ArbreNoeudBinaireRecherche<TypeInfo>::supprimeInfo(
        NoeudBinaire<TypeInfo>* ptrRac,
        const TypeInfo infoCible,
        bool& suppressionPossible) {
    // On applique la définiton décursive de la suppression
    if (ptrRac == nullptr) {
        // arbre vide, on ne peut pas supprimer, l'arbre résutlat est vide aussi
        suppressionPossible = false;
    } else if (ptrRac->getInfo() == infoCible) {
        // infoCible est à la racine de l'arbre
        ptrRac = supprimeNoeud(ptrRac);
        suppressionPossible = true;
    } else if (ptrRac->getInfo() > infoCible) {
        // supprimer dans le sous-arbre gauche
        ptrRac->setPtrFilsGauche(supprimeInfo(ptrRac->getPtrFilsGauche(), infoCible, suppressionPossible));
    } else {
        // upprimer dans le sous-arbre droit
        ptrRac->setPtrFilsDroit(supprimeInfo(ptrRac->getPtrFilsDroit(), infoCible, suppressionPossible));
    } // end if
    return ptrRac;
} // end supprimeInfo

template<class TypeInfo>
NoeudBinaire<TypeInfo>* ArbreNoeudBinaireRecherche<TypeInfo>::supprimeNoeud(NoeudBinaire<TypeInfo>* ptrNoeud) {
    // Cas 1) ptrNoeud est une feuille - il est supprimé, l'arbre est vide
    // Cas 2) ptrNoeud a un seul sous-arbre - le parent adopte ce sous-arbre
    // Cas 3) ptrNoeud a deux sous-arbres :
    //               implémentation traditionnelle : trouver le noeud successeur.
    //               implémentation alternative : trouver la valeur successeur et remplacer la valeur du noeud ;
    //                  cette approche ne requière pas un passage par référence
    if (ptrNoeud->estFeuille()) {
        delete ptrNoeud;
        return (ptrNoeud = nullptr); // affectation et retour
    } else if (ptrNoeud->getPtrFilsGauche() == nullptr) { // un sous-arbre droit uniquement
        // récupérer le sous-arbre droit
        NoeudBinaire<TypeInfo>* prtNoeudAConnecter = ptrNoeud->getPtrFilsDroit();
        // supprimer le noeud
        delete ptrNoeud;
        ptrNoeud = nullptr;
        // retourner le sous-arbre droit (adoption)
        return prtNoeudAConnecter;
    } else if (ptrNoeud->getPtrFilsDroit() == nullptr) { // un sous-arbre gauche uniquement
        // récupérer le sous-arbre gauche
        NoeudBinaire<TypeInfo>* prtNoeudAConnecter = ptrNoeud->getPtrFilsGauche();
        // supprimer le noeud
        delete ptrNoeud;
        ptrNoeud = nullptr;
        // retourner le sous-arbre gauche
        return prtNoeudAConnecter;
    } else { // deux sous arbres !!
        // APPROCHE TRADITIONNELLE pour supprimer une valeur sur un noeud avec deux sous-arbres
        // besoin d'une nouvelle info -> PASSAGE PAR REFERENCE !!! dans supprimeNoeudLePlusAGauche infra
        TypeInfo valeurNouveauNoeud;
        // le sous-arbre droit est le sous-arbre droit privé de son noeud le plus à gauche
        ptrNoeud->setPtrFilsDroit(supprimeNoeudLePlusAGauche(ptrNoeud->getPtrFilsDroit(), valeurNouveauNoeud));
        // le sous-arbre gauche est inchangé !
        // l'info portée par le noeud est l'info portée par le noeud le plus à gauche du sous-arbre droit que l'on vient de supprimer
        ptrNoeud->setInfo(valeurNouveauNoeud);
        // retourner le nouveau noeud ainsi construit
        return ptrNoeud;
    } // end if
} // end supprimeNoeud

template<class TypeInfo>
NoeudBinaire<TypeInfo>* ArbreNoeudBinaireRecherche<TypeInfo>::supprimeNoeudLePlusAGauche(NoeudBinaire<TypeInfo>* ptrNoeud,
                                                                                         TypeInfo& successeurLePlusProche) {
    // on applique la définition récursive
    // > je (ptrNoeud) n'ai pas de sous-arbre-gauche
    //                  -> je suis donc le successeur le plus à gauche
    //                  ->(mettre à jour successeurLePlusProche, retouner l'abre dans lequel je me supprime)
    // > j'ai un sous-arbre-gauche
    //                  -> faire le traitement sur mon sous-arbre gauche
    //                  -> (successeurLePlusProche sera mis à jour, retourner le sous-arbre construit)
    if (ptrNoeud->getPtrFilsGauche() == nullptr) {
        successeurLePlusProche = ptrNoeud->getInfo();
        return supprimeNoeud(ptrNoeud);
    } else {
        ptrNoeud->setPtrFilsGauche(supprimeNoeudLePlusAGauche(ptrNoeud->getPtrFilsGauche(), successeurLePlusProche));
        return ptrNoeud;
    } // end if
} // end supprimeNoeudLePlusAGauche

template<class TypeInfo>
bool ArbreNoeudBinaireRecherche<TypeInfo>::estInfoPresenteRecWorker(NoeudBinaire<TypeInfo>* ptrRac,
                                                                    const TypeInfo& infoCible) const {
    // mettre en œuvre la recherche "dichotomique"
    // > ptrRac == nullptr -> retrun false; *
    // > ptrRac != nullptr
    //      >> ptrRac->getInfo() == infoCible -> return true; *
    //      >> ptrRac->getInfo() > infoCible -> return(estInfoPresenteRecWorker(ptrRacine->getPtrFilsGauche(), infoCible));
    //      >> ptrRac->getInfo() < infocible -> return(estInfoPresenteRecWorker(ptrRacine->getPtrFilsDroite(), infoCible));
    if (ptrRac == nullptr) {
        return false; // non trouvé
    } else if (ptrRac->getInfo() == infoCible) {
        return true; // trouvé
    } else if (ptrRac->getInfo() > infoCible) {
        // chercher dans le sous-arbre gauche
        return estInfoPresenteRecWorker(ptrRac->getPtrFilsGauche(), infoCible);
    } else {
        // chercher dans le sous-arbre droit
        return estInfoPresenteRecWorker(ptrRac->getPtrFilsDroit(), infoCible);
    }
} // end estInfoPresenteRecWorker


//////////////////////////////////////////////////////////////
//      MWorkers des méthodes publiques pédagogiques
//////////////////////////////////////////////////////////////


template<class TypeInfo>
bool ArbreNoeudBinaireRecherche<TypeInfo>::aMemeGeometrieQueRecWorker(const NoeudBinaire<TypeInfo>* monPtrRac, const NoeudBinaire<TypeInfo>* sonPtrRac) const {
    if(monPtrRac == nullptr && sonPtrRac == nullptr)
        return true;
    if(monPtrRac==nullptr && sonPtrRac != nullptr || monPtrRac != nullptr && sonPtrRac == nullptr)
        return false;
    return aMemeGeometrieQueRecWorker(monPtrRac->getPtrFilsDroit(), sonPtrRac->getPtrFilsDroit()) && aMemeGeometrieQueRecWorker(monPtrRac->getPtrFilsGauche(),sonPtrRac->getPtrFilsGauche());
}

template<class TypeInfo>
bool ArbreNoeudBinaireRecherche<TypeInfo>::estEgalARecWorker(const NoeudBinaire<TypeInfo>* monPtrRac, const NoeudBinaire<TypeInfo>* sonPtrRac) const {
    /*
     * A COMPLETER
     */
    // supprimer à partir de cette ligne après complétion
    return false;
}

/**
 * @pre  ptrRac!=nulllptr
 * @param ptrRac
 * @return
 */
template<class TypeInfo>
TypeInfo ArbreNoeudBinaireRecherche<TypeInfo>::getMaxRecWorker(const NoeudBinaire<TypeInfo>* ptrRac) const {

    if( ptrRac->getPtrFilsDroit() == nullptr)
    {
        return ptrRac->getInfo();
    }
    else
    {
        return getMaxRecWorker(ptrRac->getPtrFilsDroit());
    }
    // supprimer à partir de cette ligne après complétion
}

template<class TypeInfo>
bool ArbreNoeudBinaireRecherche<TypeInfo>::aPourSousArbreRecWorker(const NoeudBinaire<TypeInfo>* ptrRacCetArbre, const NoeudBinaire<TypeInfo>* ptrRacUnArbre) const {
    /*
     * A COMPLETER
     */
    // supprimer à partir de cette ligne après complétion
    return false;
}

//////////////////////////////////////////////////////////////
//      worker d'affichage privés
//////////////////////////////////////////////////////////////

template<class TypeInfo>
void ArbreNoeudBinaireRecherche<TypeInfo>::affichePrefixeWorker(const NoeudBinaire<TypeInfo>* ptrRac) const {
    // si l'arbre n'est pas vide
    if (ptrRac) {
        cout << ptrRac->getInfo() << " ";
        affichePrefixeWorker(ptrRac->getPtrFilsGauche());
        affichePrefixeWorker(ptrRac->getPtrFilsDroit());
    } // sinon rien à faire, donc on ne fait rien !!!
}

template<class TypeInfo>
void ArbreNoeudBinaireRecherche<TypeInfo>::afficheInfixeWorker(const NoeudBinaire<TypeInfo>* ptrRac) const {
    // si l'arbre n'est pas vide
    if (ptrRac) {
        afficheInfixeWorker(ptrRac->getPtrFilsGauche());
        cout << ptrRac->getInfo() << " ";
        afficheInfixeWorker(ptrRac->getPtrFilsDroit());
    } // sinon rien à faire, donc on ne fait rien !!!
}

template<class TypeInfo>
void ArbreNoeudBinaireRecherche<TypeInfo>::affichePostfixeWorker(const NoeudBinaire<TypeInfo>* ptrRac) const {
    // si l'arbre n'est pas vide
    if (ptrRac) {
        affichePostfixeWorker(ptrRac->getPtrFilsGauche());
        affichePostfixeWorker(ptrRac->getPtrFilsDroit());
        cout << ptrRac->getInfo() << " ";
    } // sinon rien à faire, donc on ne fait rien !!!
}



//////////////////////////////////////////////////////////////
//      METHODES PUBIQUES - DEBUT ICI
//////////////////////////////////////////////////////////////


//////////////////////////////////////////////////////////////
//      Section contructeurs et destructeur
//////////////////////////////////////////////////////////////

template<class TypeInfo>
ArbreNoeudBinaireRecherche<TypeInfo>::ArbreNoeudBinaireRecherche() : ptrRacine(nullptr) {
    // cet ABR est vide -> constuction de ptrRacine
} // end du constructeur par défaut

template<class TypeInfo>
ArbreNoeudBinaireRecherche<TypeInfo>::ArbreNoeudBinaireRecherche(const TypeInfo& infoRacine) {
    // cet arbre a noeud racine contenant infoRacine et sans sous-arbre
    ptrRacine = new NoeudBinaire<TypeInfo>(infoRacine, nullptr, nullptr);
} // end constructeur avec une information

template<class TypeInfo>
ArbreNoeudBinaireRecherche<TypeInfo>::ArbreNoeudBinaireRecherche(const ArbreNoeudBinaireRecherche<TypeInfo>& arbreOriginal) {
    // cet arbre est une copie de arbreOriginal
    ptrRacine = copieArbre(arbreOriginal.ptrRacine);
} // end constructeur par copie

template<class TypeInfo>
ArbreNoeudBinaireRecherche<TypeInfo>::~ArbreNoeudBinaireRecherche() {
    // cet arbre est vidé
    this->videWorker(ptrRacine);
} // end destructeur


//////////////////////////////////////////////////////////////
//      Méthodes publiques de ArbreBinaireInterface
//////////////////////////////////////////////////////////////

template<class TypeInfo>
bool ArbreNoeudBinaireRecherche<TypeInfo>::estVide() const {
    // cet arbre est vide s'il n'a pas de noeud racine
    return ptrRacine == nullptr;
} // end estVide

template<class TypeInfo>
int ArbreNoeudBinaireRecherche<TypeInfo>::getHauteur() const {
    return getHauteurRecWorker(ptrRacine);
} // end getHauteur

template<class TypeInfo>
int ArbreNoeudBinaireRecherche<TypeInfo>::getNombreDeNoeuds() const {
    return getNombreDeNoeudsRecWorker(ptrRacine);
} // end getNombreDeNoeuds

template<class TypeInfo>
void ArbreNoeudBinaireRecherche<TypeInfo>::vide() {
    this->videWorker(ptrRacine);
    ptrRacine = nullptr;
} // end vide

template<class TypeInfo>
TypeInfo ArbreNoeudBinaireRecherche<TypeInfo>::getInfoRacine() const {
    if (estVide()) {
        throw PrecondViolatedExcep("getInfoRacine() appelée sur un arbre binaire de recherche vide.");
    } else {
        return ptrRacine->getInfo();
    }
} // end getInfoRacine

template<class TypeInfo>
void ArbreNoeudBinaireRecherche<TypeInfo>::insere(const TypeInfo& nouvelleInfo) {
    insertRecWorker(ptrRacine, nouvelleInfo);
} // end insere

template<class TypeInfo>
bool ArbreNoeudBinaireRecherche<TypeInfo>::supprime(const TypeInfo& uneInfo) {
    bool isSuccessful = false;
    ptrRacine = supprimeInfo(ptrRacine, uneInfo, isSuccessful);
    return isSuccessful;
} // end supprime

template<class TypeInfo>
bool ArbreNoeudBinaireRecherche<TypeInfo>::estInfoPresente(const TypeInfo& uneInfo) const {
    return estInfoPresenteRecWorker(ptrRacine, uneInfo); // nullptr is same as false
} // end estInfoPresente

//////////////////////////////////////////////////////////////
//      Méthodes publiques pédagogiques
//////////////////////////////////////////////////////////////

template<class TypeInfo>
bool ArbreNoeudBinaireRecherche<TypeInfo>::aMemeGeometrieQue(const ArbreNoeudBinaireRecherche<TypeInfo>& autreArbre) const {
    return aMemeGeometrieQueRecWorker(ptrRacine, autreArbre.ptrRacine);
}

template<class TypeInfo>
TypeInfo ArbreNoeudBinaireRecherche<TypeInfo>::getMax() const {
    // peut-on retourner le max
    if (ptrRacine == nullptr) {
        throw PrecondViolatedExcep("Pas de maximum sur un arbre vide !");
    } else {
        return getMaxRecWorker(ptrRacine);
    }
}

template<class TypeInfo>
bool ArbreNoeudBinaireRecherche<TypeInfo>::aPourSousArbre(const ArbreNoeudBinaireRecherche<TypeInfo>& unArbre) const {
    return aPourSousArbreRecWorker(ptrRacine, unArbre.ptrRacine);
}

template<class TypeInfo>
bool ArbreNoeudBinaireRecherche<TypeInfo>::estPliable() const {
    if(ptrRacine==nullptr)
    {
        return true;
    }
    return estPliableRecWorker(ptrRacine->getPtrFilsDroit(), ptrRacine->getPtrFilsGauche());
}
template<class TypeInfo>
bool ArbreNoeudBinaireRecherche<TypeInfo>::estPliableRecWorker(const NoeudBinaire<TypeInfo>* monPtrRac, const NoeudBinaire<TypeInfo>* sonPtrRac) const
{

    if(monPtrRac == nullptr && sonPtrRac == nullptr)
        return true;
    if(monPtrRac==nullptr && sonPtrRac != nullptr || monPtrRac != nullptr && sonPtrRac == nullptr)
        return false;
    return estPliableRecWorker(monPtrRac->getPtrFilsDroit(), sonPtrRac->getPtrFilsGauche()) && estPliableRecWorker(monPtrRac->getPtrFilsGauche(),sonPtrRac->getPtrFilsDroit());
}

//////////////////////////////////////////////////////////////
//      Méthodes d'affichage publiques
//////////////////////////////////////////////////////////////

template<class TypeInfo>
void ArbreNoeudBinaireRecherche<TypeInfo>::affichePrefixe() const {
    cout << "En parcours préfixé, l'ABO contient : ";
    affichePrefixeWorker(ptrRacine);
    cout << endl;
}

template<class TypeInfo>
void ArbreNoeudBinaireRecherche<TypeInfo>::afficheInfixe() const {
    cout << "En parcours infixé, l'ABO contient : ";
    afficheInfixeWorker(ptrRacine);
    cout << endl;
}


template<class TypeInfo>
void ArbreNoeudBinaireRecherche<TypeInfo>::affichePostfixe() const {
    cout << "En parcours postfixé, l'ABO contient : ";
    affichePostfixeWorker(ptrRacine);
    cout << endl;
}


//////////////////////////////////////////////////////////////
//      Opérateur surchargé d'affectation (fournie)
//////////////////////////////////////////////////////////////

template<class TypeInfo>
ArbreNoeudBinaireRecherche<TypeInfo>& ArbreNoeudBinaireRecherche<TypeInfo>::operator=(const ArbreNoeudBinaireRecherche<TypeInfo>& rightHandSide) {
    if (!estVide())
        vide();
    this = copieArbre(&rightHandSide);

    return *this;
} // end operator=


//////////////////////////////////////////////////////////////
//      printPretty et méthodes associées (fournie)
//////////////////////////////////////////////////////////////

// Trouver la hauteur maximale d'un arbre binaire

template<class TypeInfo>
int ArbreNoeudBinaireRecherche<TypeInfo>::maxHeight(NoeudBinaire<TypeInfo>* p) {
    if (!p) return 0;
    int leftHeight = maxHeight(p->getPtrFilsGauche());
    int rightHeight = maxHeight(p->getPtrFilsDroit());
    return (leftHeight > rightHeight) ? leftHeight + 1 : rightHeight + 1;
}

// Convertir l'information portée par un noeud en chaîne

template<class TypeInfo>
string ArbreNoeudBinaireRecherche<TypeInfo>::my2String(TypeInfo val) {
    ostringstream ss;
    ss << val;
    return ss.str();
}

// Imprimer les bras (eg, /    \ ) sur une ligne

template<class TypeInfo>
void ArbreNoeudBinaireRecherche<TypeInfo>::printBranches(int branchLen, int nodeSpaceLen, int startLen, int nodesInThisLevel, const deque<NoeudBinaire<TypeInfo>*>& nodesQueue, ostream& out) {
    typename deque<NoeudBinaire<TypeInfo>*>::const_iterator iter = nodesQueue.begin();
    for (int i = 0; i < nodesInThisLevel / 2; i++) {
        out << ((i == 0) ? setw(startLen - 1) : setw(nodeSpaceLen - 2)) << "" << ((*iter++) ? "/" : " ");
        out << setw(2 * branchLen + 2) << "" << ((*iter++) ? "\\" : " ");
    }
    out << endl;
}

// Imprimer les branches et noeuds (eg, ___10___ )

template<class TypeInfo>
void ArbreNoeudBinaireRecherche<TypeInfo>::printNodes(int branchLen, int nodeSpaceLen, int startLen, int nodesInThisLevel, const deque<NoeudBinaire<TypeInfo>*>& nodesQueue, ostream& out) {
    typename deque<NoeudBinaire<TypeInfo>*>::const_iterator iter = nodesQueue.begin();
    for (int i = 0; i < nodesInThisLevel; i++, iter++) {
        out << ((i == 0) ? setw(startLen) : setw(nodeSpaceLen)) << "" << ((*iter && (*iter)->getPtrFilsGauche()) ? setfill('_') : setfill(' '));
        out << setw(branchLen + 2) << ((*iter) ? my2String((*iter)->getInfo()) : "");
        out << ((*iter && (*iter)->getPtrFilsDroit()) ? setfill('_') : setfill(' ')) << setw(branchLen) << "" << setfill(' ');
    }
    out << endl;
}

// Imprimer uniquement les feuilles (pour la dernière ligne)

template<class TypeInfo>
void ArbreNoeudBinaireRecherche<TypeInfo>::printLeaves(int indentSpace, int level, int nodesInThisLevel, const deque<NoeudBinaire<TypeInfo>*>& nodesQueue, ostream& out) {
    typename deque<NoeudBinaire<TypeInfo>*>::const_iterator iter = nodesQueue.begin();
    for (int i = 0; i < nodesInThisLevel; i++, iter++) {
        out << ((i == 0) ? setw(indentSpace + 2) : setw(2 * level + 2)) << ((*iter) ? my2String((*iter)->getInfo()) : "");
    }
    out << endl;
}

// Affichage vertical de cet arbre sur le flux de sortie (out)
// @ param
// level  Contrôle de la largeur (eg, level 1 : espace minimal entre noeuds, level 2 : espace plus large)
// indentSpace  Contrôle de l'intentation par rapport à la marge gauche (eg, indentSpace = 0 : le noeud le plus bas à gauche est aligné complètement à gauche)

template<class TypeInfo>
void ArbreNoeudBinaireRecherche<TypeInfo>::printPretty(int level, int indentSpace, ostream& out) {

    NoeudBinaire<TypeInfo>* root = ptrRacine;

    int h = maxHeight(root);
    //cout << "dans printPretty -> maxHeight = " << h << endl;
    int nodesInThisLevel = 1;
    int branchLen = 2 * ((int) pow(2.0, h) - 1) - (3 - level)*(int) pow(2.0, h - 1); // eq of the length of branch for each node of each level
    //int branchLen = 2 * ((int) pow(2.0, h-1) - 1) - (3 - level)*(int) pow(2.0, h - 2);
    //cout << "dans printPretty -> branchLen = " << branchLen << endl;
    int nodeSpaceLen = 2 + (level + 1)*(int) pow(2.0, h); // distance between left neighbor node's right arm and right neighbor node's left arm
    //int nodeSpaceLen = 2 + (level + 1)*(int) pow(2.0, h-1);
    //cout << "dans printPretty -> nodeSpaceLen = " << nodeSpaceLen << endl;
    int startLen = branchLen + (3 - level) + indentSpace; // starting space to the first node to print of each level (for the left most node of each level only)
    //cout << "dans printPretty -> startLen = " << startLen << endl;

    deque<NoeudBinaire<TypeInfo>*> nodesQueue;
    nodesQueue.push_back(root);
    for (int r = 1; r < h; r++) {
        printBranches(branchLen, nodeSpaceLen, startLen, nodesInThisLevel, nodesQueue, out);
        branchLen = branchLen / 2 - 1;
        nodeSpaceLen = nodeSpaceLen / 2 + 1;
        startLen = branchLen + (3 - level) + indentSpace;
        printNodes(branchLen, nodeSpaceLen, startLen, nodesInThisLevel, nodesQueue, out);

        for (int i = 0; i < nodesInThisLevel; i++) {
            NoeudBinaire<TypeInfo>* currNode = nodesQueue.front();
            nodesQueue.pop_front();
            if (currNode) {
                nodesQueue.push_back(currNode->getPtrFilsGauche());
                nodesQueue.push_back(currNode->getPtrFilsDroit());
            } else {
                nodesQueue.push_back(NULL);
                nodesQueue.push_back(NULL);
            }
        }
        nodesInThisLevel *= 2;
    }
    printBranches(branchLen, nodeSpaceLen, startLen, nodesInThisLevel, nodesQueue, out);
    printLeaves(indentSpace, level, nodesInThisLevel, nodesQueue, out);
}

#endif