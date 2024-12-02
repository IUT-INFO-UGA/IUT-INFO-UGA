/*
 *
 */

#include <iostream>
#include <string>
#include "../ListeTrieeChainee.h"

using namespace std;

void construitListe(ListeTrieeChainee<string>*& ptrListe) {
    cout << endl << "**********************************" << endl;
    cout << "*                                *" << endl;
    cout << "*        construitListe()        *" << endl;
    cout << "*                                *" << endl;
    cout << "**********************************" << endl << endl;

    // vider la liste
    ptrListe->videRec();
    cout << "La liste initiale est-elle videRec ? : " << ptrListe->estVide() << " ; devrait répondre 1 (true)" << endl;

    string herve = "Hervé";
    string philippe = "Philippe";
    string jerome = "Jérôme";
    string francis = "Francis";
    string ana = "Ana";
    string sophie = "Sophie";

    ptrListe->insereRec(herve);
    ptrListe->insereRec(philippe);
    ptrListe->insereRec(jerome);
    ptrListe->insereRec(francis);
    ptrListe->insereRec(ana);
    ptrListe->insereRec(sophie);

    cout << "Après 6 insertions la liste contient : " << ptrListe->getLongueur() << " Cellules ; devrait répondre 6" << endl;
    cout << "La liste est elle videRec ? : " << ptrListe->estVide() << " ; devrait répondre 0 (false)" << endl;
}

void testeGetPosit(ListeTrieeChainee<string>*& ptrListe) {
    cout << endl << "**********************************" << endl;
    cout << "*                                *" << endl;
    cout << "*        testeGetPosit()        *" << endl;
    cout << "*                                *" << endl;
    cout << "**********************************" << endl << endl;
    
    cout << "La liste contient initialement : ";
    ptrListe->afficheCroissantRec();
    cout << endl << endl;
    cout << "Recherches de valeurs présentes ->" << endl;
    cout << " Postion de \"Ana\" : " << ptrListe->getPositIter("Ana") << " ; devrait retourner 1" << endl;
    cout << " Postion de \"Jérôme\" : " << ptrListe->getPositIter("Jérôme") << " ; devrait retourner 4" << endl;
    cout << " Postion de \"Sophie\" : " << ptrListe->getPositIter("Sophie") << " ; devrait retourner 6" << endl;
    cout << endl << "Recherches de valeurs absentes ->" << endl;
    cout << " Postion de \"Adam\" : " << ptrListe->getPositIter("Adam") << " ; devrait retourner -1" << endl;
    cout << " Postion de \"Jacques\" : " << ptrListe->getPositIter("Jacques") << " ; devrait retourner -4" << endl;
    cout << " Postion de \"Violette\" : " << ptrListe->getPositIter("Violette") << " ; devrait retourner -7" << endl;
}

void testeAffiche(ListeTrieeChainee<string>*& ptrListe) {
    cout << endl << "**********************************" << endl;
    cout << "*                                *" << endl;
    cout << "*         testeAffiche()         *" << endl;
    cout << "*                                *" << endl;
    cout << "**********************************" << endl << endl;
    
    cout << "Dans l'ordre croissant avec une procédure récursive, la liste contient :" << endl << "   -> ";
    ptrListe->afficheCroissantRec();
    cout << endl;
}

void testeInsereRec(ListeTrieeChainee<string>*& ptrListe) {
    cout << endl << "**********************************" << endl;
    cout << "*                                *" << endl;
    cout << "*        testeInsertRec()        *" << endl;
    cout << "*                                *" << endl;
    cout << "**********************************" << endl << endl;
    
    cout << "La liste contient initialement : ";
    ptrListe->afficheCroissantRec();
    cout << endl << endl;
    cout << "Insertion de Adam en début de liste " << endl;
    ptrListe->insereRec("Adam");
    cout << "  -> la liste contient : ";
    ptrListe->afficheCroissantRec();
    cout << endl;
    cout << "Insertion de Jacques en milieu de liste " << endl;
    ptrListe->insereRec("Jacques");
    cout << "  -> la liste contient : ";
    ptrListe->afficheCroissantRec();
    cout << endl;
    cout << "Insertion de Violette en fin de liste " << endl;
    ptrListe->insereRec("Violette");
    cout << "  -> la liste contient : ";
    ptrListe->afficheCroissantRec();
    cout << endl;
}

void testeSupprimePremOccInfoRec(ListeTrieeChainee<string>*& ptrListe) {
    cout << endl << "**********************************" << endl;
    cout << "*                                *" << endl;
    cout << "*  testeSupprimePremOccInfoRec() *" << endl;
    cout << "*                                *" << endl;
    cout << "**********************************" << endl << endl;
    
    cout << "La liste contient initialement : ";
    ptrListe->afficheCroissantRec();
    cout << endl << endl;
    ptrListe->supprimePremOccInfoRec("Ana");
    cout << "Après suppression de \"Ana\" (le premier), la liste contient : ";
    ptrListe->afficheCroissantRec();
    cout << endl;
    ptrListe->supprimePremOccInfoRec("Jérôme");
    cout << "Après suppression de \"Jérôme\" (au milieu), la liste contient : ";
    ptrListe->afficheCroissantRec();
    cout << endl;
    ptrListe->supprimePremOccInfoRec("Sophie");
    cout << "Après suppression de \"Sophie\" (le dernier), la liste contient : ";
    ptrListe->afficheCroissantRec();
    cout << endl;
    ptrListe->supprimePremOccInfoRec("Adam");
    cout << "Après suppression de \"Adam\" (avant le premier), la liste contient : ";
    ptrListe->afficheCroissantRec();
    cout << endl;
    ptrListe->supprimePremOccInfoRec("Jacques");
    cout << "Après suppression de \"Jacques\" (entre deux valeurs au milieu), la liste contient : ";
    ptrListe->afficheCroissantRec();
    cout << endl;
    ptrListe->supprimePremOccInfoRec("Violette");
    cout << "Après suppression de \"Violette\" (après le dernier), la liste contient : ";
    ptrListe->afficheCroissantRec();
    cout << endl;
}

void testeSupprimePremOccInfoIter(ListeTrieeChainee<string>*& ptrListe) {
    cout << endl << "***********************************" << endl;
    cout << "*                                 *" << endl;
    cout << "*  testeSupprimePremOccInfoIter() *" << endl;
    cout << "*                                 *" << endl;
    cout << "***********************************" << endl << endl;

    cout << "La liste contient initialement : ";
    ptrListe->afficheCroissantRec();
    cout << endl << endl;
    ptrListe->supprimePremOccInfoIter("Ana");
    cout << "Après suppression de \"Ana\" (le premier), la liste contient : ";
    ptrListe->afficheCroissantRec();
    cout << endl;
    ptrListe->supprimePremOccInfoIter("Jérôme");
    cout << "Après suppression de \"Jérôme\" (au milieu), la liste contient : ";
    ptrListe->afficheCroissantRec();
    cout << endl;
    ptrListe->supprimePremOccInfoRec("Sophie");
    cout << "Après suppression de \"Sophie\" (le dernier), la liste contient : ";
    ptrListe->afficheCroissantRec();
    cout << endl;
    ptrListe->supprimePremOccInfoIter("Adam");
    cout << "Après suppression de \"Adam\" (avant le premier), la liste contient : ";
    ptrListe->afficheCroissantRec();
    cout << endl;
    ptrListe->supprimePremOccInfoIter("Jacques");
    cout << "Après suppression de \"Jacques\" (entre deux valeurs au milieu), la liste contient : ";
    ptrListe->afficheCroissantRec();
    cout << endl;
    ptrListe->supprimePremOccInfoIter("Violette");
    cout << "Après suppression de \"Violette\" (après le dernier), la liste contient : ";
    ptrListe->afficheCroissantRec();
    cout << endl;
}

void testeValeursDupliquees(ListeTrieeChainee<string>*& ptrListe) {
    cout << endl << "**********************************" << endl;
    cout << "*                                *" << endl;
    cout << "*     testeValeursDupliquees()   *" << endl;
    cout << "*                                *" << endl;
    cout << "**********************************" << endl << endl;
    
    cout << "La liste contient initialement : ";
    ptrListe->afficheCroissantRec();
    cout << endl << endl;
    cout << "Insertion de \"Francis\", \"Ana\", \"Francis\", \"Hervé\", \"Francis\", \"Philippe\"" << endl << "  -> ";
    ptrListe->insereRec("Francis");
    ptrListe->insereRec("Ana");
    ptrListe->insereRec("Francis");
    ptrListe->insereRec("Hervé");
    ptrListe->insereRec("Francis");
    ptrListe->insereRec("Philippe");
    cout << "La liste contient maintenant : ";
    ptrListe->afficheCroissantRec();
    cout << endl << endl;
    cout << "Recherches de valeurs présentes ->" << endl;
    cout << " Postion de \"Ana\" : " << ptrListe->getPositIter("Ana") << " ; devrait retourner 1" << endl;
    cout << " Postion de \"Francis\" : " << ptrListe->getPositIter("Francis") << " ; devrait retourner 3" << endl;
    cout << " Postion de \"Hervé\" : " << ptrListe->getPositIter("Hervé") << " ; devrait retourner 7" << endl;
    cout << " Postion de \"Jérôme\" : " << ptrListe->getPositIter("Jérôme") << " ; devrait retourner 9" << endl;
    cout << " Postion de \"Philippe\" : " << ptrListe->getPositIter("Philippe") << " ; devrait retourner 10" << endl;
    cout << " Postion de \"Sophie\" : " << ptrListe->getPositIter("Sophie") << " ; devrait retourner 12" << endl;
    ptrListe->supprimePremOccInfoRec("Ana");
    cout << endl << "Après suppression de la première occurrence de \"Ana\", la liste contient : " << endl << " -> ";
    ptrListe->afficheCroissantRec();
    cout << endl;
    ptrListe->supprimePremOccInfoRec("Jérôme");
    cout << endl << "Après suppression de la première et unique occurrence de \"Jérôme\", la liste contient : " << endl << " -> ";
    ptrListe->afficheCroissantRec();
    cout << endl;
    ptrListe->supprimePremOccInfoRec("Francis");
    cout << endl << "Après suppression de la première occurrence de \"Francis\", la liste contient : " << endl << " -> ";
    ptrListe->afficheCroissantRec();
    cout << endl;
    ptrListe->supprimePremOccInfoRec("Philippe");
    cout << endl << "Après suppression de la première occurrence de \"Philippe\", la liste contient : " << endl << " -> ";
    ptrListe->afficheCroissantRec();
    cout << endl;
    ptrListe->supprimePremOccInfoRec("Ana");
    cout << endl << "Après suppression de la première occurrence de \"Ana\", la liste contient : " << endl << " -> ";
    ptrListe->afficheCroissantRec();
    cout << endl;
}

void testeEstEnsemble() {
    cout << endl << "**********************************" << endl;
    cout << "*                                *" << endl;
    cout << "*         testEstEnsemble()      *" << endl;
    cout << "*                                *" << endl;
    cout << "**********************************" << endl << endl;

    ListeTrieeChainee<int>* ptrListeVide = new ListeTrieeChainee<int>();
    ListeTrieeChainee<int>* ptrListeUneCellule = new ListeTrieeChainee<int>();
    ListeTrieeChainee<int>* ptrListeTrieeEnsemble = new ListeTrieeChainee<int>();
    ListeTrieeChainee<int>* ptrListeTrieeNonEnsemble = new ListeTrieeChainee<int>();

    cout << "Une liste videRec" << endl << " -> ";
    ptrListeVide->afficheCroissantRec();
    cout << endl << "est un ensemble ? : " << ptrListeVide->estEnsemble() << " (devrait répondre true)" << endl;

    ptrListeUneCellule->insereRec(12);
    cout << endl << "Une liste avec une Cellule" << endl << " -> ";
    ptrListeUneCellule->afficheCroissantRec();
    cout << endl << "est un ensemble ? : " << ptrListeUneCellule->estEnsemble() << " (devrait répondre true)" << endl;

    ptrListeTrieeEnsemble->insereRec(1);
    ptrListeTrieeEnsemble->insereRec(2);
    ptrListeTrieeEnsemble->insereRec(3);
    ptrListeTrieeEnsemble->insereRec(4);
    ptrListeTrieeEnsemble->insereRec(5);
    cout << endl << "Une liste triée sans duplication" << endl << " -> ";
    ptrListeTrieeEnsemble->afficheCroissantRec();
    cout << endl << "est un ensemble ? : " << ptrListeTrieeEnsemble->estEnsemble() << " (devrait répondre true)" << endl;

    ptrListeTrieeNonEnsemble->insereRec(1);
    ptrListeTrieeNonEnsemble->insereRec(2);
    ptrListeTrieeNonEnsemble->insereRec(3);
    ptrListeTrieeNonEnsemble->insereRec(3);
    ptrListeTrieeNonEnsemble->insereRec(5);
    cout << endl << "Une liste triée avec duplication" << endl << " -> ";
    ptrListeTrieeNonEnsemble->afficheCroissantRec();
    cout << endl << "est un ensemble ? : " << ptrListeTrieeNonEnsemble->estEnsemble() << " (devrait répondre true)" << endl;
    cout << endl;
}

void testeIntersection() {
    cout << endl << "**********************************" << endl;
    cout << "*                                *" << endl;
    cout << "*        testeIntersection()     *" << endl;
    cout << "*                                *" << endl;
    cout << "**********************************" << endl << endl;

    ListeTrieeChainee<int>* ptrEnsembleA = new ListeTrieeChainee<int>();
    ListeTrieeChainee<int>* ptrEnsembleB = new ListeTrieeChainee<int>();
    ListeTrieeChainee<int>* ptrEnsembleVide = new ListeTrieeChainee<int>();

    ptrEnsembleA->insereRec(1);
    ptrEnsembleA->insereRec(2);
    ptrEnsembleA->insereRec(3);
    ptrEnsembleA->insereRec(4);
    ptrEnsembleA->insereRec(5);
    cout << "ensemble A" << endl << " -> ";
    ptrEnsembleA->afficheCroissantRec();

    ptrEnsembleB->insereRec(1);
    ptrEnsembleB->insereRec(4);
    cout << endl << "ensemble B" << endl << " -> ";
    ptrEnsembleB->afficheCroissantRec();
    cout << endl << "ensemble vide" << endl << " -> ";
    ptrEnsembleVide->afficheCroissantRec();
    cout << endl;

    ListeTrieeChainee<int>* ptrEnsembleC = ptrEnsembleA->insersectionAvec(ptrEnsembleB);
    cout << endl << "instersection de A et B" << endl << " -> ";
    ptrEnsembleC->afficheCroissantRec();

    ListeTrieeChainee<int>* ptrEnsembleD = ptrEnsembleA->insersectionAvec(ptrEnsembleVide);
    cout << endl << "instersection de A et vide" << endl << " -> ";
    ptrEnsembleD->afficheCroissantRec();
    cout << endl;
}

void testeUnion() {
    cout << endl << "**********************************" << endl;
    cout << "*                                *" << endl;
    cout << "*        testeUnion()            *" << endl;
    cout << "*                                *" << endl;
    cout << "**********************************" << endl << endl;

    ListeTrieeChainee<int>* ptrEnsembleA = new ListeTrieeChainee<int>();
    ListeTrieeChainee<int>* ptrEnsembleB = new ListeTrieeChainee<int>();
    ListeTrieeChainee<int>* ptrEnsembleVide = new ListeTrieeChainee<int>();

    ptrEnsembleA->insereRec(1);
    ptrEnsembleA->insereRec(2);
    ptrEnsembleA->insereRec(3);
    ptrEnsembleA->insereRec(4);
    ptrEnsembleA->insereRec(5);
    cout << "ensemble A" << endl << " -> ";
    ptrEnsembleA->afficheCroissantRec();

    ptrEnsembleB->insereRec(1);
    ptrEnsembleB->insereRec(7);
    cout << endl << "ensemble B" << endl << " -> ";
    ptrEnsembleB->afficheCroissantRec();

    cout << endl << "ensemble vide" << endl << " -> ";
    ptrEnsembleVide->afficheCroissantRec();
    cout << endl;

    ListeTrieeChainee<int>* ptrEnsembleC = ptrEnsembleA->unionAvec(ptrEnsembleB);
    cout << endl << "union de A et B" << endl << " -> ";
    ptrEnsembleC->afficheCroissantRec();
    ListeTrieeChainee<int>* ptrEnsembleD = ptrEnsembleA->unionAvec(ptrEnsembleVide);
    cout << endl << "union de A et vide" << endl << " -> ";
    ptrEnsembleD->afficheCroissantRec();
    cout << endl;
}

int main(int argc, char** argv) {

    ListeTrieeChainee<string>* ptrMaListe = new ListeTrieeChainee<string>();

    construitListe(ptrMaListe);

    testeGetPosit(ptrMaListe);

    testeAffiche(ptrMaListe);

    testeInsereRec(ptrMaListe);

    // réinitialisation de la liste
    construitListe(ptrMaListe);

    testeSupprimePremOccInfoRec(ptrMaListe);

    // réinitialisation de la liste
    construitListe(ptrMaListe);

    testeSupprimePremOccInfoIter(ptrMaListe);

    /*
     * Autour des ensembles
     */

    // réinitialisation de la liste
    construitListe(ptrMaListe);

    testeValeursDupliquees(ptrMaListe);

    testeEstEnsemble();

    testeIntersection();

    testeUnion();

    return 0;
} // end main

/*
**********************************
*                                *
*        construitListe()        *
*                                *
**********************************

La liste initiale est-elle videRec ? : 1 ; devrait répondre 1 (true)
Après 6 insertions la liste contient : 6 Cellules ; devrait répondre 6
La liste est elle videRec ? : 0 ; devrait répondre 0 (false)

**********************************
*                                *
*        testeGetPosit()        *
*                                *
**********************************

La liste contient initialement : Ana Francis Hervé Jérôme Philippe Sophie

Recherches de valeurs présentes ->
 Postion de "Ana" : 1 ; devrait retourner 1
 Postion de "Jérôme" : 4 ; devrait retourner 4
 Postion de "Sophie" : 6 ; devrait retourner 6

Recherches de valeurs absentes ->
 Postion de "Adam" : -1 ; devrait retourner -1
 Postion de "Jacques" : -4 ; devrait retourner -4
 Postion de "Violette" : -7 ; devrait retourner -7

**********************************
*                                *
*         testeAffiche()         *
*                                *
**********************************

Dans l'ordre croissant avec une procédure récursive, la liste contient :
   -> Ana Francis Hervé Jérôme Philippe Sophie

**********************************
*                                *
*        testeInsertRec()        *
*                                *
**********************************

La liste contient initialement : Ana Francis Hervé Jérôme Philippe Sophie

Insertion de Adam en début de liste
  -> la liste contient : Adam Ana Francis Hervé Jérôme Philippe Sophie
Insertion de Jacques en milieu de liste
  -> la liste contient : Adam Ana Francis Hervé Jacques Jérôme Philippe Sophie
Insertion de Violette en fin de liste
  -> la liste contient : Adam Ana Francis Hervé Jacques Jérôme Philippe Sophie Violette

**********************************
*                                *
*        construitListe()        *
*                                *
**********************************

La liste initiale est-elle videRec ? : 0 ; devrait répondre 1 (true)
Après 6 insertions la liste contient : -3 Cellules ; devrait répondre 6
La liste est elle videRec ? : 0 ; devrait répondre 0 (false)

**********************************
*                                *
*  testeSupprimePremOccInfoRec() *
*                                *
**********************************

La liste contient initialement : Ana Francis Hervé Jérôme Philippe Sophie

Après suppression de "Ana" (le premier), la liste contient : Francis Hervé Jérôme Philippe Sophie
Après suppression de "Jérôme" (au milieu), la liste contient : Francis Hervé Philippe Sophie
Après suppression de "Sophie" (le dernier), la liste contient : Francis Hervé Philippe
Après suppression de "Adam" (avant le premier), la liste contient : Francis Hervé Philippe
Après suppression de "Jacques" (entre deux valeurs au milieu), la liste contient : Francis Hervé Philippe
Après suppression de "Violette" (après le dernier), la liste contient : Francis Hervé Philippe

**********************************
*                                *
*        construitListe()        *
*                                *
**********************************

La liste initiale est-elle videRec ? : 0 ; devrait répondre 1 (true)
Après 6 insertions la liste contient : -6 Cellules ; devrait répondre 6
La liste est elle videRec ? : 0 ; devrait répondre 0 (false)

***********************************
*                                 *
*  testeSupprimePremOccInfoIter() *
*                                 *
***********************************

La liste contient initialement : Ana Francis Hervé Jérôme Philippe Sophie

Après suppression de "Ana" (le premier), la liste contient : Francis Hervé Jérôme Philippe Sophie
Après suppression de "Jérôme" (au milieu), la liste contient : Francis Hervé Philippe Sophie
Après suppression de "Sophie" (le dernier), la liste contient : Francis Hervé Philippe
Après suppression de "Adam" (avant le premier), la liste contient : Francis Hervé Philippe
Après suppression de "Jacques" (entre deux valeurs au milieu), la liste contient : Francis Hervé Philippe
Après suppression de "Violette" (après le dernier), la liste contient : Francis Hervé Philippe

**********************************
*                                *
*        construitListe()        *
*                                *
**********************************

La liste initiale est-elle videRec ? : 0 ; devrait répondre 1 (true)
Après 6 insertions la liste contient : -9 Cellules ; devrait répondre 6
La liste est elle videRec ? : 0 ; devrait répondre 0 (false)

**********************************
*                                *
*     testeValeursDupliquees()   *
*                                *
**********************************

La liste contient initialement : Ana Francis Hervé Jérôme Philippe Sophie

Insertion de "Francis", "Ana", "Francis", "Hervé", "Francis", "Philippe"
  -> La liste contient maintenant : Ana Ana Francis Francis Francis Francis Hervé Hervé Jérôme Philippe Philippe Sophie

Recherches de valeurs présentes ->
 Postion de "Ana" : 1 ; devrait retourner 1
 Postion de "Francis" : 3 ; devrait retourner 3
 Postion de "Hervé" : 7 ; devrait retourner 7
 Postion de "Jérôme" : 9 ; devrait retourner 9
 Postion de "Philippe" : 10 ; devrait retourner 10
 Postion de "Sophie" : 12 ; devrait retourner 12

Après suppression de la première occurrence de "Ana", la liste contient :
 -> Ana Francis Francis Francis Francis Hervé Hervé Jérôme Philippe Philippe Sophie

Après suppression de la première et unique occurrence de "Jérôme", la liste contient :
 -> Ana Francis Francis Francis Francis Hervé Hervé Philippe Philippe Sophie

Après suppression de la première occurrence de "Francis", la liste contient :
 -> Ana Francis Francis Francis Hervé Hervé Philippe Philippe Sophie

Après suppression de la première occurrence de "Philippe", la liste contient :
 -> Ana Francis Francis Francis Hervé Hervé Philippe Sophie

Après suppression de la première occurrence de "Ana", la liste contient :
 -> Francis Francis Francis Hervé Hervé Philippe Sophie

**********************************
*                                *
*         testEstEnsemble()      *
*                                *
**********************************

Une liste videRec
 ->
est un ensemble ? : 1 (devrait répondre true)

Une liste avec une Cellule
 -> 12
est un ensemble ? : 1 (devrait répondre true)

Une liste triée sans duplication
 -> 1 2 3 4 5
est un ensemble ? : 1 (devrait répondre true)

Une liste triée avec duplication
 -> 1 2 3 3 5
est un ensemble ? : 0 (devrait répondre true)


**********************************
*                                *
*        testeIntersection()     *
*                                *
**********************************

ensemble A
 -> 1 2 3 4 5
ensemble B
 -> 1 4
ensemble vide
 ->

instersection de A et B
 -> 1 4
instersection de A et vide
 ->

**********************************
*                                *
*        testeUnion()            *
*                                *
**********************************

ensemble A
 -> 1 2 3 4 5
ensemble B
 -> 1 7
ensemble vide
 ->

union de A et B
 -> 1 2 3 4 5 7
union de A et vide
 -> 1 2 3 4 5
 */
