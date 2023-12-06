public class ListeChainee<TypeInfo extends Comparable<TypeInfo>>
        implements ListeInterface<TypeInfo> {

    // Implémentation du TAD ListeInterFace pour des éléments de type Cellule<TypeInfo>
    // TypeInfo : type des informations portées par les cellules de cette liste
    // Exemples : Integer, Rectangle, Pays, Polar

    // attributs
    private Cellule<TypeInfo> tete;
    private int nbCellules;

    /**
     * Constructeur d'une ListeChainee vide
     */
    public ListeChainee() {
        tete = null;
        nbCellules = 0;
    }

    /**
     * Getter de la tête de cette ListeChainee
     *
     * @return cellule de tête de cette ListeChainee
     */
    public Cellule<TypeInfo> getTete() {
        return tete;
    }

    /**
     * Cette ListeChainee est-elle vide ?
     *
     * @return true si cette ListeChainee est vide, false sinon
     */
    @Override
    public boolean estVide() {
        return nbCellules == 0;
    }

    /**
     * Longueur (nombre de cellules) de cette ListeChainee
     *
     * @return nombre de cellules de cette ListeChainee
     */
    @Override
    public int getLongueur() {
        return nbCellules;
    }
    /**
     * Insertion d'une nouvelle cellule en tête de cette ListeChainee
     *
     * @param uneInfo information portée par la nouvelle cellule
     * @pre aucune
     * @post - la tête de cette ListeChainee est la nouvelle cellule
     *           - la longueur de cette ListeChainee a été incrémentée
     */
    @Override
    public void insereTete(TypeInfo uneInfo) {
        this.tete = insereTeteWorker(tete, uneInfo);
    }
    // le worker
    private Cellule<TypeInfo> insereTeteWorker(Cellule<TypeInfo> cellCour, TypeInfo uneInfo) {
        cellCour = new Cellule<TypeInfo>(uneInfo, cellCour);
        nbCellules = nbCellules + 1;
        return cellCour;
    }

    /**
     * Suppression de la première cellule de cette ListeChainee
     *
     * @pre aucune
     * @post  si cette ListeChainee n'était pas vide :
     *            - sa première cellule a été supprimée
     *            - sa longueur a été décrémentée
     */
    @Override
    public void supprimeTete() {
        if (nbCellules != 0) {
            tete = supprimeTeteWorker(tete);
        }
    }
    // le worker
    private Cellule<TypeInfo> supprimeTeteWorker(Cellule<TypeInfo> cellCour) {
        cellCour = cellCour.getCelluleSuivante();
        nbCellules = nbCellules - 1;
        return cellCour;
    }

    /**
     * Insertion d'une nouvelle cellule au rang position dans cette ListeChainee
     * position est légale si 1 <= position <= (nombre de cellules + 1)
     *
     * @param position rang où insérer la nouvelle cellule
     * @param nouvelleInfo  information portée par la nouvelle cellule
     * @return true si l'insertion est réussie (position légale), false sinon
     * @pre aucune
     * @post * si position est légale :
     *             - une nouvelle cellule portant nouvelleInfo a été insérée au rang position
     *             - la longueur de cetteListeChainee a été incrémentée
     *          * si position est illégale : cette ListeChainee est inchangée
     */
    @Override
    public boolean insereAtPosit(int position, TypeInfo nouvelleInfo) {
        if (position > 0 & position <= nbCellules + 1) {
            tete = insereAtPositWorker(tete, position, nouvelleInfo);
            return true;
        } else {
            return false;
        }
    }
    // le worker (récursif)
    private Cellule<TypeInfo> insereAtPositWorker(Cellule<TypeInfo> cellCour, int position,
                                                  TypeInfo nouvelleInfo) {
        if (position == 1) {
            Cellule<TypeInfo> nouvelleCellule = insereTeteWorker(cellCour, nouvelleInfo);
            return nouvelleCellule;
        } else {
            Cellule<TypeInfo> reste = insereAtPositWorker(cellCour.getCelluleSuivante(),
                    position - 1, nouvelleInfo);
            cellCour.setCelluleSuivante(reste);
            return cellCour;
        }
    }

    /**
     * Suppression de la cellule de rang position dans cette ListeChainee
     * position est légale si 1 <= position <= (nombre de cellules)
     *
     * @param position rang de la cellule à supprimer
     * @return true si la suppression est faite (position légale), false sinon
     * @pre Aucune
     * @post * si position est légale :
     *             - la cellule de rang position a été supprimée
     *             - la longueur de cette ListeChainee a été décrémentée
     *           * si position est illégale, cette ListeChainee est inchangée
     */
    @Override
    public boolean supprimeAtPosit(int position) {
        if (position > 0 & position <= nbCellules) {
            // suppression possible
            tete = supprimeAtPositWorker(tete, position);
            return true;
        } else {
            return false;
        }
    }
    // le worker (récursif)
    private Cellule<TypeInfo> supprimeAtPositWorker(Cellule<TypeInfo> cellCour, int position) {
        if (position == 1) {
            // suppression en tête
            Cellule<TypeInfo> nouvelleListe = supprimeTeteWorker(cellCour);
            return nouvelleListe;
        } else {
            Cellule<TypeInfo> nouvelleSuite = supprimeAtPositWorker(cellCour.getCelluleSuivante(),
                    position - 1);
            cellCour.setCelluleSuivante(nouvelleSuite);
            return cellCour;
        }
    }

    /**
     * Information portée par la cellule de rang position (cellule visée)
     * position est légale si 1 <= position <= (nombre de cellules)
     *
     * @param position rang de la cellule visée dans cette ListeChainee
     * @return information portée par la cellule visée si position est légale
     * @throws ExceptionMauvaisIndice si position est illégale
     * @pre Aucune
     * @post si position est légale, l'information portée par la cellule visée
     *           a été retournée, sinon, l'exception ExceptionMauvaisIndice a été levée
     */
    @Override
    public TypeInfo getInfoAtPosit(int position) throws ExceptionMauvaisIndice {
        if (position >= 1 & position <= nbCellules) {
            return getInfoAtPositWorker(tete, position);
        } else {
            // on utilise le constructeur avec paramètre pour construire un message d'erreur parlant
            throw new ExceptionMauvaisIndice("Consultation impossible, aucun élément en position " + position + "\n");
        }
    }
    // le worker (récursif)
    private TypeInfo getInfoAtPositWorker(Cellule<TypeInfo> cellCour, int position) {
        if (position == 1) {
            return cellCour.getInfo();
        } else {
            return getInfoAtPositWorker(cellCour.getCelluleSuivante(), position - 1);
        }
    }

    /**
     * Remplacement de l'information portée par la cellule de rang position (cellule visée)
     * position est légale si 1 <= position <= (nombre de cellules)
     *
     * @param position rang de la cellule visée
     * @param nouvelleInfo nouvelle valeur de l'information portée par la cellule visée
     * @return true si le remplacement est possible (position légale),false sinon
     * @pre aucune
     * @post si position est légale, la nouvelle information portée par la cellule visée
     *             est nouvelleInfo, sinon cette ListeChainee est inchangée
     */
    @Override
    public boolean setInfoAtPosit(int position, TypeInfo nouvelleInfo) {
        if (position >= 1 & position <= nbCellules) {
            return setInfoAtPositWorker(tete, position, nouvelleInfo);
        } else {
            return false;
        }
    }
    // le worker (récursif)
    private boolean setInfoAtPositWorker(Cellule<TypeInfo> cellCour, int position,
                                         TypeInfo nouvelleInfo) {
        if (position == 1) {
            cellCour.setInfo(nouvelleInfo);
            return true;
        } else {
            return setInfoAtPositWorker(cellCour.getCelluleSuivante(),
                    position - 1, nouvelleInfo);
        }
    }

    /**
     * Suppression de toutes les cellules de cette ListeChainee
     *
     * @post cette ListeChainee est vide et son nombre des cellules = 0
     */
    @Override
    public void vide() {
        tete = null;
        nbCellules = 0;
    }

    /*
        AUTRES MÉTHODES, spécialisées pour cette ListeChainee
     */

    /**
     * Affichage de gauche à droite des informations portées par les cellules de
     * cette ListeChainee
     *
     * @pre aucune
     * @post les informations portées par les cellules de cette ListeChainee ont été
     *          affichées de la première à la dernière d'entre elles
     */
    public void afficheGaucheDroiteRec() {
        afficheGaucheDroiteRecWorker(tete);
        System.out.println();
    }
    // le worker
    private void afficheGaucheDroiteRecWorker(Cellule<TypeInfo> cellCour) {
        if (cellCour != null) {
            System.out.print(cellCour.getInfo() + " -> ");
            afficheGaucheDroiteRecWorker(cellCour.getCelluleSuivante());
        }
    }

    /**
     * Affichage de droite à gauche des informations portées par les cellules de
     * cette ListeChainee
     *
     * @pre aucune
     * @post les informations portées par les cellules de cette ListeChainee ont été
     *          affichées de la dernière à la première d'entre elles
     */
    public void afficheDroiteGaucheRec() {
        afficheDroiteGaucheRecWorker(tete);
        System.out.println();
    }
    // le worker
    private void afficheDroiteGaucheRecWorker(Cellule<TypeInfo> cellCour) {
        if (cellCour != null) {
            afficheDroiteGaucheRecWorker(cellCour.getCelluleSuivante());
            System.out.print(" <- " + cellCour.getInfo());
        }
    }
}
