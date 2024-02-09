public interface ListeTrieeInterface<TypeInfo> {
    // TypeInfo : type des informations que l'on peut mettre dans la liste
    // exemple : Integer, Rectangle, Pays, Polar

    // prototype des services minimum que doit rendre une liste
    /**
     * cette (this) liste est-elle vide
     * @return true si cette liste est vide ; false sinon
     */
    boolean estVide();

    /**
     * nombre de cellules de cette (this) liste
     * @return nombre d'éléments de cette liste
     */
    int getLongueur();

    /**
     * Insertion d'une nouvelle cellule dans cette Liste, en respect de l'ordre naturel
     * de TypeInfo
     * @param uneInfo
     */
    void insereTrie(TypeInfo uneInfo);

    /**
     * valeur de l'information portée par l'élément de rang position visé
     * position est légale si 1 <= position <= getLongueur()
     * @pre Aucune
     * @post l'information portée par l'élement visé est retournée si la position est légale
     * @param position rang de l'élément visé
     * @return information portée par l'élément visé si la position est légale
     * @throws ExceptionMauvaisIndice si la position est illégale
     */
    TypeInfo getInfoAtPosit(int position) throws ExceptionMauvaisIndice;

    /**
     * suppression de toutes les cellules de la liste
     * @post la liste est vide et le nombre d'éléments vaut 0
     */
    void vide();
}