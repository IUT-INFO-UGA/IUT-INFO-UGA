#include <iostream>
#include <string>
#include "../ListeChainee.h"

using namespace std;

void testeAffiche() {
    cout << "**********************************" << endl;
    cout << "*                                *" << endl;
    cout << "*         testeAffiche()         *" << endl;
    cout << "*                                *" << endl;
    cout << "**********************************" << endl << endl;

    //--> Construire une liste d'entiers avec des insereTete()
    ListeChainee<int> uneListe;
    uneListe.insereTete(6);
    uneListe.insereTete(5);
    uneListe.insereTete(4);
    uneListe.insereTete(3);
    uneListe.insereTete(2);
    uneListe.insereTete(1);

    //--> Faire l'affichage récursif de la liste de gauche à droite
    uneListe.afficheGDRec();
    cout << endl;

    //--> Faire l'affichage récursif de la liste de droite à gauche
    uneListe.afficheDGRec();
    cout << endl;

    //--> Faire l'affichage itératif de la liste de gauche à droite
    uneListe.afficheGDIter();
    cout << endl;

}

void testeAfficheIter() {
    cout << endl << "**********************************" << endl;
    cout << "*                                *" << endl;
    cout << "*       testeAfficheIter()       *" << endl;
    cout << "*                                *" << endl;
    cout << "**********************************" << endl << endl;
    //--> Construire une liste d'entiers avec des insereTete()
    ListeChainee<int> uneListe;
    uneListe.insereTete(6);
    uneListe.insereTete(5);
    uneListe.insereTete(4);
    uneListe.insereTete(3);
    uneListe.insereTete(2);
    uneListe.insereTete(1);

    //--> Faire l'affichage itératif de la liste de gauche à droite
    uneListe.afficheGDIter();
    cout << endl;

    //--> Faire l'affichage itératif de la liste de droite à gauche
    uneListe.afficheDGIter();
    cout << endl;

} // end testeAfficheIter()

void testeInsereAtPositRec() {
    cout << "**********************************" << endl;
    cout << "*                                *" << endl;
    cout << "*     testeInsereAtPositRec()    *" << endl;
    cout << "*                                *" << endl;
    cout << "**********************************" << endl << endl;

    ListeChainee<string> uneListe;
    cout << "uneListe vient d'être construite elle doit être videRec !" << endl;
    cout << "estVide() retourne " << uneListe.estVide() << " ; devrait retouner 1 (true)" << endl;
    cout << endl << "Insertion de zéro, un, deux, trois, quatre, cinq aux positions repectives 1, 2, 3, 4, 5, 6" << endl;
    string items[] = {"zéro", "un", "deux", "trois", "quatre", "cinq"};
    for (int i = 0; i < 6; i++) {
        cout << "Ajout de : " << items[i] << endl;
        bool success = uneListe.insereAtPositRec(i + 1, items[i]);
        if (!success) {
            cout << "Ajout de : " << items[i] << " à la liste impossible." << endl;
        }
    }
    uneListe.afficheGDRec();

    cout << "estVide() retourne " << uneListe.estVide() << " ; devrait retouner 0 (false)" << endl;
    cout << "getLongueur() retourne " << uneListe.getLongueur() << " ; devrait retouner 6" << endl;
    cout << "insertion à la position 3 de \"entreUnEtDeux\"" << endl;
    uneListe.insereAtPositRec(3, "entreUnEtDeux");
    cout << "insertion à la position 1 de \"avantZéro\"" << endl;
    uneListe.insereAtPositRec(1, "avantZéro");
    cout << "insertion à la position 9 de \"aprèsCinq\"" << endl;
    uneListe.insereAtPositRec(9, "aprèsCinq");
    cout << "insertion à la position 11 de \"tropLoin\"" << endl;
    uneListe.insereAtPositRec(11, "tropLoin");
    uneListe.afficheGDRec();
}

void testeSupprimeAtPositIter() {
    cout << endl << "**********************************" << endl;
    cout << "*                                *" << endl;
    cout << "*   testeSupprimeAtPositIter()   *" << endl;
    cout << "*                                *" << endl;
    cout << "**********************************" << endl << endl;

    ListeChainee<string> uneListe;
    cout << "Insertion de zéro, un, deux, trois, quatre, cinq aux positions repectives 1, 2, 3, 4, 5, 6" << endl;
    string items[] = {"zéro", "un", "deux", "trois", "quatre", "cinq"};
    for (int i = 0; i < 6; i++) {
        //cout << "Ajout de : " << items[i] << endl;
        bool success = uneListe.insereAtPositRec(i + 1, items[i]);
        if (!success) {
            cout << "Ajout de : " << items[i] << " à la liste impossible." << endl;
        }
    }
    cout << "La liste originale contient : " << endl;
    uneListe.afficheGDRec();

    cout << "suppression à la position 1 de \"zéro\"" << endl;
    uneListe.supprimeAtPositIter(1);
    uneListe.afficheGDRec();
    cout << "suppression à la position 2 de \"deux\"" << endl;
    uneListe.supprimeAtPositIter(2);
    uneListe.afficheGDRec();
    cout << "suppression à la position 4 de \"cinq\"" << endl;
    uneListe.supprimeAtPositIter(4);
    uneListe.afficheGDRec();
    cout << "suppression à la position 11 (trop loin !)" << endl;
    uneListe.supprimeAtPositIter(11);
    uneListe.afficheGDRec();

}

void testeEstInfoPresentRec() {
    cout << endl << "**********************************" << endl;
    cout << "*                                *" << endl;
    cout << "*    testeEstInfoPresentRec()    *" << endl;
    cout << "*                                *" << endl;
    cout << "**********************************" << endl << endl;

    ListeChainee<string> uneListe;
    cout << "Insertion de zéro, un, deux, trois, quatre, cinq aux positions repectives 1, 2, 3, 4, 5, 6" << endl;
    string items[] = {"zéro", "un", "deux", "trois", "quatre", "cinq"};
    for (int i = 0; i < 6; i++) {
        //cout << "Ajout de : " << items[i] << endl;
        bool success = uneListe.insereAtPositRec(i + 1, items[i]);
        if (!success) {
            cout << "Ajout de : " << items[i] << " à la liste impossible." << endl;
        }
    }
    cout << "La liste originale contient : " << endl;
    uneListe.afficheGDRec();
    string uneChaine = "zéro";
    cout << "\"" << uneChaine << "\" est-elle dans la liste : " << uneListe.estInfoPresentRec(uneChaine) << " (devrait être true)" << endl;
    uneChaine = "quatre";
    cout << "\"" << uneChaine << "\" est-elle dans la liste : " << uneListe.estInfoPresentRec(uneChaine) << " (devrait être true)" << endl;
    uneChaine = "test";
    cout << "\"" << uneChaine << "\" est-elle dans la liste : " << uneListe.estInfoPresentRec(uneChaine) << " (devrait être false)" << endl;
    uneChaine = "cinq";
    cout << "\"" << uneChaine << "\" est-elle dans la liste : " << uneListe.estInfoPresentRec(uneChaine) << " (devrait être true)" << endl;
}


void testeSupprimeAtPositRecAvecProc() {
    cout << endl << "**********************************" << endl;
    cout << "*                                *" << endl;
    cout << "*    testeSupprimeAtPositRec()   *" << endl;
    cout << "*                                *" << endl;
    cout << "**********************************" << endl << endl;
    
    ListeChainee<string> uneListe;
    cout << "Insertion de zéro, un, deux, trois, quatre, cinq aux positions repectives 1, 2, 3, 4, 5, 6" << endl;
    string items[] = {"zéro", "un", "deux", "trois", "quatre", "cinq"};
    for (int i = 0; i < 6; i++) {
        //cout << "Ajout de : " << items[i] << endl;
        bool success = uneListe.insereAtPositRec(i + 1, items[i]);
        if (!success) {
            cout << "Ajout de : " << items[i] << " à la liste impossible." << endl;
        }
    }
    cout << "La liste originale contient : " << endl;
    uneListe.afficheGDRec();

    cout << "suppression à la position 1 de \"zéro\"" << endl;
    uneListe.supprimeAtPositRec(1);
    uneListe.afficheGDRec();
    cout << "suppression à la position 2 de \"deux\"" << endl;
    uneListe.supprimeAtPositRec(2);
    uneListe.afficheGDRec();
    cout << "suppression à la position 4 de \"cinq\"" << endl;
    uneListe.supprimeAtPositRec(4);
    uneListe.afficheGDRec();
    cout << "suppression à la position 11 (trop loin !)" << endl;
    uneListe.supprimeAtPositRec(11);
    uneListe.afficheGDRec();

}

void testeInsereAtPositIter() {
    cout << endl << "**********************************" << endl;
    cout << "*                                *" << endl;
    cout << "*    testeInsertAtPositIter()    *" << endl;
    cout << "*                                *" << endl;
    cout << "**********************************" << endl << endl;

    ListeChainee<string> uneListe;
    cout << "uneListe vient d'être construite elle doit être videRec !" << endl;
    cout << "estVide() retourne " << uneListe.estVide() << " ; devrait retouner 1 (true)" << endl;
    cout << endl << "Insertion de zéro, un, deux, trois, quatre, cinq aux positions repectives 1, 2, 3, 4, 5, 6" << endl;
    string items[] = {"zéro", "un", "deux", "trois", "quatre", "cinq"};
    for (int i = 0; i < 6; i++) {
        //cout << "Ajout de : " << items[i] << endl;
        bool success = uneListe.insereAtPositIter(i + 1, items[i]);
        if (!success) {
            cout << "Ajout de : " << items[i] << " à la liste impossible." << endl;
        }
    }
    uneListe.afficheGDRec();

    cout << "estVide() retourne " << uneListe.estVide() << " ; devrait retouner 0 (false)" << endl;
    cout << "getLongueur() retourne " << uneListe.getLongueur() << " ; devrait retouner 6" << endl;
    cout << "insertion à la position 3 de \"entreUnEtDeux\"" << endl;
    uneListe.insereAtPositIter(3, "entreUnEtDeux");
    cout << "insertion à la position 1 de \"avantZéro\"" << endl;
    uneListe.insereAtPositIter(1, "avantZéro");
    cout << "insertion à la position 9 de \"aprèsCinq\"" << endl;
    uneListe.insereAtPositIter(9, "aprèsCinq");
    uneListe.afficheGDRec();

}



int main() {
    //testeAffiche();
    testeInsereAtPositRec();
    testeSupprimeAtPositRecAvecProc();
    testeEstInfoPresentRec();
    testeInsereAtPositIter();
    testeSupprimeAtPositIter();
    testeAfficheIter();
    return 0;
}

/*
**********************************
*                                *
*         testeAffiche()         *
*                                *
**********************************

En parcours récursif de gauche à droite, la liste contient -> 1 2 3 4 5 6 

En parcours récursif de droite à gauche, la liste contient -> 6 5 4 3 2 1 

En parcours itératif de gauche à droite, la liste contient -> 1 2 3 4 5 6 

**********************************
*                                *
*     testeInsereAtPositRec()    *
*                                *
**********************************

uneListe vient d'être construite elle doit être videRec !
estVide() retourne 1 ; devrait retouner 1 (true)

Insertion de zéro, un, deux, trois, quatre, cinq aux positions repectives 1, 2, 3, 4, 5, 6
En parcours récursif de gauche à droite, la liste contient -> zéro un deux trois quatre cinq
estVide() retourne 0 ; devrait retouner 0 (false)
getLongueur() retourne 6 ; devrait retouner 6
insertion à la position 3 de "entreUnEtDeux"
insertion à la position 1 de "avantZéro"
insertion à la position 9 de "aprèsCinq"
insertion à la position 11 de "tropLoin"
En parcours récursif de gauche à droite, la liste contient -> avantZéro zéro un entreUnEtDeux deux trois quatre cinq aprèsCinq

**********************************
*                                *
*    testeSupprimeAtPositRec()   *
*                                *
**********************************

Insertion de zéro, un, deux, trois, quatre, cinq aux positions repectives 1, 2, 3, 4, 5, 6
La liste originale contient :
En parcours récursif de gauche à droite, la liste contient -> zéro un deux trois quatre cinq
suppression à la position 1 de "zéro"
En parcours récursif de gauche à droite, la liste contient -> un deux trois quatre cinq
suppression à la position 2 de "deux"
En parcours récursif de gauche à droite, la liste contient -> un trois quatre cinq
suppression à la position 4 de "cinq"
En parcours récursif de gauche à droite, la liste contient -> un trois quatre
suppression à la position 11 (trop loin !)
En parcours récursif de gauche à droite, la liste contient -> un trois quatre

**********************************
*                                *
*    testeEstInfoPresentRec()    *
*                                *
**********************************

Insertion de zéro, un, deux, trois, quatre, cinq aux positions repectives 1, 2, 3, 4, 5, 6
La liste originale contient :
En parcours récursif de gauche à droite, la liste contient -> zéro un deux trois quatre cinq
"zéro" est-elle dans la liste : 1 (devrait être true)
"quatre" est-elle dans la liste : 1 (devrait être true)
"test" est-elle dans la liste : 0 (devrait être false)
"cinq" est-elle dans la liste : 1 (devrait être true)

**********************************
*                                *
*    testeInsertAtPositIter()    *
*                                *
**********************************

uneListe vient d'être construite elle doit être videRec !
estVide() retourne 1 ; devrait retouner 1 (true)

Insertion de zéro, un, deux, trois, quatre, cinq aux positions repectives 1, 2, 3, 4, 5, 6
En parcours récursif de gauche à droite, la liste contient -> zéro un deux trois quatre cinq
estVide() retourne 0 ; devrait retouner 0 (false)
getLongueur() retourne 6 ; devrait retouner 6
insertion à la position 3 de "entreUnEtDeux"
insertion à la position 1 de "avantZéro"
insertion à la position 9 de "aprèsCinq"
En parcours récursif de gauche à droite, la liste contient -> avantZéro zéro un entreUnEtDeux deux trois quatre cinq aprèsCinq

**********************************
*                                *
*   testeSupprimeAtPositIter()   *
*                                *
**********************************

Insertion de zéro, un, deux, trois, quatre, cinq aux positions repectives 1, 2, 3, 4, 5, 6
La liste originale contient : 
En parcours récursif de gauche à droite, la liste contient -> zéro un deux trois quatre cinq 
suppression à la position 1 de "zéro"
En parcours récursif de gauche à droite, la liste contient -> un deux trois quatre cinq 
suppression à la position 2 de "deux"
En parcours récursif de gauche à droite, la liste contient -> un trois quatre cinq 
suppression à la position 4 de "cinq"
En parcours récursif de gauche à droite, la liste contient -> un trois quatre 
suppression à la position 11 (trop loin !)
En parcours récursif de gauche à droite, la liste contient -> un trois quatre 

**********************************
*                                *
*       testeAfficheIter()       *
*                                *
**********************************

En parcours itératif de gauche à droite, la liste contient -> 1 2 3 4 5 6 

En parcours itératif de droite à gauche, la liste contient -> 6 5 4 3 2 1 
 */
