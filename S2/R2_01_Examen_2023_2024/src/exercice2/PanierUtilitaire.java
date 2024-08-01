package exercice2;

public class PanierUtilitaire {
    
    public static void afficher(Panier panier) {
        final int nbArticle = panier.getNombreArticles();
        System.out.println("\nPanier contient "+nbArticle+" article(s)");
        for (int i = 0; i < nbArticle; i++) {
            System.out.println(panier.getCommande(i));
        }
        System.out.println("prix total du panier : "+ panier.getPrix());
    } 
    
}
