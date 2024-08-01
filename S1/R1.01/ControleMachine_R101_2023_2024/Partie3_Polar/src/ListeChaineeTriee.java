public class ListeChaineeTriee<TypeInfo extends Comparable<TypeInfo>> implements ListeTrieeInterface<TypeInfo> {

    private Cellule<TypeInfo> tete;
    private int nbCellules;

    /**
     * Getter de la tête présent uniquement pour des raisons pédagogiques
     * utilisé seulement dans la classe Utilitaire
     */
    public Cellule<TypeInfo> getTete() {
        return tete;
    }

    /**
     * Construction d'une liste vide
     */
    public ListeChaineeTriee() {
        tete = null;
        nbCellules = 0;
    }

    @Override
    public boolean estVide() {
        return nbCellules == 0;
    }

    @Override
    public void vide() {
        tete = null;
        nbCellules = 0;
    }

    @Override
    public int getLongueur() {
        return nbCellules;
    }


    /**
     * A ECRIRE - Exercice 11 (b)
     * Insertion d'une nouvelle cellule dans cette Liste, en respect de l'ordre naturel
     * de TypeInfo
     *
     * @param uneInfo
     */
    @Override
    public void insereTrie(TypeInfo uneInfo) {
        // { cette Liste est triée selon l'ordre naturel de TypeInfo } =>
        // { cette Liste reste triée après l'insertion d'une nouvelle cellule d'info uneInfo }
        // ALGORITHME ITÉRATIF EXIGÉ
        Cellule<TypeInfo> cellCour = new Cellule<>(uneInfo);
        if (this.estVide()) {
            this.tete = cellCour;
            this.nbCellules++;
            return;
        }
        if (this.tete.getInfo().compareTo(uneInfo)>0) {
            cellCour.setCelluleSuivante(this.tete);
            this.tete = cellCour;
            this.nbCellules++;
            return;
        }
        Cellule<TypeInfo> cell = this.tete;
        while (cell.getCelluleSuivante() != null && cell.getCelluleSuivante().getInfo().compareTo(uneInfo)<0) {
            cell = cell.getCelluleSuivante();
        }
        cellCour.setCelluleSuivante(cell.getCelluleSuivante());
        cell.setCelluleSuivante(cellCour);

        this.nbCellules++;
    }

    /**
     * @pre Aucune
     * @post l'information portée par l'élement visé est retournée si la position est légale
     * @param position rang de l'élément visé
     * @return information portée par l'élément visé si la position est légale
     * @throws ExceptionMauvaisIndice si la position est illégale
     */
    private TypeInfo getInfoAtPositRecWorker(Cellule<TypeInfo> celluleCourante, int position) {
        if (position == 1) {
            return celluleCourante.getInfo();
        } else {
            return getInfoAtPositRecWorker(celluleCourante.getCelluleSuivante(), position - 1);
        }
    }

    @Override
    public TypeInfo getInfoAtPosit(int position) throws ExceptionMauvaisIndice {
        if (position >= 1 & position <= nbCellules) {
            return getInfoAtPositRecWorker(tete, position);
        } else {
            // on utilise le constructeur avec paramètre pour construire un message d'erreur parlant
            throw new ExceptionMauvaisIndice("Indice de valeur " + position + " illégal dans getInfoAtPosit, la position doit être dans l'intervalle [1" + ", " + nbCellules + "]\n");
        }
    }

    private void afficheGaucheDroiteRecWorker(Cellule<TypeInfo> celluleCourante) {
        if (celluleCourante != null) {
            System.out.print(celluleCourante.getInfo() + " -> ");
            afficheGaucheDroiteRecWorker(celluleCourante.getCelluleSuivante());
        }
        // si la liste de Cellules est vide, ne rien faire
    }

    public void afficheGaucheDroiteRec() {
        System.out.print("Affichage récursif de gauche à droite : ");
        afficheGaucheDroiteRecWorker(tete);
        System.out.println();
    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Méthode utilisée par chargementFichierTie
     * ATTENTION : VOUS NE DEVEZ EN AUCUN CAS UTILISER CETTE MÉTHODE !!!!!!!!
     *
     * @param uneInfo
     */
    public void constructionTriee(TypeInfo uneInfo) {
        // {cette Liste est triée} => {cette Liste reste triée après l'insertion en respectant l'ordre naturel de TypeInfo}

        // insertions en tête
        if (tete == null || (tete.getInfo().compareTo(uneInfo) == 1)) {
            tete = new Cellule<>(uneInfo, tete);
            nbCellules = nbCellules + 1;
        } else {
            // autres insertions
            Cellule<TypeInfo> cellPred = tete;
            while (cellPred.getCelluleSuivante() != null) {
                cellPred = cellPred.getCelluleSuivante();
            }
            // cellPred.getCelluleSuivante() == null
            // insertion à la fin
            cellPred.setCelluleSuivante(new Cellule<>(uneInfo));
            nbCellules = nbCellules + 1;
        }
    }
}