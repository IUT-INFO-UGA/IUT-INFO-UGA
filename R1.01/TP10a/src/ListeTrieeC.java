public class ListeTrieeC<TypeInfo extends Comparable<TypeInfo>> implements ListeTrieeInterface<TypeInfo> {

    // Implémentation du TAD ListeTrieeInterface pour des listes chainées d'éléments:
    // de type Cellule<TypeInfo>, triés par ordre croissant (au sens large)
    // TypeInfo : type des informations portées par les cellules de cette liste

    // attributs
    private Cellule<TypeInfo> tete;
    private int nbCellules;

    /**
     * Constructeur d'une ListeTrieeC vide
     */
    public ListeTrieeC() {
        tete = null;
        nbCellules = 0;
    }

    /**
     * Accès à la première cellule de cette ListeTrieeC
     *
     * @return cellule de tête de cette ListeTrieeC
     */
    public Cellule<TypeInfo> getTete() {
        return tete;
    }

    /**
     * Longueur (nombre de cellules) de cette ListeTrieeC
     *
     * @return nombre de cellules de cette ListeTrieeC
     */
    @Override
    public int getLongueur() {
        return nbCellules;
    }

    /**
     * Cette ListeTrieeC est-elle vide ?
     *
     * @return true si cette ListeTrieeC est vide ; false sinon
     */
    @Override
    public boolean estVide() {
        return nbCellules == 0;
    }

    /**
     * Insertion d'une nouvelle cellule dans cette ListeTrieeC en respect du tri
     *
     * @param uneInfo information portée par la nouvelle cellule à insérer
     * @pre
     * @post # une nouvelle cellule portant uneInfo a été insérée en respect du tri
     * dans cette ListeTrieeC :
     * -> en tête si cette ListeTrieeC est vide
     * -> avant la première cellule de cette ListeTrieeC, portant une
     * information supérieure (au sens large) à uneInfo, sinon
     * # la longueur de cette ListeTrieeC a été incrémentée
     */
    @Override
    public void insereTrie(TypeInfo uneInfo) { // forme récursive
        if (this.tete == null || this.tete.getInfo().compareTo(uneInfo) >= 0) {
            tete = new Cellule<TypeInfo>(uneInfo, tete);
            nbCellules++;
        } else {
            insereTriewk(tete, uneInfo);
            nbCellules++;
        }
    }
    // le worker
    private void insereTriewk(Cellule<TypeInfo> cellCour, TypeInfo uneInfo) {
        if (cellCour.getCelluleSuivante() == null || cellCour.getCelluleSuivante().getInfo().compareTo(uneInfo) >= 0) {
            Cellule<TypeInfo> nouvelleCellule = new Cellule<>(uneInfo, cellCour.getCelluleSuivante());
            cellCour.setCelluleSuivante(nouvelleCellule);
        } else {
            insereTriewk(cellCour.getCelluleSuivante(), uneInfo);
        }
    }

    /**
     * Suppression du premier élément de cette ListeTrieeC
     *
     * @pre
     * @post si cette liste ListeTrieeC n'était pas vide, elle a été privée de sa
     * première cellule et son nombre de cellules a été décrémenté
     */
    @Override
    public void supprimeTete() {
        if (tete != null) {
            tete = tete.getCelluleSuivante();
            nbCellules--;
        }
    }

    //  ----------------------------------------------------------------------------------------
    //   Fonction privée ITÉRATIVE utilisée pour l'implémentation de certains services
    //   spécifiés dans ListeTrieeInterface
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
    //-------------------------------------------------------------------------------------------

    /**
     * Suppression de la cellule de rang position dans cette ListeTrieeC
     * position est légale si 1 <= position <= (nombre de cellules)
     *
     * @pre
     * @param position rang de la cellule à supprimer
     * @return true si la suppression est faite (position légale) ; false sinon
     */
    @Override
    public boolean supprimeAtPosit(int position) {
        if (position > 0 & position <= nbCellules) {
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
     * Information portée par la cellule de rang position (cellule visée) dans
     * cette ListeTrieeC
     * position est légale si 1 <= position <= (nombre de cellules)
     *
     * @param position rang de la cellule visée dans cette ListeTrieeC
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
     * dans cette ListeTrieeC
     * position est légale si 1 <= position <= (nombre de cellules)
     *
     * @param position  rang de la cellule visée
     * @param nouvelleInfo nouvelle information pour la cellule visée
     * @throws ExceptionMauvaisIndice si position invalide
     * @throws ExceptionViolationTri  si postion valide, mais la modification violerait
     *                                              le tri de cette ListeTrieeC
     */
    @Override
    public void setInfoAtPosit(int position, TypeInfo nouvelleInfo)
            throws ExceptionMauvaisIndice, ExceptionViolationTri {
        if (tete == null || (position < 1 | position > nbCellules)) {
            throw new ExceptionMauvaisIndice("!!! Modification impossible, " +
                    "aucun élément en position " + position + " dans la liste !!!");
        } else {
            if (position == 1) {
                if (tete.getCelluleSuivante() == null ||
                        tete.getCelluleSuivante().getInfo().compareTo(nouvelleInfo) >= 0) {
                    tete.setInfo(nouvelleInfo);
                } else {
                    throw new ExceptionViolationTri("!!! Modification imposible, " +
                            "la nouvelle valeur de la cellule de position " + position +
                            " violerait le tri de la liste !!!!");
                }
            } else { // position > 1 et <= nbCellules
                Cellule<TypeInfo> cellPrec = celluleAtPosit(position - 1);
                Cellule<TypeInfo> cellCible = cellPrec.getCelluleSuivante();
                Cellule<TypeInfo> cellSuiv = cellCible.getCelluleSuivante();
                if (nouvelleInfo.compareTo(cellPrec.getInfo()) >= 0 & (cellSuiv == null ||
                        cellSuiv.getInfo().compareTo(nouvelleInfo) >= 0)) {
                    cellCible.setInfo(nouvelleInfo);
                } else {
                    throw new ExceptionViolationTri("!!! Modification imposible, " +
                            "la nouvelle valeur de la cellule de position " + position +
                            " violerait le tri de la liste !!!!");
                }
            }
        }
    }

    /**
     * Suppression de tous les éléments de cette ListeTrieeC
     *
     * @post cette ListeTrieeC est vide et son nombre de cellules est égal à 0
     */
    @Override
    public void vide() {
        tete = null;
        nbCellules = 0;
    }

    /**
     * Affichage GD des informations portées par les cellules de cette ListeTrieeC
     *
     * @pre aucune
     * @post les informations portées par les cellules de cette ListeTrieeC ont
     * été affichées de la 1ère à la dernière cellule (rien si liste vide)
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
