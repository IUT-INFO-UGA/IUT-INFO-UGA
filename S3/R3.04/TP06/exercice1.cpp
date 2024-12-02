#include <cstdlib>
#include <iostream>
#include <iomanip>
#include <limits>
using namespace std;

#include "Salarie.h"
#include "SalarieException.h"

int main(int argc, char** argv) {
    do {
        cout << endl << "Saisissez un(e) salarié(e) (CTRL-C pour arrêter) -----------" << endl << endl ;
        Salarie salarie;
        salarie.saisir();
        cout << endl << "Informations Salarié(e) ------------------------------------" << endl << endl ;
        salarie.afficher();
    } while(1);
  return 0;
}
