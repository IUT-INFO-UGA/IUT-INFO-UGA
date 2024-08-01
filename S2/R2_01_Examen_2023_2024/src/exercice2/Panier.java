package exercice2;

import java.util.ArrayList;

public class Panier {
	private ArrayList<LigneDeCommande> commandes;
    public Panier(){
		commandes = new ArrayList<>();
	}

	public void addLigne(LigneDeCommande ligne){
		commandes.add(ligne);
	}

	public float getPrix(){
		float prix = 0;
		for (LigneDeCommande commande : commandes) {
			prix += commande.getPrix() * commande.getQuantite();
		}
		return prix;
	}

	public void vider(){
		commandes.clear();
	}

	public int getNombreArticles(){
		return commandes.size();
	}

	public LigneDeCommande getCommande(int i){
			return commandes.get(i);
	}
}
