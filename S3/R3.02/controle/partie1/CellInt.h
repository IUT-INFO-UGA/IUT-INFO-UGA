
#ifndef _CELLINT
#define _CELLINT


class CellInt {
private:
    int info;                   // information portée par cette CellInt
    CellInt* ptrCellSuivante;   // pointeur sur la cellule suivante
    
public:

    //Constructeur par défaut de cette CellInt
    CellInt();

    //Constructeur de cette cellule avec uneInfo comme contenu
    //@param uneInfo : valeur à ranger dans l'info de cette CellInt
    CellInt(int uneInfo);


    //constructeur qui réalise une insertion en tête dans une liste de CellInt
    //@param uneInfo : info de la première CellInt
    //@param ptrCelluleSuivante : liste qui succède à cette CellInt
    CellInt(int uneInfo, CellInt* ptrCelluleSuivante);


    //Setters pour info et ptrCellSuivante
    void setInfo(int uneInfo);
    void setSuivante(CellInt* ptrCelluleSuivante);


    //Getter pour obtenir l'info de cette CellInt
    //const car la méthode ne modifie pas cet objet
    int getInfo() const;


    // Getter d'un pointeur vers la cellule suivant cette CellInt
    // @return pointeur vers une CellInt
    // /!\ cette méthode est utilisable pour l'écriture de fonctions récursives
    // qui retournent des listes
    // const car la méthode ne modifie pas cet objet
    CellInt* getSuivante() const;

    // Getter d'une référence de pointeur vers la cellule suivant cette cellule
    // @return référence sur un pointeur vers une cellule
    // /!\ cette méthode est nécessaire pour l'écriture de procédures récursives
    // dans le modèle "intuitif"
    // Ne peut être const car le pointeur retourné peut-être modifié
    CellInt*& getRefSuivante();
    
    // Affichage de l'information portée par cette cellule
    void affiche() const;
        
}; // end CellInt

#endif