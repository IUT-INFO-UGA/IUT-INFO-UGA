//  HB librement inspiré de
//  Data Abstraction & Problem Solving with C++: Walls and Mirrors
//  Frank M. Carrano and Tim Henry.
//  2013 – Pearson Education

/** @file BinaryNode.cpp */

#ifdef _NOEUD_BINAIRE

#include <cstddef>
#include <iostream>

using namespace std;

template<class TypeInfo>
NoeudBinaire<TypeInfo>::NoeudBinaire() : info(nullptr), ptrFilsGauche(nullptr), ptrFilsDroit(nullptr) {
} // end constructeur par défaut

template<class TypeInfo>
NoeudBinaire<TypeInfo>::NoeudBinaire(const TypeInfo& uneInfo) : info(uneInfo), ptrFilsGauche(nullptr), ptrFilsDroit(nullptr) {
} // end constucteur avec info

template<class TypeInfo>
NoeudBinaire<TypeInfo>::NoeudBinaire(const TypeInfo& uneInfo, NoeudBinaire<TypeInfo>* ptrFilsG,
        NoeudBinaire<TypeInfo>* ptrFilsD) : info(uneInfo), ptrFilsGauche(ptrFilsG), ptrFilsDroit(ptrFilsD) {
} // end contructeur avec info et deux sous arbres

template<class TypeInfo>
void NoeudBinaire<TypeInfo>::setInfo(const TypeInfo& uneInfo) {
    info = uneInfo;
} // end setInfo

template<class TypeInfo>
TypeInfo NoeudBinaire<TypeInfo>::getInfo() const {
    return info;
} // end getInfo

template<class TypeInfo>
bool NoeudBinaire<TypeInfo>::estFeuille() const {
    return ((ptrFilsGauche == nullptr) && (ptrFilsDroit == nullptr));
} //end estFeuille

template<class TypeInfo>
void NoeudBinaire<TypeInfo>::setPtrFilsGauche(NoeudBinaire<TypeInfo>* ptrFilsG) {
    ptrFilsGauche = ptrFilsG;
} // end setPtrSAGauche

template<class TypeInfo>
void NoeudBinaire<TypeInfo>::setPtrFilsDroit(NoeudBinaire<TypeInfo>* ptrFilsD) {
    ptrFilsDroit = ptrFilsD;
} // end setPtrSADroit

template<class TypeInfo>
NoeudBinaire<TypeInfo>* NoeudBinaire<TypeInfo>::getPtrFilsGauche() const {
    return ptrFilsGauche;
} // end getPtrSAGauche		

template<class TypeInfo>
NoeudBinaire<TypeInfo>* NoeudBinaire<TypeInfo>::getPtrFilsDroit() const {
    return ptrFilsDroit;
} // end getPtrSADroit

template<class TypeInfo>
NoeudBinaire<TypeInfo>*& NoeudBinaire<TypeInfo>::getRefPtrFilsGauche() {
    return ptrFilsGauche;
} // end getPtrSAGauche		

template<class TypeInfo>
NoeudBinaire<TypeInfo>*& NoeudBinaire<TypeInfo>::getRefPtrFilsDroit() {
    return ptrFilsDroit;
} // end getPtrSADroit

template<class TypeInfo>
void NoeudBinaire<TypeInfo>::affiche() const {
    cout << info;
} // end affiche

#endif