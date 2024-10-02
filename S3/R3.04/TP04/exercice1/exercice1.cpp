#include "Element.h"
#include "Repertoire.h"
#include "Fichier.h"
#include "Usager.h"
using namespace std;

// Système de Fichiers Créé
//
//                       COVID
//                         |
//           +-------------+-------------+   
//           |             |             |
//         STATS      discours.doc   DECISIONS
//           |
//      +----+-----+
//      |          |
//  isere.xls   rhone.xls

int main(int argc, char** argv) {
    
    Usager manu("Manu", "profs");
    Usager jean("Jean", "etudiants");
    Element* covid = new Repertoire("COVID", manu);                          // Création répertoire COVID de Manu
    Element* stats = new Repertoire("STATS", jean);                          // Création répertoire STATS de Jean
    covid->ajouter(stats);                                                   // Ajout répertoire STATS au répertoire COVID
    Element* isere = new Fichier("isere.xls", 5, "2020-10-01", jean);        // Création fichier isere.xls de Jean
    stats->ajouter(isere);                                                   // Ajout fichier isere.xls au répertoire STATS
    Element* rhone = new Fichier("rhone.xls", 15, "2020-10-02", jean);       // Création du fichier rhone.xls de Jean
    stats->ajouter(rhone);                                                   // Ajout fichier rhone.xls au répertoire STATS    
    Element* discours = new Fichier("discours.doc", 10, "2020-10-14", manu); // Création fichier discours.doc de Manu
    covid->ajouter(discours);                                                // Ajout fichier discours.doc au répertoire COVID
    Element* decisions = new Repertoire("DECISIONS", manu);                  // Création répertoire DECISIONS de Manu
    covid->ajouter(decisions);                                               // Ajout répertoire DECISIONS au répertoire COVID

    covid->afficher();     // Affichage dossier COVID
    stats->afficher();     // Affichage dossier STATS
    isere->afficher();     // Affichage fichier isere.xls
    rhone->afficher();     // Affichage fichier rhone.xls
    discours->afficher();  // Affichage fichier discours.doc
    decisions->afficher(); // Affichage dossier DECISIONS

    // Facultatif
    // string chemin = covid->rechercher("isere.xls");
    // cout << "Recherche de isere.xls dans COVID : "
    //      << ((chemin != "") ? chemin : "non trouvé?") << endl;
    // chemin = covid->rechercher("DECISIONS");
    // cout << "Recherche de DECISIONS dans COVID : "
    //      << ((chemin != "") ? chemin : "non trouvé?") << endl;
    // chemin = covid->rechercher("drome.xls");
    // cout << "Recherche de drome.xls dans COVID : "
    //      << ((chemin != "") ? chemin : "non trouvé?") << endl;
    return 0;
}

////////////// TRACE ATTENDUE //////////////////////////////////////////////////////////
// Nom : COVID - Propriétaire : Manu(profs) - Taille : 42 Ko - Date : 2020-10-14
// Nom : STATS - Propriétaire : Jean(etudiants) - Taille : 24 Ko - Date : 2020-10-02
// Nom : isere.xls - Propriétaire : Jean(etudiants) - Taille : 5 Ko - Date : 2020-10-01
// Nom : rhone.xls - Propriétaire : Jean(etudiants) - Taille : 15 Ko - Date : 2020-10-02
// Nom : discours.doc - Propriétaire : Manu(profs) - Taille : 10 Ko - Date : 2020-10-14
// Nom : DECISION - Propriétaire : Manu(profs) - Taille : 4 Ko - Date : 1970-01-01
//
// Recherche de isere.xls dans COVID : COVID/STATS/isere.xls
// Recherche de DECISIONS dans COVID : COVID/DECISION/
// Recherche de drome.xls dans COVID : non trouvé
////////////////////////////////////////////////////////////////////////////////////////