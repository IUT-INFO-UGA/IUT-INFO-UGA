#ifndef SALARIEEXCEPTION_H
#define SALARIEEXCEPTION_H
#include <stdexcept>


// A Compléter

// Toutes les exceptions de la classe Salarie seront dues à des valeurs non conformes (nom, numéro SS ou salaire)
// On va donc faire dériver SalarieExcemtion de domain_error qui est l'exception prédéfinie dans <stdexcept> pour ce genre de situation

class SalarieException  {
};

class NomIncorrectException {
};

class NumeroIncorrectException {
};

class SalaireIncorrectException {
};

#endif /* SALARIEEXCEPTION_H */

