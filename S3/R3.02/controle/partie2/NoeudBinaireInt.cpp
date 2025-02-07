
#include "NoeudBinaireInt.h"
#include <iostream>

using namespace std;

NoeudBinaireInt::NoeudBinaireInt(int uneInfo) : info(uneInfo), ptrFilsGauche(nullptr), ptrFilsDroit(nullptr) {
}

NoeudBinaireInt::~NoeudBinaireInt() {
}

int NoeudBinaireInt::getInfo() const {
    return info;
}

void NoeudBinaireInt::setInfo(int uneInfo) {
    info = uneInfo;
}

bool NoeudBinaireInt::estFeuille() const {
    return ((ptrFilsGauche == nullptr) && (ptrFilsDroit == nullptr));
}

NoeudBinaireInt* NoeudBinaireInt::getPtrFilsGauche() const {
    return ptrFilsGauche;
}

NoeudBinaireInt* NoeudBinaireInt::getPtrFilsDroit() const {
    return ptrFilsDroit;
}

void NoeudBinaireInt::setPtrFilsGauche(NoeudBinaireInt* ptrFilsG) {
    ptrFilsGauche = ptrFilsG;
}

void NoeudBinaireInt::setPtrFilsDroit(NoeudBinaireInt* ptrFilsD) {
    ptrFilsDroit = ptrFilsD;
}

void NoeudBinaireInt::affiche() const {
    cout << info;
}