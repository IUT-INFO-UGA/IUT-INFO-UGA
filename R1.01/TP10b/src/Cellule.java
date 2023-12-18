public class Cellule<TypeInfo> {

    // information portée par la Celllule
    private TypeInfo info;
    // référence vers la Cellule suivante
    private Cellule<TypeInfo> celluleSuivante;

    /**
     * Constructeur de Cellule sans suivante
     * @param info
     */
    public Cellule(TypeInfo info) {
        this.info = info;
        celluleSuivante = null;
    }

    /**
     * Constructeur de Cellule avec celluleSuivante comme suivante
     * @param info
     * @param celluleSuivante
     */
    public Cellule(TypeInfo info, Cellule<TypeInfo> celluleSuivante) {
        this.info = info;
        this.celluleSuivante = celluleSuivante;
    }

    /**
     * getter et setter de info
     */
    public TypeInfo getInfo() {
        return info;
    }
    public void setInfo(TypeInfo info) {
        this.info = info;
    }

    /**
     * getter et setter de celluleSuivante
     */
    public Cellule<TypeInfo> getCelluleSuivante() {
        return celluleSuivante;
    }
    public void setCelluleSuivante(Cellule<TypeInfo> celluleSuivante) {
        this.celluleSuivante = celluleSuivante;
    }

}
