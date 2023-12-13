public interface ListeTrieeInterface<TypeInfo> {
    // TypeInfo : type des informations portées par les éléments de la liste
    // Exemples : Integer, Rectangle, Pays, Polar

    // Services minimum que doit rendre une liste triée
    /**
     * Cette (this) liste triée est-elle vide ?
     * @return true si cette liste triée est vide ; false sinon
     */
    boolean estVide();

    /**
     * Longueur (nombre d'éléments) de cette liste triée
     *
     * @return nombre d'éléments de cette liste triée
     */
    int getLongueur();

    /**
     * Insertion d'un nouvel élément dans cette liste triée en respect de son tri
     *
     * @param uneInfo valeur de ce nouvel élément
     * @pre aucune
     * @post un nouvel élément a té inséré dans cette liste triée en respect de son tri
     */
    void insereTrie(TypeInfo uneInfo);

    /**
     * Suppression du premier élément de cette liste triée
     * @pre aucune
     * @post cette liste triée a été privée de son premier élément
     */
    void supprimeTete();

    /**
     * Suppression de l'élément de rang position dans cette liste triée
     * position est légale si 1 <= position <= (nombre d'éléments)
     * @pre aucune
     * @post l'élément de rang position a été supprimé, si position est légale,
     *           sinon, cette liste triée est inchangée
     * @param position rang de l'élément à supprimer
     * @return true si la suppression est faite (position légale) ; false sinon
     */
    boolean supprimeAtPosit(int position);

    /**
     * Information portée par l'élément de rang position (élément visé)
     * position est légale si 1 <= position <= (nombre d'éléments)
     * @pre aucune
     * @post si position est légale,l'information portée par l'élément visé a été retournée,
     *           sinon, une exception a été levée
     * @param position rang de l'élément visé
     * @return information portée par l'élément visé si position est légale
     * @throws ExceptionMauvaisIndice si position est illégale
     */
    TypeInfo getInfoAtPosit(int position) throws ExceptionMauvaisIndice;

    /**
     * Modification de l'information portée par l'élément de rang position (élément visé)
     * position est légale  si 1 <= position <= (nombre d'éléments)
     * @pre aucune
     * @post  si position est légale et si la modification de l'élément visé respecte
     *            le tri de cette liste triée, l'information portée par l'élément visé est
     *            nouvelleInfo, sinon, une exception a été levée
     * @param position rang de l'élément visé dans cette liste triée
     * @param nouvelleInfo nouvelle information pour l'élément visé
     * @throws ExceptionMauvaisIndice si position illégale
     * @throws ExceptionViolationTri si position légale, mais la modification de l'élément
     *                                            visé, violerait le tri de cette liste triée
     */
    void setInfoAtPosit(int position, TypeInfo nouvelleInfo)
            throws ExceptionMauvaisIndice, ExceptionViolationTri;

    /**
     * Suppression de tous les éléments de cette liste triée
     * @post cette liste triée est vide et son nombre de cellules est égal à 0
     */

    void vide();
}