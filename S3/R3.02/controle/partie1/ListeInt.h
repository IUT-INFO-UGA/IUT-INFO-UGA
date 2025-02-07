
#ifndef LISTEINT_H
#define LISTEINT_H

#include "CellInt.h"
#include <string>

using namespace std;


class ListeInt {
public:
    ListeInt();
    ListeInt(const ListeInt& orig);
    virtual ~ListeInt();

    //Présent uniquement pour fabriquer une liste dans le test
    void insereTete(int nouvelleInfo);

    void afficheGD();

    /**
     * Comptage des valeurs paires, worker récursif
     * @param ptrCellCour : pointeur sur la cellule courante
     * @return nombre de valeurs paires de cette liste
     */
    int nbPairsRec() const;

    /** 
     * la liste est-elle alternée ? 
     * @param   ptrCellCour : pointeur sur la cellule courante
     * @return  true si cette liste est alternée
     */
    bool estAlterneeRec() const;
    


private:
    CellInt* ptrTete;

    // workers récursifs fournis
    void insereTeteWorker(CellInt*& ptrTete, int nouvelleInfo);
    void afficheGDWorker(CellInt* ptrListe);

    // workers récursifs demandés
    int nbPairsRecWorker(const CellInt* ptrCellCour) const;
    bool estAlterneeRecWorker(const CellInt* ptrCellCour, const string attendu) const;
};

#endif /* LISTEINT_H */

