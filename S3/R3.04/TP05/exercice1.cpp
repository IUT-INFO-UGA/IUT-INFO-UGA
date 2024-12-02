#include <iostream>
#include "Salarie.h"
#include "SalarieException.h"

int main()
{
    try {
        Salarie salarie;
        salarie.afficher(std::cout);
    }
    catch (const NomIncorrectException& e) {
        std::cerr << "Erreur: de nombre" << std::endl;
    }
    catch (const NumeroIncorrectException& e) {
        std::cerr << "Erreur: de numero"<< std::endl;
    }
    catch (const SalaireIncorrectException& e) {
        std::cerr << "Erreur: de salaire"<< std::endl;
    }
    catch (const std::exception& e) {
        std::cerr << "Erreur inconnue" << std::endl;
    }

    return 0;
}
