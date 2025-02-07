
#ifndef NOEUDBINAIREINT_H
#define	NOEUDBINAIREINT_H

class NoeudBinaireInt {
public:
    NoeudBinaireInt(int uneInfo);
    virtual ~NoeudBinaireInt();
    
    int getInfo() const;
    void setInfo(int uneInfo);
    
    bool estFeuille() const;
    
    NoeudBinaireInt* getPtrFilsGauche() const;
    NoeudBinaireInt* getPtrFilsDroit() const;

    void setPtrFilsGauche(NoeudBinaireInt* ptrFilsG);
    void setPtrFilsDroit(NoeudBinaireInt* ptrFilsD);
    
    void affiche() const;
    
    
private:
    int info;
    NoeudBinaireInt* ptrFilsGauche; // pointeur sur le fils gauche
    NoeudBinaireInt* ptrFilsDroit;  // pointeur sur le fils droit
    
};

#endif	/* NOEUDBINAIREINT_H */

