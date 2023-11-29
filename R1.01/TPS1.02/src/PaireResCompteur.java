/** Classe générique pour outiller une fonction
 * Elle propose uniquement un constructeur et 2 getters
 * @param <R> : R est le type du résultat de la fonction outillée
 */
public class PaireResCompteur <R>  {
    private  R res; // résultat de la fonction outillée
    private  int compteur; // compteur du code observé

    public PaireResCompteur(R res, int compteur) {
        this.res = res;
        this.compteur = compteur;
    }
    public R getRes() {
        return res;
    }
    public int getCompteur() {
        return compteur;
    }
}