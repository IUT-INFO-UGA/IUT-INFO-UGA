/** Implémentation de la classe
    @file CellInt.cpp 
 */

#include "CellInt.h"

#include <iostream>

using namespace std;


CellInt::CellInt() : ptrCellSuivante(nullptr) {
} // end constructeur par défaut

CellInt::CellInt(int uneInfo) : info(uneInfo), ptrCellSuivante(nullptr) {
} // end constructeur avec une information

CellInt::CellInt(int uneInfo, CellInt* ptrCelluleSuivante) : info(uneInfo), ptrCellSuivante(ptrCelluleSuivante) {
} // end constructeur avec une information et une liste (insertête dans une liste existante)

void CellInt::setInfo(int uneInfo) {
    info = uneInfo;
} // end setInfo

void CellInt::setSuivante(CellInt* ptrCelluleSuivante) {
    ptrCellSuivante = ptrCelluleSuivante;
} // end setSuivant

int CellInt::getInfo() const {
    return info;
} // end getInfo

CellInt* CellInt::getSuivante() const {
    return ptrCellSuivante;
} // end getSuivant

CellInt*& CellInt::getRefSuivante() {
    return ptrCellSuivante;
} // end getRefSuivante

void CellInt::affiche() const {
    cout << info;
} // end affiche
