public class ListeTrieeD<TypeInfo extends Comparable<TypeInfo>> implements ListeTrieeInterface<TypeInfo> {

    // Implémentation du TAD ListeTrieeInterface pour des listes chainées d'éléments:
    // de type Cellule<TypeInfo>, triés par ordre décroissant (au sens large)
    // TypeInfo : type des informations portées par les cellules de cette liste

    // attributs
    private Cellule<TypeInfo> tete;
    private int nbCellules;

    /**
     * Constructeur d'une ListeTrieeD vide
     */
    public ListeTrieeD() {
        tete = null;
        nbCellules = 0;
    }

    /**
     * Accès à la première cellule de cette ListeTrieeD
     * @return cellule de tête de cette ListeTrieeD
     */
    public Cellule<TypeInfo> getTete() {
        return tete;
    }

    /**
     * Longueur (nombre de cellules) de cette ListeTrieeD
     * @return nombre de cellules de cette ListeTrieeD
     */
    @Override
    public int getLongueur() {
        return nbCellules;
    }

    /**
     * Cette ListeTrieeD est-elle vide ?
     * @return true si cette ListeTrieeD est vide ; false sinon
     */
    @Override
    public boolean estVide() {
        return nbCellules == 0;
    }

    /**
     * Insertion d'une nouvelle cellule dans cette ListeTrieeD en respect du tri
     * @pre aucune
     * @post # une nouvelle cellule portant uneInfo a été insérée en respect du tri
     *              dans cette ListeTrieeD  :
     *              -> en tête si cette ListeTrieeD est vide
     *              -> avant le premier élément de cette ListeTrieeD, portant une
     *                   information inférieure (au sens large) à uneInfo, sinon
     *           # le nombre de cellules de cette ListeTrieeDeCroissante a été incrémenté
     * @param uneInfo information portée par la cellule insérée
     */
    @Override
    public void insereTrie(TypeInfo uneInfo) {
        if (this.tete == null || this.tete.getInfo().compareTo(uneInfo) <= 0) {
            tete = new Cellule<TypeInfo>(uneInfo, tete);
            nbCellules++;
        } else {
            insereTriewk(tete, uneInfo);
            nbCellules++;
        }
    }
    private void insereTriewk(Cellule<TypeInfo> cellCour, TypeInfo uneInfo) {
        if (cellCour.getCelluleSuivante() == null || cellCour.getCelluleSuivante().getInfo().compareTo(uneInfo) <=0) {
            Cellule<TypeInfo> nouvelleCellule = new Cellule<>(uneInfo, cellCour.getCelluleSuivante());
            cellCour.setCelluleSuivante(nouvelleCellule);
        } else {
            insereTriewk(cellCour.getCelluleSuivante(), uneInfo);
        }
    }

    /**
     * Suppression du premier élément de cette ListeTrieeDeCroissante
     * @pre aucune
     * @post si cette ListeTrieeDeCroissante n'était pas vide, elle a été privée de sa
     *           première cellule et son nombre de cellules a été décrémenté     */
    @Override
    public void supprimeTete() {
        if (tete != null) {
            tete = tete.getCelluleSuivante();
            nbCellules--;
        }
    }

    //  ----------------------------------------------------------------------------------------
    //   Fonction privée utilisée pour l'implémentation de certains services spécifiés
    //    dans ListeTrieeInterface
    //  ----------------------------------------------------------------------------------------
    /**
     * Cellule de rang position dans cette ListeTrieeC
     * @pre - cette ListeTrieeC non vide
     *          - position compris entre 1 et le nombre de cellules
     * @param position = rang de la cellule à retourner
     * @return la cellule de rang position
     */
    private Cellule<TypeInfo> celluleAtPosit(int position) {
        Cellule<TypeInfo> cellCour = tete;
        int pos = 1; // la précondition précise que pos est valide
        while (pos < position) {
            cellCour = cellCour.getCelluleSuivante();
            pos++;
        } // pos == position
        return cellCour;
    }
    //------------------------------------------------------------------------------------------

    /**
     * Suppression de l'élément de rang position dans cette ListeTrieeD
     * position est valide si 1 <= position <= getLongueur()
     * @pre aucune
     * @post si position est valide, la cellule de rang position a été supprimée et
     *           la longueur de cette ListeTrieeD a été décrémentée,
     *           sinon cette ListeTrieeD est inchangée
     * @param position rang de la cellule à supprimer
     * @return true si la suppression est faite (position valide) ; false sinon
     */
    @Override
    public boolean supprimeAtPosit(int position) {
        if (position >= 1 & position <= nbCellules) {
            if (position == 1) {
                supprimeTete();
            } else {
                Cellule<TypeInfo> cellPrec = celluleAtPosit(position-1);
                Cellule<TypeInfo> cellCible = cellPrec.getCelluleSuivante();
                cellPrec.setCelluleSuivante(cellCible.getCelluleSuivante());
                nbCellules--;
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Information portée par l'élément'de rang position (cellule visée) dans
     * cette ListeTrieeD
     * position est légale si 1 <= position <= (nombre de cellules)
     * @pre aucune
     * @post l'information portée par la cellule visée a été retournée si position légale,
     *           sinon, un exception a été levée
     * @param position rang de la cellule visée dans cette ListeDécroissante
     * @return information portée par la cellule visée si position est légale
     * @throws ExceptionMauvaisIndice si position est illégale
     */
    @Override
    public TypeInfo getInfoAtPosit(int position) throws ExceptionMauvaisIndice {
        if (position < 1 |  position > nbCellules) {
            throw new ExceptionMauvaisIndice("!!! Consultation impossible, " +
                    "pas d'élément en position " + position + " dans la liste !!!");
        } else if (position == 1) {
            return tete.getInfo();
        } else { // position > 1 et <= nbCellules
            Cellule<TypeInfo> cellCible = celluleAtPosit(position);
            return cellCible.getInfo();
        }
    }

    /**
     * Modification de l'information portée par la cellule de rang position (cellule visée)
     * dans cette ListeTrieeDeCroissante
     * position est légale si 1 <= position <= (nombre de cellules)
     * @pre aucune
     * @post # si position est légale et que la modification de l'information portée par
     *             la cellule visée respecte le tri de cette ListeTrieeDeCroissante, la nouvelle
     *             information portée par cette cellule est nouvelleInfo ;
     *           # sinon, une exception a été levée     *
     * @param position rang de la cellule visée
     * @param nouvelleInfo nouvelle information pour la cellule visée
     * @throws ExceptionMauvaisIndice si position invalide
     * @throws ExceptionViolationTri  si postion valide, mais la modification violerait
     *                                              le tri de cette ListeTrieeDeCroissante
     */
    @Override
    public void setInfoAtPosit(int position, TypeInfo nouvelleInfo)
            throws ExceptionMauvaisIndice, ExceptionViolationTri {
        if (tete == null || (position < 1 | position > nbCellules)) {
            throw new ExceptionMauvaisIndice("!!! Modification impossible, " +
                    "aucun élément en position " + position  + " dans la liste !!!");
        } else {
            if (position == 1) {
                if (tete.getCelluleSuivante() == null ||
                        tete.getCelluleSuivante().getInfo().compareTo(nouvelleInfo) <= 0) {
                    tete.setInfo(nouvelleInfo);
                } else {
                    throw new ExceptionViolationTri("!!! Modification imposible, " +
                            "la nouvelle valeur de la cellule de position " + position +
                            " violerait le tri de la liste !!!");
                }
            } else { // position > 1 et <= nbCellules
                Cellule<TypeInfo> cellPrec = celluleAtPosit(position - 1);
                Cellule<TypeInfo> cellCible = cellPrec.getCelluleSuivante();
                Cellule<TypeInfo> cellSuiv = cellCible.getCelluleSuivante();
                if (cellPrec.getInfo().compareTo(nouvelleInfo)  >= 0 & (cellSuiv == null ||
                        cellSuiv.getInfo().compareTo(nouvelleInfo) <= 0)) {
                    cellCible.setInfo(nouvelleInfo);
                } else {
                    throw new ExceptionViolationTri("!!! Modification imposible, " +
                            "la nouvelle valeur de la cellule de position " + position +
                            " violerait le tri de la liste !!!");
                }
            }
        }
    }

    /**
     * Suppression de tous les éléments de cette liste triée
     * @post cette ListeTrieeDeCroissante est vide et son nombre de cellules est égal à 0
     */
    @Override
    public void vide() {
        tete = null;
        nbCellules = 0;
    }

    /** Affichage GD des informations portées par les cellules de cette ListeTrieeDeCroissante
     * @pre aucune
     * @post les informations portées par les cellules de cette ListeTrieeDeCroissante ont été
     *          affichées de la 1ère à la dernière cellule, (rien si liste vide)
     */
    public void afficheGD() {
        afficheGDWK(tete);
        System.out.println();
    }
    // le worker
    private void afficheGDWK(Cellule<TypeInfo> celluleCourante) {
        if (celluleCourante != null) {
            System.out.print(celluleCourante.getInfo() + " -> ");
            afficheGDWK(celluleCourante.getCelluleSuivante());
        }
    }
}