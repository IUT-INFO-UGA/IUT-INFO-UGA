
#ifndef ARBREBINAIREINT_H
#define ARBREBINAIREINT_H

#include "NoeudBinaireInt.h"
#include <string>

class ArbreBinaireInt {
public:
    ArbreBinaireInt();
    ArbreBinaireInt(int infoRacine);
    virtual ~ArbreBinaireInt();

    // fournies : méthodes d'insertion
    // insereRandom qui insère une feuille au hasard
    void insereRandom(int nouvelleInfo);
    // inserePath est une insertion qui permet d'inérer sur un chemin codé en string
    void inserePath(int nouvelleInfo, std::string path);
    
    // fournie : accès à la racine pour le prettyPrint
    NoeudBinaireInt* getRacine() {
        return ptrRacine;
    }
    
    // fournies : méthodes publiques d'affichage
    void affichePrefixe() const;
    void affichePostfixe() const;
    void afficheInfixe() const;
    
    // méthode fournie
    int valeurArbre() const;
    
    // méthode fournie
    /**
     *
     * @return la profondeur minimale de cet arbre
     */
    int profondeurMinimale() const;

    // méthode demandée
    /**
     * Prédicat qui vérifie que cet arbre binaire est un arbre de somme
     * 
     * @pre cet arbre est un AB
     * @param
     */
    bool estUnArbreSomme() const;
    
    // méthode fournie
    /**
     * insère uneValeur dans cet arbre binaire de somme
     * 
     * @pre cet arbre est un arbre binaire de somme
     * @post cet arbre est un arbre binaire de somme après insertion de uneValeur
     * @param uneValeur à insérer
     */
    void insereArbreSomme(const int uneValeur);

private:
    NoeudBinaireInt* ptrRacine;

    // méthodes fournies
    NoeudBinaireInt* insertRandomWorker(NoeudBinaireInt* ptrRac, NoeudBinaireInt* ptrNouveauNoeud);
    NoeudBinaireInt* insertPathWorker(NoeudBinaireInt* ptrRac, NoeudBinaireInt* ptrNouveauNoeud, std::string path);

    // méthode demandée
    /**
     * Méthode qui retourne la valeur d'un arbre de racine ptrRac
     * 
     * @return la valeur portée par ptrRac, ou 0 si cet arbre est vide
     */
    int valeurArbre(const NoeudBinaireInt* ptrRac) const;
        
    // workers demandés
    int profondeurMinimaleRecWorker(const NoeudBinaireInt* ptrRac) const;
    bool estUnArbreSommeWorker(const NoeudBinaireInt* ptrRac) const;
    NoeudBinaireInt* insereArbreSommeWorker(NoeudBinaireInt* ptrRac, NoeudBinaireInt* ptrNouveauNoeud);

    // fournis : workers pour l'affichage récursif 
    void affichePrefixeWorker(NoeudBinaireInt* ptrRac) const;
    void afficheInfixeWorker(NoeudBinaireInt* ptrRac) const;
    void affichePostfixeWorker(NoeudBinaireInt* ptrRac) const;
};

#endif	/* ARBREBINAIREINT_H */

