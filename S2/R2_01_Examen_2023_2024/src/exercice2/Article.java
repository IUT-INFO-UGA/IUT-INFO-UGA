package exercice2;

public class Article {
    private final String libelle;
	private final String description;
	private float prix;

	public Article(String libelle, String description, float prix){
		this.prix = prix;
		this.libelle = libelle;
		this.description = description;
	}

	public float getPrix() {
		return prix;
	}

	@Override
	public String toString() {
		return libelle +" "+ prix + " euros piece";
	}
}
