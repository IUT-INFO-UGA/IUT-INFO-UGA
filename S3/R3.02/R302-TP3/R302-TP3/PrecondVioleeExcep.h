//  HB librement inspiré de
//  Data Abstraction & Problem Solving with C++: Walls and Mirrors
//  Frank M. Carrano and Tim Henry.
//  2013 – Pearson Education

/** Classe définissant une exception pour précondition violée lors de l'appel d'une méthode.
    @file PrecondViolatedExcep.h */

#ifndef _PRECOND_VIOLEE_EXCEP
#define _PRECOND_VIOLEE_EXCEP

#include <stdexcept>
#include <string>

using namespace std;

class PrecondVioleeExcep : public logic_error
{
public:
   PrecondVioleeExcep(const string& message = "");
}; // end PrecondVioleeExcep

#endif
