#ifndef _CELLULE
#define _CELLULE

#include <cstddef>
#include <iostream>

using namespace std;

template<class TypeInfo>
class Cellule {
private:
    TypeInfo info; // information portée par la cellule
    Cellule<TypeInfo>* ptrCellSuivante; // pointeur sur la cellule suivante
    
public:

    //Constructeur par défaut de cette cellule
    Cellule();

    //Constructeur de cette cellule avec une information uneInfo comme contenu
    //@param uneInfo : valeur à ranger dans cet info
    Cellule(const TypeInfo& uneInfo);


    //constructeur qui réalise une insertion en tête dans une liste
    //@param uneInfo : info de la première cellule
    //@param ptrCelluleSuivante : liste qui succède à cette cellule
    Cellule(const TypeInfo& uneInfo, Cellule<TypeInfo>* ptrCelluleSuivante);


    //Setters pour info et ptrCellSuivante
    void setInfo(const TypeInfo& uneInfo);
    void setSuivante(Cellule<TypeInfo>* ptrCelluleSuivante);


    //Getter pour obtenir l'info de cette cellule
    //const car la méthode ne modifie pas cet objet
    TypeInfo getInfo() const;


    // Getter d'un pointeur vers la cellule suivant cette cellule
    // @return pointeur vers une cellule
    // /!\ cette méthode est utilisable pour l'écriture de fonctions récursives
    // qui retournent des listes
    // const car la méthode ne modifie pas cet objet
    Cellule<TypeInfo>* getSuivante() const;


    // Getter d'une référence de pointeur vers la cellule suivant cette cellule
    // @return référence sur un pointeur vers une cellule
    // /!\ cette méthode est nécessaire pour l'écriture de procédures récursives
    // dans le modèle "intuitif"
    // Ne peut être const car le pointeur retourné peut-être modifié
    Cellule<TypeInfo>*& getRefSuivante();
    
    // Affichage de l'information portée par cette cellule
    void affiche() const;
        
}; // end Cellule

template<class TypeInfo>
Cellule<TypeInfo>::Cellule() : ptrCellSuivante(nullptr) {
} // end constructeur par défaut

template<class TypeInfo>
Cellule<TypeInfo>::Cellule(const TypeInfo& uneInfo) : info(uneInfo), ptrCellSuivante(nullptr) {
} // end constructeur avec une information

template<class TypeInfo>
Cellule<TypeInfo>::Cellule(const TypeInfo& uneInfo, Cellule<TypeInfo>* ptrCelluleSuivante) : info(uneInfo), ptrCellSuivante(ptrCelluleSuivante) {
} // end constructeur avec une information et une liste (insertête dans une liste existante)

template<class TypeInfo>
void Cellule<TypeInfo>::setInfo(const TypeInfo& uneInfo) {
    info = uneInfo;
} // end setInfo

template<class TypeInfo>
void Cellule<TypeInfo>::setSuivante(Cellule<TypeInfo>* ptrCelluleSuivante) {
    ptrCellSuivante = ptrCelluleSuivante;
} // end setSuivant

template<class TypeInfo>
TypeInfo Cellule<TypeInfo>::getInfo() const {
    return info;
} // end getInfo

template<class TypeInfo>
Cellule<TypeInfo>* Cellule<TypeInfo>::getSuivante() const {
    return ptrCellSuivante;
} // end getSuivant

template<class TypeInfo>
Cellule<TypeInfo>*& Cellule<TypeInfo>::getRefSuivante() {
    return ptrCellSuivante;
} // end getRefSuivante

template<class TypeInfo>
void Cellule<TypeInfo>::affiche() const {
    cout << info;
} // end afficheCellule

#endif