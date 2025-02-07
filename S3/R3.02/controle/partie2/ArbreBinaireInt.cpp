#include "ArbreBinaireInt.h"
#include <iostream>
#include <random>
#include <queue>
#include <unordered_map>
using namespace std;

/*
 **********************************************************************************
 * PARTIE 2 - A COMPLETER
 **********************************************************************************
 */

int ArbreBinaireInt::profondeurMinimale() const {
    /*
     * EXERCICE 3 : METHODE FOURNIE, NE PAS MODIFIER
     */
    return profondeurMinimaleRecWorker(ptrRacine);
}


int ArbreBinaireInt::profondeurMinimaleRecWorker(const NoeudBinaireInt *ptrRac) const {
    if(ptrRac == nullptr)
        return 0;

    const int nbDroit = profondeurMinimaleRecWorker(ptrRac->getPtrFilsDroit())+1;
    const int nbgauche = profondeurMinimaleRecWorker(ptrRac->getPtrFilsGauche())+1;
    //on detecte si une seul branche
    if(ptrRac->getPtrFilsDroit() == nullptr)
        return nbgauche;
    else if(ptrRac->getPtrFilsGauche() == nullptr)
        return nbDroit;
    else
        return min(nbgauche,nbDroit);
}

int ArbreBinaireInt::valeurArbre() const {
    /*
     * EXERCICE 4 : METHODE FOURNIE, NE PAS MODIFIER
     */
    return valeurArbre(ptrRacine);
}

int ArbreBinaireInt::valeurArbre(const NoeudBinaireInt *ptrRac) const {
    if(ptrRac == nullptr)
        return 0;
    else
        return ptrRac->getInfo();
}

bool ArbreBinaireInt::estUnArbreSomme() const {
    /*
     * EXERCICE 4 : METHODE FOURNIE, NE PAS MODIFIER
     */
    return estUnArbreSommeWorker(ptrRacine);
}

bool ArbreBinaireInt::estUnArbreSommeWorker(const NoeudBinaireInt *ptrRac) const {
    /*
     * EXERCICE 4 : A COMPLETER
     */

    /*
     * si c'est vide c'est bon
     * si pas d'enfant c'est bon
     * on aditionne le droit et le gauche en faisant atention que l'un ne soit inexistant
     * si d+g ne sont pas egaux a la tete, on doit arrété le parcours, c'est pas bon
     * si c'est bon on teste les deux enfant
     *
     * on doit pouvoir parcourir que partielement pour etre plus opti
     */
    if(ptrRac == nullptr)
        return true;
    const NoeudBinaireInt* droit = ptrRac->getPtrFilsDroit();
    const NoeudBinaireInt* gauche = ptrRac->getPtrFilsGauche();
    if(droit == nullptr && gauche == nullptr)
        return true;
    int val = 0;
    if(droit!=nullptr)
        val = droit->getInfo();
    if(gauche != nullptr)
        val += gauche->getInfo();

    if(val!=valeurArbre(ptrRac))
        return false;
    else
        return estUnArbreSommeWorker(droit) && estUnArbreSommeWorker(gauche);
}

// méthode fournie

void ArbreBinaireInt::insereArbreSomme(int uneValeur) {
    /*
     * EXERCICE 5 : METHODE FOURNIE, NE PAS MODIFIER
     */
    NoeudBinaireInt *ptrNouveauNoeud = new NoeudBinaireInt(uneValeur);
    ptrRacine = insereArbreSommeWorker(ptrRacine, ptrNouveauNoeud);
}

NoeudBinaireInt *ArbreBinaireInt::insereArbreSommeWorker(NoeudBinaireInt *ptrRac, NoeudBinaireInt *ptrNouveauNoeud) {
    /*if (ptrRac == nullptr) {
        return ptrNouveauNoeud;
    } else {
        if (rand() % 2 == 0) {
            ptrRac->setPtrFilsGauche(insertRandomWorker(ptrRac->getPtrFilsGauche(), ptrNouveauNoeud));
        } else {
            ptrRac->setPtrFilsDroit(insertRandomWorker(ptrRac->getPtrFilsDroit(), ptrNouveauNoeud));
        }
    }
    return ptrRac;
    */
}

/*
 **********************************************************************************
 * NE PAS MODIFIER CE QUI SUIT
 **********************************************************************************
 */

ArbreBinaireInt::ArbreBinaireInt() : ptrRacine(nullptr) {
}

ArbreBinaireInt::ArbreBinaireInt(int infoRacine) {
    ptrRacine = new NoeudBinaireInt(infoRacine);
}

ArbreBinaireInt::~ArbreBinaireInt() {
}

void ArbreBinaireInt::affichePrefixeWorker(NoeudBinaireInt *ptrRac) const {
    if (ptrRac) {
        cout << ptrRac->getInfo() << " ";
        affichePrefixeWorker(ptrRac->getPtrFilsGauche());
        affichePrefixeWorker(ptrRac->getPtrFilsDroit());
    } // sinon rien à faire, donc on ne fait rien !!!
}

void ArbreBinaireInt::affichePrefixe() const {
    affichePrefixeWorker(ptrRacine);
    cout << endl;
}

void ArbreBinaireInt::afficheInfixeWorker(NoeudBinaireInt *ptrRac) const {
    if (ptrRac) {
        afficheInfixeWorker(ptrRac->getPtrFilsGauche());
        cout << ptrRac->getInfo() << " ";
        afficheInfixeWorker(ptrRac->getPtrFilsDroit());
    } // sinon rien à faire, donc on ne fait rien !!!
}

void ArbreBinaireInt::afficheInfixe() const {
    afficheInfixeWorker(ptrRacine);
    cout << endl;
}

void ArbreBinaireInt::affichePostfixeWorker(NoeudBinaireInt *ptrRac) const {
    if (ptrRac) {
        affichePostfixeWorker(ptrRac->getPtrFilsGauche());
        affichePostfixeWorker(ptrRac->getPtrFilsDroit());
        cout << ptrRac->getInfo() << " ";
    } // sinon rien à faire, donc on ne fait rien !!!
}

void ArbreBinaireInt::affichePostfixe() const {
    affichePostfixeWorker(ptrRacine);
    cout << endl;
}

/**
 *  insertion d'une feuille au hasard
 */
int pileOuFace() {
    return rand() % 2;
}

NoeudBinaireInt *ArbreBinaireInt::insertRandomWorker(NoeudBinaireInt *ptrRac, NoeudBinaireInt *ptrNouveauNoeud) {
    if (ptrRac == nullptr) {
        return ptrNouveauNoeud;
    } else {
        int cote = pileOuFace();
        if (cote == 0) {
            ptrRac->setPtrFilsGauche(insertRandomWorker(ptrRac->getPtrFilsGauche(), ptrNouveauNoeud));
        } else {
            ptrRac->setPtrFilsDroit(insertRandomWorker(ptrRac->getPtrFilsDroit(), ptrNouveauNoeud));
        }
    }
    return ptrRac;
}

void ArbreBinaireInt::insereRandom(int nouvelleInfo) {
    NoeudBinaireInt *ptrNouveauNoeud = new NoeudBinaireInt(nouvelleInfo);
    ptrRacine = insertRandomWorker(ptrRacine, ptrNouveauNoeud);
}

/**
 * insertion d'une feuille sur un chemin (path)
 */
NoeudBinaireInt *ArbreBinaireInt::insertPathWorker(NoeudBinaireInt *ptrRac, NoeudBinaireInt *ptrNouveauNoeud,
                                                   string path) {
    if (path.size() == 0) {
        return ptrNouveauNoeud;
    } else {
        //cout << "path : " << path << " - ";
        char cote = path[0];
        //cout << "cote : " << cote << " - ";
        string newPath = path.erase(0, 1);
        //cout << "newPath : " << newPath << endl;
        if (cote == '0') {
            // insertion à gauche
            ptrRac->setPtrFilsGauche(insertPathWorker(ptrRac->getPtrFilsGauche(), ptrNouveauNoeud, newPath));
        } else {
            // insertion à droite
            ptrRac->setPtrFilsDroit(insertPathWorker(ptrRac->getPtrFilsDroit(), ptrNouveauNoeud, newPath));
        }
        return ptrRac;
    }
}

void ArbreBinaireInt::inserePath(int nouvelleInfo, string path) {
    NoeudBinaireInt *ptrNouveauNoeud = new NoeudBinaireInt(nouvelleInfo);
    ptrRacine = insertPathWorker(ptrRacine, ptrNouveauNoeud, path);
}
