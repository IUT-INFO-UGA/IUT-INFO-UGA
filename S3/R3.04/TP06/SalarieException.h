#ifndef SALARIEEXCEPTION_H
#define SALARIEEXCEPTION_H
#include <stdexcept>


// Toutes les exceptions de la classe Salarie seront dues à des valeurs non conformes (nom, numéro SS ou salaire)
// On fait donc dériver SalarieExcemtion de domain_error qui est l'exception prédéfinie dans <stdexcept> pour ce genre de situation

class SalarieException : public std::domain_error {
public:

    SalarieException(const std::string & what_arg) : std::domain_error(what_arg) {
    }
};

class NomIncorrectException : public SalarieException {
public:

    NomIncorrectException(const std::string & what_arg = "Exception Salarie : Nom Incorrect")
    : SalarieException(what_arg) {
    }
};

class NumeroIncorrectException : public SalarieException {
public:

    NumeroIncorrectException(const std::string & what_arg = "Exception Salarie : Numéro SS Incorrect")
    : SalarieException(what_arg) {
    }
};

class SalaireIncorrectException : public SalarieException {
public:

    SalaireIncorrectException(const std::string & what_arg = "Exception Salarie : Salaire Mensuel Incorrect")
    : SalarieException(what_arg) {
    }
};

#endif /* SALARIEEXCEPTION_H */

