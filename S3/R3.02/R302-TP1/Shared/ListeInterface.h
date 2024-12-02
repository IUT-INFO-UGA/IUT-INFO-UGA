//  HB librement inspiré de
//  Data Abstraction & Problem Solving with C++: Walls and Mirrors
//  Frank M. Carrano and Tim Henry.
//  2013 – Pearson Education

/** Interface pour le type abstrait de donnée Liste
    C'est une classe abstraite dont vont hériter chacune des classes qui
    instancient finalement la liste chaînée
 
    On voit bien cela puisque cette classe ne décrit pas les données
    Elle ne décrit que les méthodes
    @file ListeInterface.h */

#ifndef _LIST_INTERFACE
#define _LIST_INTERFACE

template<class TypeInfo>
class ListeInterface {
public:
    /** cette (this) liste est-elle videRec ,
     @return True si la liste est videRec ; False sinon. */
    virtual bool estVide() const = 0;

    /** nombre de cellules de cette (this) liste.
     @return nombre de cellules dans la liste. */
    virtual int getLongueur() const = 0;

    /** insertion d'une cellule contentant nouvelleInfo en tête de cette (this) liste.
     @pre  Aucune.
     @post une nouvelle cellule contenant nouvelleInfo est ajouté en tête de cette liste.
     @param nouvelleInfo  information portée par la nouvelle cellule de tête. */
    virtual void insereTete(const TypeInfo& nouvelleInfo) = 0;

    /** suppression de la première cellule de cette liste.
     @pre  Aucune.
     @post cette liste est privée de sa première cellule. */
    virtual void supprimeTete() = 0;

    /** insertion ITERATIVE d'une cellule contentant nouvelleInfo à la position nouvellePosition ;
     * la procédure n'utilise pas de booléens
     @pre  Aucune.
     @post  si 1 <= position <= getLongueur() + 1 et l'insertion est réussie,
        nouvelleInfo est la nouvellePosition dans cette liste,
        et la valeur retournée est True ; sinon la valeur retournée est False
     @param nouvellePosition  position à laquelle insérer nouvelleInfo.
     @param nouvelleInfo  information à insérer dans la liste.
     @return  True si l'insertion est réussie, False sinon. */
    virtual bool insereAtPositIter(const int nouvellePosition, const TypeInfo& nouvelleInfo) = 0;

    /** insertion RECURSIVE d'une cellule contentant nouvelleInfo à la position nouvellePosition.
     * la méthode utilise "un WORKER" qui est une PROCEDURE avec un paramètre donnée-résultat 
    @pre  Aucune.
    @post  si 1 <= position <= getLongueur() + 1 et l'insertion est réussie,
        nouvelleInfo est la nouvellePosition dans cette liste,
        et la valeur retournée est True ; sinon la valeur retournée est False
    @param nouvellePosition  position à laquelle insérer nouvelleInfo.
    @param nouvelleInfo  information à insérer dans la liste.
    @return  True si l'insertion est réussie, False sinon. */
    virtual bool insereAtPositRec(int nouvellePosition, const TypeInfo& nouvelleInfo) = 0;

    /** suppression ITERATIVE de la cellule visée au rang position ;
     * la méthode n'utilise pas de booléen
     @pre  Aucune.
     @post  si 1 <= position <= getLongueur() la suppression est réussie,
        la cellule visée est supprimé de cette liste,
        and la valeur retournée est True ; sinon la valeur retournée est False.
     @param position  rang de la cellule visée à supprimer.
     @return  True si la suppression est réussie, False sinon. */
    virtual bool supprimeAtPositIter(int position) = 0;

    /** suppression RECUSIVE de la cellule visée au rang position.
     * la méthode utilise "un WORKER" qui est une PROCEDURE avec un paramètre donnée-résultat 
     @pre  Aucune.
     @post  si 1 <= position <= getLongueur() la suppression est réussie,
        la cellule visée est supprimé de cette liste,
        and la valeur retournée est True ; sinon la valeur retournée est False.
     @param position  rang de la cellule visée à supprimer.
     @return  True si la suppression est réussie, False sinon. */
    virtual bool supprimeAtPositRec(int position) = 0;

    /** suppression de toutes les cellules de la liste (version itérative).
     @post  la liste est videRec et le nombre de cellules vaut 0. */
    virtual void videIter() = 0;

    /** suppression de toutes les cellules de la liste (version récursive).
     @post  la liste est videRec et le nombre de cellules vaut 0. */
    virtual void videRec() = 0;

    /** RECUSIVE valeur de l'information portée par la cellule visée de rang position.
     @post  l'information portée par la cellule visée est retournée.
     @param position  rang de la cellule visée.
     @return  information portée par la cellule visée ou lève une exception. */
    virtual TypeInfo getInfoAtPositRec(int position) const = 0;

}; // end ListInterface
#endif