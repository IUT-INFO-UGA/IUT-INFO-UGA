package exercice2;

public class LigneDeCommande {
	private Article article;
	private int quantite;

	public LigneDeCommande(Article article, int quantite){
		this.quantite = quantite;
		this.article = article;
	}
	public float getPrix() {
		return article.getPrix();
	}

	public int getQuantite(){
		return quantite;
	}

	@Override
	public String toString() {
		return article.toString() + " - quantité(s) "+quantite;
	}
}
