#include "Composite.h"
#include "Visiteur.h"

int main() {
    Element * liste[] = {new Fichier(), new Repertoire()};
    Operation1 op1; // On instancie un visiteur de type Operation1
    Operation2 op2; // On instancie un visiteur de type Operation2
    // On "visite" les éléments avec op1
    for (int i = 0; i < 2; i++) {
        liste[i]->accepte(op1);
    }
    // On  "visite" les éléments avec op2
    for (int i = 0; i < 2; i++) {
        liste[i]->accepte(op2);
    }
}