//  HB librement inspiré de
//  Data Abstraction & Problem Solving with C++: Walls and Mirrors
//  Frank M. Carrano and Tim Henry.
//  2013 – Pearson Education

/** Implémentation de la classe : une seule méthode un contructeur.
    @file PrecondVioleeExcep.cpp */

#include "PrecondVioleeExcep.h"  

PrecondVioleeExcep::PrecondVioleeExcep(const string& message): logic_error(message)
{
}  // end constructeur

// fin de l'implémentation

