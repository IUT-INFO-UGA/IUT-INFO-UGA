#ifndef SALARIE_H
#define	SALARIE_H

#include <string>
#include <iostream>
#include "SalarieException.h"
#include "ObjetContraint.h"
#include <map>

class Salarie {
public:
    // A COMPLETER : Spécifier les méthodes d'instance d'un Salarie

    Salarie();
    Salarie(std::string nom, std::string numeroSS, float salaire);
    ~Salarie();
    std::string getNom() const;
    std::string getNumeroSS() const;
    float getSalaireMensuel() const;
    void setNom(std::string nom);
    void setNumeroSS(std::string numeroSS);
    void setSalaireMensuel(float salaire);
    float getImpot();
    void saisir(std::istream & entree);
    void afficher(std::ostream & sortie);

    // Fourni : Constantes de Classe
    static const float                 SMIC;
    static const float                 COEFF_SMIC;
    static const std::string           NOM_DEF;
    static const std::string           NUMERO_SS_DEF;
    static const std::map<float,float> TRANCHES_IMPOT;

private:
    std::string m_nom;
    std::string m_numeroSS;
    ObjetContraint<float> *m_salaireMensuel;
};

#endif	/* SALARIE_H */

