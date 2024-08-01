package exercice2;

public class TestPanier {
    
    public static void main(String[] args) {
        
        // A COMPLETER
        
        // ATTENTION :
        // TRACE ATTENDUE DANS LE FICHIER TestPanier-trace.txt
        
        // Créer un objet de type article : cheval à bascule, description : Cheval à bascule en bois naturel, prix 79.5
        final Article chevalABascule = new Article("cheval à bascule","Cheval à bascule en bois naturel", 79.5f);
        // Créer un objet de type article : Etabli grand modèle, description : Grand établi en bois pour charpentier en herbe avec ses outils, prix 80.5
        final Article etabliGrandModel = new Article("Etabli grand modèle","Grand établi en bois pour charpentier en herbe avec ses outils", 80.5f);
        // Créer un objet de type article : Epee bois, description : Engagez-vous dans des combats endiablés équipez de votre épée en bois, prix 9
        final Article epeeBois = new Article("epée bois", "Engagez-vous dans des combats endiablés équipez de votre épée en bois", 9f);
        
        
        // Créer un objet de type panier contenant un cheval et un etabli
        final Panier panier = new Panier();
        panier.addLigne(new LigneDeCommande(chevalABascule, 1));
        panier.addLigne(new LigneDeCommande(etabliGrandModel, 1));
        // Afficher le panier et son prix
        PanierUtilitaire.afficher(panier);
        // Vider le panier
        panier.vider();
        // Ajouter au panier un etabli et deux épées
        panier.addLigne(new LigneDeCommande(etabliGrandModel, 1));
        panier.addLigne(new LigneDeCommande(epeeBois, 2));
        // Afficher le panier et son prix
        PanierUtilitaire.afficher(panier);
    }
}
