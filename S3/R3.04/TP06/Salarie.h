#ifndef SALARIE_H
#define	SALARIE_H

#include <string>
#include <iostream>
#include "SalarieException.h"
#include "ObjetContraint.h"
#include <map>

class Salarie {
public:
    Salarie(const std::string & nom = NOM_DEF,
            const std::string & numeroSS = NUMERO_SS_DEF,
            float salaireMensuel = SMIC);
    const std::string & getNom() const;
    void setNom(const std::string & nom);
    const std::string & getNumeroSS() const;
    void setNumeroSS(const std::string & numeroSS);
    float getSalaireMensuel() const;
    void setSalaireMensuel(float salaireMensuel);
    float getImpot() const;
    void saisir();
    void afficher() const;

private:
    std::string m_nom;
    std::string m_numeroSS;
    ObjetContraint<float> m_salaireMensuel;
public:
    // Constantes de Classe
    static const float SMIC;
    static const float COEFF_SMIC ;
    static const std::string NOM_DEF;
    static const std::string NUMERO_SS_DEF;
    static const std::map<float,float> TRANCHES_IMPOT;
};

#endif	/* SALARIE_H */

