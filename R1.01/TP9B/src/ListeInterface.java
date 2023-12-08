public interface ListeInterface<TypeInfo> {
    // TypeInfo : type des informations que l'on peut mettre dans la liste
    // Exemples : Integer, Rectangle, Pays, Polar

    // prototype des services minimum que doit rendre une liste
    /**
     * Cette (this) liste est-elle vide ?
     *
     * @return true si cette liste ne comporte aucun élément, false sinon
     */
    boolean estVide();

    /**
     * Longueur (nombre d'éléments) de cette (this) liste
     *
     * @return nombre d'éléments de cette liste
     */
    int getLongueur();

    /**
     * Insertion d'un nouvel élément en tête de cette (this) liste
     *
     * @param uneInfo valeur de ce nouvel élément
     * @pre Aucune
     * @post la tête de cette liste est le nouvel élément
     */
    void insereTete(TypeInfo uneInfo);

    /**
     * Suppression du premier élément de cette liste
     *
     * @pre aucune
     * @post cette liste a été privée de son premier élément
     *       si cette liste n'était pas vide
     */
    void supprimeTete();

    // les positions dans une liste sont numérotées à partir de 1

    /**
     * Insertion d'un nouvel élément au rang position
     * position est légale si 1 <= position <= (nombre d'éléments + 1)
     *
     * @param position rang où insérer le nouvel élément
     * @param nouvelleInfo valeur de ce nouvel élément
     * @return true si l'insertion est réussie (position légale), false sinon
     * @pre aucune
     * @post une nouvel élément a été inséré au rang position
     *           si position est légale, sinon cette liste est inchangée
     */
    boolean insereAtPosit(int position, TypeInfo nouvelleInfo);

    /**
     * Suppression de l'élément de rang position
     * position est légale si 1 <= position <= (nombre d'éléments)
     *
     * @param position rang de l'élément à supprimer
     * @return true si la suppression est faite (position légale), false sinon
     * @pre aucune
     * @post l'élément de rang position a été supprimé si position est légale,
     *           sinon cette liste est inchangée
     */
    boolean supprimeAtPosit(int position);

    /**
     * Valeur de l'élément de rang position (élément visé)
     * position est légale si 1 <= position <= (nombre d'éléments)
     *
     * @param position rang de l'élément visé
     * @return ivaleur de l'élément visé si position est légale
     * @throws ExceptionMauvaisIndice si position est illégale
     * @pre Aucune
     * @post la valeur de l'élément visé a été retournée si position est légale
     */
    TypeInfo getInfoAtPosit(int position) throws ExceptionMauvaisIndice;

    /**
     * Modification de l'élément de rang position (élément visé)
     * position est légale si 1 <= position <= (nombre d'éléments)
     *
     * @param position rang de l'élément visé
     * @param nouvelleInfo nouvelle valeur de l'élément visé
     * @return true si le remplacement est possible (position légale), false sinon
     * @pre Aucune
     * @post nouvelle valeur de l'élément visé est nouvelleInfo si position est légale,
     *           sinon cette liste est inchangée
     */
    boolean setInfoAtPosit(int position, TypeInfo nouvelleInfo);

    /**
     * Suppression de tous les éléments de cette liste
     *
     * @post cette liste est vide et son nombre d'éléments vaut 0
     */
    void vide();

}