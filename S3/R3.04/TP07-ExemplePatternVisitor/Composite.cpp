#include "Composite.h"
#include "Visiteur.h"

void Fichier::accepte(const Visiteur & v) const {
    v.visite(*this);
}

void Repertoire::accepte(const Visiteur & v) const {
    v.visite(*this);
}

std::string Fichier::nomFichier() const {
    return "Fichier";
}

std::string Repertoire::nomRepertoire() const {
    return "Repertoire";
}