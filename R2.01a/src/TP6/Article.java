package TP6;

public class Article {
	private final short SEUIL = 100;
	private String intitule;
	private double prix;
	private int stock;

	public Article(String intitule, double prix, int stock) {
		setIntitule(intitule);
		this.prix = prix;
		this.stock = stock;
	}

	public String getIntitule() {
		return intitule;
	}

	public double getPrix() {
		return prix;
	}

	/**
	 * Calculates the total price of the article based on the given quantity.
	 *
	 * @param quantite The quantity of the article.
	 * @return The total price of the article.
	 */
	public double getPrix(int quantite) {
		if (quantite >= SEUIL) {
			return (prix * quantite) * 0.1;
		}
		return prix * quantite;
	}

	public int getStock() {
		return stock;
	}

	public void setIntitule(String intitule) throws IntituleException {
		if (intitule == null || intitule.isEmpty()) {
			throw new IntituleException("Intitule cannot be null or empty.");
		}
		this.intitule = intitule.substring(0, 1).toUpperCase() + intitule.substring(1).toLowerCase();
	}

	public void setPrix(double prix) throws PrixException {
		if(prix<=0)
			throw new PrixException("pas de prix <=0");
		this.prix = prix;
	}

	public void setStock(int stock)throws StockException  {
		if (stock < 0)
			throw new StockException("not enough stock");
		this.stock = stock;
	}

	public boolean existQuantite(int quantite) {
		return quantite <= stock;
	}

	public void removeQuantite(int quantite) throws StockException {
		if (quantite > stock)
			throw new StockException("not enough stock");
		stock -= quantite;
	}
}
