public class Pays implements Comparable<Pays> {

	private String nom;
	private String continent;
	private int population;
	private int superficie;

	public Pays(String nom, String continent, int population, int superficie) {
		this.nom = nom;
		this.continent = continent;
		this.population = population;
		this.superficie = superficie;
	}

	public String getNom() {
		return nom;
	}

	public String getContinent() {
		return continent;
	}

	public int getPopulation() {
		return population;
	}

	public int getSuperficie() {
		return superficie;
	}

	@Override
	public int compareTo(Pays o) {

		// { } =>
		// { résultat = -1 si le continent de ce Pays précède celui de o,
		// ou si, le ce Pays a le même continent que o, mais son nom
		// précède celui de o (casse prise en compte)
		// résultat = 0 si le continent et le nom de ce Pays sont les mêmes
		// que ceux de o (casse prise en compte)
		// résultat = 1 dans tous les autres cas }

		if (this.continent.compareTo(o.continent) < 0
				|| (this.continent.compareTo(o.continent) == 0 && this.nom.compareTo(o.nom) < 0)) {
			return -1;
		} else if (this.continent.compareTo(o.continent) == 0 && this.nom.compareTo(o.nom) == 0) {
			return 0;
		}
		return 1;
	}

	@Override
	public String toString() {
		return (continent + " (" + nom + " - " + population + " hab. - " + superficie + " km2)");
	}
}