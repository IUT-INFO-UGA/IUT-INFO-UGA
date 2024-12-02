//  HB librement inspiré de
//  Data Abstraction & Problem Solving with C++: Walls and Mirrors
//  Frank M. Carrano and Tim Henry.
//  2013 – Pearson Education


/** Interface pour le type abstrait de données ListeTrieeInterface
 @file SortedListInterface.h */

#ifndef _LISTE_TRIEE_INTERFACE
#define _LISTE_TRIEE_INTERFACE

template<class TypeInfo>
class ListeTrieeInterface {
public:

    /** insère (RECURSIF), à sa place, une Cellule contenant nouvelleInfo dans cette liste
     *   triée de telle façon quelle demeure triée
     * @pre Cette liste est triés
     * @post  uneInfo est insérée, et cette liste reste triée
     * @param uneInfo : contenu pour lequel insérer uen Cellule */
    virtual void insereRec(const TypeInfo& nouvelleInfo) = 0;

    /** supprime la première ou l'unique Cellule de cette liste triée
     *    contenant uneInfo.
     * @pre  Cette liste est triée.
     * @post  Si la suppression est possible, la première occurrence de
     *    uneInfo n'est plus présente dans cette liste, et la valeur retournée
     *    est vrai (true). Sinon, cette liste triée est inchangée et la
     *    valeur retournée est faux (false).
     * @param uneInfo  le contenu à supprimer.
     * @return  true si la suppression est possible, false sinon. */
    virtual bool supprimePremOccInfoIter(const TypeInfo& uneInfo) = 0;

    /** supprime RECURSIF de la première ou l'unique Cellule de cette liste triée
     *    conenant uneInfo.
     * @pre  Cette liste est triée.
     * @post  Si la suppression est possible, la première occurrence de
     *    uneInfo n'est plus présente dans cette liste, et la valeur retournée
     *    est vrai (true). Sinon, cette liste triée est inchangée et la
     *    valeur retournée est faux (false).
     * @param uneInfo  le contenu à supprimer.
     * @return  true si la suppression est possible, false sinon. */
    virtual bool supprimePremOccInfoRec(const TypeInfo& uneInfo) = 0;

    /** Retourne la position de la première ou de l'unique occurrence de uneInfo
     *    dans cette liste triée. Si uneInfo n'est pas dans cette liste,
     *    retourne la position que uneInfo devrait occuper.
     * 
     * NOTE : version ITERATIVE uniquement (récursif inutilement compliquée)
     * @pre  Cette liste est triée.
     * @post  La position qu'occupe ou que devrait occuper uneInfo est retourné.
     *    Cette liste chaînée n'est pas modifiée.
     * @param uneInfo  contenu à localiser.
     * @return  Soit la première position de uneInfo si présent dans cette liste ;
     *    soit la position que uneInfo devrait occupé comme entier négatif */
    virtual int getPositIter(const TypeInfo& uneInfo) const = 0;

    /** cette liste est-elle videRec ? */
    virtual bool estVide() const = 0;

    /** retourne le nombre de Cellules de cette liste. */
    virtual int getLongueur() const = 0;
    
    /** supprime toutes les Cellules de cette liste. */
    virtual void videRec() = 0;

}; // end ListeTrieeInterface
#endif